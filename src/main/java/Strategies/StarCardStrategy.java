package Strategies;

import Classes.Game;
import Interfaces.IStrategy;

public class StarCardStrategy implements IStrategy {

    @Override
    public void setBonusCard(Game game) {
        game.getPlayerTank().setShootingRate(game.getPlayerTank().getShootingRate()+2);
    }

}
