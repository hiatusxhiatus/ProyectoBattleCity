
package Scenarios;

import Factories.*;
import Interfaces.IScenario;
import Interfaces.IStructure;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Level4 implements IScenario {

    ArrayList<IStructure> structures;
    StructureFactory structureFactory;
    private JPanel panelWindow;
    private JPanel panelGame;

    public Level4() {
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

        structureFactory = new BrickStructureFactory();

        structures.add(structureFactory.createStructure(new Point(352, 800)));
        structures.add(structureFactory.createStructure(new Point(352, 768)));
        structures.add(structureFactory.createStructure(new Point(352, 736)));
        structures.add(structureFactory.createStructure(new Point(384, 736)));
        structures.add(structureFactory.createStructure(new Point(416, 736)));
        structures.add(structureFactory.createStructure(new Point(448, 736)));
        structures.add(structureFactory.createStructure(new Point(448, 768)));
        structures.add(structureFactory.createStructure(new Point(448, 800)));
        structures.add(structureFactory.createStructure(new Point(0, 64)));
        structures.add(structureFactory.createStructure(new Point(32, 64)));
        structures.add(structureFactory.createStructure(new Point(32, 96)));
        structures.add(structureFactory.createStructure(new Point(0, 96)));
        structures.add(structureFactory.createStructure(new Point(192, 0)));
        structures.add(structureFactory.createStructure(new Point(224, 0)));
        structures.add(structureFactory.createStructure(new Point(224, 32)));
        structures.add(structureFactory.createStructure(new Point(192, 32)));
        structures.add(structureFactory.createStructure(new Point(768, 64)));
        structures.add(structureFactory.createStructure(new Point(800, 64)));
        structures.add(structureFactory.createStructure(new Point(800, 96)));
        structures.add(structureFactory.createStructure(new Point(768, 96)));
        structures.add(structureFactory.createStructure(new Point(640, 768)));
        structures.add(structureFactory.createStructure(new Point(672, 768)));
        structures.add(structureFactory.createStructure(new Point(672, 800)));
        structures.add(structureFactory.createStructure(new Point(640, 800)));
        structures.add(structureFactory.createStructure(new Point(672, 736)));
        structures.add(structureFactory.createStructure(new Point(640, 736)));
        structures.add(structureFactory.createStructure(new Point(576, 768)));
        structures.add(structureFactory.createStructure(new Point(608, 768)));
        structures.add(structureFactory.createStructure(new Point(608, 800)));
        structures.add(structureFactory.createStructure(new Point(576, 800)));
        structures.add(structureFactory.createStructure(new Point(128, 768)));
        structures.add(structureFactory.createStructure(new Point(160, 768)));
        structures.add(structureFactory.createStructure(new Point(160, 800)));
        structures.add(structureFactory.createStructure(new Point(128, 800)));
        structures.add(structureFactory.createStructure(new Point(160, 736)));
        structures.add(structureFactory.createStructure(new Point(128, 736)));
        structures.add(structureFactory.createStructure(new Point(192, 768)));
        structures.add(structureFactory.createStructure(new Point(224, 768)));
        structures.add(structureFactory.createStructure(new Point(224, 800)));
        structures.add(structureFactory.createStructure(new Point(192, 800)));
        structures.add(structureFactory.createStructure(new Point(768, 640)));
        structures.add(structureFactory.createStructure(new Point(800, 640)));
        structures.add(structureFactory.createStructure(new Point(800, 672)));
        structures.add(structureFactory.createStructure(new Point(768, 672)));
        structures.add(structureFactory.createStructure(new Point(768, 576)));
        structures.add(structureFactory.createStructure(new Point(800, 576)));
        structures.add(structureFactory.createStructure(new Point(800, 608)));
        structures.add(structureFactory.createStructure(new Point(768, 608)));
        structures.add(structureFactory.createStructure(new Point(704, 384)));
        structures.add(structureFactory.createStructure(new Point(736, 384)));
        structures.add(structureFactory.createStructure(new Point(736, 416)));
        structures.add(structureFactory.createStructure(new Point(704, 416)));
        structures.add(structureFactory.createStructure(new Point(64, 384)));
        structures.add(structureFactory.createStructure(new Point(96, 384)));
        structures.add(structureFactory.createStructure(new Point(96, 416)));
        structures.add(structureFactory.createStructure(new Point(64, 416)));
        structures.add(structureFactory.createStructure(new Point(0, 640)));
        structures.add(structureFactory.createStructure(new Point(32, 640)));
        structures.add(structureFactory.createStructure(new Point(32, 672)));
        structures.add(structureFactory.createStructure(new Point(0, 672)));
        structures.add(structureFactory.createStructure(new Point(0, 576)));
        structures.add(structureFactory.createStructure(new Point(32, 576)));
        structures.add(structureFactory.createStructure(new Point(32, 608)));
        structures.add(structureFactory.createStructure(new Point(0, 608)));


        structureFactory = new WallStructureFactory();

        structures.add(structureFactory.createStructure(new Point(0, 384)));
        structures.add(structureFactory.createStructure(new Point(32, 384)));
        structures.add(structureFactory.createStructure(new Point(32, 416)));
        structures.add(structureFactory.createStructure(new Point(0, 416)));
        structures.add(structureFactory.createStructure(new Point(800, 416)));
        structures.add(structureFactory.createStructure(new Point(768, 416)));
        structures.add(structureFactory.createStructure(new Point(768, 384)));
        structures.add(structureFactory.createStructure(new Point(800, 384)));
        structures.add(structureFactory.createStructure(new Point(256, 416)));
        structures.add(structureFactory.createStructure(new Point(224, 416)));
        structures.add(structureFactory.createStructure(new Point(224, 384)));
        structures.add(structureFactory.createStructure(new Point(256, 384)));
        structures.add(structureFactory.createStructure(new Point(320, 416)));
        structures.add(structureFactory.createStructure(new Point(288, 416)));
        structures.add(structureFactory.createStructure(new Point(288, 384)));
        structures.add(structureFactory.createStructure(new Point(320, 384)));
        structures.add(structureFactory.createStructure(new Point(576, 416)));
        structures.add(structureFactory.createStructure(new Point(544, 416)));
        structures.add(structureFactory.createStructure(new Point(544, 384)));
        structures.add(structureFactory.createStructure(new Point(576, 384)));
        structures.add(structureFactory.createStructure(new Point(512, 416)));
        structures.add(structureFactory.createStructure(new Point(480, 416)));
        structures.add(structureFactory.createStructure(new Point(480, 384)));
        structures.add(structureFactory.createStructure(new Point(512, 384)));
        structures.add(structureFactory.createStructure(new Point(544, 576)));
        structures.add(structureFactory.createStructure(new Point(512, 576)));
        structures.add(structureFactory.createStructure(new Point(512, 544)));
        structures.add(structureFactory.createStructure(new Point(544, 544)));
        structures.add(structureFactory.createStructure(new Point(544, 640)));
        structures.add(structureFactory.createStructure(new Point(512, 640)));
        structures.add(structureFactory.createStructure(new Point(512, 608)));
        structures.add(structureFactory.createStructure(new Point(544, 608)));
        structures.add(structureFactory.createStructure(new Point(288, 640)));
        structures.add(structureFactory.createStructure(new Point(256, 640)));
        structures.add(structureFactory.createStructure(new Point(256, 608)));
        structures.add(structureFactory.createStructure(new Point(288, 608)));
        structures.add(structureFactory.createStructure(new Point(288, 576)));
        structures.add(structureFactory.createStructure(new Point(256, 576)));
        structures.add(structureFactory.createStructure(new Point(256, 544)));
        structures.add(structureFactory.createStructure(new Point(288, 544)));
        structures.add(structureFactory.createStructure(new Point(256, 224)));
        structures.add(structureFactory.createStructure(new Point(224, 224)));
        structures.add(structureFactory.createStructure(new Point(224, 192)));
        structures.add(structureFactory.createStructure(new Point(256, 192)));
        structures.add(structureFactory.createStructure(new Point(192, 224)));
        structures.add(structureFactory.createStructure(new Point(160, 224)));
        structures.add(structureFactory.createStructure(new Point(160, 192)));
        structures.add(structureFactory.createStructure(new Point(192, 192)));
        structures.add(structureFactory.createStructure(new Point(384, 160)));
        structures.add(structureFactory.createStructure(new Point(352, 160)));
        structures.add(structureFactory.createStructure(new Point(352, 128)));
        structures.add(structureFactory.createStructure(new Point(384, 128)));
        structures.add(structureFactory.createStructure(new Point(448, 160)));
        structures.add(structureFactory.createStructure(new Point(416, 160)));
        structures.add(structureFactory.createStructure(new Point(416, 128)));
        structures.add(structureFactory.createStructure(new Point(448, 128)));
        structures.add(structureFactory.createStructure(new Point(576, 96)));
        structures.add(structureFactory.createStructure(new Point(544, 96)));
        structures.add(structureFactory.createStructure(new Point(544, 64)));
        structures.add(structureFactory.createStructure(new Point(576, 64)));
        structures.add(structureFactory.createStructure(new Point(640, 96)));
        structures.add(structureFactory.createStructure(new Point(608, 96)));
        structures.add(structureFactory.createStructure(new Point(608, 64)));
        structures.add(structureFactory.createStructure(new Point(640, 64)));
        structures.add(structureFactory.createStructure(new Point(384, 96)));
        structures.add(structureFactory.createStructure(new Point(416, 96)));
        structures.add(structureFactory.createStructure(new Point(384, 192)));
        structures.add(structureFactory.createStructure(new Point(416, 192)));
        structures.add(structureFactory.createStructure(new Point(192, 160)));
        structures.add(structureFactory.createStructure(new Point(224, 160)));
        structures.add(structureFactory.createStructure(new Point(192, 256)));
        structures.add(structureFactory.createStructure(new Point(224, 256)));
        structures.add(structureFactory.createStructure(new Point(256, 352)));
        structures.add(structureFactory.createStructure(new Point(288, 352)));
        structures.add(structureFactory.createStructure(new Point(256, 448)));
        structures.add(structureFactory.createStructure(new Point(288, 448)));
        structures.add(structureFactory.createStructure(new Point(512, 352)));
        structures.add(structureFactory.createStructure(new Point(544, 352)));
        structures.add(structureFactory.createStructure(new Point(512, 448)));
        structures.add(structureFactory.createStructure(new Point(544, 448)));
        structures.add(structureFactory.createStructure(new Point(576, 128)));
        structures.add(structureFactory.createStructure(new Point(608, 128)));
        structures.add(structureFactory.createStructure(new Point(576, 32)));
        structures.add(structureFactory.createStructure(new Point(608, 32)));
        structures.add(structureFactory.createStructure(new Point(320, 576)));
        structures.add(structureFactory.createStructure(new Point(320, 608)));
        structures.add(structureFactory.createStructure(new Point(224, 576)));
        structures.add(structureFactory.createStructure(new Point(224, 608)));
        structures.add(structureFactory.createStructure(new Point(480, 576)));
        structures.add(structureFactory.createStructure(new Point(480, 608)));
        structures.add(structureFactory.createStructure(new Point(576, 576)));
        structures.add(structureFactory.createStructure(new Point(576, 608)));

        structureFactory = new GrassStructureFactory();

        structures.add(structureFactory.createStructure(new Point(320, 480)));
        structures.add(structureFactory.createStructure(new Point(352, 480)));
        structures.add(structureFactory.createStructure(new Point(352, 448)));
        structures.add(structureFactory.createStructure(new Point(320, 448)));
        structures.add(structureFactory.createStructure(new Point(320, 640)));
        structures.add(structureFactory.createStructure(new Point(352, 640)));
        structures.add(structureFactory.createStructure(new Point(352, 672)));
        structures.add(structureFactory.createStructure(new Point(320, 672)));
        structures.add(structureFactory.createStructure(new Point(192, 448)));
        structures.add(structureFactory.createStructure(new Point(224, 448)));
        structures.add(structureFactory.createStructure(new Point(224, 480)));
        structures.add(structureFactory.createStructure(new Point(192, 480)));
        structures.add(structureFactory.createStructure(new Point(192, 640)));
        structures.add(structureFactory.createStructure(new Point(224, 640)));
        structures.add(structureFactory.createStructure(new Point(224, 672)));
        structures.add(structureFactory.createStructure(new Point(192, 672)));
        structures.add(structureFactory.createStructure(new Point(448, 640)));
        structures.add(structureFactory.createStructure(new Point(480, 640)));
        structures.add(structureFactory.createStructure(new Point(480, 672)));
        structures.add(structureFactory.createStructure(new Point(448, 672)));
        structures.add(structureFactory.createStructure(new Point(576, 640)));
        structures.add(structureFactory.createStructure(new Point(608, 640)));
        structures.add(structureFactory.createStructure(new Point(608, 672)));
        structures.add(structureFactory.createStructure(new Point(576, 672)));
        structures.add(structureFactory.createStructure(new Point(320, 320)));
        structures.add(structureFactory.createStructure(new Point(352, 320)));
        structures.add(structureFactory.createStructure(new Point(352, 352)));
        structures.add(structureFactory.createStructure(new Point(320, 352)));
        structures.add(structureFactory.createStructure(new Point(192, 320)));
        structures.add(structureFactory.createStructure(new Point(224, 320)));
        structures.add(structureFactory.createStructure(new Point(224, 352)));
        structures.add(structureFactory.createStructure(new Point(192, 352)));
        structures.add(structureFactory.createStructure(new Point(256, 256)));
        structures.add(structureFactory.createStructure(new Point(256, 288)));
        structures.add(structureFactory.createStructure(new Point(288, 288)));
        structures.add(structureFactory.createStructure(new Point(288, 256)));
        structures.add(structureFactory.createStructure(new Point(256, 128)));
        structures.add(structureFactory.createStructure(new Point(256, 160)));
        structures.add(structureFactory.createStructure(new Point(288, 160)));
        structures.add(structureFactory.createStructure(new Point(288, 128)));
        structures.add(structureFactory.createStructure(new Point(448, 96)));
        structures.add(structureFactory.createStructure(new Point(480, 96)));
        structures.add(structureFactory.createStructure(new Point(480, 64)));
        structures.add(structureFactory.createStructure(new Point(448, 64)));
        structures.add(structureFactory.createStructure(new Point(448, 192)));
        structures.add(structureFactory.createStructure(new Point(480, 192)));
        structures.add(structureFactory.createStructure(new Point(480, 224)));
        structures.add(structureFactory.createStructure(new Point(448, 224)));
        structures.add(structureFactory.createStructure(new Point(640, 32)));
        structures.add(structureFactory.createStructure(new Point(672, 32)));
        structures.add(structureFactory.createStructure(new Point(672, 0)));
        structures.add(structureFactory.createStructure(new Point(640, 0)));
        structures.add(structureFactory.createStructure(new Point(640, 128)));
        structures.add(structureFactory.createStructure(new Point(672, 128)));
        structures.add(structureFactory.createStructure(new Point(672, 160)));
        structures.add(structureFactory.createStructure(new Point(640, 160)));

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

}
