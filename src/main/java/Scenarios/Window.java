
package Scenarios;

import Classes.Tank;
import Enums.TankType;
import Factories.MenuFactory;
import Factories.ScenarioFactory;
import Interfaces.IScenario;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Window extends JFrame {

    public Window() {
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 871);
        setBackground(Color.GRAY);
        setForeground(Color.GRAY);

        JPanel contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setVisible(true);

    }


}