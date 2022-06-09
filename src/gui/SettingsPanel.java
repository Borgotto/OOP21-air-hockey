package gui;

import utils.JComponentLoader;
import javax.swing.*;
import logics.Difficulty;
import java.awt.*;

public class SettingsPanel extends AbstractGridBagLayoutJComponent {
    private static final long serialVersionUID = 1L;
    
    final Theme themeArray[] = Theme.values();
    final Difficulty difficultyArray[] = logics.Difficulty.values();
    
    public SettingsPanel() {
        super("Air Hockey - Settings", new Dimension(GUI.getMinScreenSize()/2, GUI.getMinScreenSize()));
        
        /*
         * User name panel
         */
        
        JPanel p1 = new JPanel(new FlowLayout());
        
        c.gridx = 0;
        c.gridy = 0;
        
        JLabel l1 = new JLabel("Username:");
        p1.add(l1, c);
        
        c.gridx = 1;
        c.gridy = 0;
        
        JTextField t1 = new JTextField(10);
        t1.addActionListener(e -> {

        });
        p1.add(t1, c);

        addComponent(p1, 0, 0);
        
        /*
         * Style panel
         */
        
        JPanel p2 = new JPanel(new FlowLayout());
        
        c.gridx = 0;
        c.gridy = 0;
        
        JLabel l2 = new JLabel("Theme:");
        p2.add(l2, c);
        
        c.gridx = 1;
        c.gridy = 0;
        
        JComboBox<Theme> t2 = new JComboBox<Theme>(themeArray);
        t2.addActionListener(e -> {
        	
        });
        p2.add(t2, c);
        
        addComponent(p2, 0, 1);
        
        /*
         * Score panel
         */
        
        JPanel p3 = new JPanel(new FlowLayout());
        
        c.gridx = 0;
        c.gridy = 0;
        
        JLabel l3 = new JLabel("Max score:");
        p3.add(l3, c);
        
        c.gridx = 1;
        c.gridy = 0;
        
        JTextField t3 = new JTextField(3);
        t3.addActionListener(e -> {
        	
        });
        p3.add(t3, c);
        
        addComponent(p3, 0, 2);
        
        /*
         * Difficulty panel
         */
        
        JPanel p4 = new JPanel(new FlowLayout());
        
        c.gridx = 0;
        c.gridy = 0;
        
        JLabel l4 = new JLabel("Difficulty:");
        p4.add(l4, c);
        
        c.gridx = 1;
        c.gridy = 0;
        
        JComboBox<Difficulty> t4 = new JComboBox<Difficulty>(difficultyArray);
        t4.addActionListener(e -> {
        	
        });
        p4.add(t4, c);
        
        addComponent(p4, 0, 3);
        
        /*
         * Last buttons of the window
         */
        
        JPanel p5 = new JPanel(new FlowLayout());
        
        c.gridx = 0;
        c.gridy = 0;
        
        JButton b1 = new JButton("Save settings");
        b1.addActionListener(e -> {
        	
        });
        p5.add(b1, c);
        
        c.gridx = 1;
        c.gridy = 0;
        
        JButton b3 = new JButton("Go back");
        b3.addActionListener(e -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            JComponentLoader.load(parentFrame, new MenuPanel());
        });
        p5.add(b3, c);
        
        addComponent(p5, 0, 4);
    }
    
    public void addComponent(JComponent component, int x, int y) {
    	c.gridx = x;
    	c.gridy = y;
    	this.add(component, c);
    }
}