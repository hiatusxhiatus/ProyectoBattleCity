package Interfaces;

import Enums.Keys;

public interface IObservable {

    public void addObserver(IObserver observer);
    public void removeObserver(IObserver observer);
    void notifyObservers();

}
