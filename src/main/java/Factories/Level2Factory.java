package Factories;

import Interfaces.IScenario;
import Scenarios.Level2;

public class Level2Factory extends ScenarioFactory {

    @Override
    public IScenario createScenario() {
        return new Level2();
    }

}
