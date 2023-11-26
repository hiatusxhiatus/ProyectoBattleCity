package Strategies;

import Classes.Game;
import Classes.Tank;
import Interfaces.IStrategy;

public class ClockCardStrategy implements IStrategy {

    @Override
    public void setBonusCard(Game game) {

        for (Tank tank : game.getEnemyTanks()) {

            Thread thread = new Thread(() -> {

                try {

                    tank.setPaused(true);
                    Thread.sleep(7000);
                    tank.setPaused(false);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });

            thread.start();
        }
    }
}
