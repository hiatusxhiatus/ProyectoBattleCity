package Structures;

import Classes.ImageCache;
import Enums.BrickState;
import Enums.Orientation;
import Enums.StructureType;
import Interfaces.IStructure;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
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
        label.setIcon(ImageCache.loadImage("src/main/java/imagenes/brick.png"));
        label.setBounds(location.x, location.y, 32, 32);
        label.setLocation(location);

    }

    public void setNewAppearance() {

        switch (state) {
            case Top -> label.setIcon(ImageCache.loadImage("src/main/java/imagenes/brickT.png"));
            case Left -> label.setIcon(ImageCache.loadImage("src/main/java/imagenes/brickL.png"));
            case Right -> label.setIcon(ImageCache.loadImage("src/main/java/imagenes/brickR.png"));
            case Bottom -> label.setIcon(ImageCache.loadImage("src/main/java/imagenes/brickB.png"));
            case TopLeft -> label.setIcon(ImageCache.loadImage("src/main/java/imagenes/brickTL.png"));
            case TopRight -> label.setIcon(ImageCache.loadImage("src/main/java/imagenes/brickTR.png"));
            case BottomLeft -> label.setIcon(ImageCache.loadImage("src/main/java/imagenes/brickBL.png"));
            case BottomRight -> label.setIcon(ImageCache.loadImage("src/main/java/imagenes/brickBR.png"));
            case TopLeftCorner -> label.setIcon(ImageCache.loadImage("src/main/java/imagenes/brickTLCorner.png"));
            case TopRightCorner -> label.setIcon(ImageCache.loadImage("src/main/java/imagenes/brickTRCorner.png"));
            case BottomLeftCorner -> label.setIcon(ImageCache.loadImage("src/main/java/imagenes/brickBLCorner.png"));
            case BottomRightCorner -> label.setIcon(ImageCache.loadImage("src/main/java/imagenes/brickBRCorner.png"));
        }
    }

    public void setNewState(Orientation orientation) {

        switch (state) {

            case Complete:
                if (orientation.equals(Orientation.Up))
                    state = BrickState.Bottom;
                else if (orientation.equals(Orientation.Down))
                    state = BrickState.Top;
                else if (orientation.equals(Orientation.Left))
                    state = BrickState.Right;
                else if (orientation.equals(Orientation.Right))
                    state = BrickState.Left;
                break;
            case Top:
                if (orientation.equals(Orientation.Up))
                    state = BrickState.Destroyed;
                else if (orientation.equals(Orientation.Down))
                    state = BrickState.Destroyed;
                else if (orientation.equals(Orientation.Left))
                    state = BrickState.TopRight;
                else if (orientation.equals(Orientation.Right))
                    state = BrickState.TopLeft;
                break;
            case Bottom:
                if (orientation.equals(Orientation.Up))
                    state = BrickState.Destroyed;
                else if (orientation.equals(Orientation.Down))
                    state = BrickState.Destroyed;
                else if (orientation.equals(Orientation.Left))
                    state = BrickState.BottomRight;
                else if (orientation.equals(Orientation.Right))
                    state = BrickState.BottomLeft;
                break;
            case Left:
                if (orientation.equals(Orientation.Up))
                    state = BrickState.BottomLeft;
                else if (orientation.equals(Orientation.Down))
                    state = BrickState.TopLeft;
                else if (orientation.equals(Orientation.Left))
                    state = BrickState.Destroyed;
                else if (orientation.equals(Orientation.Right))
                    state = BrickState.Destroyed;
                break;
            case Right:
                if (orientation.equals(Orientation.Up))
                    state = BrickState.BottomRight;
                else if (orientation.equals(Orientation.Down))
                    state = BrickState.TopRight;
                else if (orientation.equals(Orientation.Left))
                    state = BrickState.Destroyed;
                else if (orientation.equals(Orientation.Right))
                    state = BrickState.Destroyed;
                break;
            case TopLeft, TopRight, BottomLeft, BottomRight:
                if (orientation.equals(Orientation.Up))
                    state = BrickState.Destroyed;
                else if (orientation.equals(Orientation.Down))
                    state = BrickState.Destroyed;
                else if (orientation.equals(Orientation.Left))
                    state = BrickState.Destroyed;
                else if (orientation.equals(Orientation.Right))
                    state = BrickState.Destroyed;
                break;
            case TopLeftCorner:
                if (orientation.equals(Orientation.Up))
                    state = BrickState.BottomLeft;
                else if (orientation.equals(Orientation.Down))
                    state = BrickState.Top;
                else if (orientation.equals(Orientation.Left))
                    state = BrickState.TopRight;
                else if (orientation.equals(Orientation.Right))
                    state = BrickState.Left;
                break;
            case TopRightCorner:
                if (orientation.equals(Orientation.Up))
                    state = BrickState.BottomRight;
                else if (orientation.equals(Orientation.Down))
                    state = BrickState.Top;
                else if (orientation.equals(Orientation.Left))
                    state = BrickState.Right;
                else if (orientation.equals(Orientation.Right))
                    state = BrickState.TopLeft;
                break;
            case BottomLeftCorner:
                if (orientation.equals(Orientation.Up))
                    state = BrickState.Bottom;
                else if (orientation.equals(Orientation.Down))
                    state = BrickState.TopLeft;
                else if (orientation.equals(Orientation.Left))
                    state = BrickState.BottomRight;
                else if (orientation.equals(Orientation.Right))
                    state = BrickState.Left;
                break;
            case BottomRightCorner:
                if (orientation.equals(Orientation.Up))
                    state = BrickState.Bottom;
                else if (orientation.equals(Orientation.Down))
                    state = BrickState.TopRight;
                else if (orientation.equals(Orientation.Left))
                    state = BrickState.Right;
                else if (orientation.equals(Orientation.Right))
                    state = BrickState.BottomLeft;
                break;
        }

    }


    @Override
    public void setHP(int hp, Orientation orientation) {
        this.hp = hp;
        setNewState(orientation);
        setNewAppearance();
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
        //setNewStateAndAppearance(state);
    }

}
