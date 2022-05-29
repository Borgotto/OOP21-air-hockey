package gui;

import utils.JPanelLoader;

import javax.swing.*;

public class GUI extends JFrame {
    private static final long serialVersionUID = 1L;
    
    public GUI(Integer size) {
        var menuPanel = new MenuPanel();
        JPanelLoader.load(this, menuPanel);
        this.pack();
        menuPanel.setImages();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(3*size, 4*size);
        this.setResizable(false);
        this.setVisible(true);
    }
}
