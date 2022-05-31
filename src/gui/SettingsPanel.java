package gui;

import utils.JPanelLoader;

import javax.swing.*;
import java.awt.*;


public class SettingsPanel extends AbstractGridBagLayoutJPanel {
    private static final long serialVersionUID = 1L;
    
    public SettingsPanel() {
        super("Air Hockey - Settings", new Dimension(GUI.getMinScreenSize()/2, GUI.getMinScreenSize()));

        c.gridx = 0;
        c.gridy = 3;

        var b1 = new JButton("Save settings");
        b1.addActionListener(e -> {

        });
        this.add(b1,c);

        c.gridx = 1;
        c.gridy = 3;

        var b2 = new JButton("Go back");
        b2.addActionListener(e -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            JPanelLoader.load(parentFrame, new MenuPanel());
        });
        this.add(b2,c);
    }
}