package Classes;

import Commands.ShootCommand;
import Enums.Orientation;

public class ThreadEnemyShoot extends Thread {

    private Tank tank;
    private boolean isRunning;
    private Game game;
    private boolean bulletHit;

    public ThreadEnemyShoot(Tank tank, Game game) {
        this.tank = tank;
        this.game = game;
        isRunning = true;
    }

    @Override
    public void run () {

        try {
            sleep(1000);

            while (isRunning && tank.isActive())
            {

                bulletHit = false;
                Bullet bullet = new Bullet(tank.getOrientation(), tank.getLocation());
                game.getScenario().getPanelGame().add(bullet.getLabel());
                game.getScenario().getPanelGame().setComponentZOrder(bullet.getLabel(), 0);

                Thread bulletThread = new Thread(() -> {
                    while (!bulletHit) {
                        bulletHit = false;

                        try {

                            if (bullet.getOrientation().equals(Orientation.Up)) {

                                if (bullet.getLocation().y -13 > 0 && game.validateMovement(game.generateRange(bullet.getLocation().x, 16), game.generateRange(bullet.getLocation().y -13, 16), true, bullet.getOrientation(), false, tank))
                                    tank.executeCommand(new ShootCommand(bullet));
                                else
                                    bulletHit = true;

                            } else if (bullet.getOrientation().equals(Orientation.Down)) {

                                if (bullet.getLocation().y +13 < 832 && game.validateMovement(game.generateRange(bullet.getLocation().x, 16), game.generateRange(bullet.getLocation().y +13, 16), true, bullet.getOrientation(), false, tank))
                                    tank.executeCommand(new ShootCommand(bullet));
                                else
                                    bulletHit = true;

                            } else if (bullet.getOrientation().equals(Orientation.Left)) {

                                if (bullet.getLocation().x -13 > 0 && game.validateMovement(game.generateRange(bullet.getLocation().x -13, 16), game.generateRange(bullet.getLocation().y, 16), true, bullet.getOrientation(), false, tank))
                                    tank.executeCommand(new ShootCommand(bullet));
                                else
                                    bulletHit = true;

                            } else if (bullet.getOrientation().equals(Orientation.Right)) {

                                if (bullet.getLocation().x +13 < 832 && game.validateMovement(game.generateRange(bullet.getLocation().x +13, 16), game.generateRange(bullet.getLocation().y, 16), true, bullet.getOrientation(), false, tank))
                                    tank.executeCommand(new ShootCommand(bullet));
                                else
                                    bulletHit = true;
                            }

                            //game.getWindowRef().getContentPane().revalidate();
                            game.getWindowRef().getContentPane().repaint();

                            if (bulletHit) {
                                game.getScenario().getPanelGame().setComponentZOrder(bullet.getLabel(), 0);
                                bullet.bulletHit();
                                //game.getWindowRef().getContentPane().revalidate();
                                game.getWindowRef().getContentPane().repaint();
                                game.getScenario().getPanelGame().remove(bullet.getLabel());
                                break;
                            }

                            sleep(17);

                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }

                });

                bulletThread.start();
                sleep(3500);

            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
