
package Scenarios;

import Classes.ImageCache;
import Factories.*;
import Interfaces.IScenario;
import Interfaces.IStructure;
import Observers.BulletObserver;
import Observers.CardObserver;
import Observers.TankObserver;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Level1 implements IScenario {

    private ArrayList<IStructure> structures;
    private ArrayList<TankObserver> tanksLeft;
    private ArrayList<CardObserver> cardsGotten;
    private BulletObserver bulletCounter;
    private IStructure eagle;
    private StructureFactory structureFactory;
    private JPanel panelWindow;
    private JPanel panelGame;

    public Level1() {
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

        panelWindow.setBackground(new Color(116, 116, 116));
        panelWindow.setForeground(Color.white);
        panelWindow.setBorder(javax.swing.BorderFactory.createLineBorder(Color.lightGray, 4, true));
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

        structures.add(structureFactory.createStructure(new Point(608, 224)));
        structures.add(structureFactory.createStructure(new Point(320, 64)));
        structures.add(structureFactory.createStructure(new Point(352, 64)));
        structures.add(structureFactory.createStructure(new Point(480, 96)));
        structures.add(structureFactory.createStructure(new Point(448, 96)));
        structures.add(structureFactory.createStructure(new Point(608, 288)));
        structures.add(structureFactory.createStructure(new Point(640, 160)));
        structures.add(structureFactory.createStructure(new Point(672, 160)));
        structures.add(structureFactory.createStructure(new Point(672, 224)));
        structures.add(structureFactory.createStructure(new Point(640, 224)));
        structures.add(structureFactory.createStructure(new Point(704, 192)));
        structures.add(structureFactory.createStructure(new Point(704, 224)));
        structures.add(structureFactory.createStructure(new Point(704, 256)));
        structures.add(structureFactory.createStructure(new Point(704, 288)));
        structures.add(structureFactory.createStructure(new Point(256, 160)));
        structures.add(structureFactory.createStructure(new Point(256, 192)));
        structures.add(structureFactory.createStructure(new Point(288, 192)));
        structures.add(structureFactory.createStructure(new Point(288, 160)));
        structures.add(structureFactory.createStructure(new Point(160, 352)));
        structures.add(structureFactory.createStructure(new Point(160, 320)));
        structures.add(structureFactory.createStructure(new Point(160, 288)));
        structures.add(structureFactory.createStructure(new Point(160, 256)));
        structures.add(structureFactory.createStructure(new Point(192, 192)));
        structures.add(structureFactory.createStructure(new Point(192, 224)));
        structures.add(structureFactory.createStructure(new Point(224, 128)));
        structures.add(structureFactory.createStructure(new Point(224, 160)));
        structures.add(structureFactory.createStructure(new Point(576, 320)));
        structures.add(structureFactory.createStructure(new Point(576, 352)));
        structures.add(structureFactory.createStructure(new Point(576, 384)));
        structures.add(structureFactory.createStructure(new Point(576, 416)));
        structures.add(structureFactory.createStructure(new Point(576, 448)));
        structures.add(structureFactory.createStructure(new Point(608, 448)));
        structures.add(structureFactory.createStructure(new Point(608, 480)));
        structures.add(structureFactory.createStructure(new Point(640, 512)));
        structures.add(structureFactory.createStructure(new Point(640, 544)));
        structures.add(structureFactory.createStructure(new Point(640, 576)));
        structures.add(structureFactory.createStructure(new Point(672, 576)));
        structures.add(structureFactory.createStructure(new Point(576, 576)));
        structures.add(structureFactory.createStructure(new Point(608, 576)));
        structures.add(structureFactory.createStructure(new Point(512, 608)));
        structures.add(structureFactory.createStructure(new Point(544, 608)));
        structures.add(structureFactory.createStructure(new Point(448, 640)));
        structures.add(structureFactory.createStructure(new Point(480, 640)));
        structures.add(structureFactory.createStructure(new Point(384, 672)));
        structures.add(structureFactory.createStructure(new Point(416, 672)));
        structures.add(structureFactory.createStructure(new Point(320, 672)));
        structures.add(structureFactory.createStructure(new Point(352, 672)));
        structures.add(structureFactory.createStructure(new Point(256, 640)));
        structures.add(structureFactory.createStructure(new Point(288, 640)));
        structures.add(structureFactory.createStructure(new Point(192, 608)));
        structures.add(structureFactory.createStructure(new Point(224, 608)));
        structures.add(structureFactory.createStructure(new Point(352, 800)));
        structures.add(structureFactory.createStructure(new Point(352, 768)));
        structures.add(structureFactory.createStructure(new Point(352, 736)));
        structures.add(structureFactory.createStructure(new Point(384, 736)));
        structures.add(structureFactory.createStructure(new Point(416, 736)));
        structures.add(structureFactory.createStructure(new Point(448, 736)));
        structures.add(structureFactory.createStructure(new Point(448, 768)));
        structures.add(structureFactory.createStructure(new Point(448, 800)));
        structures.add(structureFactory.createStructure(new Point(128, 576)));
        structures.add(structureFactory.createStructure(new Point(160, 576)));
        structures.add(structureFactory.createStructure(new Point(64, 576)));
        structures.add(structureFactory.createStructure(new Point(96, 576)));
        structures.add(structureFactory.createStructure(new Point(96, 544)));
        structures.add(structureFactory.createStructure(new Point(96, 512)));
        structures.add(structureFactory.createStructure(new Point(128, 480)));
        structures.add(structureFactory.createStructure(new Point(128, 448)));
        structures.add(structureFactory.createStructure(new Point(128, 416)));
        structures.add(structureFactory.createStructure(new Point(128, 384)));
        structures.add(structureFactory.createStructure(new Point(64, 640)));
        structures.add(structureFactory.createStructure(new Point(96, 640)));
        structures.add(structureFactory.createStructure(new Point(64, 672)));
        structures.add(structureFactory.createStructure(new Point(96, 672)));
        structures.add(structureFactory.createStructure(new Point(128, 640)));
        structures.add(structureFactory.createStructure(new Point(160, 640)));
        structures.add(structureFactory.createStructure(new Point(128, 672)));
        structures.add(structureFactory.createStructure(new Point(160, 672)));
        structures.add(structureFactory.createStructure(new Point(128, 704)));
        structures.add(structureFactory.createStructure(new Point(160, 704)));
        structures.add(structureFactory.createStructure(new Point(192, 672)));
        structures.add(structureFactory.createStructure(new Point(224, 672)));
        structures.add(structureFactory.createStructure(new Point(192, 704)));
        structures.add(structureFactory.createStructure(new Point(224, 704)));
        structures.add(structureFactory.createStructure(new Point(512, 672)));
        structures.add(structureFactory.createStructure(new Point(544, 672)));
        structures.add(structureFactory.createStructure(new Point(512, 704)));
        structures.add(structureFactory.createStructure(new Point(544, 704)));
        structures.add(structureFactory.createStructure(new Point(576, 640)));
        structures.add(structureFactory.createStructure(new Point(608, 640)));
        structures.add(structureFactory.createStructure(new Point(640, 640)));
        structures.add(structureFactory.createStructure(new Point(672, 640)));
        structures.add(structureFactory.createStructure(new Point(576, 672)));
        structures.add(structureFactory.createStructure(new Point(608, 672)));
        structures.add(structureFactory.createStructure(new Point(640, 672)));
        structures.add(structureFactory.createStructure(new Point(672, 672)));
        structures.add(structureFactory.createStructure(new Point(576, 704)));
        structures.add(structureFactory.createStructure(new Point(608, 704)));
        structures.add(structureFactory.createStructure(new Point(320, 160)));
        structures.add(structureFactory.createStructure(new Point(352, 160)));
        structures.add(structureFactory.createStructure(new Point(320, 128)));
        structures.add(structureFactory.createStructure(new Point(352, 128)));
        structures.add(structureFactory.createStructure(new Point(352, 96)));
        structures.add(structureFactory.createStructure(new Point(320, 96)));
        structures.add(structureFactory.createStructure(new Point(384, 160)));
        structures.add(structureFactory.createStructure(new Point(416, 160)));
        structures.add(structureFactory.createStructure(new Point(384, 128)));
        structures.add(structureFactory.createStructure(new Point(416, 128)));
        structures.add(structureFactory.createStructure(new Point(416, 96)));
        structures.add(structureFactory.createStructure(new Point(384, 96)));
        structures.add(structureFactory.createStructure(new Point(320, 192)));
        structures.add(structureFactory.createStructure(new Point(352, 192)));
        structures.add(structureFactory.createStructure(new Point(384, 192)));
        structures.add(structureFactory.createStructure(new Point(416, 192)));
        structures.add(structureFactory.createStructure(new Point(416, 224)));
        structures.add(structureFactory.createStructure(new Point(576, 480)));
        structures.add(structureFactory.createStructure(new Point(576, 512)));
        structures.add(structureFactory.createStructure(new Point(128, 544)));
        structures.add(structureFactory.createStructure(new Point(160, 544)));
        structures.add(structureFactory.createStructure(new Point(608, 512)));
        structures.add(structureFactory.createStructure(new Point(576, 544)));
        structures.add(structureFactory.createStructure(new Point(608, 544)));
        structures.add(structureFactory.createStructure(new Point(192, 544)));
        structures.add(structureFactory.createStructure(new Point(256, 576)));
        structures.add(structureFactory.createStructure(new Point(480, 608)));
        structures.add(structureFactory.createStructure(new Point(448, 608)));
        structures.add(structureFactory.createStructure(new Point(288, 576)));
        structures.add(structureFactory.createStructure(new Point(288, 608)));
        structures.add(structureFactory.createStructure(new Point(256, 608)));
        structures.add(structureFactory.createStructure(new Point(192, 576)));
        structures.add(structureFactory.createStructure(new Point(224, 544)));
        structures.add(structureFactory.createStructure(new Point(224, 576)));
        structures.add(structureFactory.createStructure(new Point(256, 544)));
        structures.add(structureFactory.createStructure(new Point(288, 544)));
        structures.add(structureFactory.createStructure(new Point(256, 416)));
        structures.add(structureFactory.createStructure(new Point(288, 416)));
        structures.add(structureFactory.createStructure(new Point(352, 416)));
        structures.add(structureFactory.createStructure(new Point(320, 416)));
        structures.add(structureFactory.createStructure(new Point(320, 448)));
        structures.add(structureFactory.createStructure(new Point(352, 448)));
        structures.add(structureFactory.createStructure(new Point(384, 448)));
        structures.add(structureFactory.createStructure(new Point(416, 448)));
        structures.add(structureFactory.createStructure(new Point(320, 480)));
        structures.add(structureFactory.createStructure(new Point(352, 480)));
        structures.add(structureFactory.createStructure(new Point(384, 480)));
        structures.add(structureFactory.createStructure(new Point(416, 480)));
        structures.add(structureFactory.createStructure(new Point(416, 512)));
        structures.add(structureFactory.createStructure(new Point(384, 512)));
        structures.add(structureFactory.createStructure(new Point(352, 512)));
        structures.add(structureFactory.createStructure(new Point(320, 512)));
        structures.add(structureFactory.createStructure(new Point(320, 544)));
        structures.add(structureFactory.createStructure(new Point(352, 544)));
        structures.add(structureFactory.createStructure(new Point(384, 544)));
        structures.add(structureFactory.createStructure(new Point(416, 544)));
        structures.add(structureFactory.createStructure(new Point(320, 576)));
        structures.add(structureFactory.createStructure(new Point(352, 576)));
        structures.add(structureFactory.createStructure(new Point(384, 576)));
        structures.add(structureFactory.createStructure(new Point(416, 576)));
        structures.add(structureFactory.createStructure(new Point(416, 608)));
        structures.add(structureFactory.createStructure(new Point(384, 608)));
        structures.add(structureFactory.createStructure(new Point(352, 608)));
        structures.add(structureFactory.createStructure(new Point(320, 608)));
        structures.add(structureFactory.createStructure(new Point(320, 640)));
        structures.add(structureFactory.createStructure(new Point(352, 640)));
        structures.add(structureFactory.createStructure(new Point(384, 640)));
        structures.add(structureFactory.createStructure(new Point(416, 640)));
        structures.add(structureFactory.createStructure(new Point(448, 128)));
        structures.add(structureFactory.createStructure(new Point(480, 128)));
        structures.add(structureFactory.createStructure(new Point(512, 128)));
        structures.add(structureFactory.createStructure(new Point(544, 128)));
        structures.add(structureFactory.createStructure(new Point(544, 160)));
        structures.add(structureFactory.createStructure(new Point(512, 160)));
        structures.add(structureFactory.createStructure(new Point(480, 160)));
        structures.add(structureFactory.createStructure(new Point(448, 160)));
        structures.add(structureFactory.createStructure(new Point(448, 192)));
        structures.add(structureFactory.createStructure(new Point(480, 192)));
        structures.add(structureFactory.createStructure(new Point(512, 192)));
        structures.add(structureFactory.createStructure(new Point(544, 192)));
        structures.add(structureFactory.createStructure(new Point(448, 224)));
        structures.add(structureFactory.createStructure(new Point(480, 224)));
        structures.add(structureFactory.createStructure(new Point(512, 224)));
        structures.add(structureFactory.createStructure(new Point(544, 224)));
        structures.add(structureFactory.createStructure(new Point(544, 256)));
        structures.add(structureFactory.createStructure(new Point(512, 256)));
        structures.add(structureFactory.createStructure(new Point(480, 256)));
        structures.add(structureFactory.createStructure(new Point(448, 256)));
        structures.add(structureFactory.createStructure(new Point(384, 224)));
        structures.add(structureFactory.createStructure(new Point(512, 288)));
        structures.add(structureFactory.createStructure(new Point(544, 288)));
        structures.add(structureFactory.createStructure(new Point(352, 224)));
        structures.add(structureFactory.createStructure(new Point(256, 224)));
        structures.add(structureFactory.createStructure(new Point(512, 320)));
        structures.add(structureFactory.createStructure(new Point(544, 320)));
        structures.add(structureFactory.createStructure(new Point(544, 352)));
        structures.add(structureFactory.createStructure(new Point(512, 352)));
        structures.add(structureFactory.createStructure(new Point(288, 224)));
        structures.add(structureFactory.createStructure(new Point(512, 416)));
        structures.add(structureFactory.createStructure(new Point(544, 416)));
        structures.add(structureFactory.createStructure(new Point(320, 224)));
        structures.add(structureFactory.createStructure(new Point(512, 384)));
        structures.add(structureFactory.createStructure(new Point(544, 384)));
        structures.add(structureFactory.createStructure(new Point(576, 288)));
        structures.add(structureFactory.createStructure(new Point(544, 448)));
        structures.add(structureFactory.createStructure(new Point(512, 448)));
        structures.add(structureFactory.createStructure(new Point(480, 448)));
        structures.add(structureFactory.createStructure(new Point(448, 448)));
        structures.add(structureFactory.createStructure(new Point(448, 480)));
        structures.add(structureFactory.createStructure(new Point(480, 480)));
        structures.add(structureFactory.createStructure(new Point(512, 480)));
        structures.add(structureFactory.createStructure(new Point(544, 480)));
        structures.add(structureFactory.createStructure(new Point(448, 512)));
        structures.add(structureFactory.createStructure(new Point(480, 512)));
        structures.add(structureFactory.createStructure(new Point(512, 512)));
        structures.add(structureFactory.createStructure(new Point(544, 512)));
        structures.add(structureFactory.createStructure(new Point(544, 544)));
        structures.add(structureFactory.createStructure(new Point(512, 544)));
        structures.add(structureFactory.createStructure(new Point(480, 544)));
        structures.add(structureFactory.createStructure(new Point(448, 544)));
        structures.add(structureFactory.createStructure(new Point(448, 576)));
        structures.add(structureFactory.createStructure(new Point(480, 576)));
        structures.add(structureFactory.createStructure(new Point(512, 576)));
        structures.add(structureFactory.createStructure(new Point(544, 576)));
        structures.add(structureFactory.createStructure(new Point(192, 256)));
        structures.add(structureFactory.createStructure(new Point(224, 256)));
        structures.add(structureFactory.createStructure(new Point(224, 224)));
        structures.add(structureFactory.createStructure(new Point(224, 192)));
        structures.add(structureFactory.createStructure(new Point(160, 416)));
        structures.add(structureFactory.createStructure(new Point(160, 384)));
        structures.add(structureFactory.createStructure(new Point(576, 256)));
        structures.add(structureFactory.createStructure(new Point(576, 224)));
        structures.add(structureFactory.createStructure(new Point(576, 192)));
        structures.add(structureFactory.createStructure(new Point(576, 160)));
        structures.add(structureFactory.createStructure(new Point(160, 480)));
        structures.add(structureFactory.createStructure(new Point(160, 448)));
        structures.add(structureFactory.createStructure(new Point(672, 192)));
        structures.add(structureFactory.createStructure(new Point(640, 192)));
        structures.add(structureFactory.createStructure(new Point(128, 512)));
        structures.add(structureFactory.createStructure(new Point(160, 512)));
        structures.add(structureFactory.createStructure(new Point(608, 192)));
        structures.add(structureFactory.createStructure(new Point(608, 160)));
        structures.add(structureFactory.createStructure(new Point(192, 448)));
        structures.add(structureFactory.createStructure(new Point(224, 448)));
        structures.add(structureFactory.createStructure(new Point(256, 448)));
        structures.add(structureFactory.createStructure(new Point(288, 448)));
        structures.add(structureFactory.createStructure(new Point(288, 480)));
        structures.add(structureFactory.createStructure(new Point(256, 480)));
        structures.add(structureFactory.createStructure(new Point(224, 480)));
        structures.add(structureFactory.createStructure(new Point(192, 480)));
        structures.add(structureFactory.createStructure(new Point(192, 512)));
        structures.add(structureFactory.createStructure(new Point(224, 512)));
        structures.add(structureFactory.createStructure(new Point(256, 512)));
        structures.add(structureFactory.createStructure(new Point(288, 512)));
        structures.add(structureFactory.createStructure(new Point(384, 64)));
        structures.add(structureFactory.createStructure(new Point(416, 64)));
        structures.add(structureFactory.createStructure(new Point(256, 96)));
        structures.add(structureFactory.createStructure(new Point(288, 96)));
        structures.add(structureFactory.createStructure(new Point(256, 128)));
        structures.add(structureFactory.createStructure(new Point(288, 128)));
        structures.add(structureFactory.createStructure(new Point(608, 256)));
        structures.add(structureFactory.createStructure(new Point(608, 128 )));
        structures.add(structureFactory.createStructure(new Point(576, 128)));
        structures.add(structureFactory.createStructure(new Point(544, 96)));
        structures.add(structureFactory.createStructure(new Point(512, 96)));

        structureFactory = new WallStructureFactory();

        structures.add(structureFactory.createStructure(new Point(0, 800)));
        structures.add(structureFactory.createStructure(new Point(32, 800)));
        structures.add(structureFactory.createStructure(new Point(32, 768)));
        structures.add(structureFactory.createStructure(new Point(0, 768)));
        structures.add(structureFactory.createStructure(new Point(800, 800)));
        structures.add(structureFactory.createStructure(new Point(768, 800)));
        structures.add(structureFactory.createStructure(new Point(768, 768)));
        structures.add(structureFactory.createStructure(new Point(800, 768)));
        structures.add(structureFactory.createStructure(new Point(768, 128)));
        structures.add(structureFactory.createStructure(new Point(800, 128)));
        structures.add(structureFactory.createStructure(new Point(0, 192)));
        structures.add(structureFactory.createStructure(new Point(32, 192)));
        structures.add(structureFactory.createStructure(new Point(256, 320)));
        structures.add(structureFactory.createStructure(new Point(256, 352)));
        structures.add(structureFactory.createStructure(new Point(384, 352)));
        structures.add(structureFactory.createStructure(new Point(384, 320)));

        structureFactory = new WaterStructureFactory();

        structures.add(structureFactory.createStructure(new Point(32, 320)));
        structures.add(structureFactory.createStructure(new Point(32, 352)));
        structures.add(structureFactory.createStructure(new Point(0, 352)));
        structures.add(structureFactory.createStructure(new Point(800, 416)));
        structures.add(structureFactory.createStructure(new Point(768, 416)));
        structures.add(structureFactory.createStructure(new Point(768, 384)));
        structures.add(structureFactory.createStructure(new Point(800, 384)));
        structures.add(structureFactory.createStructure(new Point(736, 416)));
        structures.add(structureFactory.createStructure(new Point(704, 416)));
        structures.add(structureFactory.createStructure(new Point(704, 384)));
        structures.add(structureFactory.createStructure(new Point(736, 384)));
        structures.add(structureFactory.createStructure(new Point(0, 320)));

        structureFactory = new GrassStructureFactory();

        structures.add(structureFactory.createStructure(new Point(64, 0)));
        structures.add(structureFactory.createStructure(new Point(64, 32)));
        structures.add(structureFactory.createStructure(new Point(96, 0)));
        structures.add(structureFactory.createStructure(new Point(96, 32)));
        structures.add(structureFactory.createStructure(new Point(128, 32)));
        structures.add(structureFactory.createStructure(new Point(160, 32)));
        structures.add(structureFactory.createStructure(new Point(160, 0)));
        structures.add(structureFactory.createStructure(new Point(128, 0)));
        structures.add(structureFactory.createStructure(new Point(64, 96)));
        structures.add(structureFactory.createStructure(new Point(96, 96)));
        structures.add(structureFactory.createStructure(new Point(96, 64)));
        structures.add(structureFactory.createStructure(new Point(64, 64)));
        structures.add(structureFactory.createStructure(new Point(0, 96)));
        structures.add(structureFactory.createStructure(new Point(32, 96)));
        structures.add(structureFactory.createStructure(new Point(32, 64)));
        structures.add(structureFactory.createStructure(new Point(0, 64)));
        structures.add(structureFactory.createStructure(new Point(0, 160)));
        structures.add(structureFactory.createStructure(new Point(32, 160)));
        structures.add(structureFactory.createStructure(new Point(32, 128)));
        structures.add(structureFactory.createStructure(new Point(0, 128)));
        structures.add(structureFactory.createStructure(new Point(704, 32)));
        structures.add(structureFactory.createStructure(new Point(736, 32)));
        structures.add(structureFactory.createStructure(new Point(736, 0)));
        structures.add(structureFactory.createStructure(new Point(704, 0)));
        structures.add(structureFactory.createStructure(new Point(768, 96)));
        structures.add(structureFactory.createStructure(new Point(800, 96)));
        structures.add(structureFactory.createStructure(new Point(800, 64)));
        structures.add(structureFactory.createStructure(new Point(768, 64)));
        structures.add(structureFactory.createStructure(new Point(0, 736)));
        structures.add(structureFactory.createStructure(new Point(32, 736)));
        structures.add(structureFactory.createStructure(new Point(32, 704)));
        structures.add(structureFactory.createStructure(new Point(0, 704)));
        structures.add(structureFactory.createStructure(new Point(64, 800)));
        structures.add(structureFactory.createStructure(new Point(96, 800)));
        structures.add(structureFactory.createStructure(new Point(96, 768)));
        structures.add(structureFactory.createStructure(new Point(64, 768)));
        structures.add(structureFactory.createStructure(new Point(768, 736)));
        structures.add(structureFactory.createStructure(new Point(800, 736)));
        structures.add(structureFactory.createStructure(new Point(800, 704)));
        structures.add(structureFactory.createStructure(new Point(768, 704)));
        structures.add(structureFactory.createStructure(new Point(768, 672)));
        structures.add(structureFactory.createStructure(new Point(800, 672)));
        structures.add(structureFactory.createStructure(new Point(800, 640)));
        structures.add(structureFactory.createStructure(new Point(768, 640)));
        structures.add(structureFactory.createStructure(new Point(704, 736)));
        structures.add(structureFactory.createStructure(new Point(736, 736)));
        structures.add(structureFactory.createStructure(new Point(736, 704)));
        structures.add(structureFactory.createStructure(new Point(704, 704)));
        structures.add(structureFactory.createStructure(new Point(640, 800)));
        structures.add(structureFactory.createStructure(new Point(672, 800)));
        structures.add(structureFactory.createStructure(new Point(672, 768)));
        structures.add(structureFactory.createStructure(new Point(640, 768)));
        structures.add(structureFactory.createStructure(new Point(704, 768)));
        structures.add(structureFactory.createStructure(new Point(736, 768)));
        structures.add(structureFactory.createStructure(new Point(736, 800)));
        structures.add(structureFactory.createStructure(new Point(704, 800)));

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
    public ArrayList<TankObserver> getTanksLeft() {
        return tanksLeft;
    }

    @Override
    public void setHP(int hp) {
        System.out.println(hp);
        labelHP.setText(Integer.toString(hp));
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
