package Classes;

import Enums.*;
import Factories.*;
import Interfaces.*;
import Observers.*;
import Strategies.*;
import Threads.*;
import Scenarios.*;
import Scenarios.Window;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;


public class Game implements KeyListener {

    private final Window windowRef;
    private IScenario scenario;
    private ScenarioFactory scenarioFactory;
    private AtomicBoolean bulletHit;
    private ArrayList<Tank> enemyTanks;
    private ArrayList<WildCard> wildCards;

    private boolean isStagePanel;
    private boolean isMovingUp;
    private boolean isMovingDown;
    private boolean isMovingLeft;
    private boolean isMovingRight;
    private boolean gameRunning;
    private boolean isBulletFlying;
    private boolean eagleAlive;

    private long lastShotTime;
    private int activeEnemyTanks;
    private int currentLevel;

    private Tank allyTank;
    private Tank simpleTank;
    private Tank fastMoveTank;
    private Tank fastShootTank;
    private Tank resistantTank;
    private Tank redTank;
    private Tank playerTank;


    public Game(Window windowRef) {
        this.windowRef = windowRef;
        initializeGame();
    }

    public void initializeGame() {

        this.bulletHit = new AtomicBoolean(false);
        this.enemyTanks = new ArrayList<>();
        this.wildCards = new ArrayList<>();

        this.isStagePanel = false;
        this.isMovingUp = false;
        this.isMovingDown = false;
        this.isMovingLeft = false;
        this.isMovingRight = false;
        this.gameRunning = false;
        this.isBulletFlying = false;
        this.eagleAlive = true;


        this.lastShotTime = 0;
        this.activeEnemyTanks = 0;
        this.currentLevel = 1;

        this.allyTank = new Tank(3,1,1, new JLabel(), TankType.Ally);
        this.simpleTank = new Tank(2,1,1,new JLabel(),TankType.Simple);
        this.fastMoveTank = new Tank(1,2,1,new JLabel(),TankType.FastMove);
        this.fastShootTank = new Tank(1,1,2,new JLabel(),TankType.FastShoot);
        this.resistantTank = new Tank(4,1,1,new JLabel(),TankType.Resistant);
        this.redTank = new Tank(2,1,1,new JLabel(),TankType.Red);

        windowRef.getContentPane().add(new MenuGame().getPanel());
        windowRef.revalidate();
        windowRef.repaint();
        windowRef.addKeyListener(this);

    }

    public void startGame() {

        playerTank = allyTank.clone();
        playerTank.setOrientation(Orientation.Up);
        playerTank.setLocation(256, 764);

        scenario.getPanelGame().add(playerTank.getLabel());
        scenario.getPanelGame().revalidate();
        scenario.getPanelGame().repaint();
        playerTank.setActive(true);

        for (TankObserver tankObserver : scenario.getTanksLeft()) {
            playerTank.addObserver(tankObserver);
        }

        addRandomEnemyTanks();
        new ThreadSpawnEnemyTanks(this).start();
        new ThreadPlayerMovement(this).start();
        new ThreadVerifyWinner(this).start();

    }

    public Orientation randomOrientation() {

        Random random = new Random();

        int rand = random.nextInt(4);

        switch (rand) {
            case 0: return Orientation.Up;
            case 1: return Orientation.Down;
            case 2: return Orientation.Left;
            case 3: return Orientation.Right;
        }

        return Orientation.Down;
    }

    public void generateWildCard() {

        Random random = new Random();
        int card = random.nextInt(6);
        CardType cardType = null;

        switch (card){
            case 0 -> cardType = CardType.Clock;
            case 1 -> cardType = CardType.Star;
            case 2 -> cardType = CardType.Helmet;
            case 3 -> cardType = CardType.Shovel;
            case 4 -> cardType = CardType.Bomb;
            case 5 -> cardType = CardType.Tank;
        }

        boolean isValid;
        int x;
        int y;

        do {
            isValid = true;
            random = new Random();
            x = random.nextInt(13) * 64;
            y = random.nextInt(13) * 64;

            for (IStructure structure : scenario.getStructures())
                if (structure.getLocation().equals(new Point(x, y)))
                {
                    isValid = false;
                    break;
                }

        } while (!isValid);

        WildCard wildCard = new WildCard(new Point(x, y), cardType);
        wildCards.add(wildCard);
        scenario.getPanelGame().add(wildCard.getLabel());
        scenario.getPanelGame().setComponentZOrder(wildCard.getLabel(), 0);

    }

