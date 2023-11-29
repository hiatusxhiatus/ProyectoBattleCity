package Interfaces;

import Observers.BulletObserver;
import Observers.CardObserver;
import Observers.TankObserver;
import javax.swing.*;
import java.util.ArrayList;

public interface IScenario {

    ArrayList<IStructure> getStructures();
    ArrayList<TankObserver> getTanksLeft();
    BulletObserver getBulletCounter();
    CardObserver getCardCounter();
    IStructure getEagle();
    JPanel getPanelGame();
    JPanel getPanel();
    JLabel getLabelPressEnter();
    void resetPanel();
    void setHP(int hp);

}
