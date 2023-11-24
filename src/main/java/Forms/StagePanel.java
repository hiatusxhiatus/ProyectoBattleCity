/*
 * Created by JFormDesigner on Thu Nov 23 14:24:07 CST 2023
 */

package Forms;

import java.awt.*;
import javax.swing.*;

/**
 * @author danny
 */
public class StagePanel extends JPanel {
    public StagePanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Pepe Montero Sanchez
        label1 = new JLabel();
        lblpressEnter = new JLabel();

        //======== this ========
        setBackground(new Color(0x999999));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
        , 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
        , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
         getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(null);

        //---- label1 ----
        label1.setText("Press enter to continue");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Pixel NES", Font.PLAIN, 20));
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(0, 370, 1030, 95);

        //---- lblpressEnter ----
        lblpressEnter.setHorizontalAlignment(SwingConstants.CENTER);
        lblpressEnter.setIcon(new ImageIcon(getClass().getResource("/imagenes/pressEnterBlack.gif")));
        add(lblpressEnter);
        lblpressEnter.setBounds(0, 530, 1030, 87);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Pepe Montero Sanchez
    private JLabel label1;
    private JLabel lblpressEnter;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
