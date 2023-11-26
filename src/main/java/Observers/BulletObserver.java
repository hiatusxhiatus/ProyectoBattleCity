package Observers;


import Interfaces.IObserver;
import javax.swing.*;
import java.awt.*;

public class BulletObserver implements IObserver {

    private Point location;
    private int bulletCounter;
    private JLabel label;

    public BulletObserver(Point location) {
        this.label = new JLabel();
        this.bulletCounter = 0;
        this.location = location;
        setupLabel();
    }

    public void setupLabel() {

        label.setText("0");
        label.setFont(new Font("Pixel NES", Font.PLAIN, 26));
        label.setForeground(Color.black);
        label.setText(Integer.toString(bulletCounter));
        label.setBounds(location.x, location.y, 32, 32);
        label.setLocation(location);

    }

    @Override
    public void update() {
        label.setText(Integer.toString(++bulletCounter));
    }

    public JLabel getLabel() {
        return label;
    }
}