    public void setBonus(WildCard card) {

        BonusManager bonusManager = new BonusManager();

        switch (card.getCardType()) {
            case Clock -> bonusManager.setStrategy(new ClockCardStrategy());
            case Star -> bonusManager.setStrategy(new StarCardStrategy());
            case Tank -> bonusManager.setStrategy(new TankCardStrategy());
            case Shovel -> bonusManager.setStrategy(new ShovelCardStrategy());
            case Bomb -> bonusManager.setStrategy(new BombCardStrategy());
            case Helmet -> bonusManager.setStrategy(new HelmetCardStrategy());

        }
        bonusManager.executeStrategy(this);
    }

    public void randomSpawnPoint(Tank tank) {

        Random random;
        boolean isValid;
        int x;
        int y;

        do {
            isValid = false;
            random = new Random();
            x = random.nextInt(13) * 64;
            y = random.nextInt(5) * 64;

            double distance = calculateDistance(playerTank.getLocation(), new Point(x, y));

            if (distance >= 64 && isValidSpawn(x, y)) {
                if (tank.getTankType().equals(TankType.Ally))
                    tank.getLabel().setBounds(x, y, 52, 52);
                else
                    tank.getLabel().setBounds(x, y, 60, 60);

                tank.getLabel().setLocation(x, y);
                tank.setLocation(x, y);
                isValid = true;
            }

        } while (!isValid);
    }

