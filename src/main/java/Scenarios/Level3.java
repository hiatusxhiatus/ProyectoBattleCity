
package Scenarios;

import Enums.BrickState;
import Interfaces.IStructure;
import Factories.*;
import Observers.*;

import javax.swing.*;
import java.awt.*;


public class Level3 extends Level {

    public Level3() {
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
        returnStructures().add(returnStructureFactory().createStructure(new Point(128, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(704, 288)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(704, 256)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(704, 224)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 480)));

        returnStructures().add(returnStructureFactory().createStructure(new Point(96, 224)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Bottom);
        returnStructures().add(returnStructureFactory().createStructure(new Point(64, 320)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Bottom);
        returnStructures().add(returnStructureFactory().createStructure(new Point(96, 320)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Bottom);
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 320)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Bottom);
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 288)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Bottom);
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 224)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Bottom);
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 320)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Bottom);
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 224)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Bottom);
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 224)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Bottom);
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 224)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Bottom);
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 320)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Bottom);
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 320)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Bottom);
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 320)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Bottom);
        returnStructures().add(returnStructureFactory().createStructure(new Point(640, 320)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Bottom);
        returnStructures().add(returnStructureFactory().createStructure(new Point(736, 224)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Bottom);
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 224)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Bottom);
        returnStructures().add(returnStructureFactory().createStructure(new Point(736, 320)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Bottom);
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 320)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Bottom);
        returnStructures().add(returnStructureFactory().createStructure(new Point(704, 320)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Bottom);

        returnStructures().add(returnStructureFactory().createStructure(new Point(736, 256)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Top);
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 256)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Top);
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 416)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Top);
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 416)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Top);
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 416)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Top);
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 416)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Top);
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 416)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Top);
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 416)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Top);
        returnStructures().add(returnStructureFactory().createStructure(new Point(96, 256)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Top);

        returnStructures().add(returnStructureFactory().createStructure(new Point(64, 256)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.TopRightCorner);
        returnStructures().add(returnStructureFactory().createStructure(new Point(128, 224)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.TopRightCorner);
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 512)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.TopRightCorner);
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 512)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.TopRightCorner);

        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 512)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.TopLeft);
        returnStructures().add(returnStructureFactory().createStructure(new Point(320, 416)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.TopLeft);
        returnStructures().add(returnStructureFactory().createStructure(new Point(448, 416)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.TopLeft);
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 416)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.TopLeft);
        returnStructures().add(returnStructureFactory().createStructure(new Point(640, 416)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.TopLeft);

        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 480)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.BottomLeftCorner);
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 224)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.BottomLeftCorner);

        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 224)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.TopLeftCorner);
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 448)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.TopLeftCorner);
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 512)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.TopLeftCorner);
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 512)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.TopLeftCorner);

        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 448)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.BottomRight);
        returnStructures().add(returnStructureFactory().createStructure(new Point(288, 512)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.BottomRight);
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 448)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.BottomRight);
        returnStructures().add(returnStructureFactory().createStructure(new Point(128, 320)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.BottomRight);
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 320)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.BottomRight);

        returnStructures().add(returnStructureFactory().createStructure(new Point(64, 224)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.BottomRightCorner);
        returnStructures().add(returnStructureFactory().createStructure(new Point(128, 256)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.BottomRightCorner);
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 288)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.BottomRightCorner);
        returnStructures().add(returnStructureFactory().createStructure(new Point(640, 480)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.BottomRightCorner);

        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 224)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.TopRight);
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 416)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.TopRight);
        returnStructures().add(returnStructureFactory().createStructure(new Point(544, 416)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.TopRight);
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 416)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.TopRight);
        returnStructures().add(returnStructureFactory().createStructure(new Point(672, 416)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.TopRight);
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 512)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.TopRight);

        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 256)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Right);
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 480)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Right);
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 448)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Right);
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 480)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Right);
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 448)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Right);
        returnStructures().add(returnStructureFactory().createStructure(new Point(512, 512)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Right);
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 448)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Right);
        returnStructures().add(returnStructureFactory().createStructure(new Point(672, 448)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Right);
        returnStructures().add(returnStructureFactory().createStructure(new Point(640, 512)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Right);
        returnStructures().add(returnStructureFactory().createStructure(new Point(64, 288)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Right);

        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 480)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Left);
        returnStructures().add(returnStructureFactory().createStructure(new Point(352, 448)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Left);
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 480)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Left);
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 448)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Left);
        returnStructures().add(returnStructureFactory().createStructure(new Point(480, 512)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Left);
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 448)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Left);
        returnStructures().add(returnStructureFactory().createStructure(new Point(640, 448)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Left);
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 512)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Left);
        returnStructures().add(returnStructureFactory().createStructure(new Point(160, 256)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Left);
        returnStructures().add(returnStructureFactory().createStructure(new Point(160, 288)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Left);
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 224)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Left);
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 256)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Left);
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 288)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.Left);

        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 320)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.BottomLeft);
        returnStructures().add(returnStructureFactory().createStructure(new Point(160, 320)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.BottomLeft);
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 512)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.BottomLeft);
        returnStructures().add(returnStructureFactory().createStructure(new Point(256, 448)));
        returnStructures().get(returnStructures().size()-1).setState(BrickState.BottomLeft);


        setStructureFactory(new WallStructureFactory());

        returnStructures().add(returnStructureFactory().createStructure(new Point(0, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(0, 704)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 704)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(0, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(0, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(64, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(96, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(96, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(64, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(800, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(800, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(800, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 704)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(800, 704)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(704, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(736, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(736, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(704, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 96)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(0, 96)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(800, 96)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 96)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(416, 96)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(384, 96)));

        setStructureFactory(new GrassStructureFactory());

        returnStructures().add(returnStructureFactory().createStructure(new Point(0, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(0, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(0, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(0, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(32, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(64, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(64, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(64, 704)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(64, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(96, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(96, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(96, 704)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(96, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(128, 704)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(128, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(128, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(128, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(160, 704)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(160, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(160, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(160, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(800, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(800, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 576)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 608)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(768, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(800, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(800, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(736, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(736, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(704, 640)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(704, 672)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(704, 704)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(704, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(736, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(736, 704)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(672, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(672, 704)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(640, 704)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(640, 736)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(640, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(640, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(672, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(672, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(192, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(224, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 800)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(576, 768)));
        returnStructures().add(returnStructureFactory().createStructure(new Point(608, 768)));

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

        labelLevel.setText("3");
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

