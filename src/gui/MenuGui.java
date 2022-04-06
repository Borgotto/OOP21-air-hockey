package gui;

import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;


public class MenuGui extends JFrame {
    private static final long serialVersionUID = 1L;

    public MenuGui(int size) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(9*size, 16*size);
        this.setTitle("Air Hockey");
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.3;
        c.weighty = 0.3;
        panel.add(new JLabel("inserire immagine logo qua"), c);
        c.gridy = 1;
        panel.add(new JButton("New game"), c);
        c.gridy = 2;
        panel.add(new JButton("Continue"), c);
        panel.getComponent(panel.getComponentCount()-1).setEnabled(false);
        c.gridy = 3;
        panel.add(new JButton("Settings"), c);
        c.gridy = 4;
        panel.add(new JButton("Credits"), c);
        c.gridy = 5;
        panel.add(new JButton("Quit"), c);        
        
        this.getContentPane().add(panel);
        this.setVisible(true);
    }
}
