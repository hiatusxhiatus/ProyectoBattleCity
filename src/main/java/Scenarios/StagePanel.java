package Scenarios;

import javax.swing.*;
import java.awt.*;

public class StagePanel {

    private JPanel stagePanel;

    public StagePanel(int levelNumber){

        JLabel label1 = new JLabel();
        this.stagePanel = new JPanel();

        this.stagePanel.setBackground(new Color(0x999999));
        this.stagePanel.setLayout(null);

        label1.setText("Stage " + levelNumber);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Pixel NES", Font.PLAIN, 36));
        label1.setForeground(Color.black);
        this.stagePanel.add(label1);
        label1.setBounds(0, 370, 1030, 95);

        Dimension preferredSize = new Dimension();
        for(int i = 0; i < this.stagePanel.getComponentCount(); i++) {
            Rectangle bounds = this.stagePanel.getComponent(i).getBounds();
            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
        }

        Insets insets = this.stagePanel.getInsets();
        preferredSize.width += insets.right;
        preferredSize.height += insets.bottom;
        this.stagePanel.setMinimumSize(preferredSize);
        this.stagePanel.setPreferredSize(preferredSize);

    }

    public JPanel getStagePanel() {
        return stagePanel;
    }

}


