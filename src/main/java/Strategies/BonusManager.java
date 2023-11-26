package Strategies;

import Classes.Game;
import Classes.Tank;
import Interfaces.IStrategy;

public class BonusManager {

    private IStrategy strategy;

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Game game) {
        strategy.setBonusCard(game);
    }

}
