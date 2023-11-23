package Factories;

import Interfaces.IScenario;
import Scenarios.Level5;

public class Level5Factory extends ScenarioFactory {

    @Override
    public IScenario createScenario() {
        return new Level5();
    }
}
