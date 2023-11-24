
package Scenarios;

import Factories.*;
import Interfaces.IScenario;
import Interfaces.IStructure;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Level6 implements IScenario {

    ArrayList<IStructure> structures;
    IStructure eagle;
    StructureFactory structureFactory;
    private JPanel panelWindow;
    private JPanel panelGame;

    public Level6() {
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

        structures.add(structureFactory.createStructure(new Point(352, 736)));
        structures.add(structureFactory.createStructure(new Point(352, 768)));
        structures.add(structureFactory.createStructure(new Point(352, 800)));
        structures.add(structureFactory.createStructure(new Point(384, 736)));
        structures.add(structureFactory.createStructure(new Point(416, 736)));
        structures.add(structureFactory.createStructure(new Point(448, 736)));
        structures.add(structureFactory.createStructure(new Point(448, 768)));
        structures.add(structureFactory.createStructure(new Point(448, 800)));
        structures.add(structureFactory.createStructure(new Point(0, 768)));
        structures.add(structureFactory.createStructure(new Point(32, 768)));
        structures.add(structureFactory.createStructure(new Point(32, 800)));
        structures.add(structureFactory.createStructure(new Point(0, 800)));
        structures.add(structureFactory.createStructure(new Point(160, 736)));
        structures.add(structureFactory.createStructure(new Point(128, 736)));
        structures.add(structureFactory.createStructure(new Point(128, 704)));
        structures.add(structureFactory.createStructure(new Point(160, 704)));
        structures.add(structureFactory.createStructure(new Point(288, 736)));
        structures.add(structureFactory.createStructure(new Point(256, 736)));
        structures.add(structureFactory.createStructure(new Point(256, 704)));
        structures.add(structureFactory.createStructure(new Point(288, 704)));
        structures.add(structureFactory.createStructure(new Point(608, 800)));
        structures.add(structureFactory.createStructure(new Point(576, 800)));
        structures.add(structureFactory.createStructure(new Point(576, 768)));
        structures.add(structureFactory.createStructure(new Point(608, 768)));
        structures.add(structureFactory.createStructure(new Point(96, 480)));
        structures.add(structureFactory.createStructure(new Point(64, 480)));
        structures.add(structureFactory.createStructure(new Point(64, 448)));
        structures.add(structureFactory.createStructure(new Point(96, 448)));
        structures.add(structureFactory.createStructure(new Point(160, 352)));
        structures.add(structureFactory.createStructure(new Point(128, 352)));
        structures.add(structureFactory.createStructure(new Point(128, 320)));
        structures.add(structureFactory.createStructure(new Point(160, 320)));
        structures.add(structureFactory.createStructure(new Point(96, 96)));
        structures.add(structureFactory.createStructure(new Point(64, 96)));
        structures.add(structureFactory.createStructure(new Point(64, 64)));
        structures.add(structureFactory.createStructure(new Point(96, 64)));
        structures.add(structureFactory.createStructure(new Point(288, 160)));
        structures.add(structureFactory.createStructure(new Point(256, 160)));
        structures.add(structureFactory.createStructure(new Point(256, 128)));
        structures.add(structureFactory.createStructure(new Point(288, 128)));
        structures.add(structureFactory.createStructure(new Point(480, 96)));
        structures.add(structureFactory.createStructure(new Point(448, 96)));
        structures.add(structureFactory.createStructure(new Point(448, 64)));
        structures.add(structureFactory.createStructure(new Point(480, 64)));
        structures.add(structureFactory.createStructure(new Point(672, 32)));
        structures.add(structureFactory.createStructure(new Point(640, 32)));
        structures.add(structureFactory.createStructure(new Point(640, 0)));
        structures.add(structureFactory.createStructure(new Point(672, 0)));
        structures.add(structureFactory.createStructure(new Point(672, 224)));
        structures.add(structureFactory.createStructure(new Point(640, 224)));
        structures.add(structureFactory.createStructure(new Point(640, 192)));
        structures.add(structureFactory.createStructure(new Point(672, 192)));
        structures.add(structureFactory.createStructure(new Point(736, 352)));
        structures.add(structureFactory.createStructure(new Point(704, 352)));
        structures.add(structureFactory.createStructure(new Point(704, 320)));
        structures.add(structureFactory.createStructure(new Point(736, 320)));
        structures.add(structureFactory.createStructure(new Point(736, 544)));
        structures.add(structureFactory.createStructure(new Point(704, 544)));
        structures.add(structureFactory.createStructure(new Point(704, 512)));
        structures.add(structureFactory.createStructure(new Point(736, 512)));
        structures.add(structureFactory.createStructure(new Point(352, 480)));
        structures.add(structureFactory.createStructure(new Point(320, 480)));
        structures.add(structureFactory.createStructure(new Point(320, 448)));
        structures.add(structureFactory.createStructure(new Point(352, 448)));

        structureFactory = new WallStructureFactory();

        structures.add(structureFactory.createStructure(new Point(640, 768)));
        structures.add(structureFactory.createStructure(new Point(672, 768)));
        structures.add(structureFactory.createStructure(new Point(672, 800)));
        structures.add(structureFactory.createStructure(new Point(640, 800)));
        structures.add(structureFactory.createStructure(new Point(0, 512)));
        structures.add(structureFactory.createStructure(new Point(32, 512)));
        structures.add(structureFactory.createStructure(new Point(32, 544)));
        structures.add(structureFactory.createStructure(new Point(0, 544)));
        structures.add(structureFactory.createStructure(new Point(64, 256)));
        structures.add(structureFactory.createStructure(new Point(96, 256)));
        structures.add(structureFactory.createStructure(new Point(96, 288)));
        structures.add(structureFactory.createStructure(new Point(64, 288)));
        structures.add(structureFactory.createStructure(new Point(320, 64)));
        structures.add(structureFactory.createStructure(new Point(352, 64)));
        structures.add(structureFactory.createStructure(new Point(352, 96)));
        structures.add(structureFactory.createStructure(new Point(320, 96)));
        structures.add(structureFactory.createStructure(new Point(384, 320)));
        structures.add(structureFactory.createStructure(new Point(416, 320)));
        structures.add(structureFactory.createStructure(new Point(416, 352)));
        structures.add(structureFactory.createStructure(new Point(384, 352)));
        structures.add(structureFactory.createStructure(new Point(576, 384)));
        structures.add(structureFactory.createStructure(new Point(608, 384)));
        structures.add(structureFactory.createStructure(new Point(608, 416)));
        structures.add(structureFactory.createStructure(new Point(576, 416)));
        structures.add(structureFactory.createStructure(new Point(768, 384)));
        structures.add(structureFactory.createStructure(new Point(800, 384)));
        structures.add(structureFactory.createStructure(new Point(800, 416)));
        structures.add(structureFactory.createStructure(new Point(768, 416)));
        structures.add(structureFactory.createStructure(new Point(704, 128)));
        structures.add(structureFactory.createStructure(new Point(736, 128)));
        structures.add(structureFactory.createStructure(new Point(736, 160)));
        structures.add(structureFactory.createStructure(new Point(704, 160)));
        structures.add(structureFactory.createStructure(new Point(192, 640)));
        structures.add(structureFactory.createStructure(new Point(224, 640)));
        structures.add(structureFactory.createStructure(new Point(224, 672)));
        structures.add(structureFactory.createStructure(new Point(192, 672)));

        structureFactory = new WaterStructureFactory();

        structures.add(structureFactory.createStructure(new Point(384, 512)));
        structures.add(structureFactory.createStructure(new Point(416, 512)));
        structures.add(structureFactory.createStructure(new Point(416, 544)));
        structures.add(structureFactory.createStructure(new Point(384, 544)));
        structures.add(structureFactory.createStructure(new Point(448, 512)));
        structures.add(structureFactory.createStructure(new Point(480, 512)));
        structures.add(structureFactory.createStructure(new Point(480, 544)));
        structures.add(structureFactory.createStructure(new Point(448, 544)));
        structures.add(structureFactory.createStructure(new Point(384, 576)));
        structures.add(structureFactory.createStructure(new Point(416, 576)));
        structures.add(structureFactory.createStructure(new Point(416, 608)));
        structures.add(structureFactory.createStructure(new Point(384, 608)));
        structures.add(structureFactory.createStructure(new Point(448, 576)));
        structures.add(structureFactory.createStructure(new Point(480, 576)));
        structures.add(structureFactory.createStructure(new Point(480, 608)));
        structures.add(structureFactory.createStructure(new Point(448, 608)));
        structures.add(structureFactory.createStructure(new Point(192, 64)));
        structures.add(structureFactory.createStructure(new Point(224, 64)));
        structures.add(structureFactory.createStructure(new Point(224, 96)));
        structures.add(structureFactory.createStructure(new Point(192, 96)));
        structures.add(structureFactory.createStructure(new Point(128, 128)));
        structures.add(structureFactory.createStructure(new Point(160, 128)));
        structures.add(structureFactory.createStructure(new Point(160, 160)));
        structures.add(structureFactory.createStructure(new Point(128, 160)));
        structures.add(structureFactory.createStructure(new Point(192, 128)));
        structures.add(structureFactory.createStructure(new Point(224, 128)));
        structures.add(structureFactory.createStructure(new Point(224, 160)));
        structures.add(structureFactory.createStructure(new Point(192, 160)));
        structures.add(structureFactory.createStructure(new Point(128, 96)));
        structures.add(structureFactory.createStructure(new Point(160, 96)));
        structures.add(structureFactory.createStructure(new Point(160, 64)));
        structures.add(structureFactory.createStructure(new Point(128, 64)));
        structures.add(structureFactory.createStructure(new Point(576, 128)));
        structures.add(structureFactory.createStructure(new Point(608, 128)));
        structures.add(structureFactory.createStructure(new Point(608, 160)));
        structures.add(structureFactory.createStructure(new Point(576, 160)));
        structures.add(structureFactory.createStructure(new Point(512, 192)));
        structures.add(structureFactory.createStructure(new Point(544, 192)));
        structures.add(structureFactory.createStructure(new Point(544, 224)));
        structures.add(structureFactory.createStructure(new Point(512, 224)));
        structures.add(structureFactory.createStructure(new Point(576, 192)));
        structures.add(structureFactory.createStructure(new Point(608, 192)));
        structures.add(structureFactory.createStructure(new Point(608, 224)));
        structures.add(structureFactory.createStructure(new Point(576, 224)));
        structures.add(structureFactory.createStructure(new Point(512, 160)));
        structures.add(structureFactory.createStructure(new Point(544, 160)));
        structures.add(structureFactory.createStructure(new Point(544, 128)));
        structures.add(structureFactory.createStructure(new Point(512, 128)));
        structures.add(structureFactory.createStructure(new Point(704, 576)));
        structures.add(structureFactory.createStructure(new Point(736, 576)));
        structures.add(structureFactory.createStructure(new Point(736, 608)));
        structures.add(structureFactory.createStructure(new Point(704, 608)));
        structures.add(structureFactory.createStructure(new Point(640, 640)));
        structures.add(structureFactory.createStructure(new Point(672, 640)));
        structures.add(structureFactory.createStructure(new Point(672, 672)));
        structures.add(structureFactory.createStructure(new Point(640, 672)));
        structures.add(structureFactory.createStructure(new Point(704, 640)));
        structures.add(structureFactory.createStructure(new Point(736, 640)));
        structures.add(structureFactory.createStructure(new Point(736, 672)));
        structures.add(structureFactory.createStructure(new Point(704, 672)));
        structures.add(structureFactory.createStructure(new Point(640, 608)));
        structures.add(structureFactory.createStructure(new Point(672, 608)));
        structures.add(structureFactory.createStructure(new Point(672, 576)));
        structures.add(structureFactory.createStructure(new Point(640, 576)));
        structures.add(structureFactory.createStructure(new Point(192, 448)));
        structures.add(structureFactory.createStructure(new Point(224, 448)));
        structures.add(structureFactory.createStructure(new Point(224, 480)));
        structures.add(structureFactory.createStructure(new Point(192, 480)));
        structures.add(structureFactory.createStructure(new Point(128, 512)));
        structures.add(structureFactory.createStructure(new Point(160, 512)));
        structures.add(structureFactory.createStructure(new Point(160, 544)));
        structures.add(structureFactory.createStructure(new Point(128, 544)));
        structures.add(structureFactory.createStructure(new Point(192, 512)));
        structures.add(structureFactory.createStructure(new Point(224, 512)));
        structures.add(structureFactory.createStructure(new Point(224, 544)));
        structures.add(structureFactory.createStructure(new Point(192, 544)));
        structures.add(structureFactory.createStructure(new Point(128, 480)));
        structures.add(structureFactory.createStructure(new Point(160, 480)));
        structures.add(structureFactory.createStructure(new Point(160, 448)));
        structures.add(structureFactory.createStructure(new Point(128, 448)));
        structures.add(structureFactory.createStructure(new Point(320, 256)));
        structures.add(structureFactory.createStructure(new Point(352, 256)));
        structures.add(structureFactory.createStructure(new Point(352, 288)));
        structures.add(structureFactory.createStructure(new Point(320, 288)));
        structures.add(structureFactory.createStructure(new Point(256, 320)));
        structures.add(structureFactory.createStructure(new Point(288, 320)));
        structures.add(structureFactory.createStructure(new Point(288, 352)));
        structures.add(structureFactory.createStructure(new Point(256, 352)));
        structures.add(structureFactory.createStructure(new Point(320, 320)));
        structures.add(structureFactory.createStructure(new Point(352, 320)));
        structures.add(structureFactory.createStructure(new Point(352, 352)));
        structures.add(structureFactory.createStructure(new Point(320, 352)));
        structures.add(structureFactory.createStructure(new Point(256, 288)));
        structures.add(structureFactory.createStructure(new Point(288, 288)));
        structures.add(structureFactory.createStructure(new Point(288, 256)));
        structures.add(structureFactory.createStructure(new Point(256, 256)));

        structureFactory = new GrassStructureFactory();

        structures.add(structureFactory.createStructure(new Point(64, 320)));
        structures.add(structureFactory.createStructure(new Point(96, 320)));
        structures.add(structureFactory.createStructure(new Point(96, 352)));
        structures.add(structureFactory.createStructure(new Point(64, 352)));
        structures.add(structureFactory.createStructure(new Point(0, 384)));
        structures.add(structureFactory.createStructure(new Point(32, 384)));
        structures.add(structureFactory.createStructure(new Point(32, 416)));
        structures.add(structureFactory.createStructure(new Point(0, 416)));
        structures.add(structureFactory.createStructure(new Point(64, 384)));
        structures.add(structureFactory.createStructure(new Point(96, 384)));
        structures.add(structureFactory.createStructure(new Point(96, 416)));
        structures.add(structureFactory.createStructure(new Point(64, 416)));
        structures.add(structureFactory.createStructure(new Point(0, 352)));
        structures.add(structureFactory.createStructure(new Point(32, 352)));
        structures.add(structureFactory.createStructure(new Point(32, 320)));
        structures.add(structureFactory.createStructure(new Point(0, 320)));
        structures.add(structureFactory.createStructure(new Point(384, 192)));
        structures.add(structureFactory.createStructure(new Point(416, 192)));
        structures.add(structureFactory.createStructure(new Point(416, 224)));
        structures.add(structureFactory.createStructure(new Point(384, 224)));
        structures.add(structureFactory.createStructure(new Point(448, 192)));
        structures.add(structureFactory.createStructure(new Point(480, 192)));
        structures.add(structureFactory.createStructure(new Point(480, 224)));
        structures.add(structureFactory.createStructure(new Point(448, 224)));
        structures.add(structureFactory.createStructure(new Point(384, 160)));
        structures.add(structureFactory.createStructure(new Point(416, 160)));
        structures.add(structureFactory.createStructure(new Point(416, 128)));
        structures.add(structureFactory.createStructure(new Point(384, 128)));
        structures.add(structureFactory.createStructure(new Point(480, 160)));
        structures.add(structureFactory.createStructure(new Point(448, 128)));
        structures.add(structureFactory.createStructure(new Point(480, 128)));
        structures.add(structureFactory.createStructure(new Point(448, 160)));
        structures.add(structureFactory.createStructure(new Point(512, 576)));
        structures.add(structureFactory.createStructure(new Point(544, 576)));
        structures.add(structureFactory.createStructure(new Point(544, 608)));
        structures.add(structureFactory.createStructure(new Point(512, 608)));
        structures.add(structureFactory.createStructure(new Point(576, 576)));
        structures.add(structureFactory.createStructure(new Point(608, 576)));
        structures.add(structureFactory.createStructure(new Point(608, 608)));
        structures.add(structureFactory.createStructure(new Point(576, 608)));
        structures.add(structureFactory.createStructure(new Point(512, 544)));
        structures.add(structureFactory.createStructure(new Point(544, 544)));
        structures.add(structureFactory.createStructure(new Point(544, 512)));
        structures.add(structureFactory.createStructure(new Point(512, 512)));
        structures.add(structureFactory.createStructure(new Point(608, 544)));
        structures.add(structureFactory.createStructure(new Point(576, 512)));
        structures.add(structureFactory.createStructure(new Point(608, 512)));
        structures.add(structureFactory.createStructure(new Point(576, 544)));
        structures.add(structureFactory.createStructure(new Point(320, 128)));
        structures.add(structureFactory.createStructure(new Point(352, 128)));
        structures.add(structureFactory.createStructure(new Point(320, 160)));
        structures.add(structureFactory.createStructure(new Point(352, 160)));
        structures.add(structureFactory.createStructure(new Point(352, 192)));
        structures.add(structureFactory.createStructure(new Point(320, 192)));
        structures.add(structureFactory.createStructure(new Point(320, 224)));
        structures.add(structureFactory.createStructure(new Point(352, 224)));
        structures.add(structureFactory.createStructure(new Point(448, 288)));
        structures.add(structureFactory.createStructure(new Point(480, 288)));
        structures.add(structureFactory.createStructure(new Point(480, 256)));
        structures.add(structureFactory.createStructure(new Point(448, 256)));
        structures.add(structureFactory.createStructure(new Point(128, 416)));
        structures.add(structureFactory.createStructure(new Point(160, 416)));
        structures.add(structureFactory.createStructure(new Point(160, 384)));
        structures.add(structureFactory.createStructure(new Point(128, 384)));
        structures.add(structureFactory.createStructure(new Point(576, 672)));
        structures.add(structureFactory.createStructure(new Point(608, 672)));
        structures.add(structureFactory.createStructure(new Point(608, 640)));
        structures.add(structureFactory.createStructure(new Point(576, 640)));
        structures.add(structureFactory.createStructure(new Point(512, 672)));
        structures.add(structureFactory.createStructure(new Point(544, 672)));
        structures.add(structureFactory.createStructure(new Point(544, 640)));
        structures.add(structureFactory.createStructure(new Point(512, 640)));
        structures.add(structureFactory.createStructure(new Point(256, 672)));
        structures.add(structureFactory.createStructure(new Point(288, 672)));
        structures.add(structureFactory.createStructure(new Point(288, 640)));
        structures.add(structureFactory.createStructure(new Point(256, 640)));
        structures.add(structureFactory.createStructure(new Point(256, 608)));
        structures.add(structureFactory.createStructure(new Point(288, 608)));
        structures.add(structureFactory.createStructure(new Point(288, 576)));
        structures.add(structureFactory.createStructure(new Point(256, 576)));
        structures.add(structureFactory.createStructure(new Point(256, 544)));
        structures.add(structureFactory.createStructure(new Point(288, 544)));
        structures.add(structureFactory.createStructure(new Point(288, 512)));
        structures.add(structureFactory.createStructure(new Point(256, 512)));
        structures.add(structureFactory.createStructure(new Point(320, 544)));
        structures.add(structureFactory.createStructure(new Point(352, 544)));
        structures.add(structureFactory.createStructure(new Point(352, 512)));
        structures.add(structureFactory.createStructure(new Point(320, 512)));

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
