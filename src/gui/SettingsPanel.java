package gui;

import logics.Difficulty;
import logics.Settings;
import logics.Theme;
import utils.JComponentLoader;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SettingsPanel extends AbstractGridBagLayoutJPanel {
    private static final long serialVersionUID = -4632838315051894445L;
    final Theme[] themeArray = Theme.values();
    final Difficulty[] difficultyArray = logics.Difficulty.values();
    
    public SettingsPanel() {
        super("Air Hockey - Settings", new Dimension(GUI.getMinScreenSize(), GUI.getMinScreenSize()*3/4));
        
        // Load Settings obj
        Settings settings = new Settings().load();
        // Username JPanel
        JPanel p1 = new JPanel(new FlowLayout());
        c.gridx = 0;
        c.gridy = 0;
        p1.add(new JLabel("Username:"), c);
        c.gridx = 1;
        c.gridy = 0;
        JTextField t1 = new JTextField(settings.getUsername(), 10);
        p1.add(t1, c);
        this.addComponent(p1, 0, 0);
        
        // Theme JPanel
        JPanel p2 = new JPanel(new FlowLayout());
        c.gridx = 0;
        c.gridy = 0;
        p2.add(new JLabel("Theme:"), c);
        c.gridx = 1;
        c.gridy = 0;
        JComboBox<Theme> t2 = new JComboBox<>(themeArray);
        t2.setSelectedItem(settings.getTheme());
        p2.add(t2, c);
        this.addComponent(p2, 0, 1);
        
        // maxScore JPanel
        JPanel p3 = new JPanel(new FlowLayout());
        c.gridx = 0;
        c.gridy = 0;
        p3.add(new JLabel("Max score:"), c);
        c.gridx = 1;
        c.gridy = 0;
        JTextField t3 = new JTextField(String.valueOf(settings.getMaxScore()), 3);
        p3.add(t3, c);
        this.addComponent(p3, 0, 2);
        
        // Difficulty JPanel
        JPanel p4 = new JPanel(new FlowLayout());
        c.gridx = 0;
        c.gridy = 0;
        p4.add(new JLabel("Difficulty:"), c);
        c.gridx = 1;
        c.gridy = 0;
        JComboBox<Difficulty> t4 = new JComboBox<>(difficultyArray);
        t4.setSelectedItem(settings.getDifficulty());
        p4.add(t4, c);
        this.addComponent(p4, 0, 3);
        
        // Save and Back to Menu buttons
        JPanel p5 = new JPanel(new FlowLayout());
        c.gridx = 0;
        c.gridy = 0;
        JButton b1 = new JButton("Save settings");
        b1.addActionListener(e -> {
        	settings.setUsername(t1.getText());
        	settings.setTheme((Theme)t2.getSelectedItem());
        	settings.setMaxScore(Integer.parseInt(t3.getText()));
        	settings.setDifficulty((Difficulty)t4.getSelectedItem());
	        try {
	        	settings.save();
	        } catch (IOException e1) {
	        	e1.printStackTrace();
	        }
        });
        p5.add(b1, c);
        c.gridx = 1;
        c.gridy = 0;
        JButton b2 = new JButton("Reset settings");
        b2.addActionListener(e -> {
            Settings resetSettings = new Settings();
            try {
				resetSettings.save();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            JComponentLoader.load(parentFrame, new SettingsPanel());
        });
        p5.add(b2, c);
        c.gridx = 2;
        c.gridy = 0;
        JButton b3 = new JButton("Go back");
        b3.addActionListener(e -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            JComponentLoader.load(parentFrame, new MenuPanel());
        });
        p5.add(b3, c);
        this.addComponent(p5, 0, 4);
    }

    /**
     * Adds a component to a component that uses a GridBagLayout.
     * @param component The component to add.
     * @param x The row index.
     * @param y The column index.
     */
    private void addComponent(JComponent component, int x, int y) {
    	this.c.gridx = x;
    	this.c.gridy = y;
    	this.add(component, c);
    }
}