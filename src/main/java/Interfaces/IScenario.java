package Interfaces;

import javax.swing.*;
import java.util.ArrayList;

public interface IScenario {

    void initScenario();
    JPanel getPanel();
    JPanel getPanelGame();
    ArrayList<IStructure> getStructures();
    IStructure getEagle();

}
