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

        switch (tank.getOrientation()) {
            case Right:
                tank.setLocation((tank.getLocation().x + 5), tank.getLocation().y);
                tank.getLabel().getLocation().setLocation(tank.getLocation().x, tank.getLocation().y);
                break;
            case Left:
                tank.setLocation((tank.getLocation().x - 5), tank.getLocation().y);
                tank.getLabel().getLocation().setLocation(tank.getLocation().x, tank.getLocation().y);
                break;

            case Up:
                tank.setLocation((tank.getLocation().x), tank.getLocation().y - 5);
                tank.getLabel().getLocation().setLocation(tank.getLocation().x, tank.getLocation().y);
                break;
            case Down:
                tank.setLocation((tank.getLocation().x), tank.getLocation().y + 5);
                tank.getLabel().getLocation().setLocation(tank.getLocation().x, tank.getLocation().y);
                break;
        }

    }
}


