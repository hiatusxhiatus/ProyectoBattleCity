package Threads;

import Classes.Game;
import Classes.Tank;

public class ThreadVerifyWinner extends Thread {

    private Game game;

    public ThreadVerifyWinner(Game game) {
        this.game = game;
    }

    @Override
    public void run() {

        while (game.isGameRunning()) {

            try {
                boolean allEnemiesDejected = true;

                for (Tank enemy : game.getEnemyTanks())
                    if (enemy.getHp() > 0) {
                        allEnemiesDejected = false;
                        break;
                    }

                if (allEnemiesDejected) {
                    game.getScenario().getLabelPressEnter().setVisible(true);
                    game.setGameRunning(false);
                }


                Thread.sleep(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}