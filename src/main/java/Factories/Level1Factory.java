package Factories;

import Interfaces.IScenario;
import Scenarios.Level1;

import javax.swing.*;

public class Level1Factory extends ScenarioFactory {

    @Override
    public IScenario createScenario() {
        return new Level1();
    }

}
