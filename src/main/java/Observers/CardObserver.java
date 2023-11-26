package Observers;

import Classes.ImageCache;
import Interfaces.IObserver;

import javax.swing.*;
import java.awt.*;

public class CardObserver implements IObserver {

    private Point location;
    private JLabel label;

    public CardObserver(Point location) {
        this.label = new JLabel();
        this.location = location;
        setupLabel();
    }

    public void setupLabel() {

        //label.setIcon(ImageCache.loadImage("src/main/java/imagenes/defaultCard.png"));
        label.setBounds(location.x, location.y, 64, 64);
        label.setLocation(location);

    }

    @Override
    public void update() {
        label.setVisible(true);
    }

    public JLabel getLabel() {
        return label;
    }
}
