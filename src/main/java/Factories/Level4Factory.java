package Factories;


import Interfaces.IScenario;
import Scenarios.Level4;

public class Level4Factory extends ScenarioFactory {

    @Override
    public IScenario createScenario() {
        return new Level4();
    }
}

