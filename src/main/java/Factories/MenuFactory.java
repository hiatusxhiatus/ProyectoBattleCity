package Factories;

import Interfaces.IScenario;
import Scenarios.Menu;

public class MenuFactory extends ScenarioFactory{

    public MenuFactory() {
    }

    @Override
    public IScenario createScenario() {
        return new Menu();
    }
}
