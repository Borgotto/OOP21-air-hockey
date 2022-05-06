package gui;

import javax.swing.*;

import utils.JPanelLoader;

public class GUI extends JFrame {
    private static final long serialVersionUID = 1L;
    
    public GUI(Integer size) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(3*size, 4*size);
        
        JPanelLoader.load(this, new MenuPanel());

        this.setResizable(false);
               
        this.setVisible(true);
    }
}
