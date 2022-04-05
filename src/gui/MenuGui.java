package gui;

import java.awt.*;
import javax.swing.*; 


public class MenuGui extends JFrame{
    private static final long serialVersionUID = 1L;

    public MenuGui(int size) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100*size, 100*size);
        
        JPanel grid = new JPanel(new GridLayout(size,size));
        this.getContentPane().add(BorderLayout.CENTER,grid);
        
       
        
        this.setVisible(true);
    }
}
