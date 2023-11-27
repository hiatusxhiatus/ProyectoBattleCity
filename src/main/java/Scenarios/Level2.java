
package Scenarios;

import Interfaces.IStructure;
import Factories.*;
import Observers.*;

import javax.swing.*;
import java.awt.*;

public class Level2 extends Level {

    public Level2() {
        super();
        initScenario();

    }

    public void initScenario() {

        labelLevel = new JLabel();

        setStructureFactory(new EagleStructureFactory());
        setEagle(returnStructureFactory().createStructure(new Point(384, 768)));

        setStructureFactory(new BrickStructureFactory());

        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 128)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(545, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 160)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 640)));

        setStructureFactory(new WallStructureFactory());

        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(640, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 352)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 512)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 512)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 512)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(255, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(225, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(225, 515)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(255, 515)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 512)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 512)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 512)));

        setStructureFactory(new WaterStructureFactory());

        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 384)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 416)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 448)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 512)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 512)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 480)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 512)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 512)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 512)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 512)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 544)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 576)));

        setStructureFactory(new GrassStructureFactory());

        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 192)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 320)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 320)));

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

        labelLevel.setText("2");
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

