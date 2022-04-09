package gui;

import javax.swing.*;

public class GUI extends JFrame {
    private static final long serialVersionUID = 1L;
    
    public GUI(int size) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(9*size, 16*size);
        
        JPanelLoader.load(this, new MenuPanel());
               
        this.setVisible(true);
    }
}
