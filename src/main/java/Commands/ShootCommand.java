package Commands;

import Classes.Bullet;
import Classes.Game;
import Classes.Tank;
import Enums.Orientation;
import Interfaces.TankCommand;

import javax.swing.*;
import java.awt.*;

public class ShootCommand implements TankCommand {

    private final Bullet bullet;

    public ShootCommand(Bullet bullet) {
        this.bullet = bullet;
    }

    @Override
    public void execute() {

        switch (bullet.getOrientation()) {
            case Up -> bullet.setLocation(bullet.getLocation().x, bullet.getLocation().y-13);
            case Down -> bullet.setLocation(bullet.getLocation().x, bullet.getLocation().y+13);
            case Left -> bullet.setLocation(bullet.getLocation().x-13, bullet.getLocation().y);
            case Right -> bullet.setLocation(bullet.getLocation().x+13, bullet.getLocation().y);
        }
    }

}
