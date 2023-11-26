package Classes;

import Commands.MoveCommand;
import Commands.ShootCommand;
import Enums.*;
import Factories.*;
import Factories.MenuFactory;
import Factories.ScenarioFactory;
import Interfaces.IScenario;
import Interfaces.IStructure;
import Scenarios.StagePanel;
import Scenarios.Window;
import Observers.TankObserver;
import Strategies.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Thread.sleep;

public class Game implements KeyListener {

    private Window windowRef;
    private IScenario scenario;
    private ScenarioFactory scenarioFactory;
    private Thread bulletThread = null;
    private AtomicBoolean bulletHit = new AtomicBoolean(false);
    private ArrayList<Tank> enemyTanks;
    private ArrayList<WildCard> wildCards;

    private boolean isStagePanel;
    private boolean isMovingUp = false;
    private boolean isMovingDown = false;
    private boolean isMovingLeft = false;
    private boolean isMovingRight = false;
    private boolean gameRunning = true;

    private long lastSpacePressTime = 0;
    private int activeEnemyTanks = 0;

    private Tank allyTank;
    private Tank simpleTank;
    private Tank fastMoveTank;
    private Tank fastShootTank;
    private Tank resistantTank;
    private Tank redTank;
    private Tank playerTank;


    public Game(Window windowRef) {
        this.windowRef = windowRef;
        this.isStagePanel = false;
        this.enemyTanks = new ArrayList<Tank>();
        wildCards = new ArrayList<>();
        initializeGame();
    }

    public void initializeGame() {

        scenarioFactory = new MenuFactory();
        scenario = scenarioFactory.createScenario();
        windowRef.getContentPane().add(scenario.getPanel());
        windowRef.revalidate();
        windowRef.repaint();
        windowRef.addKeyListener(this);

        this.allyTank = new Tank(3,1,1, new JLabel(), TankType.Ally);
        this.simpleTank = new Tank(2,1,1,new JLabel(),TankType.Simple);
        this.fastMoveTank = new Tank(1,2,1,new JLabel(),TankType.FastMove);
        this.fastShootTank = new Tank(1,1,2,new JLabel(),TankType.FastShoot);
        this.resistantTank = new Tank(4,1,1,new JLabel(),TankType.Resistant);
        this.redTank = new Tank(2,1,1,new JLabel(),TankType.Red);

    }

