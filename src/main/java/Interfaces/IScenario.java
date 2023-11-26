package Interfaces;

import Observers.BulletObserver;
import Observers.CardObserver;
import Observers.TankObserver;

import javax.swing.*;
import java.util.ArrayList;

public interface IScenario {

    void initScenario();
    JPanel getPanel();
    JPanel getPanelGame();
    ArrayList<IStructure> getStructures();
    ArrayList<TankObserver> getTanksLeft();
    ArrayList<CardObserver> getCardsGotten();
    BulletObserver getBulletCounter();
    void setHP(int hp);
    IStructure getEagle();


}
