package Commands;

import Classes.Tank;
import Enums.Orientation;
import Enums.TankType;
import Interfaces.TankCommand;

import javax.swing.*;
import java.util.Random;

public class MoveCommand implements TankCommand {

    private final Tank tank;

    public MoveCommand(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void execute() {

        if (tank.getOrientation().equals(Orientation.Right)) {

            tank.setLocation((tank.getLocation().x+3), tank.getLocation().y);
            tank.getLabel().getLocation().setLocation(tank.getLocation().x, tank.getLocation().y);
            tank.getLabel().setIcon(new ImageIcon("src/main/java/imagenes/yellowTankRIGHTCHIKITO.png"));

        } else if (tank.getOrientation().equals(Orientation.Left)) {

            tank.setLocation((tank.getLocation().x-3), tank.getLocation().y);
            tank.getLabel().getLocation().setLocation(tank.getLocation().x, tank.getLocation().y);
            tank.getLabel().setIcon(new ImageIcon("src/main/java/imagenes/yellowTankLEFTCHIKITO.png"));

        } else if (tank.getOrientation().equals(Orientation.Up)) {
            tank.setLocation((tank.getLocation().x), tank.getLocation().y-3);
            tank.getLabel().getLocation().setLocation(tank.getLocation().x, tank.getLocation().y);
            tank.getLabel().setIcon(new ImageIcon("src/main/java/imagenes/yellowTankUPCHIKITO.png"));

        } else {
            tank.setLocation((tank.getLocation().x), tank.getLocation().y+3);
            tank.getLabel().getLocation().setLocation(tank.getLocation().x, tank.getLocation().y);
            tank.getLabel().setIcon(new ImageIcon("src/main/java/imagenes/yellowTankDOWNCHIKITO.png"));
        }
    }
}
