package Interfaces;

import Enums.Keys;

public interface IObserver {
    void updateKey(Keys key, boolean isPressed);
}