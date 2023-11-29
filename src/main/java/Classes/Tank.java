package Classes;

import Enums.Orientation;
import Enums.TankType;
import Interfaces.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import javax.swing.*;
import java.awt.*;

public class Tank implements IPrototype, IObservable {

    private int hp;
    private int speed;
    private int shootingRate;
    private boolean isActive;
    private boolean isPaused;
    private boolean isProtected;
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
        this.isPaused = false;
        this.isProtected = false;
        this.observers = new ArrayList<>();
        setUpLabel();
    }

    public void executeCommand(TankCommand command) {
        command.execute();
    }

    public void setUpLabel() {
        if (tankType.equals(TankType.Ally))
            setDamaged();

        setNewAppearance();

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

    public void setProtected() {

        Thread helmetProtection = new Thread(() -> {

            try {
                isProtected = true;
                Thread.sleep(10000);
                isProtected = false;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        helmetProtection.start();

    }

    public void setDamaged() {

        Thread damaged = new Thread(() -> {

            try {
                this.isProtected = true;
                Thread.sleep(3000);
                this.isProtected = false;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        damaged.start();

    }

    public void setNewAppearance() {
        ImageIcon tankImage = null;

        if (tankType.equals(TankType.Ally))
        {
            if (!isProtected) {
                switch (orientation) {
                    case Right -> tankImage = ImageCache.loadImage("resources/Images/yellowTankRIGHT.png");
                    case Left -> tankImage = ImageCache.loadImage("resources/Images/yellowTankLEFT.png");
                    case Down -> tankImage = ImageCache.loadImage("resources/Images/yellowTankDOWN.png");
                    case Up -> tankImage = ImageCache.loadImage("resources/Images/yellowTankUP.png");
                }
            } else {
                switch (orientation) {
                    case Right ->tankImage = ImageCache.loadImage("resources/Images/protectedTankRIGHT.gif");
                    case Left -> tankImage = ImageCache.loadImage("resources/Images/protectedTankLEFT.gif");
                    case Down -> tankImage = ImageCache.loadImage("resources/Images/protectedTankDOWN.gif");
                    case Up -> tankImage = ImageCache.loadImage("resources/Images/protectedTankUP.gif");
                }
            }

        } else {

            if (tankType.equals(TankType.Simple))
            {
                switch (orientation) {
                    case Right -> tankImage = ImageCache.loadImage("resources/Images/simpleTankRIGHT.png");
                    case Left -> tankImage = ImageCache.loadImage("resources/Images/simpleTankLEFT.png");
                    case Down -> tankImage = ImageCache.loadImage("resources/Images/simpleTankDOWN.png");
                    case Up -> tankImage = ImageCache.loadImage("resources/Images/simpleTankUP.png");
                }

            } else if (tankType.equals(TankType.FastMove)) {
                switch (orientation) {
                    case Right -> tankImage = ImageCache.loadImage("resources/Images/fastMoveTankRIGHT.png");
                    case Left -> tankImage = ImageCache.loadImage("resources/Images/fastMoveTankLEFT.png");
                    case Down -> tankImage = ImageCache.loadImage("resources/Images/fastMoveTankDOWN.png");
                    case Up -> tankImage = ImageCache.loadImage("resources/Images/fastMoveTankUP.png");
                }

            } else if (tankType.equals(TankType.FastShoot)) {
                switch (orientation) {
                    case Right -> tankImage = ImageCache.loadImage("resources/Images/fastShootTankRIGHT.png");
                    case Left -> tankImage = ImageCache.loadImage("resources/Images/fastShootTankLEFT.png");
                    case Down -> tankImage = ImageCache.loadImage("resources/Images/fastShootTankDOWN.png");
                    case Up -> tankImage = ImageCache.loadImage("resources/Images/fastShootTankUP.png");
                }

            } else if (tankType.equals(TankType.Resistant)){
                switch (orientation) {
                    case Right -> tankImage = ImageCache.loadImage("resources/Images/resistantTankRIGHT.png");
                    case Left -> tankImage = ImageCache.loadImage("resources/Images/resistantTankLEFT.png");
                    case Down -> tankImage = ImageCache.loadImage("resources/Images/resistantTankDOWN.png");
                    case Up -> tankImage = ImageCache.loadImage("resources/Images/resistantTankUP.png");
                }

            } else
                switch (orientation) {
                    case Right -> tankImage = ImageCache.loadImage("resources/Images/redTankRIGHT.gif");
                    case Left -> tankImage = ImageCache.loadImage("resources/Images/redTankLEFT.gif");
                    case Down -> tankImage = ImageCache.loadImage("resources/Images/redTankDOWN.gif");
                    case Up -> tankImage = ImageCache.loadImage("resources/Images/redTankUP.gif");
                }

            label.setBounds(location.x, location.y, 60,60);
        }

        label.setIcon(tankImage);

    }

    // GETTERs AND SETTERs

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {

        if (!isProtected)
        {
            this.hp = hp;
            if (hp <= 0)
                isActive = false;
        }

        if (tankType.equals(TankType.Ally))
            setDamaged();
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

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(int x, int y) {
        this.location = new Point(x, y);
        this.label.setLocation(location);
        setNewAppearance();
    }

    public TankType getTankType() {
        return tankType;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
        setNewAppearance();
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

    public void setShootingRate(int shootingRate) {
        this.shootingRate = shootingRate;
    }

    public void setProtected(boolean aProtected) {
        isProtected = aProtected;
    }


}
