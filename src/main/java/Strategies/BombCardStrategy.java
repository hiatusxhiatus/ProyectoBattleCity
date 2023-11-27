package Strategies;

import Classes.Game;
import Classes.Tank;
import Enums.TankType;
import Interfaces.IStrategy;

public class BombCardStrategy implements IStrategy {

    @Override
    public void setBonusCard(Game game) {

        for (Tank enemy : game.getEnemyTanks())
        {
            if (enemy.isActive())
            {
                enemy.setHp(0);
                game.getScenario().getPanelGame().remove(enemy.getLabel());
                game.getPlayerTank().notifyObservers();
                enemy.setActive(false);
                game.setActiveEnemyTanks(game.getActiveEnemyTanks()-1);

                if (enemy.getTankType().equals(TankType.Red))
                    game.generateWildCard();
            }
        }
    }
}
