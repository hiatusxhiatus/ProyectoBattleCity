package Commands;

import Classes.Tank;
import Interfaces.TankCommand;

public class ShootCommand implements TankCommand {

    private final Tank tank;

    public ShootCommand(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void execute() {
        // Lógica de disparo del tanque
        // Aquí podrías implementar la lógica para disparar
        // Por ejemplo, reducir la munición, efectos visuales, etc.
        System.out.println("¡Pum! El tanque" + tank +" ha disparado.");

    }

}
