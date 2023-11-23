package Factories;

import Interfaces.IStructure;
import Structures.BrickStructure;

import java.awt.*;

public class BrickStructureFactory extends StructureFactory {

    public BrickStructureFactory() {
    }

    @Override
    public IStructure createStructure(Point location) {
        return new BrickStructure(location);
    }
}
