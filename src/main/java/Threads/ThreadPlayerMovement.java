package Threads;

import Classes.Game;
import Commands.MoveCommand;
import Enums.Orientation;

public class ThreadPlayerMovement extends Thread {

    Game game;

    public ThreadPlayerMovement(Game game) {
        this.game = game;
    }

    public void run() {

        while (game.isGameRunning())
        {
            int speed = 4 + game.getPlayerTank().getSpeed();

            try {
                if (game.isMovingRight()) {

                    if (game.getPlayerTank().getLocation().x+speed+52 < 832 && game.validateMovement(game.generateRange(game.getPlayerTank().getLocation().x+speed, 52), game.generateRange(game.getPlayerTank().getLocation().y, 52), false, game.getPlayerTank().getOrientation(), true, game.getPlayerTank()))
                    {
                        game.getPlayerTank().setOrientation(Orientation.Right);
                        game.getPlayerTank().executeCommand(new MoveCommand(game.getPlayerTank()));
                    }

                } else if (game.isMovingLeft()) {

                    if (game.getPlayerTank().getLocation().x-speed > 0 && game.validateMovement(game.generateRange(game.getPlayerTank().getLocation().x-speed, 52), game.generateRange(game.getPlayerTank().getLocation().y, 52), false, game.getPlayerTank().getOrientation(), true, game.getPlayerTank()))
                    {
                        game.getPlayerTank().setOrientation(Orientation.Left);
                        game.getPlayerTank().executeCommand(new MoveCommand(game.getPlayerTank()));
                    }

                } else if (game.isMovingUp()) {

                    if (game.getPlayerTank().getLocation().y-speed > 0 && game.validateMovement(game.generateRange(game.getPlayerTank().getLocation().x, 52), game.generateRange(game.getPlayerTank().getLocation().y-speed,52), false, game.getPlayerTank().getOrientation(), true, game.getPlayerTank()))
                    {
                        game.getPlayerTank().setOrientation(Orientation.Up);
                        game.getPlayerTank().executeCommand(new MoveCommand(game.getPlayerTank()));
                    }

                } else if (game.isMovingDown()) {

                    if (game.getPlayerTank().getLocation().y+speed+52 < 832 && game.validateMovement(game.generateRange(game.getPlayerTank().getLocation().x, 52), game.generateRange(game.getPlayerTank().getLocation().y+speed,52), false, game.getPlayerTank().getOrientation(), true, game.getPlayerTank()))
                    {
                        game.getPlayerTank().setOrientation(Orientation.Down);
                        game.getPlayerTank().executeCommand(new MoveCommand(game.getPlayerTank()));
                    }
                }

                game.getWindowRef().getContentPane().repaint();

                sleep(17);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
