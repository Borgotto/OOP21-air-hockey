package gui;

import utils.JPanelLoader;

import javax.swing.*;

public class GUI extends JFrame {
    private static final long serialVersionUID = 1L;
    
    public GUI(Integer size) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(3*size, 4*size);

        this.pack();
        
        JPanelLoader.load(this, new MenuPanel());

        this.setResizable(false);
               
        this.setVisible(true);
    }
}
