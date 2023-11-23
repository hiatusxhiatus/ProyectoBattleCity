package Structures;

import Enums.BrickState;
import Enums.StructureType;
import Interfaces.IStructure;

import javax.swing.*;
import java.awt.*;

public class BrickStructure implements IStructure {

    private int hp;
    private Point location;
    private JLabel label;
    private StructureType type;
    private BrickState state;

    public BrickStructure(Point location) {
        this.hp = 4;
        this.label = new JLabel();
        this.type = StructureType.Brick;
        this.state = BrickState.Complete;
        this.location = location;
        setUpLabel();
    }

    public void setUpLabel() {

        label.setIcon(new ImageIcon("src/main/java/imagenes/brick.png"));
        label.setBounds(location.x, location.y, 32, 32);
        label.setLocation(location);

    }

    public void setNewStateAndAppearance(BrickState state) {

        this.state = state;

        switch (state) {
            case Top -> label.setIcon(new ImageIcon("src/main/java/imagenes/brickT.png"));
            case Left -> label.setIcon(new ImageIcon("src/main/java/imagenes/brickL.png"));
            case Right -> label.setIcon(new ImageIcon("src/main/java/imagenes/brickR.png"));
            case Bottom -> label.setIcon(new ImageIcon("src/main/java/imagenes/brickB.png"));
            case TopLeft -> label.setIcon(new ImageIcon("src/main/java/imagenes/brickTL.png"));
            case TopRight -> label.setIcon(new ImageIcon("src/main/java/imagenes/brickTR.png"));
            case BottomLeft -> label.setIcon(new ImageIcon("src/main/java/imagenes/brickBL.png"));
            case BottomRight -> label.setIcon(new ImageIcon("src/main/java/imagenes/brickBR.png"));
            case TopLeftCorner -> label.setIcon(new ImageIcon("src/main/java/imagenes/brickTLCorner.png"));
            case TopRightCorner -> label.setIcon(new ImageIcon("src/main/java/imagenes/brickTRCorner.png"));
            case BottomLeftCorner -> label.setIcon(new ImageIcon("src/main/java/imagenes/brickBLCorner.png"));
            case BottomRightCorner -> label.setIcon(new ImageIcon("src/main/java/imagenes/brickBRCorner.png"));
        }

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
        return state;
    }

    @Override
    public void setState(BrickState state) {
        setNewStateAndAppearance(state);
    }

}
