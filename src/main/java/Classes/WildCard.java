package Classes;

import Enums.CardType;
import javax.swing.*;
import java.awt.*;

public class WildCard {

    private JLabel label;
    private Point location;
    private CardType cardType;
    private boolean used;

    public WildCard(Point location, CardType cardType) {
        this.location = location;
        this.cardType = cardType;
        this.used = false;
        this.label = new JLabel();
        setUpLabel();
    }

    public void setUpLabel() {

        switch (cardType) {
            case Clock -> label.setIcon(ImageCache.loadImage("resources/Images/clockCard.gif"));
            case Star -> label.setIcon(ImageCache.loadImage("resources/Images/starCard.gif"));
            case Helmet -> label.setIcon(ImageCache.loadImage("resources/Images/helmetCard.gif"));
            case Shovel -> label.setIcon(ImageCache.loadImage("resources/Images/shovelCard.gif"));
            case Bomb -> label.setIcon(ImageCache.loadImage("resources/Images/bombCard.gif"));
            case Tank -> label.setIcon(ImageCache.loadImage("resources/Images/tankCard.gif"));
        }

        label.setBounds(location.x, location.y, 64, 64);
        label.setLocation(location);

        Thread wildCard = new Thread(() -> {

            try {
                Thread.sleep(13000);
                label.setVisible(false);
                used = true;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        wildCard.start();


    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public JLabel getLabel() {
        return label;
    }

    public Point getLocation() {
        return location;
    }

    public CardType getCardType() {
        return cardType;
    }

}
