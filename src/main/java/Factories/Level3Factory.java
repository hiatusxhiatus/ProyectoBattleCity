package Factories;

import Interfaces.IScenario;
import Scenarios.Level3;

public class Level3Factory extends ScenarioFactory {

    @Override
    public IScenario createScenario() {
        return new Level3();
    }
}
