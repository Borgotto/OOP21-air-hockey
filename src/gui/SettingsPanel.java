package gui;

import utils.JPanelLoader;

import javax.swing.*;


public class SettingsPanel extends AbstractGridBagLayoutJPanel {
    private static final long serialVersionUID = 1L;
    
    public SettingsPanel() {
        super("Air Hockey - Settings");
        
        var b1 = new JButton("Go back");
        b1.addActionListener(e -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            JPanelLoader.load(parentFrame, new MenuPanel());
        });
        this.add(b1,c);
    }
}