    public void spawnTanks() {

        playerTank = allyTank.clone();
        playerTank.setLocation(new Point(256, 764));
        playerTank.getLabel().setLocation(256, 764);
        playerTank.setOrientation(Orientation.Up);

        scenario.getPanelGame().add(playerTank.getLabel());
        scenario.getPanelGame().revalidate();
        scenario.getPanelGame().repaint();
        playerTank.setActive(true);

        for (TankObserver tankObserver : scenario.getTanksLeft()) {
            playerTank.addObserver(tankObserver);
        }

        addRandomEnemyTanks();

        new Thread(() -> {

            try {
                int i = 0;

                do {
                    if (activeEnemyTanks < 5)
                    {
                        activeEnemyTanks++;
                        Tank tank = enemyTanks.get(i++);
                        tank.setOrientation(Orientation.Down);
                        tank.setActive(true);
                        new ThreadEnemyMove(this, tank).start();
                        new ThreadEnemyShoot(tank, this).start();
                        randomSpawnPoint(tank);
                        scenario.getPanelGame().add(tank.getLabel());
                        sleep(4000);
                    }

                } while (i < enemyTanks.size());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        startTankMovementThread();

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
        CardType cardType = CardType.Star;

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

        WildCard wildCard = new WildCard(new Point(x, y), CardType.Bomb);
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
            //case Helmet ->

        }

        bonusManager.executeStrategy(this);

        //bonusManager.setStrategy(new ClockCardStrategy());
        //bonusManager.executeStrategy();

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
                tank.setLocation(new Point(x, y));
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
        int redTanksCount = random.nextInt(3) + 2; // Genera un número aleatorio entre 2 y 4
        redTanksCount = Math.min(redTanksCount, 20); // Limita el máximo de redTank a 20

        for (int i = 0; i < redTanksCount; i++) {
            if (this.enemyTanks.size() < 20) {
                this.enemyTanks.add(redTank.clone());
            }
        }

        while (this.enemyTanks.size() < 20) {
            int tankType = random.nextInt(4); // Considerando que tienes 4 tipos de tanques
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
                // Puedes añadir más casos si tienes más tipos de tanques
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
                    isValidStructure = false;
                    return false;
                }

            } else if (structure.getType().equals(StructureType.Water)) {

                if (!isBullet) {
                    if (containsOverlap(subjectRangeX, structureRangeX))
                        isValidMovementX = false;

                    if (containsOverlap(subjectRangeY, structureRangeY))
                        isValidMovementY = false;

                    if (!isValidMovementX && !isValidMovementY) {
                        isValidStructure = false;
                        return false;
                    }
                }

            } else {
                scenario.getPanelGame().setComponentZOrder(structure.getLabel(), 0);
            }
        }

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

    private synchronized void shootBullet(long currentTime) {

        bulletHit.set(false);
        Bullet bullet = new Bullet(playerTank.getOrientation(), playerTank.getLocation());
        scenario.getBulletCounter().update();
        scenario.getPanelGame().add(bullet.getLabel());
        scenario.getPanelGame().setComponentZOrder(bullet.getLabel(), 0);

        lastSpacePressTime = currentTime;

        bulletThread = new Thread(() -> {
            while (!bulletHit.get()) {
                bulletHit.set(false);

                try {

                    if (bullet.getOrientation().equals(Orientation.Up)) {

                        if (bullet.getLocation().y - 13 > 0 && validateMovement(generateRange(bullet.getLocation().x, 16), generateRange(bullet.getLocation().y - 13, 16), true, bullet.getOrientation(), true, playerTank))
                            playerTank.executeCommand(new ShootCommand(bullet));
                        else
                            bulletHit.set(true);

                    } else if (bullet.getOrientation().equals(Orientation.Down)) {

                        if (bullet.getLocation().y + 13 < 832 && validateMovement(generateRange(bullet.getLocation().x, 16), generateRange(bullet.getLocation().y + 13, 16), true, bullet.getOrientation(), true, playerTank))
                            playerTank.executeCommand(new ShootCommand(bullet));
                        else
                            bulletHit.set(true);

                    } else if (bullet.getOrientation().equals(Orientation.Left)) {

                        if (bullet.getLocation().x - 13 > 0 && validateMovement(generateRange(bullet.getLocation().x - 13, 16), generateRange(bullet.getLocation().y, 16), true, bullet.getOrientation(), true, playerTank))
                            playerTank.executeCommand(new ShootCommand(bullet));
                        else
                            bulletHit.set(true);

                    } else if (bullet.getOrientation().equals(Orientation.Right)) {

                        if (bullet.getLocation().x + 13 < 832 && validateMovement(generateRange(bullet.getLocation().x + 13, 16), generateRange(bullet.getLocation().y, 16), true, bullet.getOrientation(), true, playerTank))
                            playerTank.executeCommand(new ShootCommand(bullet));
                        else
                            bulletHit.set(true);
                    }

                    //windowRef.getContentPane().revalidate();
                    windowRef.getContentPane().repaint();

                    if (bulletHit.get()) {
                        scenario.getPanelGame().setComponentZOrder(bullet.getLabel(), 0);
                        bullet.bulletHit();
                        //windowRef.getContentPane().revalidate();
                        windowRef.getContentPane().repaint();
                        scenario.getPanelGame().remove(bullet.getLabel());
                        break;
                    }


                    sleep(17);

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        bulletThread.start();
    }

    public void startTankMovementThread() {

        Thread movementThread = new Thread(() -> {

            while (gameRunning)
            {
                int speed = 4 + playerTank.getSpeed();

                try {
                    if (isMovingRight) {

                        if (playerTank.getLocation().x+speed+52 < 832 && validateMovement(generateRange(playerTank.getLocation().x+speed, 52), generateRange(playerTank.getLocation().y, 52), false, playerTank.getOrientation(), true, playerTank))
                        {
                            playerTank.setOrientation(Orientation.Right);
                            playerTank.executeCommand(new MoveCommand(playerTank));
                        }

                    } else if (isMovingLeft) {

                        if (playerTank.getLocation().x-speed > 0 && validateMovement(generateRange(playerTank.getLocation().x-speed, 52), generateRange(playerTank.getLocation().y, 52), false, playerTank.getOrientation(), true, playerTank))
                        {
                            playerTank.setOrientation(Orientation.Left);
                            playerTank.executeCommand(new MoveCommand(playerTank));
                        }

                    } else if (isMovingUp) {

                        if (playerTank.getLocation().y-speed > 0 && validateMovement(generateRange(playerTank.getLocation().x, 52), generateRange(playerTank.getLocation().y-speed,52), false, playerTank.getOrientation(), true, playerTank))
                        {
                            playerTank.setOrientation(Orientation.Up);
                            playerTank.executeCommand(new MoveCommand(playerTank));
                        }

                    } else if (isMovingDown) {

                        if (playerTank.getLocation().y+speed+52 < 832 && validateMovement(generateRange(playerTank.getLocation().x, 52), generateRange(playerTank.getLocation().y+speed,52), false, playerTank.getOrientation(), true, playerTank))
                        {
                            playerTank.setOrientation(Orientation.Down);
                            playerTank.executeCommand(new MoveCommand(playerTank));
                        }
                    }

                    windowRef.getContentPane().repaint();

                    sleep(17);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        movementThread.start();
    }

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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {

            if (!isStagePanel) {
                StagePanel stagePanel = new StagePanel(1);

                windowRef.getContentPane().removeAll();
                windowRef.getContentPane().add(stagePanel.getStagePanel());
                windowRef.getContentPane().revalidate();
                windowRef.getContentPane().repaint();
                this.isStagePanel = true;

            } else {
                windowRef.getContentPane().removeAll();

                this.scenarioFactory = new Level1Factory();
                scenario = scenarioFactory.createScenario();
                scenario.getPanelGame().setLocation(20,20);
                windowRef.getContentPane().add(scenario.getPanel());
                windowRef.getContentPane().revalidate();
                windowRef.getContentPane().repaint();
                spawnTanks();

                this.isStagePanel = false;
            }

        }else if (keyCode == KeyEvent.VK_W) {
            playerTank.setOrientation(Orientation.Up);
            isMovingUp = true;
        } else if (keyCode == KeyEvent.VK_A) {
            playerTank.setOrientation(Orientation.Left);
            isMovingLeft = true;
        } else if (keyCode == KeyEvent.VK_S) {
            playerTank.setOrientation(Orientation.Down);
            isMovingDown = true;
        } else if (keyCode == KeyEvent.VK_D) {
            playerTank.setOrientation(Orientation.Right);
            isMovingRight = true;
        }

        if (keyCode == KeyEvent.VK_SPACE && gameRunning) {

            long currentTime = System.currentTimeMillis();
            if (currentTime - lastSpacePressTime > 500/playerTank.getShootingRate())
                if (bulletThread == null || !bulletThread.isAlive())
                    shootBullet(currentTime);

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
}


