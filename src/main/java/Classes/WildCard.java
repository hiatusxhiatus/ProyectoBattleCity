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
            case Clock -> label.setIcon(ImageCache.loadImage("src/main/java/imagenes/clockCard.gif"));
            case Star -> label.setIcon(ImageCache.loadImage("src/main/java/imagenes/starCard.gif"));
            case Helmet -> label.setIcon(ImageCache.loadImage("src/main/java/imagenes/helmetCard.gif"));
            case Shovel -> label.setIcon(ImageCache.loadImage("src/main/java/imagenes/shovelCard.gif"));
            case Bomb -> label.setIcon(ImageCache.loadImage("src/main/java/imagenes/bombCard.gif"));
            case Tank -> label.setIcon(ImageCache.loadImage("src/main/java/imagenes/tankCard.gif"));
        }

        label.setBounds(location.x, location.y, 64, 64);
        label.setLocation(location);

        Thread wildCard = new Thread(() -> {

            try {
                Thread.sleep(10000);
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
