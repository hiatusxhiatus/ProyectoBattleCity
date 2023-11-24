package Classes;

import Enums.Orientation;
import Enums.TankType;
import Interfaces.*;
import java.awt.*;
import javax.swing.*;

public class Tank implements IPrototype {

    private int hp;
    private int speed;
    private int shootingRate;
    private boolean isActive;
    private Point location;
    private JLabel label;
    private TankType tankType;
    private Orientation orientation;

    public Tank(int hp, int speed, int shootingRate, JLabel label, TankType tankType) {
        this.hp = hp;
        this.speed = speed;
        this.shootingRate = shootingRate;
        this.label = label;
        this.tankType = tankType;
        this.location = new Point(0,0);
        this.orientation = Orientation.Up;
        this.isActive = false;
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

        switch (tankType) {
            case Ally -> label.setIcon(new ImageIcon("src/main/java/imagenes/yellowTankUP.png"));
            case Simple -> label.setIcon(new ImageIcon("src/main/java/imagenes/simpleTankDOWN.png"));
            case FastMove -> label.setIcon(new ImageIcon("src/main/java/imagenes/fastMoveTankDOWN.png"));
            case FastShoot -> label.setIcon(new ImageIcon("src/main/java/imagenes/fastShootTankDOWN.png"));
            case Resistant -> label.setIcon(new ImageIcon("src/main/java/imagenes/resistantTankDOWN.png"));
        }

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
        this.hp = hp;
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
        label.setBounds(x, y, 52, 52);
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

        if (tankType.equals(TankType.Ally))
        {
            switch (orientation) {
                case Right -> label.setIcon(new ImageIcon("src/main/java/imagenes/yellowTankRIGHT.png"));
                case Left -> label.setIcon(new ImageIcon("src/main/java/imagenes/yellowTankLEFT.png"));
                case Down -> label.setIcon(new ImageIcon("src/main/java/imagenes/yellowTankDOWN.png"));
                case Up -> label.setIcon(new ImageIcon("src/main/java/imagenes/yellowTankUP.png"));
            }
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
