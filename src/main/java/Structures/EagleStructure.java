package Structures;

import Enums.BrickState;
import Enums.Orientation;
import Enums.StructureType;
import Interfaces.IStructure;

import javax.swing.*;
import java.awt.*;

public class EagleStructure implements IStructure {

    private int hp;
    private Point location;
    private JLabel label;
    private StructureType type;

    public EagleStructure(Point location) {
        this.hp = 1;
        this.label = new JLabel();
        this.type = StructureType.Eagle;
        this.location = location;
        setUpLabel();
    }

    public void setUpLabel() {

        label.setIcon(new ImageIcon("src/main/java/imagenes/eagle.png"));
        label.setBounds(location.x, location.y, 64, 64);
        label.setLocation(location);

    }

    @Override
    public void setHP(int hp, Orientation orientation) {
        this.hp = hp;
    }

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public Point getLocation() {
        return location;
    }

    @Override
    public JLabel getLabel() {
        return label;
    }

    @Override
    public StructureType getType() {
        return type;
    }

    @Override
    public BrickState getState() {
        return null;
    }

    @Override
    public void setState(BrickState state) {

    }
}
