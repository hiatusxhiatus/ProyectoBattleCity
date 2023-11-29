package Classes;

import Enums.Orientation;

import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

public class Bullet {

    private Orientation orientation;
    private JLabel label;
    private Point location;

    public Bullet(Orientation orientation, Point location) {
        this.orientation = orientation;
        this.location = location;
        this.label = new JLabel();
        setUpLabel();
    }

    public void setUpLabel() {
        int x = location.x;
        int y = location.y;

        ImageIcon bulletImage = null;
        switch (orientation) {
            case Up:
                bulletImage = ImageCache.loadImage("resources/Images/bulletUP.png");
                location = new Point(x + 18, y - 16);
                label.setBounds(x, y, 16, 16);
                break;
            case Down:
                bulletImage = ImageCache.loadImage("resources/Images/bulletDOWN.png");
                location = new Point(x + 18, y + 52);
                label.setBounds(x, y, 16, 16);
                break;
            case Left:
                bulletImage = ImageCache.loadImage("resources/Images/bulletLEFT.png");
                location = new Point(x - 18, y + 19);
                label.setBounds(x, y, 16, 16);
                break;
            case Right:
                bulletImage = ImageCache.loadImage("resources/Images/bulletRIGHT.png");
                location = new Point(x + 52, y + 19);
                label.setBounds(x, y, 16, 16);
                break;
        }

        label.setIcon(bulletImage);
        label.setBounds(location.x, location.y, 16, 16);
    }

    public void bulletHit() throws InterruptedException {

        label.setIcon(new ImageIcon("resources/Images/bulletHit.gif"));

        switch (orientation) {
            case Up, Down -> label.setBounds(location.x-25, location.y-32, 64, 64);
            case Left, Right -> label.setBounds(location.x-32, location.y-25, 64, 64);
        }

        sleep(150);

    }

    //getters and setters

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(int x, int y) {
        this.location = new Point(x, y);
        this.label.setLocation(x, y);
    }
}
