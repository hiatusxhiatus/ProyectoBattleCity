package Structures;

import Enums.BrickState;
import Enums.StructureType;
import Interfaces.IStructure;

import javax.swing.*;
import java.awt.*;

public class WallStructure implements IStructure {

    private int hp;
    private Point location;
    private JLabel label;
    private StructureType type;

    public WallStructure(Point location) {
        this.hp = Integer.MAX_VALUE;
        this.label = new JLabel();
        this.type = StructureType.Wall;
        this.location = location;
        setUpLabel();
    }

    public void setUpLabel() {

        label.setIcon(new ImageIcon("src/main/java/imagenes/wall.png"));
        label.setBounds(location.x, location.y, 32, 32);
        label.setLocation(location);

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