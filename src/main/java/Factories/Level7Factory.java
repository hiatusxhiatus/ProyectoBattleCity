package Factories;

import Interfaces.IScenario;
import Scenarios.Level7;

public class Level7Factory extends ScenarioFactory{

    @Override
    public IScenario createScenario() {
        return new Level7();

    }
}
