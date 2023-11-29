package Interfaces;

import Enums.BrickState;
import Enums.Orientation;
import Enums.StructureType;

import javax.print.attribute.standard.OrientationRequested;
import javax.swing.*;
import java.awt.*;

public interface IStructure {

    int getHP();
    JLabel getLabel();
    Point getLocation();
    BrickState getState();
    StructureType getType();
    void setState(BrickState state);
    void setType(StructureType type);
    void setHP(int hp, Orientation orientation);
}
