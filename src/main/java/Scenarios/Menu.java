
package Scenarios;

import Interfaces.IScenario;
import Interfaces.IStructure;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.*;

public class Menu implements IScenario {

    public Menu() {
        initScenario();
    }

    @Override
    public void initScenario() {

        panel = new JPanel();
        lblTitle = new JLabel();
        lblPoints = new JLabel();
        lblPlayer1 = new JLabel();
        lblCopyright = new JLabel();
        lblTank = new JLabel();
        lblITCR = new JLabel();
        lblHiatusChomin = new JLabel();
        lblpressEnter = new JLabel();

        panel.setBackground(Color.black);
        panel.setForeground(Color.white);
        panel.setPreferredSize(new Dimension(1152, 720));
        panel.setLayout(null);

        //---- lblTitle ----
        lblTitle.setIcon(new ImageIcon("src/main/java/imagenes/TITLE.png"));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblTitle);
        lblTitle.setBounds(0, 110, 1025, 310);

        //---- lblPoints ----
        lblPoints.setText("I -    00 HI- 20000");
        lblPoints.setFont(new Font("Pixel NES", Font.PLAIN, 42));
        lblPoints.setForeground(Color.white);
        panel.add(lblPoints);
        lblPoints.setBounds(50, 30, 840, 55);

        //---- lblPlayer1 ----
        lblPlayer1.setText("1 player");
        lblPlayer1.setFont(new Font("Pixel NES", Font.PLAIN, 42));
        lblPlayer1.setForeground(Color.white);
        lblPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblPlayer1);
        lblPlayer1.setBounds(395, 470, 250, 60);

        //---- lblCopyright ----
        lblCopyright.setFont(new Font("Pixel NES", Font.PLAIN, 42));
        lblCopyright.setForeground(Color.white);
        lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);
        lblCopyright.setText("all rights reserved");
        panel.add(lblCopyright);
        lblCopyright.setBounds(0, 765, 1025, 60);

        //---- lblTank ----
        lblTank.setIcon(new ImageIcon("src/main/java/imagenes/yellowTankRIGHT.png"));
        panel.add(lblTank);
        lblTank.setBounds(325, 470, 56, 56);

        //---- lblITCR ----
        lblITCR.setFont(new Font("Pixel NES", Font.PLAIN, 42));
        lblITCR.setForeground(Color.red);
        lblITCR.setHorizontalAlignment(SwingConstants.CENTER);
        lblITCR.setIcon(null);
        lblITCR.setText("ITCR");
        panel.add(lblITCR);
        lblITCR.setBounds(0, 655, 1025, 55);

        //---- lblHiatusChomin ----
        lblHiatusChomin.setFont(new Font("Pixel NES", Font.PLAIN, 42));
        lblHiatusChomin.setForeground(Color.white);
        lblHiatusChomin.setHorizontalAlignment(SwingConstants.CENTER);
        lblHiatusChomin.setText("2023 hiatus chomin ltd");
        panel.add(lblHiatusChomin);
        lblHiatusChomin.setBounds(0, 710, 1025, 60);

        //---- lblpressEnter ----
        lblpressEnter.setHorizontalAlignment(SwingConstants.CENTER);
        lblpressEnter.setIcon(new ImageIcon("src/main/java/imagenes/pressEnterBlack.gif"));
        panel.add(lblpressEnter);
        lblpressEnter.setBounds(0, 550, 1030, 87);


        // compute preferred size
        Dimension preferredSize = new Dimension();
        for(int i = 0; i < panel.getComponentCount(); i++) {
            Rectangle bounds = panel.getComponent(i).getBounds();
            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
        }
        Insets insets = panel.getInsets();
        panel.setVisible(true);
        preferredSize.width += insets.right;
        preferredSize.height += insets.bottom;
        panel.setMinimumSize(preferredSize);
        panel.setPreferredSize(preferredSize);

    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public JPanel getPanelGame() {
        return null;
    }

    @Override
    public ArrayList<IStructure> getStructures() {
        return null;
    }

    @Override
    public IStructure getEagle() {
        return null;
    }

    private JPanel panel;
    private JLabel lblTitle;
    private JLabel lblPoints;
    private JLabel lblPlayer1;
    private JLabel lblCopyright;
    private JLabel lblTank;
    private JLabel lblITCR;
    private JLabel lblHiatusChomin;
    private JLabel lblpressEnter;

}
