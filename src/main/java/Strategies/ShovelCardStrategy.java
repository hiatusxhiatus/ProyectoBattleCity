package Strategies;

import Classes.Game;
import Enums.StructureType;
import Interfaces.IStrategy;
import Interfaces.IStructure;

import java.awt.*;

public class ShovelCardStrategy implements IStrategy {

    @Override
    public void setBonusCard(Game game) {

        Thread thread = new Thread(() -> {

            try {
                boolean isStructure;

                for (IStructure structure : game.getScenario().getStructures())
                {
                    isStructure = false;
                    if (structure.getLocation().equals(new Point(352, 736)))
                        isStructure = true;
                    else if (structure.getLocation().equals(new Point(352, 768)))
                        isStructure = true;
                    else if (structure.getLocation().equals(new Point(352, 800)))
                        isStructure = true;
                    else if (structure.getLocation().equals(new Point(384, 736)))
                        isStructure = true;
                    else if (structure.getLocation().equals(new Point(416, 736)))
                        isStructure = true;
                    else if (structure.getLocation().equals(new Point(448, 736)))
                        isStructure = true;
                    else if (structure.getLocation().equals(new Point(448, 768)))
                        isStructure = true;
                    else if (structure.getLocation().equals(new Point(448, 800)))
                        isStructure = true;

                    if (isStructure)
                        structure.setType(StructureType.Wall);
                }

                Thread.sleep(20000);

                for (IStructure structure : game.getScenario().getStructures())
                {
                    isStructure = false;
                    if (structure.getLocation().equals(new Point(352, 736)))
                        isStructure = true;
                    else if (structure.getLocation().equals(new Point(352, 768)))
                        isStructure = true;
                    else if (structure.getLocation().equals(new Point(352, 800)))
                        isStructure = true;
                    else if (structure.getLocation().equals(new Point(384, 736)))
                        isStructure = true;
                    else if (structure.getLocation().equals(new Point(416, 736)))
                        isStructure = true;
                    else if (structure.getLocation().equals(new Point(448, 736)))
                        isStructure = true;
                    else if (structure.getLocation().equals(new Point(448, 768)))
                        isStructure = true;
                    else if (structure.getLocation().equals(new Point(448, 800)))
                        isStructure = true;

                    if (isStructure)
                        structure.setType(StructureType.Brick);

                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        thread.start();

    }
}
