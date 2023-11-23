package Factories;

import Interfaces.IStructure;
import Structures.WaterStructure;
import java.awt.*;

public class WaterStructureFactory extends StructureFactory{

    public WaterStructureFactory() {
    }

    @Override
    public IStructure createStructure(Point location) {
        return new WaterStructure(location);
    }
}
