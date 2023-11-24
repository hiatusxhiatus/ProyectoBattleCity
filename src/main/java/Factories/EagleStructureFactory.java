package Factories;

import Interfaces.IStructure;
import Structures.EagleStructure;
import java.awt.*;

public class EagleStructureFactory extends StructureFactory{

    @Override
    public IStructure createStructure(Point location) {
        return new EagleStructure(location);
    }
}
