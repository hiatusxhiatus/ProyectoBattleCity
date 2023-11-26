package Classes;

import Enums.Keys;
import Enums.Orientation;
import Enums.TankType;
import Interfaces.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Tank implements IPrototype, IObservable {

    private int hp;
    private int speed;
    private int shootingRate;
    private boolean isActive;
    private boolean isPaused;
    private boolean damaged;
    private Point location;
    private JLabel label;
    private TankType tankType;
    private Orientation orientation;
    private ArrayList<IObserver> observers;

    public Tank(int hp, int speed, int shootingRate, JLabel label, TankType tankType) {
        this.hp = hp;
        this.speed = speed;
        this.shootingRate = shootingRate;
        this.label = label;
        this.tankType = tankType;
        this.location = new Point(0,0);
        this.orientation = Orientation.Down;
        this.isActive = false;
        this.damaged = false;
        this.isPaused = false;
        this.observers = new ArrayList<>();
        setUpLabel();
    }

    public Tank(Tank tank) {

        this.hp = tank.hp;
        this.tankType = tank.tankType;
        this.speed = tank.speed;
        this.label = tank.label;
        this.shootingRate = tank.shootingRate;
        this.location = tank.location;
    }

    public void executeCommand(TankCommand command) {
        command.execute();
    }

    public void setUpLabel() {
        ImageIcon tankImage = null;

        switch (tankType) {
            case Ally -> tankImage = ImageCache.loadImage("src/main/java/imagenes/yellowTankUP.png");
            case Simple -> tankImage = ImageCache.loadImage("src/main/java/imagenes/simpleTankDOWN.png");
            case FastMove -> tankImage = ImageCache.loadImage("src/main/java/imagenes/fastMoveTankDOWN.png");
            case FastShoot -> tankImage = ImageCache.loadImage("src/main/java/imagenes/fastShootTankDOWN.png");
            case Resistant -> tankImage = ImageCache.loadImage("src/main/java/imagenes/resistantTankDOWN.png");
            case Red -> tankImage = ImageCache.loadImage("src/main/java/imagenes/redTankDOWN.gif");
        }

        label.setIcon(tankImage);
        label.setBounds(0, 0, 52, 52);
        label.setLocation(0,0);
    }

    @Override
    public Tank clone() {

        Tank clonedTank = new Tank(this.hp, this.speed, this.shootingRate, new JLabel(), this.tankType);

        Point clonedLocation = new Point();
        clonedLocation.x = this.location.x;
        clonedLocation.y = this.location.y;

        JLabel clonedLabel = new JLabel();
        clonedLabel.setIcon(this.label.getIcon());
        clonedLabel.setBounds(this.label.getBounds());
        clonedLabel.setLocation(this.label.getLocation());

        clonedTank.hp = this.hp;
        clonedTank.speed = this.speed;
        clonedTank.shootingRate = this.shootingRate;
        clonedTank.tankType = this.tankType;

        return clonedTank;
    }

    // GETTERs AND SETTERs

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {

        if (tankType.equals(TankType.Ally))
            setDamaged();

        this.hp = hp;
        if (hp <= 0) {
            isActive = false;
        }
    }

    public void setDamaged() {

        Thread damaged = new Thread(() -> {

            try {
                this.damaged = true;
                Thread.sleep(3000);
                this.damaged = false;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        damaged.start();

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getShootingRate() {
        return shootingRate;
    }

    public void setShootingRate(int shootingRate) {
        this.shootingRate = shootingRate;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public void setLocation(int x, int y) {
        if (tankType.equals(TankType.Ally))
            label.setBounds(x, y, 52, 52);
        else label.setBounds(x, y, 60, 60);

        this.location = new Point(x, y);
    }

    public TankType getTankType() {
        return tankType;
    }

    public void setTankType(TankType tankType) {
        this.tankType = tankType;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
        ImageIcon tankImage = null;

        if (tankType.equals(TankType.Ally))
        {
            if (!damaged) {
                switch (orientation) {
                    case Right -> tankImage = ImageCache.loadImage("src/main/java/imagenes/yellowTankRIGHT.png");
                    case Left -> tankImage = ImageCache.loadImage("src/main/java/imagenes/yellowTankLEFT.png");
                    case Down -> tankImage = ImageCache.loadImage("src/main/java/imagenes/yellowTankDOWN.png");
                    case Up -> tankImage = ImageCache.loadImage("src/main/java/imagenes/yellowTankUP.png");
                }
            } else {
                switch (orientation) {
                    case Right -> tankImage = ImageCache.loadImage("src/main/java/imagenes/damagedRIGHT.gif");
                    case Left -> tankImage = ImageCache.loadImage("src/main/java/imagenes/damagedLEFT.gif");
                    case Down -> tankImage = ImageCache.loadImage("src/main/java/imagenes/damagedDOWN.gif");
                    case Up -> tankImage = ImageCache.loadImage("src/main/java/imagenes/damagedUP.gif");
                }
            }

        } else {

            if (tankType.equals(TankType.Simple))
            {
                switch (orientation) {
                    case Right -> tankImage = ImageCache.loadImage("src/main/java/imagenes/simpleTankRIGHT.png");
                    case Left -> tankImage = ImageCache.loadImage("src/main/java/imagenes/simpleTankLEFT.png");
                    case Down -> tankImage = ImageCache.loadImage("src/main/java/imagenes/simpleTankDOWN.png");
                    case Up -> tankImage = ImageCache.loadImage("src/main/java/imagenes/simpleTankUP.png");
                }

            } else if (tankType.equals(TankType.FastMove)) {
                switch (orientation) {
                    case Right -> tankImage = ImageCache.loadImage("src/main/java/imagenes/fastMoveTankRIGHT.png");
                    case Left -> tankImage = ImageCache.loadImage("src/main/java/imagenes/fastMoveTankLEFT.png");
                    case Down -> tankImage = ImageCache.loadImage("src/main/java/imagenes/fastMoveTankDOWN.png");
                    case Up -> tankImage = ImageCache.loadImage("src/main/java/imagenes/fastMoveTankUP.png");
                }

            } else if (tankType.equals(TankType.FastShoot)) {
                switch (orientation) {
                    case Right -> tankImage = ImageCache.loadImage("src/main/java/imagenes/fastShootTankRIGHT.png");
                    case Left -> tankImage = ImageCache.loadImage("src/main/java/imagenes/fastShootTankLEFT.png");
                    case Down -> tankImage = ImageCache.loadImage("src/main/java/imagenes/fastShootTankDOWN.png");
                    case Up -> tankImage = ImageCache.loadImage("src/main/java/imagenes/fastShootTankUP.png");
                }

            } else if (tankType.equals(TankType.Resistant)){
                switch (orientation) {
                    case Right -> tankImage = ImageCache.loadImage("src/main/java/imagenes/resistantTankRIGHT.png");
                    case Left -> tankImage = ImageCache.loadImage("src/main/java/imagenes/resistantTankLEFT.png");
                    case Down -> tankImage = ImageCache.loadImage("src/main/java/imagenes/resistantTankDOWN.png");
                    case Up -> tankImage = ImageCache.loadImage("src/main/java/imagenes/resistantTankUP.png");
                }

            } else
                switch (orientation) {
                    case Right -> tankImage = ImageCache.loadImage("src/main/java/imagenes/redTankRIGHT.gif");
                    case Left -> tankImage = ImageCache.loadImage("src/main/java/imagenes/redTankLEFT.gif");
                    case Down -> tankImage = ImageCache.loadImage("src/main/java/imagenes/redTankDOWN.gif");
                    case Up -> tankImage = ImageCache.loadImage("src/main/java/imagenes/redTankUP.gif");
                }

            label.setBounds(location.x, location.y, 60,60);
        }

        label.setIcon(tankImage);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        if (!observers.isEmpty()) {
            observers.get(0).update();
            observers.remove(observers.get(0));
        }

    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }
}
