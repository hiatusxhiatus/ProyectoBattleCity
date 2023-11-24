package Interfaces;

import Enums.BrickState;
import Enums.Orientation;
import Enums.StructureType;

import javax.print.attribute.standard.OrientationRequested;
import javax.swing.*;
import java.awt.*;

public interface IStructure {

    void setHP(int hp, Orientation orientation);
    int getHP();
    Point getLocation();
    JLabel getLabel();
    StructureType getType();
    BrickState getState();
    void setState(BrickState state);
}
