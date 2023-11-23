package Classes;

import Enums.TankType;
import Factories.Level1Factory;
import Factories.MenuFactory;
import Factories.ScenarioFactory;
import Interfaces.IScenario;
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
    private IScenario scenario;
    private boolean isStagePanel;

    private Tank allyTank;
    private Tank simpleTank;
    private Tank fastMoveTank;
    private Tank fastShootTank;
    private Tank resistantTank;
    private ArrayList<Tank> enemyTanks;

    public Game(Window windowRef) {
        this.windowRef = windowRef;
        this.isStagePanel = false;
        this.enemyTanks = new ArrayList<Tank>();
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


        getEnemyTanks(3);
        randomSpawnPoint();

        for (Tank tank : enemyTanks)
            System.out.println(tank.getLabel().getLocation());

        Timer timer = new Timer();
        long delay = 500;

        for (Tank tank : enemyTanks)
        {
            timer.schedule(new TimerTask()
            {
                public void run()
                {
                    //System.out.println(tank.getLabel().getLocation());
                    scenario.getPanelGame().add(tank.getLabel());
                    scenario.getPanelGame().revalidate();
                    scenario.getPanelGame().repaint();
                }
            }, delay);

            delay += 500;
        }
    }

    public void randomSpawnPoint() {

        Random random = new Random();
        int x;
        int y;

        for (Tank tank : enemyTanks)
        {
            do {
                random = new Random();
                x = random.nextInt(26) * 32;
                y = random.nextInt(26) * 32;

                if (isValidSpawn(x, y)) {
                    tank.getLabel().setBounds(x, y, 64, 64);
                    tank.getLabel().setLocation(x, y);
                }

            } while (!isValidSpawn(x, y));
        }
        System.out.println("\n");
    }

    public boolean isValidSpawn(int cordX, int cordY) {

        Component[] components = scenario.getPanelGame().getComponents();


        for (Component component: components) {
            if (component.getX() == cordX && component.getY() == cordY)
                return false;
            if (component.getX()+32 == cordX && component.getY() == cordY)
                return false;
            if (component.getX() == cordX && component.getY()+32 == cordY)
                return false;
            if (component.getX()+32 == cordX && component.getY()+32 == cordY)
                return false;
        }

        return true;
    }


    public ArrayList<Integer> getXRange(int cordX) {

        ArrayList<Integer> xRange = new ArrayList<>();

        int lastCord = cordX + 32;

        for (int i = cordX; i < lastCord; i++)
            xRange.add(i);

        return  xRange;
    }

    public ArrayList<Integer> getYRange(int cordY) {

        ArrayList<Integer> yRange = new ArrayList<>();

        int lastCord = cordY + 32;

        for (int i = cordY; i < lastCord; i++)
            yRange.add(i);

        return  yRange;
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
                windowRef.getContentPane().add(scenario.getPanel());
                windowRef.getContentPane().revalidate();
                windowRef.getContentPane().repaint();
                spawnTanks();
                this.isStagePanel = false;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
