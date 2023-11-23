package Interfaces;

import Classes.Tank;

public interface IPrototype extends Cloneable {

    Tank clone();

}
