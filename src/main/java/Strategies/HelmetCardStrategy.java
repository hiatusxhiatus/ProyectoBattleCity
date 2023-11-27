package Strategies;

import Classes.Game;
import Interfaces.IStrategy;

public class HelmetCardStrategy implements IStrategy {

    @Override
    public void setBonusCard(Game game) {

        game.getPlayerTank().setProtected();

    }
}
