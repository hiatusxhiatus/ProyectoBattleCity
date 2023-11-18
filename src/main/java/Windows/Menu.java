package Windows;

import java.awt.*;
import javax.swing.*;

public class Menu extends JPanel {
    public Menu() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Pepe Montero Sanchez
        this2 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label5 = new JLabel();
        label7 = new JLabel();
        label6 = new JLabel();
        label8 = new JLabel();

        //======== this2 ========
        {
            this2.setBackground(Color.black);
            this2.setForeground(Color.white);
            this2.setPreferredSize(new Dimension(1152, 720));
            this2.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder
            (0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER,javax.swing.border
            .TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
            .Color.red),this2. getBorder()));this2. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void
            propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException()
            ;}});
            this2.setLayout(null);

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/imagenes/TITLE.png")));
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            this2.add(label1);
            label1.setBounds(0, 110, 1030, 310);

            //---- label2 ----
            label2.setText("I -    00 HI- 20000");
            label2.setFont(new Font("Pixel NES", Font.PLAIN, 42));
            label2.setForeground(Color.white);
            this2.add(label2);
            label2.setBounds(50, 30, 840, 55);

            //---- label3 ----
            label3.setText("1 player");
            label3.setFont(new Font("Pixel NES", Font.PLAIN, 42));
            label3.setForeground(Color.white);
            label3.setHorizontalAlignment(SwingConstants.CENTER);
            this2.add(label3);
            label3.setBounds(395, 470, 250, 60);

            //---- label5 ----
            label5.setFont(new Font("Pixel NES", Font.PLAIN, 42));
            label5.setForeground(Color.white);
            label5.setHorizontalAlignment(SwingConstants.CENTER);
            label5.setText("all rights reserved");
            this2.add(label5);
            label5.setBounds(0, 800, 1030, 60);

            //---- label7 ----
            label7.setIcon(new ImageIcon(getClass().getResource("/imagenes/yellowTankRIGHT.png")));
            this2.add(label7);
            label7.setBounds(325, 470, 56, 56);

            //---- label6 ----
            label6.setFont(new Font("Pixel NES", Font.PLAIN, 42));
            label6.setForeground(Color.red);
            label6.setHorizontalAlignment(SwingConstants.CENTER);
            label6.setIcon(null);
            label6.setText("ITCR");
            this2.add(label6);
            label6.setBounds(0, 685, 1030, 55);

            //---- label8 ----
            label8.setFont(new Font("Pixel NES", Font.PLAIN, 42));
            label8.setForeground(Color.white);
            label8.setHorizontalAlignment(SwingConstants.CENTER);
            label8.setText("2023 hiatus chomin ltd");
            this2.add(label8);
            label8.setBounds(0, 745, 1030, 60);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < this2.getComponentCount(); i++) {
                    Rectangle bounds = this2.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = this2.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                this2.setMinimumSize(preferredSize);
                this2.setPreferredSize(preferredSize);
            }
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Pepe Montero Sanchez
    private JPanel this2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label5;
    private JLabel label7;
    private JLabel label6;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
