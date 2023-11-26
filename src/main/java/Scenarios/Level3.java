
package Scenarios;

import Classes.ImageCache;
import Enums.BrickState;
import Factories.*;
import Interfaces.IScenario;
import Interfaces.IStructure;
import Observers.BulletObserver;
import Observers.CardObserver;
import Observers.TankObserver;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Level3 implements IScenario {

    private ArrayList<IStructure> structures;
    private ArrayList<TankObserver> tanksLeft;
    private ArrayList<CardObserver> cardsGotten;
    private BulletObserver bulletCounter;
    private IStructure eagle;
    private StructureFactory structureFactory;
    private JPanel panelWindow;
    private JPanel panelGame;

    public Level3() {
        initScenario();
    }

    @Override
    public void initScenario() {

        structures = new ArrayList<>();
        tanksLeft = new ArrayList<>();
        cardsGotten = new ArrayList<>();
        panelWindow = new JPanel();
        panelGame = new JPanel();
        labelI = new JLabel();
        labelHPIcon = new JLabel();
        labelHP = new JLabel();
        labelP = new JLabel();
        labelFlag = new JLabel();
        labelLevel = new JLabel();
        labelBullet = new JLabel();

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

        structures.add(structureFactory.createStructure(new Point(352, 800)));
        structures.add(structureFactory.createStructure(new Point(352, 768)));
        structures.add(structureFactory.createStructure(new Point(352, 736)));
        structures.add(structureFactory.createStructure(new Point(384, 736)));
        structures.add(structureFactory.createStructure(new Point(416, 736)));
        structures.add(structureFactory.createStructure(new Point(448, 736)));
        structures.add(structureFactory.createStructure(new Point(448, 768)));
        structures.add(structureFactory.createStructure(new Point(448, 800)));
        structures.add(structureFactory.createStructure(new Point(128, 288)));
        structures.add(structureFactory.createStructure(new Point(256, 256)));
        structures.add(structureFactory.createStructure(new Point(256, 288)));
        structures.add(structureFactory.createStructure(new Point(352, 224)));
        structures.add(structureFactory.createStructure(new Point(352, 256)));
        structures.add(structureFactory.createStructure(new Point(352, 288)));
        structures.add(structureFactory.createStructure(new Point(480, 224)));
        structures.add(structureFactory.createStructure(new Point(480, 256)));
        structures.add(structureFactory.createStructure(new Point(480, 288)));
        structures.add(structureFactory.createStructure(new Point(576, 288)));
        structures.add(structureFactory.createStructure(new Point(576, 256)));
        structures.add(structureFactory.createStructure(new Point(576, 224)));
        structures.add(structureFactory.createStructure(new Point(704, 288)));
        structures.add(structureFactory.createStructure(new Point(704, 256)));
        structures.add(structureFactory.createStructure(new Point(704, 224)));
        structures.add(structureFactory.createStructure(new Point(192, 480)));

        structures.add(structureFactory.createStructure(new Point(96, 224)));
        structures.get(structures.size()-1).setState(BrickState.Bottom);
        structures.add(structureFactory.createStructure(new Point(64, 320)));
        structures.get(structures.size()-1).setState(BrickState.Bottom);
        structures.add(structureFactory.createStructure(new Point(96, 320)));
        structures.get(structures.size()-1).setState(BrickState.Bottom);
        structures.add(structureFactory.createStructure(new Point(256, 320)));
        structures.get(structures.size()-1).setState(BrickState.Bottom);
        structures.add(structureFactory.createStructure(new Point(224, 288)));
        structures.get(structures.size()-1).setState(BrickState.Bottom);
        structures.add(structureFactory.createStructure(new Point(320, 224)));
        structures.get(structures.size()-1).setState(BrickState.Bottom);
        structures.add(structureFactory.createStructure(new Point(352, 320)));
        structures.get(structures.size()-1).setState(BrickState.Bottom);
        structures.add(structureFactory.createStructure(new Point(384, 224)));
        structures.get(structures.size()-1).setState(BrickState.Bottom);
        structures.add(structureFactory.createStructure(new Point(448, 224)));
        structures.get(structures.size()-1).setState(BrickState.Bottom);
        structures.add(structureFactory.createStructure(new Point(512, 224)));
        structures.get(structures.size()-1).setState(BrickState.Bottom);
        structures.add(structureFactory.createStructure(new Point(480, 320)));
        structures.get(structures.size()-1).setState(BrickState.Bottom);
        structures.add(structureFactory.createStructure(new Point(576, 320)));
        structures.get(structures.size()-1).setState(BrickState.Bottom);
        structures.add(structureFactory.createStructure(new Point(608, 320)));
        structures.get(structures.size()-1).setState(BrickState.Bottom);
        structures.add(structureFactory.createStructure(new Point(640, 320)));
        structures.get(structures.size()-1).setState(BrickState.Bottom);
        structures.add(structureFactory.createStructure(new Point(736, 224)));
        structures.get(structures.size()-1).setState(BrickState.Bottom);
        structures.add(structureFactory.createStructure(new Point(768, 224)));
        structures.get(structures.size()-1).setState(BrickState.Bottom);
        structures.add(structureFactory.createStructure(new Point(736, 320)));
        structures.get(structures.size()-1).setState(BrickState.Bottom);
        structures.add(structureFactory.createStructure(new Point(768, 320)));
        structures.get(structures.size()-1).setState(BrickState.Bottom);
        structures.add(structureFactory.createStructure(new Point(704, 320)));
        structures.get(structures.size()-1).setState(BrickState.Bottom);

        structures.add(structureFactory.createStructure(new Point(736, 256)));
        structures.get(structures.size()-1).setState(BrickState.Top);
        structures.add(structureFactory.createStructure(new Point(768, 256)));
        structures.get(structures.size()-1).setState(BrickState.Top);
        structures.add(structureFactory.createStructure(new Point(224, 416)));
        structures.get(structures.size()-1).setState(BrickState.Top);
        structures.add(structureFactory.createStructure(new Point(256, 416)));
        structures.get(structures.size()-1).setState(BrickState.Top);
        structures.add(structureFactory.createStructure(new Point(352, 416)));
        structures.get(structures.size()-1).setState(BrickState.Top);
        structures.add(structureFactory.createStructure(new Point(384, 416)));
        structures.get(structures.size()-1).setState(BrickState.Top);
        structures.add(structureFactory.createStructure(new Point(512, 416)));
        structures.get(structures.size()-1).setState(BrickState.Top);
        structures.add(structureFactory.createStructure(new Point(480, 416)));
        structures.get(structures.size()-1).setState(BrickState.Top);
        structures.add(structureFactory.createStructure(new Point(96, 256)));
        structures.get(structures.size()-1).setState(BrickState.Top);

        structures.add(structureFactory.createStructure(new Point(64, 256)));
        structures.get(structures.size()-1).setState(BrickState.TopRightCorner);
        structures.add(structureFactory.createStructure(new Point(128, 224)));
        structures.get(structures.size()-1).setState(BrickState.TopRightCorner);
        structures.add(structureFactory.createStructure(new Point(224, 512)));
        structures.get(structures.size()-1).setState(BrickState.TopRightCorner);
        structures.add(structureFactory.createStructure(new Point(384, 512)));
        structures.get(structures.size()-1).setState(BrickState.TopRightCorner);

        structures.add(structureFactory.createStructure(new Point(320, 512)));
        structures.get(structures.size()-1).setState(BrickState.TopLeft);
        structures.add(structureFactory.createStructure(new Point(320, 416)));
        structures.get(structures.size()-1).setState(BrickState.TopLeft);
        structures.add(structureFactory.createStructure(new Point(448, 416)));
        structures.get(structures.size()-1).setState(BrickState.TopLeft);
        structures.add(structureFactory.createStructure(new Point(576, 416)));
        structures.get(structures.size()-1).setState(BrickState.TopLeft);
        structures.add(structureFactory.createStructure(new Point(640, 416)));
        structures.get(structures.size()-1).setState(BrickState.TopLeft);

        structures.add(structureFactory.createStructure(new Point(608, 480)));
        structures.get(structures.size()-1).setState(BrickState.BottomLeftCorner);
        structures.add(structureFactory.createStructure(new Point(224, 224)));
        structures.get(structures.size()-1).setState(BrickState.BottomLeftCorner);

        structures.add(structureFactory.createStructure(new Point(192, 224)));
        structures.get(structures.size()-1).setState(BrickState.TopLeftCorner);
        structures.add(structureFactory.createStructure(new Point(192, 448)));
        structures.get(structures.size()-1).setState(BrickState.TopLeftCorner);
        structures.add(structureFactory.createStructure(new Point(256, 512)));
        structures.get(structures.size()-1).setState(BrickState.TopLeftCorner);
        structures.add(structureFactory.createStructure(new Point(352, 512)));
        structures.get(structures.size()-1).setState(BrickState.TopLeftCorner);

        structures.add(structureFactory.createStructure(new Point(288, 448)));
        structures.get(structures.size()-1).setState(BrickState.BottomRight);
        structures.add(structureFactory.createStructure(new Point(288, 512)));
        structures.get(structures.size()-1).setState(BrickState.BottomRight);
        structures.add(structureFactory.createStructure(new Point(224, 448)));
        structures.get(structures.size()-1).setState(BrickState.BottomRight);
        structures.add(structureFactory.createStructure(new Point(128, 320)));
        structures.get(structures.size()-1).setState(BrickState.BottomRight);
        structures.add(structureFactory.createStructure(new Point(192, 320)));
        structures.get(structures.size()-1).setState(BrickState.BottomRight);

        structures.add(structureFactory.createStructure(new Point(64, 224)));
        structures.get(structures.size()-1).setState(BrickState.BottomRightCorner);
        structures.add(structureFactory.createStructure(new Point(128, 256)));
        structures.get(structures.size()-1).setState(BrickState.BottomRightCorner);
        structures.add(structureFactory.createStructure(new Point(192, 288)));
        structures.get(structures.size()-1).setState(BrickState.BottomRightCorner);
        structures.add(structureFactory.createStructure(new Point(640, 480)));
        structures.get(structures.size()-1).setState(BrickState.BottomRightCorner);

        structures.add(structureFactory.createStructure(new Point(256, 224)));
        structures.get(structures.size()-1).setState(BrickState.TopRight);
        structures.add(structureFactory.createStructure(new Point(416, 416)));
        structures.get(structures.size()-1).setState(BrickState.TopRight);
        structures.add(structureFactory.createStructure(new Point(544, 416)));
        structures.get(structures.size()-1).setState(BrickState.TopRight);
        structures.add(structureFactory.createStructure(new Point(608, 416)));
        structures.get(structures.size()-1).setState(BrickState.TopRight);
        structures.add(structureFactory.createStructure(new Point(672, 416)));
        structures.get(structures.size()-1).setState(BrickState.TopRight);
        structures.add(structureFactory.createStructure(new Point(416, 512)));
        structures.get(structures.size()-1).setState(BrickState.TopRight);

        structures.add(structureFactory.createStructure(new Point(192, 256)));
        structures.get(structures.size()-1).setState(BrickState.Right);
        structures.add(structureFactory.createStructure(new Point(384, 480)));
        structures.get(structures.size()-1).setState(BrickState.Right);
        structures.add(structureFactory.createStructure(new Point(384, 448)));
        structures.get(structures.size()-1).setState(BrickState.Right);
        structures.add(structureFactory.createStructure(new Point(512, 480)));
        structures.get(structures.size()-1).setState(BrickState.Right);
        structures.add(structureFactory.createStructure(new Point(512, 448)));
        structures.get(structures.size()-1).setState(BrickState.Right);
        structures.add(structureFactory.createStructure(new Point(512, 512)));
        structures.get(structures.size()-1).setState(BrickState.Right);
        structures.add(structureFactory.createStructure(new Point(608, 448)));
        structures.get(structures.size()-1).setState(BrickState.Right);
        structures.add(structureFactory.createStructure(new Point(672, 448)));
        structures.get(structures.size()-1).setState(BrickState.Right);
        structures.add(structureFactory.createStructure(new Point(640, 512)));
        structures.get(structures.size()-1).setState(BrickState.Right);
        structures.add(structureFactory.createStructure(new Point(64, 288)));
        structures.get(structures.size()-1).setState(BrickState.Right);

        structures.add(structureFactory.createStructure(new Point(352, 480)));
        structures.get(structures.size()-1).setState(BrickState.Left);
        structures.add(structureFactory.createStructure(new Point(352, 448)));
        structures.get(structures.size()-1).setState(BrickState.Left);
        structures.add(structureFactory.createStructure(new Point(480, 480)));
        structures.get(structures.size()-1).setState(BrickState.Left);
        structures.add(structureFactory.createStructure(new Point(480, 448)));
        structures.get(structures.size()-1).setState(BrickState.Left);
        structures.add(structureFactory.createStructure(new Point(480, 512)));
        structures.get(structures.size()-1).setState(BrickState.Left);
        structures.add(structureFactory.createStructure(new Point(576, 448)));
        structures.get(structures.size()-1).setState(BrickState.Left);
        structures.add(structureFactory.createStructure(new Point(640, 448)));
        structures.get(structures.size()-1).setState(BrickState.Left);
        structures.add(structureFactory.createStructure(new Point(608, 512)));
        structures.get(structures.size()-1).setState(BrickState.Left);
        structures.add(structureFactory.createStructure(new Point(160, 256)));
        structures.get(structures.size()-1).setState(BrickState.Left);
        structures.add(structureFactory.createStructure(new Point(160, 288)));
        structures.get(structures.size()-1).setState(BrickState.Left);
        structures.add(structureFactory.createStructure(new Point(32, 224)));
        structures.get(structures.size()-1).setState(BrickState.Left);
        structures.add(structureFactory.createStructure(new Point(32, 256)));
        structures.get(structures.size()-1).setState(BrickState.Left);
        structures.add(structureFactory.createStructure(new Point(32, 288)));
        structures.get(structures.size()-1).setState(BrickState.Left);

        structures.add(structureFactory.createStructure(new Point(32, 320)));
        structures.get(structures.size()-1).setState(BrickState.BottomLeft);
        structures.add(structureFactory.createStructure(new Point(160, 320)));
        structures.get(structures.size()-1).setState(BrickState.BottomLeft);
        structures.add(structureFactory.createStructure(new Point(192, 512)));
        structures.get(structures.size()-1).setState(BrickState.BottomLeft);
        structures.add(structureFactory.createStructure(new Point(256, 448)));
        structures.get(structures.size()-1).setState(BrickState.BottomLeft);


        structureFactory = new WallStructureFactory();

        structures.add(structureFactory.createStructure(new Point(32, 320)));
        structures.add(structureFactory.createStructure(new Point(0, 736)));
        structures.add(structureFactory.createStructure(new Point(0, 704)));
        structures.add(structureFactory.createStructure(new Point(32, 704)));
        structures.add(structureFactory.createStructure(new Point(32, 736)));
        structures.add(structureFactory.createStructure(new Point(32, 768)));
        structures.add(structureFactory.createStructure(new Point(32, 800)));
        structures.add(structureFactory.createStructure(new Point(0, 800)));
        structures.add(structureFactory.createStructure(new Point(0, 768)));
        structures.add(structureFactory.createStructure(new Point(64, 768)));
        structures.add(structureFactory.createStructure(new Point(96, 768)));
        structures.add(structureFactory.createStructure(new Point(96, 800)));
        structures.add(structureFactory.createStructure(new Point(64, 800)));
        structures.add(structureFactory.createStructure(new Point(800, 800)));
        structures.add(structureFactory.createStructure(new Point(768, 800)));
        structures.add(structureFactory.createStructure(new Point(768, 768)));
        structures.add(structureFactory.createStructure(new Point(800, 768)));
        structures.add(structureFactory.createStructure(new Point(800, 736)));
        structures.add(structureFactory.createStructure(new Point(768, 736)));
        structures.add(structureFactory.createStructure(new Point(768, 704)));
        structures.add(structureFactory.createStructure(new Point(800, 704)));
        structures.add(structureFactory.createStructure(new Point(704, 768)));
        structures.add(structureFactory.createStructure(new Point(736, 768)));
        structures.add(structureFactory.createStructure(new Point(736, 800)));
        structures.add(structureFactory.createStructure(new Point(704, 800)));
        structures.add(structureFactory.createStructure(new Point(32, 96)));
        structures.add(structureFactory.createStructure(new Point(0, 96)));
        structures.add(structureFactory.createStructure(new Point(800, 96)));
        structures.add(structureFactory.createStructure(new Point(768, 96)));
        structures.add(structureFactory.createStructure(new Point(416, 96)));
        structures.add(structureFactory.createStructure(new Point(384, 96)));

        structureFactory = new GrassStructureFactory();

        structures.add(structureFactory.createStructure(new Point(0, 640)));
        structures.add(structureFactory.createStructure(new Point(0, 672)));
        structures.add(structureFactory.createStructure(new Point(0, 576)));
        structures.add(structureFactory.createStructure(new Point(0, 608)));
        structures.add(structureFactory.createStructure(new Point(32, 576)));
        structures.add(structureFactory.createStructure(new Point(32, 608)));
        structures.add(structureFactory.createStructure(new Point(32, 640)));
        structures.add(structureFactory.createStructure(new Point(32, 672)));
        structures.add(structureFactory.createStructure(new Point(64, 640)));
        structures.add(structureFactory.createStructure(new Point(64, 672)));
        structures.add(structureFactory.createStructure(new Point(64, 704)));
        structures.add(structureFactory.createStructure(new Point(64, 736)));
        structures.add(structureFactory.createStructure(new Point(96, 640)));
        structures.add(structureFactory.createStructure(new Point(96, 672)));
        structures.add(structureFactory.createStructure(new Point(96, 704)));
        structures.add(structureFactory.createStructure(new Point(96, 736)));
        structures.add(structureFactory.createStructure(new Point(128, 704)));
        structures.add(structureFactory.createStructure(new Point(128, 736)));
        structures.add(structureFactory.createStructure(new Point(128, 768)));
        structures.add(structureFactory.createStructure(new Point(128, 800)));
        structures.add(structureFactory.createStructure(new Point(160, 704)));
        structures.add(structureFactory.createStructure(new Point(160, 736)));
        structures.add(structureFactory.createStructure(new Point(160, 768)));
        structures.add(structureFactory.createStructure(new Point(160, 800)));
        structures.add(structureFactory.createStructure(new Point(800, 608)));
        structures.add(structureFactory.createStructure(new Point(800, 576)));
        structures.add(structureFactory.createStructure(new Point(768, 576)));
        structures.add(structureFactory.createStructure(new Point(768, 608)));
        structures.add(structureFactory.createStructure(new Point(768, 640)));
        structures.add(structureFactory.createStructure(new Point(768, 672)));
        structures.add(structureFactory.createStructure(new Point(800, 672)));
        structures.add(structureFactory.createStructure(new Point(800, 640)));
        structures.add(structureFactory.createStructure(new Point(736, 672)));
        structures.add(structureFactory.createStructure(new Point(736, 640)));
        structures.add(structureFactory.createStructure(new Point(704, 640)));
        structures.add(structureFactory.createStructure(new Point(704, 672)));
        structures.add(structureFactory.createStructure(new Point(704, 704)));
        structures.add(structureFactory.createStructure(new Point(704, 736)));
        structures.add(structureFactory.createStructure(new Point(736, 736)));
        structures.add(structureFactory.createStructure(new Point(736, 704)));
        structures.add(structureFactory.createStructure(new Point(672, 736)));
        structures.add(structureFactory.createStructure(new Point(672, 704)));
        structures.add(structureFactory.createStructure(new Point(640, 704)));
        structures.add(structureFactory.createStructure(new Point(640, 736)));
        structures.add(structureFactory.createStructure(new Point(640, 768)));
        structures.add(structureFactory.createStructure(new Point(640, 800)));
        structures.add(structureFactory.createStructure(new Point(672, 800)));
        structures.add(structureFactory.createStructure(new Point(672, 768)));
        structures.add(structureFactory.createStructure(new Point(224, 800)));
        structures.add(structureFactory.createStructure(new Point(192, 800)));
        structures.add(structureFactory.createStructure(new Point(192, 768)));
        structures.add(structureFactory.createStructure(new Point(224, 768)));
        structures.add(structureFactory.createStructure(new Point(608, 800)));
        structures.add(structureFactory.createStructure(new Point(576, 800)));
        structures.add(structureFactory.createStructure(new Point(576, 768)));
        structures.add(structureFactory.createStructure(new Point(608, 768)));

        panelGame.add(eagle.getLabel());

        tanksLeft.add(new TankObserver(new Point(925, 270)));
        tanksLeft.add(new TankObserver(new Point(890, 270)));
        tanksLeft.add(new TankObserver(new Point(960, 235)));
        tanksLeft.add(new TankObserver(new Point(925, 235)));
        tanksLeft.add(new TankObserver(new Point(890, 235)));
        tanksLeft.add(new TankObserver(new Point(960, 200)));
        tanksLeft.add(new TankObserver(new Point(925, 200)));
        tanksLeft.add(new TankObserver(new Point(890, 200)));
        tanksLeft.add(new TankObserver(new Point(960, 165)));
        tanksLeft.add(new TankObserver(new Point(925, 165)));
        tanksLeft.add(new TankObserver(new Point(890, 165)));
        tanksLeft.add(new TankObserver(new Point(960, 130)));
        tanksLeft.add(new TankObserver(new Point(925, 130)));
        tanksLeft.add(new TankObserver(new Point(890, 130)));
        tanksLeft.add(new TankObserver(new Point(960, 95)));
        tanksLeft.add(new TankObserver(new Point(925, 95)));
        tanksLeft.add(new TankObserver(new Point(890, 95)));
        tanksLeft.add(new TankObserver(new Point(960, 60)));
        tanksLeft.add(new TankObserver(new Point(925, 60)));
        tanksLeft.add(new TankObserver(new Point(890, 60)));
        cardsGotten.add(new CardObserver(new Point(945, 660)));
        cardsGotten.add(new CardObserver(new Point(875, 660)));
        cardsGotten.add(new CardObserver(new Point(945, 595)));
        cardsGotten.add(new CardObserver(new Point(875, 595)));
        bulletCounter = new BulletObserver(new Point(940, 780));

        //---- labelI ----
        labelI.setText("I");
        labelI.setFont(new Font("Pixel NES", Font.PLAIN, 40));
        labelI.setForeground(Color.black);
        panelWindow.add(labelI);
        labelI.setBounds(905, 330, 30, 35);

        //---- labelHPIcon ----
        labelHPIcon.setIcon(ImageCache.loadImage("src/main/java/imagenes/hp.png"));
        labelHPIcon.setHorizontalAlignment(SwingConstants.CENTER);
        panelWindow.add(labelHPIcon);
        labelHPIcon.setBounds(905, 370, 32, 32);

        //---- labelHP ----
        labelHP.setText("3");
        labelHP.setFont(new Font("Pixel NES", Font.PLAIN, 40));
        labelHP.setForeground(Color.black);
        panelWindow.add(labelHP);
        labelHP.setBounds(940, 365, 35, 35);

        //---- labelP ----
        labelP.setText("P");
        labelP.setFont(new Font("Pixel NES", Font.PLAIN, 40));
        labelP.setForeground(Color.black);
        panelWindow.add(labelP);
        labelP.setBounds(940, 330, 40, 35);

        //---- labelFlag ----
        labelFlag.setIcon(ImageCache.loadImage("src/main/java/imagenes/flag.png"));
        labelFlag.setHorizontalAlignment(SwingConstants.CENTER);
        panelWindow.add(labelFlag);
        labelFlag.setBounds(905, 440, 64, 64);

        //---- labelLevel ----
        labelLevel.setText("8");
        labelLevel.setFont(new Font("Pixel NES", Font.PLAIN, 40));
        labelLevel.setForeground(Color.black);
        panelWindow.add(labelLevel);
        labelLevel.setBounds(940, 505, 35, 35);

        //---- labelBullet ----
        labelBullet.setIcon(ImageCache.loadImage("src/main/java/imagenes/bulletRIGHT.png"));
        labelBullet.setHorizontalAlignment(SwingConstants.CENTER);
        panelWindow.add(labelBullet);
        labelBullet.setBounds(905, 780, 32, 32);

        for (IStructure structure : structures)
            panelGame.add(structure.getLabel());

        for (TankObserver tank : tanksLeft)
            panelWindow.add(tank.getLabel());

        for (CardObserver card : cardsGotten)
            panelWindow.add(card.getLabel());

        panelWindow.add(bulletCounter.getLabel());

        panelWindow.add(panelGame);
        panelGame.setBounds(0, 0, 832, 832);

    }

    private JLabel labelI;
    private JLabel labelHPIcon;
    private JLabel labelHP;
    private JLabel labelP;
    private JLabel labelFlag;
    private JLabel labelLevel;
    private JLabel labelBullet;

    @Override
    public ArrayList<CardObserver> getCardsGotten() {
        return cardsGotten;
    }

    @Override
    public BulletObserver getBulletCounter() {
        return bulletCounter;
    }

    @Override
    public void setHP(int hp) {
        labelHP.setText(Integer.toString(hp));
    }

    @Override
    public ArrayList<TankObserver> getTanksLeft() {
        return tanksLeft;
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
