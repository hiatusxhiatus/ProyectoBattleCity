package Classes;

import Enums.TankType;
import Interfaces.IPrototype;
import java.util.ArrayList;

import javax.swing.*;

public class Tank implements IPrototype {

    private int hp;
    private int speed;
    private int shootingRate;
    private JLabel label;
    private TankType tankType;

    private ArrayList<Integer> XRange;
    private ArrayList<Integer> YRange;

    public Tank(int hp, int speed, int shootingRate, JLabel label, TankType tankType) {
        this.hp = hp;
        this.speed = speed;
        this.shootingRate = shootingRate;
        this.label = label;
        this.tankType = tankType;
        this.XRange = new ArrayList<Integer>();
        this.YRange = new ArrayList<Integer>();
        setUpLabel();
    }

    public Tank(Tank tank) {

        this.hp = tank.hp;
        this.tankType = tank.tankType;
        this.speed = tank.speed;
        this.label = tank.label;
        this.shootingRate = tank.shootingRate;
        this.XRange = tank.XRange;
        this.YRange = tank.YRange;
    }

    public void setUpLabel() {

        switch (tankType) {
            case Ally -> label.setIcon(new ImageIcon("src/main/java/imagenes/yellowTankRIGHT.png"));
            case Simple -> label.setIcon(new ImageIcon("src/main/java/imagenes/simpleTankRIGHT.png"));
            case FastMove -> label.setIcon(new ImageIcon("src/main/java/imagenes/fastMoveTankRIGHT.png"));
            case FastShoot -> label.setIcon(new ImageIcon("src/main/java/imagenes/fastShootTankRIGHT.png"));
            case Resistant -> label.setIcon(new ImageIcon("src/main/java/imagenes/resistantTankRIGHT.png"));
        }

        label.setBounds(0, 0, 64, 64);
        label.setLocation(0,0);
    }

    @Override
    public Tank clone() {

        Tank clonedTank = new Tank(this.hp, this.speed, this.shootingRate, new JLabel(), this.tankType);

        clonedTank.XRange = new ArrayList<>(this.XRange.size());
        for (Integer value : this.XRange) {
            clonedTank.XRange.add(value);
        }

        // Copiar YRange
        clonedTank.YRange = new ArrayList<>(this.YRange.size());
        for (Integer value : this.YRange) {
            clonedTank.YRange.add(value);
        }

        // Clonar el JLabel
        JLabel clonedLabel = new JLabel();
        clonedLabel.setIcon(this.label.getIcon());  // Puedes necesitar copiar más atributos según tus necesidades
        clonedLabel.setBounds(this.label.getBounds());
        clonedLabel.setLocation(this.label.getLocation());

        clonedTank.hp = this.hp;
        clonedTank.speed = this.speed;
        clonedTank.shootingRate = this.shootingRate;
        clonedTank.tankType = this.tankType;

        return clonedTank;
    }

    public void setXRange(int cordX) {

        XRange.clear();

        int lastCord = cordX + 63;

        for (int i = cordX; i < lastCord; i++)
            this.XRange.add(i);

    }

    public void setYRange(int cordY) {

        YRange.clear();

        int lastCord = cordY + 63;

        for (int i = cordY; i < lastCord; i++)
            this.YRange.add(i);
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

}
