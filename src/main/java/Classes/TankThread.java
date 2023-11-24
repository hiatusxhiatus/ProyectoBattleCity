package Classes;

import Commands.ShootCommand;
import Enums.TankType;

public class TankThread extends Thread{

    Tank tank;
    boolean running;

    public TankThread(Tank tank) {
        this.tank = tank;
        this.running = true;
    }

    @Override
    public void run() {
        try {
            while (running && !tank.getTankType().equals(TankType.Ally))
            {
                tank.executeCommand(new ShootCommand(tank));
                sleep(tank.getShootingRate()*1000);
            }

            while (running && tank.getTankType().equals(TankType.Ally))
            {

                sleep(tank.getShootingRate()*1000);

            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
