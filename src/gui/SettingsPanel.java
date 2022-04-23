package gui;

import java.awt.*;
import javax.swing.*;

import utils.JPanelLoader;


public class SettingsPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    
    public SettingsPanel() {
        this.setName("Air Hockey");
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        var b1 = new JButton("Go back");
        b1.addActionListener(e -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            JPanelLoader.load(parentFrame, new MenuPanel());
        });
        this.add(b1,c);
    }
}