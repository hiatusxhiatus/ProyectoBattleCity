package Scenarios;

import Classes.ImageCache;
import Factories.StructureFactory;
import Interfaces.IScenario;
import Interfaces.IStructure;
import Observers.BulletObserver;
import Observers.CardObserver;
import Observers.TankObserver;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Level implements IScenario {

    private ArrayList<IStructure> structures;
    private ArrayList<TankObserver> tanksLeft;
    private BulletObserver bulletCounter;
    private CardObserver cardCounter;
    private IStructure eagle;
    private StructureFactory structureFactory;
    private JPanel panelWindow ;
    private JPanel panelGame;
    private JLabel labelI;
    private JLabel labelHPIcon;
    private JLabel labelHP;
    private JLabel labelP;
    private JLabel labelFlag;
    private JLabel labelBullet;
    private JLabel labelCard;
    private JLabel labelPressEnter;

    public Level() {
        structures = new ArrayList<>();
        tanksLeft = new ArrayList<>();
        panelWindow = new JPanel();
        panelGame = new JPanel();
        labelI = new JLabel();
        labelHPIcon = new JLabel();
        labelHP = new JLabel();
        labelP = new JLabel();
        labelFlag = new JLabel();
        labelBullet = new JLabel();
        labelCard = new JLabel();
        labelPressEnter = new JLabel();

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

        //---- labelI ----
        labelI.setText("I");
        labelI.setFont(new Font("Pixel NES", Font.PLAIN, 40));
        labelI.setForeground(Color.black);
        returnPanelWindow().add(labelI);
        labelI.setBounds(905, 330, 30, 35);

        //---- labelHPIcon ----
        labelHPIcon.setIcon(ImageCache.loadImage("src/main/java/imagenes/hp.png"));
        labelHPIcon.setHorizontalAlignment(SwingConstants.CENTER);
        returnPanelWindow().add(labelHPIcon);
        labelHPIcon.setBounds(905, 370, 32, 32);
        //---- labelHP ----
        labelHP.setText("3");
        labelHP.setFont(new Font("Pixel NES", Font.PLAIN, 40));
        labelHP.setForeground(Color.black);
        returnPanelWindow().add(labelHP);
        labelHP.setBounds(940, 365, 35, 35);

        //---- labelP ----
        labelP.setText("P");
        labelP.setFont(new Font("Pixel NES", Font.PLAIN, 40));
        labelP.setForeground(Color.black);
        returnPanelWindow().add(labelP);
        labelP.setBounds(940, 330, 40, 35);

        //---- labelFlag ----
        labelFlag.setIcon(ImageCache.loadImage("src/main/java/imagenes/flag.png"));
        labelFlag.setHorizontalAlignment(SwingConstants.CENTER);
        returnPanelWindow().add(labelFlag);
        labelFlag.setBounds(905, 440, 64, 64);

        //---- labelBullet ----
        labelBullet.setIcon(ImageCache.loadImage("src/main/java/imagenes/bulletRIGHT.png"));
        labelBullet.setHorizontalAlignment(SwingConstants.CENTER);
        returnPanelWindow().add(labelBullet);
        labelBullet.setBounds(905, 780, 32, 32);

        //---- labelCard ----
        labelCard.setHorizontalAlignment(SwingConstants.CENTER);
        labelCard.setIcon(ImageCache.loadImage("src/main/java/imagenes/defaultCard.png"));
        panelWindow.add(labelCard);
        labelCard.setBounds(900, 740, 32, 32);

        //---- labelPressEnter ----
        labelPressEnter.setHorizontalAlignment(SwingConstants.CENTER);
        labelPressEnter.setIcon(ImageCache.loadImage("src/main/java/imagenes/pressEnter.gif"));
        panelGame.add(labelPressEnter);
        labelPressEnter.setBounds(225, 670, 385, 65);
        panelGame.setComponentZOrder(labelPressEnter, 0);
        labelPressEnter.setVisible(false);

    }

    public ArrayList<IStructure> returnStructures() {
        return structures;
    }

    public ArrayList<TankObserver> returnTanksLeft() {
        return tanksLeft;
    }

    public BulletObserver returnBulletCounter() {
        return bulletCounter;
    }

    public void setBulletCounter(BulletObserver bulletCounter) {
        this.bulletCounter = bulletCounter;
    }

    public CardObserver returnCardCounter() {
        return cardCounter;
    }

    public void setCardCounter(CardObserver cardCounter) {
        this.cardCounter = cardCounter;
    }

    public IStructure returnEagle() {
        return eagle;
    }

    public void setEagle(IStructure eagle) {
        this.eagle = eagle;
    }

    public StructureFactory returnStructureFactory() {
        return structureFactory;
    }

    public void setStructureFactory(StructureFactory structureFactory) {
        this.structureFactory = structureFactory;
    }

    public JPanel returnPanelWindow() {
        return panelWindow;
    }

    public JPanel returnPanelGame() {
        return panelGame;
    }

    @Override
    public BulletObserver getBulletCounter() {
        return this.bulletCounter;
    }

    @Override
    public CardObserver getCardCounter() {
        return this.cardCounter;
    }

    @Override
    public ArrayList<TankObserver> getTanksLeft() {
        return this.tanksLeft;
    }

    @Override
    public void setHP(int hp) {
        this.labelHP.setText(Integer.toString(hp));
    }

    @Override
    public JPanel getPanel() {
        return this.panelWindow;
    }

    @Override
    public JPanel getPanelGame() {
        return this.panelGame;
    }

    @Override
    public ArrayList<IStructure> getStructures() {
        return this.structures;
    }

    @Override
    public IStructure getEagle() {
        return this.eagle;
    }

    @Override
    public JLabel getLabelPressEnter() {
        return labelPressEnter;
    }

}
