package Classes;

import Commands.MoveCommand;
import Commands.ShootCommand;
import Enums.BrickState;
import Enums.Orientation;
import Enums.StructureType;
import Enums.TankType;
import Factories.*;
import Factories.MenuFactory;
import Factories.ScenarioFactory;
import Interfaces.IObserver;
import Interfaces.IScenario;
import Interfaces.IStructure;
import Scenarios.StagePanel;
import Scenarios.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Thread.sleep;

public class Game implements KeyListener {

    private Window windowRef;
    private ScenarioFactory scenarioFactory;
    private ArrayList<IObserver> keyObservers;
    private IScenario scenario;
    private long lastSpacePressTime = 0;
    private boolean isStagePanel;
    private boolean isGameStarted;
    private boolean isMovingUp = false;
    private boolean isMovingDown = false;
    private boolean isMovingLeft = false;
    private boolean isMovingRight = false;
    private boolean isShooting = false;

    private Tank allyTank;
    private Tank simpleTank;
    private Tank fastMoveTank;
    private Tank fastShootTank;
    private Tank resistantTank;

    private ArrayList<Tank> enemyTanks;
    private Tank playerTank;

    public Game(Window windowRef) {
        this.windowRef = windowRef;
        this.isStagePanel = false;
        this.isGameStarted = false;
        this.enemyTanks = new ArrayList<Tank>();
        this.keyObservers = new ArrayList<>();
        initializeGame();
    }

    public void initializeGame() {

        this.scenarioFactory = new MenuFactory();
        scenario = scenarioFactory.createScenario();
        windowRef.getContentPane().add(scenario.getPanel());
        windowRef.revalidate();
        windowRef.repaint();

        windowRef.addKeyListener(this);

        this.allyTank = new Tank(3,1,2, new JLabel(), TankType.Ally);
        this.simpleTank = new Tank(2,1,2,new JLabel(),TankType.Simple);
        this.fastMoveTank = new Tank(1,3,2,new JLabel(),TankType.FastMove);
        this.fastShootTank = new Tank(1,1,1,new JLabel(),TankType.FastShoot);
        this.resistantTank = new Tank(4,1,2,new JLabel(),TankType.Resistant);

    }

