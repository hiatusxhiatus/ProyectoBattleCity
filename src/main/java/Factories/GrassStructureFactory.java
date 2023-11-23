package Factories;

import Interfaces.IStructure;
import Structures.GrassStructure;

import java.awt.*;

public class GrassStructureFactory extends StructureFactory{

    public GrassStructureFactory() {
    }

    @Override
    public IStructure createStructure(Point location) {
        return new GrassStructure(location);
    }
}
