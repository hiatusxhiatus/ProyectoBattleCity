package Factories;

import Interfaces.IScenario;
import Scenarios.Level8;

public class Level8Factory extends ScenarioFactory {

    @Override
    public IScenario createScenario() {
        return new Level8();
    }
}
