package gui;

import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;


public class MenuGui extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private List<JButton> buttons = new ArrayList<>();

    public MenuGui(int size) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100*size, 100*size);
        this.setTitle("Air Hockey");
        
        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        this.getContentPane().add(panel);
        
        buttons.add(new JButton("New game"));
        buttons.add(new JButton("Continue"));
        buttons.get(buttons.size()-1).setEnabled(false);
        buttons.add(new JButton("Settings"));
        buttons.add(new JButton("Credits"));
        buttons.add(new JButton("Quit"));
        
        buttons.forEach(button -> {
            //button.setBorder(BorderFactory.createEmptyBorder(25, 25, 20, 20));
            //button.setAlignmentX(Component.CENTER_ALIGNMENT);
            //button.setAlignmentY(Component.CENTER_ALIGNMENT);
            panel.add(button);
        });
        
        this.setVisible(true);
    }
}
