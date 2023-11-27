package Strategies;

import Classes.Game;
import Interfaces.IStrategy;

public class TankCardStrategy implements IStrategy {

    @Override
    public void setBonusCard(Game game) {
        game.getPlayerTank().setSpeed(game.getPlayerTank().getSpeed()+2);
    }

}