    public void spawnTanks() {

        playerTank = allyTank.clone();
        playerTank.setLocation(new Point(256, 764));
        playerTank.getLabel().setLocation(256, 764);

        scenario.getPanelGame().add(playerTank.getLabel());
        scenario.getPanelGame().revalidate();
        scenario.getPanelGame().repaint();
        startTankMovementThread();
        playerTank.setActive(true);

        getEnemyTanks(3);

        Timer timer = new Timer();

        new Thread(() -> {
            try {
                for (Tank tank : enemyTanks) {

                    sleep(1000);
                    randomSpawnPoint(tank);
                    scenario.getPanelGame().add(tank.getLabel());
                    scenario.getPanelGame().revalidate();
                    scenario.getPanelGame().repaint();
                    tank.setOrientation(Orientation.Down);
                    tank.setActive(true);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

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
                tank.getLabel().setBounds(x, y, 52, 52);
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

    public void getEnemyTanks(int level) {

        this.enemyTanks.clear();

        switch (level) {
            case 1:
                for (int i = 0; i < 20; i++)
                    this.enemyTanks.add(simpleTank.clone());
                break;
            case 2:
                for (int i = 0; i < 15; i++)
                    this.enemyTanks.add(simpleTank.clone());
                for (int i = 0; i < 5; i++)
                    this.enemyTanks.add(fastShootTank.clone());
                break;
            case 3:
                for (int i = 0; i < 10; i++)
                    this.enemyTanks.add(simpleTank.clone());
                for (int i = 0; i < 5; i++)
                    this.enemyTanks.add(fastShootTank.clone());
                for (int i = 0; i < 5; i++)
                    this.enemyTanks.add(fastMoveTank.clone());
                break;
            case 4:
                for (int i = 0; i < 5; i++)
                    this.enemyTanks.add(simpleTank.clone());
                for (int i = 0; i < 5; i++)
                    this.enemyTanks.add(fastShootTank.clone());
                for (int i = 0; i < 5; i++)
                    this.enemyTanks.add(fastMoveTank.clone());
                for (int i = 0; i < 5; i++)
                    this.enemyTanks.add(resistantTank.clone());
                break;
            case 5:
                for (int i = 0; i < 3; i++)
                    this.enemyTanks.add(simpleTank.clone());
                for (int i = 0; i < 6; i++)
                    this.enemyTanks.add(fastShootTank.clone());
                for (int i = 0; i < 6; i++)
                    this.enemyTanks.add(fastMoveTank.clone());
                for (int i = 0; i < 5; i++)
                    this.enemyTanks.add(resistantTank.clone());
                break;
            case 6:
                for (int i = 0; i < 7; i++)
                    this.enemyTanks.add(fastShootTank.clone());
                for (int i = 0; i < 7; i++)
                    this.enemyTanks.add(fastMoveTank.clone());
                for (int i = 0; i < 6; i++)
                    this.enemyTanks.add(resistantTank.clone());
                break;
            case 7:
                for (int i = 0; i < 5; i++)
                    this.enemyTanks.add(fastShootTank.clone());
                for (int i = 0; i < 8; i++)
                    this.enemyTanks.add(fastMoveTank.clone());
                for (int i = 0; i < 7; i++)
                    this.enemyTanks.add(resistantTank.clone());
                break;
            case 8:
                for (int i = 0; i < 3; i++)
                    this.enemyTanks.add(fastShootTank.clone());
                for (int i = 0; i < 5; i++)
                    this.enemyTanks.add(fastMoveTank.clone());
                for (int i = 0; i < 12; i++)
                    this.enemyTanks.add(resistantTank.clone());
                break;
        }
    }

    public synchronized boolean validateMovement(ArrayList<Integer> subjectRangeX, ArrayList<Integer> subjectRangeY, boolean isBullet, Orientation orientation) {

        boolean isValidStructure = true;
        boolean isValidTank = true;
        boolean isValidMovementX;
        boolean isValidMovementY;
        ArrayList<Integer> structureRangeX;
        ArrayList<Integer> structureRangeY;
        ArrayList<Integer> enemyRangeX;
        ArrayList<Integer> enemyRangeY;

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
                        System.out.println("eliminar");
                        scenario.getPanelGame().remove(structure.getLabel());
                        scenario.getStructures().remove(structure);
                    }
                }

                if (!isValidMovementX && !isValidMovementY) {
                    isValidStructure = false;
                    break;
                }

            } else if (structure.getType().equals(StructureType.Water)) {

                if (!isBullet) {
                    if (containsOverlap(subjectRangeX, structureRangeX))
                        isValidMovementX = false;

                    if (containsOverlap(subjectRangeY, structureRangeY))
                        isValidMovementY = false;

                    if (!isValidMovementX && !isValidMovementY) {
                        isValidStructure = false;
                        break;
                    }
                }

            } else {
                scenario.getPanelGame().setComponentZOrder(structure.getLabel(), 0);
            }
        }

        for (Tank enemy : enemyTanks) {

            if (enemy.isActive()) {
                isValidTank = true;
                isValidMovementX = true;
                isValidMovementY = true;
                enemyRangeX = generateRange(enemy.getLocation().x, 52);
                enemyRangeY = generateRange(enemy.getLocation().y, 52);

                if (containsOverlap(subjectRangeX, enemyRangeX))
                    isValidMovementX = false;

                if (containsOverlap(subjectRangeY, enemyRangeY))
                    isValidMovementY = false;

                if (!isValidMovementX && !isValidMovementY) {
                    isValidTank = false;
                    break;
                }
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

                this.scenarioFactory = new Level8Factory();
                scenario = scenarioFactory.createScenario();
                scenario.getPanelGame().setLocation(20,20);
                windowRef.getContentPane().add(scenario.getPanel());
                windowRef.getContentPane().revalidate();
                windowRef.getContentPane().repaint();
                spawnTanks();
                this.isGameStarted = true;
                this.isStagePanel = false;
            }

        } else if (keyCode == KeyEvent.VK_W) {
            //playerTank.setOrientation(Orientation.Up);
            isMovingUp = true;
        } else if (keyCode == KeyEvent.VK_A) {
            //playerTank.setOrientation(Orientation.Left);
            isMovingLeft = true;
        } else if (keyCode == KeyEvent.VK_S) {
            //playerTank.setOrientation(Orientation.Down);
            isMovingDown = true;
        } else if (keyCode == KeyEvent.VK_D) {
            //playerTank.setOrientation(Orientation.Right);
            isMovingRight = true;
        } else if (keyCode == KeyEvent.VK_SPACE && !isShooting) {

            long currentTime = System.currentTimeMillis();
            if (currentTime - lastSpacePressTime > 500)
            {
                AtomicBoolean bulletHit = new AtomicBoolean(false);
                Bullet bullet = new Bullet(playerTank.getOrientation(), playerTank.getLocation());
                scenario.getPanelGame().add(bullet.getLabel());
                scenario.getPanelGame().setComponentZOrder(bullet.getLabel(), 0);

                isShooting = true;
                lastSpacePressTime = currentTime;

                Thread bulletThread = new Thread(() -> {

                    while (true) {
                        bulletHit.set(false);

                        try {

                            if (bullet.getOrientation().equals(Orientation.Up)) {

                                if (bullet.getLocation().y - 5 > 0 && validateMovement(generateRange(bullet.getLocation().x, 16), generateRange(bullet.getLocation().y - 5, 16), true, bullet.getOrientation()))
                                    playerTank.executeCommand(new ShootCommand(bullet));
                                else
                                    bulletHit.set(true);

                            } else if (bullet.getOrientation().equals(Orientation.Down)) {

                                if (bullet.getLocation().y + 5 < 832 && validateMovement(generateRange(bullet.getLocation().x, 16), generateRange(bullet.getLocation().y + 5, 16), true, bullet.getOrientation()))
                                    playerTank.executeCommand(new ShootCommand(bullet));
                                else
                                    bulletHit.set(true);

                            } else if (bullet.getOrientation().equals(Orientation.Left)) {

                                if (bullet.getLocation().x - 5 > 0 && validateMovement(generateRange(bullet.getLocation().x - 5, 16), generateRange(bullet.getLocation().y, 16), true, bullet.getOrientation()))
                                    playerTank.executeCommand(new ShootCommand(bullet));
                                else
                                    bulletHit.set(true);

                            } else if (bullet.getOrientation().equals(Orientation.Right)) {

                                if (bullet.getLocation().x + 5 < 832 && validateMovement(generateRange(bullet.getLocation().x + 5, 16), generateRange(bullet.getLocation().y, 16), true, bullet.getOrientation()))
                                    playerTank.executeCommand(new ShootCommand(bullet));
                                else
                                    bulletHit.set(true);
                            }

                            windowRef.getContentPane().revalidate();
                            windowRef.getContentPane().repaint();

                            if (bulletHit.get()) {
                                scenario.getPanelGame().setComponentZOrder(bullet.getLabel(), 0);
                                bullet.bulletHit();
                                windowRef.getContentPane().revalidate();
                                windowRef.getContentPane().repaint();
                                scenario.getPanelGame().remove(bullet.getLabel());
                                break;
                            }


                            sleep(1);

                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                bulletThread.start();
            }

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
        } else if (keyCode == KeyEvent.VK_SPACE) {
            isShooting = false;
        }
    }

    public void  startTankMovementThread() {

        Thread movementThread = new Thread(() -> {

            while (true)
            {
                try {
                    if (isMovingRight) {
                        if (playerTank.getLocation().x+3+52 < 832 && validateMovement(generateRange(playerTank.getLocation().x+3, 52), generateRange(playerTank.getLocation().y, 52), false, playerTank.getOrientation()))
                        {
                            playerTank.setOrientation(Orientation.Right);
                            playerTank.executeCommand(new MoveCommand(playerTank));
                        }

                    } else if (isMovingLeft) {

                        if (playerTank.getLocation().x-3 > 0 && validateMovement(generateRange(playerTank.getLocation().x-3, 52), generateRange(playerTank.getLocation().y, 52), false, playerTank.getOrientation()))
                        {
                            playerTank.setOrientation(Orientation.Left);
                            playerTank.executeCommand(new MoveCommand(playerTank));
                        }

                    } else if (isMovingUp) {

                        if (playerTank.getLocation().y-3 > 0 && validateMovement(generateRange(playerTank.getLocation().x, 52), generateRange(playerTank.getLocation().y-3,52), false, playerTank.getOrientation()))
                        {
                            playerTank.setOrientation(Orientation.Up);
                            playerTank.executeCommand(new MoveCommand(playerTank));
                        }

                    } else if (isMovingDown) {

                        if (playerTank.getLocation().y+3+52 < 832 && validateMovement(generateRange(playerTank.getLocation().x, 52), generateRange(playerTank.getLocation().y+3,52), false, playerTank.getOrientation()))
                        {
                            playerTank.setOrientation(Orientation.Down);
                            playerTank.executeCommand(new MoveCommand(playerTank));
                        }
                    }

                    windowRef.getContentPane().revalidate();
                    windowRef.getContentPane().repaint();

                    sleep(10);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        movementThread.start();
    }


}
