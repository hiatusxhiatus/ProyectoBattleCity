package Threads;

import Classes.Game;
import Classes.Tank;
import Commands.MoveCommand;
import Enums.Orientation;

public class ThreadEnemyMove extends  Thread {

    private boolean isRunning;
    private Game game;
    private Tank tank;

    public ThreadEnemyMove(Game game, Tank tank) {
        this.game = game;
        this.tank = tank;
        isRunning = true;
    }

    @Override
    public void run() {

        boolean isWall;

        try {

            while (isRunning && tank.isActive()) {

                if (!tank.isPaused()) {

                    isWall = false;

                    if (tank.getOrientation().equals(Orientation.Up)) {
                        if (tank.getLocation().y - 5 > 0 && game.validateMovement(game.generateRange(tank.getLocation().x, 60), game.generateRange(tank.getLocation().y - 5, 60), false, tank.getOrientation(), false, tank)) {
                            tank.setOrientation(Orientation.Up);
                            tank.executeCommand(new MoveCommand(tank));
                        } else
                            isWall = true;

                    } else if (tank.getOrientation().equals(Orientation.Down)) {

                        if (tank.getLocation().y + 5 + 60 < 832 && game.validateMovement(game.generateRange(tank.getLocation().x, 60), game.generateRange(tank.getLocation().y + 5, 60), false, tank.getOrientation(), false, tank)) {
                            tank.setOrientation(Orientation.Down);
                            tank.executeCommand(new MoveCommand(tank));
                        } else
                            isWall = true;

                    } else if (tank.getOrientation().equals(Orientation.Left)) {

                        if (tank.getLocation().x - 5 > 0 && game.validateMovement(game.generateRange(tank.getLocation().x - 5, 60), game.generateRange(tank.getLocation().y, 60), false, tank.getOrientation(), false, tank)) {
                            tank.setOrientation(Orientation.Left);
                            tank.executeCommand(new MoveCommand(tank));
                        } else
                            isWall = true;

                    } else if (tank.getOrientation().equals(Orientation.Right)) {

                        if (tank.getLocation().x + 5 + 60 < 832 && game.validateMovement(game.generateRange(tank.getLocation().x + 5, 60), game.generateRange(tank.getLocation().y, 60), false, tank.getOrientation(), false, tank)) {
                            tank.setOrientation(Orientation.Right);
                            tank.executeCommand(new MoveCommand(tank));
                        } else
                            isWall = true;
                    }

                    if (isWall) {
                        sleep(1000);
                        tank.setOrientation(game.randomOrientation());
                    }
                }
                    sleep(17);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
