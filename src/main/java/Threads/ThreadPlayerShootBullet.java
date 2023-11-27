package Threads;

import Classes.Bullet;
import Classes.Game;
import Commands.ShootCommand;
import Enums.Orientation;

public class ThreadPlayerShootBullet extends Thread{

    private Game game;
    private long currentTime;

    public ThreadPlayerShootBullet(Game game, long currentTime) {
        this.game = game;
        this.currentTime = currentTime;
    }

    public void run() {

        if (!game.isBulletFlying()) {

            game.setBulletFlying(true);

            game.getBulletHit().set(false);
            Bullet bullet = new Bullet(game.getPlayerTank().getOrientation(), game.getPlayerTank().getLocation());
            game.getScenario().getBulletCounter().update();
            game.getScenario().getPanelGame().add(bullet.getLabel());
            game.getScenario().getPanelGame().setComponentZOrder(bullet.getLabel(), 0);

            game.setLastShotTime(currentTime);

            while (!game.getBulletHit().get()) {
                game.getBulletHit().set(false);

                try {

                    if (bullet.getOrientation().equals(Orientation.Up)) {

                        if (bullet.getLocation().y - 13 > 0 && game.validateMovement(game.generateRange(bullet.getLocation().x, 16), game.generateRange(bullet.getLocation().y - 13, 16), true, bullet.getOrientation(), true, game.getPlayerTank()))
                            game.getPlayerTank().executeCommand(new ShootCommand(bullet));
                        else
                            game.getBulletHit().set(true);

                    } else if (bullet.getOrientation().equals(Orientation.Down)) {

                        if (bullet.getLocation().y + 13 < 832 && game.validateMovement(game.generateRange(bullet.getLocation().x, 16), game.generateRange(bullet.getLocation().y + 13, 16), true, bullet.getOrientation(), true, game.getPlayerTank()))
                            game.getPlayerTank().executeCommand(new ShootCommand(bullet));
                        else
                            game.getBulletHit().set(true);

                    } else if (bullet.getOrientation().equals(Orientation.Left)) {

                        if (bullet.getLocation().x - 13 > 0 && game.validateMovement(game.generateRange(bullet.getLocation().x - 13, 16), game.generateRange(bullet.getLocation().y, 16), true, bullet.getOrientation(), true, game.getPlayerTank()))
                            game.getPlayerTank().executeCommand(new ShootCommand(bullet));
                        else
                            game.getBulletHit().set(true);

                    } else if (bullet.getOrientation().equals(Orientation.Right)) {

                        if (bullet.getLocation().x + 13 < 832 && game.validateMovement(game.generateRange(bullet.getLocation().x + 13, 16), game.generateRange(bullet.getLocation().y, 16), true, bullet.getOrientation(), true, game.getPlayerTank()))
                            game.getPlayerTank().executeCommand(new ShootCommand(bullet));
                        else
                            game.getBulletHit().set(true);
                    }


                    game.getWindowRef().getContentPane().repaint();

                    if (game.getBulletHit().get()) {
                        game.setBulletFlying(false);
                        game.getScenario().getPanelGame().setComponentZOrder(bullet.getLabel(), 0);
                        bullet.bulletHit();

                        game.getWindowRef().getContentPane().repaint();
                        game.getScenario().getPanelGame().remove(bullet.getLabel());
                        break;
                    }


                    sleep(17);

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

}
