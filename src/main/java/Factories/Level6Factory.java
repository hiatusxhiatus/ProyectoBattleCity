package Factories;


import Interfaces.IScenario;
import Scenarios.Level6;

public class Level6Factory extends ScenarioFactory {
    @Override
    public IScenario createScenario() {
        return new Level6();
    }
}

