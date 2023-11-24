
package Scenarios;

import Factories.*;
import Interfaces.IScenario;
import Interfaces.IStructure;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Level2 implements IScenario {

    ArrayList<IStructure> structures;
    IStructure eagle;
    StructureFactory structureFactory;
    private JPanel panelWindow;
    private JPanel panelGame;

    public Level2() {
        initScenario();
    }

    @Override
    public void initScenario() {

        structures = new ArrayList<>();
        panelWindow = new JPanel();
        panelGame = new JPanel();

        panelWindow.setBackground(Color.gray);
        panelWindow.setForeground(Color.white);
        panelWindow.setPreferredSize(new Dimension(1024, 832));
        panelWindow.setSize(new Dimension(1024, 832));
        panelWindow.setLayout(null);

        panelGame.setBackground(Color.black);
        panelGame.setForeground(Color.white);
        panelGame.setPreferredSize(new Dimension(1024, 832));
        panelGame.setMinimumSize(new Dimension(832, 832));
        panelGame.setSize(new Dimension(832, 832));
        panelGame.setLayout(null);

        {
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < panelGame.getComponentCount(); i++) {
                Rectangle bounds = panelGame.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = panelGame.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            panelGame.setMinimumSize(preferredSize);
            panelGame.setPreferredSize(preferredSize);
        }

        structureFactory = new EagleStructureFactory();
        eagle = structureFactory.createStructure(new Point(384, 768));

        structureFactory = new BrickStructureFactory();

        structures.add(structureFactory.createStructure(new Point(320, 160)));
        structures.add(structureFactory.createStructure(new Point(320, 128)));
        structures.add(structureFactory.createStructure(new Point(352, 128)));
        structures.add(structureFactory.createStructure(new Point(352, 160)));
        structures.add(structureFactory.createStructure(new Point(352, 800)));
        structures.add(structureFactory.createStructure(new Point(352, 768)));
        structures.add(structureFactory.createStructure(new Point(352, 736)));
        structures.add(structureFactory.createStructure(new Point(384, 736)));
        structures.add(structureFactory.createStructure(new Point(415, 736)));
        structures.add(structureFactory.createStructure(new Point(447, 736)));
        structures.add(structureFactory.createStructure(new Point(447, 768)));
        structures.add(structureFactory.createStructure(new Point(447, 800)));
        structures.add(structureFactory.createStructure(new Point(384, 160)));
        structures.add(structureFactory.createStructure(new Point(416, 160)));
        structures.add(structureFactory.createStructure(new Point(416, 128)));
        structures.add(structureFactory.createStructure(new Point(384, 128)));
        structures.add(structureFactory.createStructure(new Point(448, 128)));
        structures.add(structureFactory.createStructure(new Point(480, 160)));
        structures.add(structureFactory.createStructure(new Point(480, 128)));
        structures.add(structureFactory.createStructure(new Point(448, 160)));
        structures.add(structureFactory.createStructure(new Point(288, 160)));
        structures.add(structureFactory.createStructure(new Point(512, 160)));
        structures.add(structureFactory.createStructure(new Point(544, 160)));
        structures.add(structureFactory.createStructure(new Point(545, 160)));
        structures.add(structureFactory.createStructure(new Point(576, 160)));
        structures.add(structureFactory.createStructure(new Point(416, 416)));
        structures.add(structureFactory.createStructure(new Point(384, 416)));
        structures.add(structureFactory.createStructure(new Point(384, 384)));
        structures.add(structureFactory.createStructure(new Point(416, 384)));
        structures.add(structureFactory.createStructure(new Point(448, 384)));
        structures.add(structureFactory.createStructure(new Point(480, 384)));
        structures.add(structureFactory.createStructure(new Point(480, 448)));
        structures.add(structureFactory.createStructure(new Point(480, 416)));
        structures.add(structureFactory.createStructure(new Point(512, 448)));
        structures.add(structureFactory.createStructure(new Point(512, 416)));
        structures.add(structureFactory.createStructure(new Point(544, 416)));
        structures.add(structureFactory.createStructure(new Point(544, 448)));
        structures.add(structureFactory.createStructure(new Point(576, 448)));
        structures.add(structureFactory.createStructure(new Point(288, 416)));
        structures.add(structureFactory.createStructure(new Point(320, 416)));
        structures.add(structureFactory.createStructure(new Point(320, 384)));
        structures.add(structureFactory.createStructure(new Point(288, 384)));
        structures.add(structureFactory.createStructure(new Point(288, 448)));
        structures.add(structureFactory.createStructure(new Point(320, 448)));
        structures.add(structureFactory.createStructure(new Point(256, 416)));
        structures.add(structureFactory.createStructure(new Point(224, 448)));
        structures.add(structureFactory.createStructure(new Point(256, 448)));
        structures.add(structureFactory.createStructure(new Point(288, 480)));
        structures.add(structureFactory.createStructure(new Point(512, 480)));
        structures.add(structureFactory.createStructure(new Point(576, 640)));
        structures.add(structureFactory.createStructure(new Point(544, 640)));
        structures.add(structureFactory.createStructure(new Point(512, 640)));
        structures.add(structureFactory.createStructure(new Point(512, 608)));
        structures.add(structureFactory.createStructure(new Point(544, 608)));
        structures.add(structureFactory.createStructure(new Point(480, 608)));
        structures.add(structureFactory.createStructure(new Point(480, 640)));
        structures.add(structureFactory.createStructure(new Point(224, 640)));
        structures.add(structureFactory.createStructure(new Point(256, 640)));
        structures.add(structureFactory.createStructure(new Point(256, 608)));
        structures.add(structureFactory.createStructure(new Point(288, 608)));
        structures.add(structureFactory.createStructure(new Point(288, 640)));
        structures.add(structureFactory.createStructure(new Point(320, 608)));
        structures.add(structureFactory.createStructure(new Point(320, 640)));

        structureFactory = new WallStructureFactory();

        structures.add(structureFactory.createStructure(new Point(448, 224)));
        structures.add(structureFactory.createStructure(new Point(448, 192)));
        structures.add(structureFactory.createStructure(new Point(416, 192)));
        structures.add(structureFactory.createStructure(new Point(416, 224)));
        structures.add(structureFactory.createStructure(new Point(384, 224)));
        structures.add(structureFactory.createStructure(new Point(512, 224)));
        structures.add(structureFactory.createStructure(new Point(512, 192)));
        structures.add(structureFactory.createStructure(new Point(384, 192)));
        structures.add(structureFactory.createStructure(new Point(416, 288)));
        structures.add(structureFactory.createStructure(new Point(416, 256)));
        structures.add(structureFactory.createStructure(new Point(288, 256)));
        structures.add(structureFactory.createStructure(new Point(288, 288)));
        structures.add(structureFactory.createStructure(new Point(384, 256)));
        structures.add(structureFactory.createStructure(new Point(384, 288)));
        structures.add(structureFactory.createStructure(new Point(352, 256)));
        structures.add(structureFactory.createStructure(new Point(320, 352)));
        structures.add(structureFactory.createStructure(new Point(352, 352)));
        structures.add(structureFactory.createStructure(new Point(352, 320)));
        structures.add(structureFactory.createStructure(new Point(320, 320)));
        structures.add(structureFactory.createStructure(new Point(384, 352)));
        structures.add(structureFactory.createStructure(new Point(416, 352)));
        structures.add(structureFactory.createStructure(new Point(416, 320)));
        structures.add(structureFactory.createStructure(new Point(384, 320)));
        structures.add(structureFactory.createStructure(new Point(448, 352)));
        structures.add(structureFactory.createStructure(new Point(480, 352)));
        structures.add(structureFactory.createStructure(new Point(480, 320)));
        structures.add(structureFactory.createStructure(new Point(448, 320)));
        structures.add(structureFactory.createStructure(new Point(480, 256)));
        structures.add(structureFactory.createStructure(new Point(448, 256)));
        structures.add(structureFactory.createStructure(new Point(448, 288)));
        structures.add(structureFactory.createStructure(new Point(480, 288)));
        structures.add(structureFactory.createStructure(new Point(544, 224)));
        structures.add(structureFactory.createStructure(new Point(512, 320)));
        structures.add(structureFactory.createStructure(new Point(512, 256)));
        structures.add(structureFactory.createStructure(new Point(544, 192)));
        structures.add(structureFactory.createStructure(new Point(608, 256)));
        structures.add(structureFactory.createStructure(new Point(576, 256)));
        structures.add(structureFactory.createStructure(new Point(576, 224)));
        structures.add(structureFactory.createStructure(new Point(608, 224)));
        structures.add(structureFactory.createStructure(new Point(640, 256)));
        structures.add(structureFactory.createStructure(new Point(512, 352)));
        structures.add(structureFactory.createStructure(new Point(576, 320)));
        structures.add(structureFactory.createStructure(new Point(544, 320)));
        structures.add(structureFactory.createStructure(new Point(224, 544)));
        structures.add(structureFactory.createStructure(new Point(256, 544)));
        structures.add(structureFactory.createStructure(new Point(256, 512)));
        structures.add(structureFactory.createStructure(new Point(224, 512)));
        structures.add(structureFactory.createStructure(new Point(224, 480)));
        structures.add(structureFactory.createStructure(new Point(256, 480)));
        structures.add(structureFactory.createStructure(new Point(288, 512)));
        structures.add(structureFactory.createStructure(new Point(255, 480)));
        structures.add(structureFactory.createStructure(new Point(225, 480)));
        structures.add(structureFactory.createStructure(new Point(225, 515)));
        structures.add(structureFactory.createStructure(new Point(255, 515)));
        structures.add(structureFactory.createStructure(new Point(576, 480)));
        structures.add(structureFactory.createStructure(new Point(544, 480)));
        structures.add(structureFactory.createStructure(new Point(544, 512)));
        structures.add(structureFactory.createStructure(new Point(576, 512)));
        structures.add(structureFactory.createStructure(new Point(576, 544)));
        structures.add(structureFactory.createStructure(new Point(544, 544)));
        structures.add(structureFactory.createStructure(new Point(512, 512)));

        structureFactory = new WaterStructureFactory();

        structures.add(structureFactory.createStructure(new Point(352, 384)));
        structures.add(structureFactory.createStructure(new Point(352, 416)));
        structures.add(structureFactory.createStructure(new Point(352, 448)));
        structures.add(structureFactory.createStructure(new Point(384, 448)));
        structures.add(structureFactory.createStructure(new Point(416, 448)));
        structures.add(structureFactory.createStructure(new Point(448, 416)));
        structures.add(structureFactory.createStructure(new Point(448, 448)));
        structures.add(structureFactory.createStructure(new Point(320, 480)));
        structures.add(structureFactory.createStructure(new Point(320, 512)));
        structures.add(structureFactory.createStructure(new Point(288, 544)));
        structures.add(structureFactory.createStructure(new Point(288, 576)));
        structures.add(structureFactory.createStructure(new Point(320, 544)));
        structures.add(structureFactory.createStructure(new Point(320, 576)));
        structures.add(structureFactory.createStructure(new Point(352, 480)));
        structures.add(structureFactory.createStructure(new Point(352, 512)));
        structures.add(structureFactory.createStructure(new Point(352, 544)));
        structures.add(structureFactory.createStructure(new Point(352, 576)));
        structures.add(structureFactory.createStructure(new Point(384, 480)));
        structures.add(structureFactory.createStructure(new Point(416, 480)));
        structures.add(structureFactory.createStructure(new Point(448, 480)));
        structures.add(structureFactory.createStructure(new Point(480, 480)));
        structures.add(structureFactory.createStructure(new Point(384, 512)));
        structures.add(structureFactory.createStructure(new Point(416, 512)));
        structures.add(structureFactory.createStructure(new Point(448, 512)));
        structures.add(structureFactory.createStructure(new Point(480, 512)));
        structures.add(structureFactory.createStructure(new Point(384, 544)));
        structures.add(structureFactory.createStructure(new Point(416, 544)));
        structures.add(structureFactory.createStructure(new Point(448, 544)));
        structures.add(structureFactory.createStructure(new Point(480, 544)));
        structures.add(structureFactory.createStructure(new Point(512, 544)));
        structures.add(structureFactory.createStructure(new Point(448, 576)));
        structures.add(structureFactory.createStructure(new Point(480, 576)));
        structures.add(structureFactory.createStructure(new Point(512, 576)));

        structureFactory = new GrassStructureFactory();

        structures.add(structureFactory.createStructure(new Point(320, 192)));
        structures.add(structureFactory.createStructure(new Point(352, 192)));
        structures.add(structureFactory.createStructure(new Point(352, 224)));
        structures.add(structureFactory.createStructure(new Point(320, 224)));
        structures.add(structureFactory.createStructure(new Point(320, 256)));
        structures.add(structureFactory.createStructure(new Point(320, 288)));
        structures.add(structureFactory.createStructure(new Point(352, 288)));
        structures.add(structureFactory.createStructure(new Point(256, 224)));
        structures.add(structureFactory.createStructure(new Point(288, 224)));
        structures.add(structureFactory.createStructure(new Point(288, 192)));
        structures.add(structureFactory.createStructure(new Point(256, 256)));
        structures.add(structureFactory.createStructure(new Point(256, 288)));
        structures.add(structureFactory.createStructure(new Point(256, 320)));
        structures.add(structureFactory.createStructure(new Point(288, 320)));

        panelGame.add(eagle.getLabel());

        for (IStructure structure : structures)
            panelGame.add(structure.getLabel());

        panelWindow.add(panelGame);
        panelGame.setBounds(0, 0, 832, 832);

    }

    @Override
    public JPanel getPanel() {
        return panelWindow;
    }

    @Override
    public JPanel getPanelGame() {
        return panelGame;
    }

    @Override
    public ArrayList<IStructure> getStructures() {
        return structures;
    }

    @Override
    public IStructure getEagle() {
        return eagle;
    }
}