package Classes;

import Commands.MoveCommand;
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
import java.util.TimerTask;

public class Game implements KeyListener {

    private Window windowRef;
    private ScenarioFactory scenarioFactory;
    private ArrayList<IObserver> keyObservers;
    private IScenario scenario;
    private boolean isStagePanel;
    private boolean isGameStarted;
    private boolean isMovingUp = false;
    private boolean isMovingDown = false;
    private boolean isMovingLeft = false;
    private boolean isMovingRight = false;

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

        new TankThread(playerTank).start();
        scenario.getPanelGame().add(playerTank.getLabel());
        scenario.getPanelGame().revalidate();
        scenario.getPanelGame().repaint();
        startTankMovementThread();
        playerTank.setActive(true);

        getEnemyTanks(3);

        Timer timer = new Timer();
        long delay = 500;

        for (Tank tank : enemyTanks)
        {
            randomSpawnPoint(tank);
            timer.schedule(new TimerTask()
            {
                public void run()
                {
                    //new TankThread(tank).start();
                    scenario.getPanelGame().add(tank.getLabel());
                    scenario.getPanelGame().revalidate();
                    scenario.getPanelGame().repaint();
                    tank.setOrientation(Orientation.Down);
                    tank.setActive(true);
                }
            }, delay);

            delay += 500;
        }
    }

    public void randomSpawnPoint(Tank tank) {

        Random random = new Random();
        boolean isValid = false;
        int x;
        int y;

        do {
            isValid = false;
            random = new Random();
            x = random.nextInt(13) * 64;
            y = random.nextInt(5) * 64;

            if (isValidSpawn(x, y)) {
                tank.getLabel().setBounds(x, y, 52, 52);
                tank.getLabel().setLocation(x, y);
                tank.setLocation(new Point(x, y));
                isValid = true;
            }

        } while (!isValid);

    }

    public boolean isValidSpawn(int cordX, int cordY) {

        boolean allGrass = false;
        boolean validSpawn = true;
        boolean noTank = true;

        for (IStructure structure: scenario.getStructures())
        {
            if (structure.getType().equals(StructureType.Grass) && structure.getLocation().x == cordX && structure.getLocation().y == cordY)
            {
                allGrass = true;
                for (IStructure structure2 : scenario.getStructures())
                {
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

        for (IStructure structure: scenario.getStructures())
        {
            if (structure.getLocation().x == cordX && structure.getLocation().y == cordY)
                validSpawn = false;
            if (structure.getLocation().x == cordX+32 && structure.getLocation().y == cordY)
                validSpawn = false;
            if (structure.getLocation().x == cordX && structure.getLocation().y == cordY+32)
                validSpawn = false;
            if (structure.getLocation().x == cordX+32 && structure.getLocation().y == cordY+32)
                validSpawn = false;
            if (!validSpawn)
                break;
        }

        for (Tank tank : enemyTanks) {
            if (tank.getLocation().x == cordX && tank.getLocation().y == cordY)
                noTank = false;
            if (tank.getLocation().x == cordX+32 && tank.getLocation().y == cordY)
                noTank = false;
            if (tank.getLocation().x == cordX && tank.getLocation().y == cordY+32)
                noTank = false;
            if (tank.getLocation().x == cordX+32 && tank.getLocation().y == cordY+32)
                noTank = false;
            if(!noTank)
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

    public boolean validateMovement(ArrayList<Integer> tankRangeX, ArrayList<Integer> tankRangeY) {

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
            if (!structure.getType().equals(StructureType.Grass)) {
                isValidStructure = true;
                isValidMovementX = true;
                isValidMovementY = true;
                structureRangeX = generateRange(structure.getLocation().x, 32);
                structureRangeY = generateRange(structure.getLocation().y, 32);

                if (containsOverlap(tankRangeX, structureRangeX))
                    isValidMovementX = false;

                if (containsOverlap(tankRangeY, structureRangeY))
                    isValidMovementY = false;

                if (!isValidMovementX && !isValidMovementY) {
                    isValidStructure = false;
                    break;
                }
            }
        }

        for (Tank enemy : enemyTanks) {

            if (enemy.isActive()) {
                isValidTank = true;
                isValidMovementX = true;
                isValidMovementY = true;
                enemyRangeX = generateRange(enemy.getLocation().x, 52);
                enemyRangeY = generateRange(enemy.getLocation().y, 52);

                if (containsOverlap(tankRangeX, enemyRangeX))
                    isValidMovementX = false;

                if (containsOverlap(tankRangeY, enemyRangeY))
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
                windowRef.getContentPane().add(scenario.getPanel());
                windowRef.getContentPane().revalidate();
                windowRef.getContentPane().repaint();
                spawnTanks();
                this.isGameStarted = true;
                this.isStagePanel = false;
            }

        } else if (keyCode == KeyEvent.VK_W) {
            isMovingUp = true;
        } else if (keyCode == KeyEvent.VK_A) {
            isMovingLeft = true;
        } else if (keyCode == KeyEvent.VK_S) {
            isMovingDown = true;
        } else if (keyCode == KeyEvent.VK_D) {
            isMovingRight = true;
        }
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


    public void startTankMovementThread() {

        Thread movementThread = new Thread(() -> {

            while (true)
            {
                try {
                    if (isMovingRight) {

                        if (validateMovement(generateRange(playerTank.getLocation().x+3, 52), generateRange(playerTank.getLocation().y, 52)))
                        {
                            playerTank.setOrientation(Orientation.Right);
                            playerTank.executeCommand(new MoveCommand(playerTank));
                            windowRef.getContentPane().revalidate();
                            windowRef.getContentPane().repaint();
                        }

                    } else if (isMovingLeft) {

                        if (validateMovement(generateRange(playerTank.getLocation().x-3, 52), generateRange(playerTank.getLocation().y, 52)))
                        {
                            playerTank.setOrientation(Orientation.Left);
                            playerTank.executeCommand(new MoveCommand(playerTank));
                            windowRef.getContentPane().revalidate();
                            windowRef.getContentPane().repaint();
                        }

                    } else if (isMovingUp) {

                        if (validateMovement(generateRange(playerTank.getLocation().x, 52), generateRange(playerTank.getLocation().y-3,52)))
                        {
                            playerTank.setOrientation(Orientation.Up);
                            playerTank.executeCommand(new MoveCommand(playerTank));
                            windowRef.getContentPane().revalidate();
                            windowRef.getContentPane().repaint();
                        }

                    } else if (isMovingDown) {

                        if (validateMovement(generateRange(playerTank.getLocation().x, 52), generateRange(playerTank.getLocation().y+3,52)))
                        {
                            playerTank.setOrientation(Orientation.Down);
                            playerTank.executeCommand(new MoveCommand(playerTank));
                            windowRef.getContentPane().revalidate();
                            windowRef.getContentPane().repaint();
                        }
                    }

                    Thread.sleep(10);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        movementThread.start();
    }


}
