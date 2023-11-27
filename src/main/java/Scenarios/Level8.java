
package Scenarios;

import Interfaces.IStructure;
import Factories.*;
import Observers.*;

import javax.swing.*;
import java.awt.*;


public class Level8 extends Level {

    public Level8() {
        super();
        initScenario();

    }

    public void initScenario() {

        labelLevel = new JLabel();
        returnPanelWindow().setBackground(Color.gray);
        returnPanelWindow().setForeground(Color.white);
        returnPanelWindow().setPreferredSize(new Dimension(1024, 832));
        returnPanelWindow().setSize(new Dimension(1024, 832));
        returnPanelWindow().setLayout(null);

        returnPanelGame().setBackground(Color.black);
        returnPanelGame().setForeground(Color.white);
        returnPanelGame().setPreferredSize(new Dimension(1024, 832));
        returnPanelGame().setMinimumSize(new Dimension(832, 832));
        returnPanelGame().setSize(new Dimension(832, 832));
        returnPanelGame().setLayout(null);

        {
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < returnPanelGame().getComponentCount(); i++) {
                Rectangle bounds = returnPanelGame().getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = returnPanelGame().getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            returnPanelGame().setMinimumSize(preferredSize);
            returnPanelGame().setPreferredSize(preferredSize);
        }

        setStructureFactory(new EagleStructureFactory());
        setEagle(returnStructureFactory().createStructure(new Point(384, 768)));

        setStructureFactory(new BrickStructureFactory());

        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 384)));

        setStructureFactory(new WallStructureFactory());

        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 512)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 512)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 512)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(64, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(64, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(96, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(64, 100)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(736, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(736, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(704, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(736, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(64, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(64, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(96, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(64, 512)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 320)));

        setStructureFactory(new GrassStructureFactory());

        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 704)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 704)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 704)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 704)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 96)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 96)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 512)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 512)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 512)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 512)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 288)));

        returnPanelGame().add(returnEagle().getLabel());

        returnTanksLeft().add(new TankObserver(new Point(925, 270)));
        returnTanksLeft().add(new TankObserver(new Point(890, 270)));
        returnTanksLeft().add(new TankObserver(new Point(960, 235)));
        returnTanksLeft().add(new TankObserver(new Point(925, 235)));
        returnTanksLeft().add(new TankObserver(new Point(890, 235)));
        returnTanksLeft().add(new TankObserver(new Point(960, 200)));
        returnTanksLeft().add(new TankObserver(new Point(925, 200)));
        returnTanksLeft().add(new TankObserver(new Point(890, 200)));
        returnTanksLeft().add(new TankObserver(new Point(960, 165)));
        returnTanksLeft().add(new TankObserver(new Point(925, 165)));
        returnTanksLeft().add(new TankObserver(new Point(890, 165)));
        returnTanksLeft().add(new TankObserver(new Point(960, 130)));
        returnTanksLeft().add(new TankObserver(new Point(925, 130)));
        returnTanksLeft().add(new TankObserver(new Point(890, 130)));
        returnTanksLeft().add(new TankObserver(new Point(960, 95)));
        returnTanksLeft().add(new TankObserver(new Point(925, 95)));
        returnTanksLeft().add(new TankObserver(new Point(890, 95)));
        returnTanksLeft().add(new TankObserver(new Point(960, 60)));
        returnTanksLeft().add(new TankObserver(new Point(925, 60)));
        returnTanksLeft().add(new TankObserver(new Point(890, 60)));
        setBulletCounter(new BulletObserver(new Point(940, 780)));
        setCardCounter(new CardObserver(new Point(940, 740)));

        labelLevel.setText("8");
        labelLevel.setFont(new Font("Pixel NES", Font.PLAIN, 40));
        labelLevel.setForeground(Color.black);
        returnPanelWindow().add(labelLevel);
        labelLevel.setBounds(940, 505, 35, 35);

        for (IStructure structure : returnStructures())
            returnPanelGame().add(structure.getLabel());

        for (TankObserver tank : returnTanksLeft())
            returnPanelWindow().add(tank.getLabel());

        returnPanelWindow().add(returnCardCounter().getLabel());
        returnPanelWindow().add(returnBulletCounter().getLabel());

        returnPanelWindow().add(returnPanelGame());
        returnPanelGame().setBounds(0, 0, 832, 832);

    }

    JLabel labelLevel;
}

