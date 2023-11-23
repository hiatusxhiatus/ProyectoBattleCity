package Factories;

import Interfaces.IStructure;
import Structures.WallStructure;

import java.awt.*;

public class WallStructureFactory extends StructureFactory {

    public WallStructureFactory() {
    }

    @Override
    public IStructure createStructure(Point location) {
        return new WallStructure(location);
    }
}