    private double calculateDistance(Point p1, Point p2) {
        int dx = p2.x - p1.x;
        int dy = p2.y - p1.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public boolean isValidSpawn(int cordX, int cordY) {

            boolean allGrass = false;
            boolean validSpawn = true;
            boolean noTank = true;

            for (IStructure structure : scenario.getStructures()) {
                if (structure.getType().equals(StructureType.Grass) && structure.getLocation().x == cordX && structure.getLocation().y == cordY) {
                    allGrass = true;
                    for (IStructure structure2 : scenario.getStructures()) {
                        if (structure2.getLocation().x == cordX + 32 && structure2.getLocation().y == cordY && !structure2.getType().equals(StructureType.Grass))
                            allGrass = false;
                        if (structure2.getLocation().x == cordX && structure2.getLocation().y == cordY + 32 && !structure2.getType().equals(StructureType.Grass))
                            allGrass = false;
                        if (structure2.getLocation().x == cordX + 32 && structure2.getLocation().y == cordY + 32 && !structure2.getType().equals(StructureType.Grass))
                            allGrass = false;
                        if (!allGrass)
                            break;
                    }
                }
            }

            for (IStructure structure : scenario.getStructures()) {
                if (structure.getLocation().x == cordX && structure.getLocation().y == cordY)
                    validSpawn = false;
                if (structure.getLocation().x == cordX + 32 && structure.getLocation().y == cordY)
                    validSpawn = false;
                if (structure.getLocation().x == cordX && structure.getLocation().y == cordY + 32)
                    validSpawn = false;
                if (structure.getLocation().x == cordX + 32 && structure.getLocation().y == cordY + 32)
                    validSpawn = false;
                if (!validSpawn)
                    break;
            }

            for (Tank tank : enemyTanks) {
                if (tank.getLocation().x == cordX && tank.getLocation().y == cordY)
                    noTank = false;
                if (tank.getLocation().x == cordX + 32 && tank.getLocation().y == cordY)
                    noTank = false;
                if (tank.getLocation().x == cordX && tank.getLocation().y == cordY + 32)
                    noTank = false;
                if (tank.getLocation().x == cordX + 32 && tank.getLocation().y == cordY + 32)
                    noTank = false;
                if (!noTank)
                    break;
            }

            return (validSpawn && noTank) || (allGrass && noTank);
        }

    public void addRandomEnemyTanks() {
        Random random = new Random();
        int redTanksCount = random.nextInt(3) + 2;
        redTanksCount = Math.min(redTanksCount, 5);

        for (int i = 0; i < redTanksCount; i++) {
            if (this.enemyTanks.size() < 20) {
                this.enemyTanks.add(redTank.clone());
            }
        }

        while (this.enemyTanks.size() < 20) {
            int tankType = random.nextInt(4);
            switch (tankType) {
                case 0:
                    this.enemyTanks.add(simpleTank.clone());
                    break;
                case 1:
                    this.enemyTanks.add(fastShootTank.clone());
                    break;
                case 2:
                    this.enemyTanks.add(fastMoveTank.clone());
                    break;
                case 3:
                    this.enemyTanks.add(resistantTank.clone());
                    break;
            }
        }

        Collections.shuffle(enemyTanks);
    }

    public synchronized boolean validateMovement(ArrayList<Integer> subjectRangeX, ArrayList<Integer> subjectRangeY, boolean isBullet, Orientation orientation, boolean isPlayer, Tank tank) {

        boolean isValidStructure = true;
        boolean isValidTank = true;
        boolean isValidMovementX = true;
        boolean isValidMovementY = true;
        ArrayList<Integer> structureRangeX;
        ArrayList<Integer> structureRangeY;
        ArrayList<Integer> enemyRangeX;
        ArrayList<Integer> enemyRangeY;
        ArrayList<Integer> playerRangeX;
        ArrayList<Integer> playerRangeY;


        if (isBullet && !isPlayer) {

            playerRangeX = generateRange(playerTank.getLocation().x, 52);
            playerRangeY = generateRange(playerTank.getLocation().y, 52);

            if (containsOverlap(subjectRangeX, playerRangeX))
                isValidMovementX = false;

            if (containsOverlap(subjectRangeY, playerRangeY))
                isValidMovementY = false;

            if (!isValidMovementX && !isValidMovementY) {
                playerTank.setHp(playerTank.getHp() - 1);
                scenario.setHP(playerTank.getHp());

                if (!playerTank.isActive()) {
                    scenario.getPanelGame().remove(playerTank.getLabel());

                    for (Tank enemy : enemyTanks) {
                        enemy.setActive(false);
                    }

                    scenario.getLabelPressEnter().setVisible(true);
                    scenario.getPanelGame().setComponentZOrder(scenario.getLabelPressEnter(), 0);
                    gameRunning = false;
                }
                return false;
            }

        } else if (!isBullet && !isPlayer) {

            playerRangeX = generateRange(playerTank.getLocation().x, 52);
            playerRangeY = generateRange(playerTank.getLocation().y, 52);

            if (containsOverlap(subjectRangeX, playerRangeX))
                isValidMovementX = false;

            if (containsOverlap(subjectRangeY, playerRangeY))
                isValidMovementY = false;

            if (!isValidMovementX && !isValidMovementY) {
                return false;
            }

        } else if (!isBullet && isPlayer) {

            int i = 0;

            while (i < wildCards.size())
            {
                WildCard card = wildCards.get(i++);

                if (!card.isUsed()) {

                    playerRangeX = generateRange(card.getLocation().x, 64);
                    playerRangeY = generateRange(card.getLocation().y, 64);

                    if (containsOverlap(subjectRangeX, playerRangeX))
                        isValidMovementX = false;

                    if (containsOverlap(subjectRangeY, playerRangeY))
                        isValidMovementY = false;

                    if (!isValidMovementX && !isValidMovementY) {

                        card.setUsed(true);
                        scenario.getCardCounter().update();
                        card.getLabel().setVisible(false);
                        setBonus(card);
                        scenario.getPanelGame().remove(card.getLabel());
                        wildCards.remove(card);
                    }
                }
            }

        }

        for (Tank enemy : enemyTanks) {

            if (!enemy.equals(tank) && enemy.isActive()) {
                isValidTank = true;
                isValidMovementX = true;
                isValidMovementY = true;
                enemyRangeX = generateRange(enemy.getLocation().x, 60);
                enemyRangeY = generateRange(enemy.getLocation().y, 60);

                if (containsOverlap(subjectRangeX, enemyRangeX))
                    isValidMovementX = false;

                if (containsOverlap(subjectRangeY, enemyRangeY))
                    isValidMovementY = false;

                if (isBullet && isPlayer && !isValidMovementX && !isValidMovementY) {
                    enemy.setHp(enemy.getHp() - 1);

                    if (!enemy.isActive()) {
                        scenario.getPanelGame().remove(enemy.getLabel());
                        tank.notifyObservers();
                        enemy.setActive(false);
                        activeEnemyTanks--;

                        if (enemy.getTankType().equals(TankType.Red))
                            generateWildCard();
                    }
                    return false;

                } else if (!isBullet && !isPlayer && !isValidMovementX && !isValidMovementY) {
                    return false;

                } else if (!isBullet && isPlayer && !isValidMovementX && !isValidMovementY) {
                    return false;
                }
            }
        }

        for (IStructure structure : scenario.getStructures())
        {
            isValidStructure = true;
            isValidMovementX = true;
            isValidMovementY = true;
            structureRangeX = generateRange(structure.getLocation().x, 32);
            structureRangeY = generateRange(structure.getLocation().y, 32);

            if (!structure.getType().equals(StructureType.Grass) && !structure.getType().equals(StructureType.Water)) {

                if (containsOverlap(subjectRangeX, structureRangeX))
                    isValidMovementX = false;

                if (containsOverlap(subjectRangeY, structureRangeY))
                    isValidMovementY = false;

                if (!isValidMovementX && !isValidMovementY && structure.getType().equals(StructureType.Brick) && isBullet) {
                    structure.setHP(structure.getHP()-1, orientation);
                    if (structure.getState().equals(BrickState.Destroyed)) {
                        scenario.getPanelGame().remove(structure.getLabel());
                        scenario.getStructures().remove(structure);
                    }
                    return false;
                }

                if (!isValidMovementX && !isValidMovementY) {
                    return false;
                }

            } else if (structure.getType().equals(StructureType.Water)) {

                if (!isBullet) {
                    if (containsOverlap(subjectRangeX, structureRangeX))
                        isValidMovementX = false;

                    if (containsOverlap(subjectRangeY, structureRangeY))
                        isValidMovementY = false;

                    if (!isValidMovementX && !isValidMovementY) {
                        return false;
                    }
                }

            } else {
                scenario.getPanelGame().setComponentZOrder(structure.getLabel(), 0);
            }
        }


        ArrayList<Integer> eagleRangeX = generateRange(scenario.getEagle().getLocation().x, 64);
        ArrayList<Integer> eagleRangeY = generateRange(scenario.getEagle().getLocation().y, 64);

        if (containsOverlap(subjectRangeX, eagleRangeX))
            isValidMovementX = false;

        if (containsOverlap(subjectRangeY, eagleRangeY))
            isValidMovementY = false;

        if (isBullet && !isPlayer && !isValidMovementX && !isValidMovementY) {
            playerTank.setProtected(false);
            playerTank.setHp(0);
            scenario.setHP(0);

            scenario.getPanelGame().setComponentZOrder(scenario.getLabelPressEnter(), 0);

            if (!playerTank.isActive()) {
                scenario.getPanelGame().remove(playerTank.getLabel());

                for (Tank enemy : enemyTanks) {
                    enemy.setActive(false);
                    enemy.setHp(0);
                }

                scenario.getLabelPressEnter().setVisible(true);
                gameRunning = false;
            }

            return false;

        } else if (!isValidMovementX && !isValidMovementY)
            return false;


        return isValidStructure && isValidTank;
    }

    private boolean containsOverlap(ArrayList<Integer> tankRange, ArrayList<Integer> structureRange) {

        for (Integer coordinate : tankRange)
            if (structureRange.contains(coordinate)) {
                return true;
            }

        return false;
    }

    public ArrayList<Integer> generateRange(int currentCord, int pixels) {

        ArrayList<Integer> range = new ArrayList<>();
        int limit = currentCord + pixels;

        for (int i = currentCord; i < limit; i++)
            range.add(i);

        return range;
    }

    public void clearLevel() {

        if (currentLevel != 1) {
            scenario.resetPanel();
        }

        scenario = null;

        this.bulletHit = new AtomicBoolean(false);
        enemyTanks.clear();
        wildCards.clear();
        this.enemyTanks = new ArrayList<>();
        this.wildCards = new ArrayList<>();

        this.isStagePanel = false;
        this.isMovingUp = false;
        this.isMovingDown = false;
        this.isMovingLeft = false;
        this.isMovingRight = false;
        this.gameRunning = false;

        this.lastShotTime = 0;
        this.activeEnemyTanks = 0;

        windowRef.getContentPane().removeAll();

    }

    public void nextLevel() {

        clearLevel();
        eagleAlive = true;

        switch (currentLevel) {
            case 1 -> scenarioFactory = new Level1Factory();
            case 2 -> scenarioFactory = new Level2Factory();
            case 3 -> scenarioFactory = new Level3Factory();
            case 4 -> scenarioFactory = new Level4Factory();
            case 5 -> scenarioFactory = new Level5Factory();
            case 6 -> scenarioFactory = new Level6Factory();
            case 7 -> scenarioFactory = new Level7Factory();
            case 8 -> scenarioFactory = new Level8Factory();
        }

        if (currentLevel < 9) {
            currentLevel++;
            scenario = scenarioFactory.createScenario();
            scenario.getPanelGame().setLocation(20, 20);
            windowRef.getContentPane().add(scenario.getPanel());

            gameRunning = true;
            isStagePanel = false;
            startGame();

        } else {
            currentLevel = 1;
            windowRef.getContentPane().add(new MenuGame().getPanel());
        }
    }

    public void showStagePanel() {

        windowRef.getContentPane().removeAll();
        StagePanel stagePanel;

        if (currentLevel != 9)
            stagePanel = new StagePanel("Stage " + currentLevel);
        else
            stagePanel = new StagePanel("Thank you for playing!");

        windowRef.getContentPane().add(stagePanel.getStagePanel());
        isStagePanel = true;

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER && !gameRunning)
        {
            if (!isStagePanel)
                showStagePanel();
            else
                nextLevel();

            windowRef.getContentPane().revalidate();
            windowRef.getContentPane().repaint();

        }else if (keyCode == KeyEvent.VK_W && gameRunning) {
            playerTank.setOrientation(Orientation.Up);
            isMovingUp = true;
        } else if (keyCode == KeyEvent.VK_A && gameRunning) {
            playerTank.setOrientation(Orientation.Left);
            isMovingLeft = true;
        } else if (keyCode == KeyEvent.VK_S && gameRunning) {
            playerTank.setOrientation(Orientation.Down);
            isMovingDown = true;
        } else if (keyCode == KeyEvent.VK_D && gameRunning) {
            playerTank.setOrientation(Orientation.Right);
            isMovingRight = true;
        }

        if (keyCode == KeyEvent.VK_SPACE && gameRunning) {
            long currentTime = System.currentTimeMillis();
            long shootingInterval = 350 / playerTank.getShootingRate();

            if (currentTime - lastShotTime > shootingInterval)
                new ThreadPlayerShootBullet(this, currentTime).start();

        } else if (keyCode == KeyEvent.VK_ESCAPE)
            System.exit(0);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W) {
            isMovingUp = false;
        } else if (keyCode == KeyEvent.VK_A) {
            isMovingLeft = false;
        } else if (keyCode == KeyEvent.VK_S) {
            isMovingDown = false;
        } else if (keyCode == KeyEvent.VK_D) {
            isMovingRight = false;
        }
    }


    //getter and setters

    public Tank getPlayerTank() {
        return playerTank;
    }

    public IScenario getScenario() {
        return scenario;
    }

    public Window getWindowRef() {
        return windowRef;
    }

    public ArrayList<Tank> getEnemyTanks() {
        return enemyTanks;
    }

    public int getActiveEnemyTanks() {
        return activeEnemyTanks;
    }

    public void setActiveEnemyTanks(int activeEnemyTanks) {
        this.activeEnemyTanks = activeEnemyTanks;
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    public boolean isMovingUp() {
        return isMovingUp;
    }

    public boolean isMovingDown() {
        return isMovingDown;
    }

    public boolean isMovingLeft() {
        return isMovingLeft;
    }

    public boolean isMovingRight() {
        return isMovingRight;
    }

    public AtomicBoolean getBulletHit() {
        return bulletHit;
    }

    public void setLastShotTime(long lastShotTime) {
        this.lastShotTime = lastShotTime;
    }

    public boolean isBulletFlying() {
        return isBulletFlying;
    }

    public void setBulletFlying(boolean bulletFlying) {
        isBulletFlying = bulletFlying;
    }

    public boolean isEagleAlive() {
        return eagleAlive;
    }

    public void setEagleAlive(boolean eagleAlive) {
        this.eagleAlive = eagleAlive;
    }
}