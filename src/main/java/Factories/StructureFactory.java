package Factories;

import Interfaces.IStructure;
import java.awt.*;

public abstract class StructureFactory {

    public abstract IStructure createStructure(Point location);

}
