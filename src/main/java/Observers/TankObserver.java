package Observers;

import Classes.ImageCache;
import Interfaces.IObserver;
import javax.swing.*;
import java.awt.*;

public class TankObserver implements IObserver {

    private Point location;
    private JLabel label;

    public TankObserver(Point location) {
        this.label = new JLabel();
        this.location = location;
        setupLabel();
    }

    public void setupLabel() {

        label.setIcon(ImageCache.loadImage("src/main/java/imagenes/tank.png"));
        label.setBounds(location.x, location.y, 32, 32);
        label.setLocation(location);

    }

    @Override
    public void update() {
        label.setVisible(false);
    }

    public JLabel getLabel() {
        return label;
    }
}
