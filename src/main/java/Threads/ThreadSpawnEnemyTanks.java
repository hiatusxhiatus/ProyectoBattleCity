package Threads;

import Classes.Game;
import Classes.Tank;
import Enums.Orientation;

public class ThreadSpawnEnemyTanks extends Thread {

    private Game game;

    public ThreadSpawnEnemyTanks(Game game) {
        this.game = game;
    }

    public void run() {

        try {
            int i = 0;

            do {
                if (game.getActiveEnemyTanks() < 5)
                {
                    game.setActiveEnemyTanks(game.getActiveEnemyTanks()+1);
                    Tank tank = game.getEnemyTanks().get(i++);
                    tank.setOrientation(Orientation.Down);
                    tank.setActive(true);
                    new ThreadEnemyMove(game, tank).start();
                    new ThreadEnemyShoot(tank, game).start();
                    game.randomSpawnPoint(tank);
                    game.getScenario().getPanelGame().add(tank.getLabel());
                    sleep(4000);
                }

                sleep(100);

            } while (i < game.getEnemyTanks().size() && game.isGameRunning());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
