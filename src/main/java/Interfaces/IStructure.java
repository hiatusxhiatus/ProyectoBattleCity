package Interfaces;

import Enums.BrickState;
import Enums.StructureType;

import javax.swing.*;
import java.awt.*;

public interface IStructure {

    int getHP();
    Point getLocation();
    JLabel getLabel();
    StructureType getType();
    BrickState getState();
    void setState(BrickState state);
}
