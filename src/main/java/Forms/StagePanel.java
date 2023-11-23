
package Forms;

import java.awt.*;
import javax.swing.*;

public class StagePanel extends JPanel {
    
    public StagePanel() {
        initComponents();
    }

    private void initComponents() {
        label1 = new JLabel();

        //======== this ========
        setBackground(new Color(0x999999));
        setLayout(null);

        //---- label1 ----
        label1.setText("Stage #");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Pixel NES", Font.PLAIN, 36));
        label1.setForeground(Color.black);
        add(label1);
        label1.setBounds(0, 370, 1030, 95);

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
    }
    
    private JLabel label1;



}
