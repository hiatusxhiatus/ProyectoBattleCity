
package Scenarios;

import Interfaces.IStructure;
import Factories.*;
import Observers.*;

import javax.swing.*;
import java.awt.*;

public class Level4 extends Level {

    public Level4() {
        super();
        initScenario();

    }

    public void initScenario() {

        labelLevel = new JLabel();

        setStructureFactory(new EagleStructureFactory());
        setEagle(returnStructureFactory().createStructure(new Point(384, 768)));

        setStructureFactory(new BrickStructureFactory());

        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(0, 64)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 64)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 96)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(0, 96)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 0)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 0)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 32)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 32)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 64)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(800, 64)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(800, 96)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 96)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(640, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(672, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(672, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(640, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(672, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(640, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(128, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(160, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(160, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(128, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(160, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(128, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(800, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(800, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(800, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(800, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(704, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(736, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(736, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(704, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(64, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(96, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(96, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(64, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(0, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(0, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(0, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(0, 608)));

        setStructureFactory(new WallStructureFactory());

        returnStructures().add(returnStructureFactory().createStructure(new Point(0, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(0, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(800, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(800, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(160, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(160, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 96)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 96)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 64)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 64)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(640, 96)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 96)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 64)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(640, 64)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 96)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 96)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 32)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 32)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 608)));

        setStructureFactory(new GrassStructureFactory());

        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 96)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 96)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 64)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 64)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(640, 32)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(672, 32)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(672, 0)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(640, 0)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(640, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(672, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(672, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(640, 160)));

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

        labelLevel.setText("4");
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

