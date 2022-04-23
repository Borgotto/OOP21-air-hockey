package utils;

import javax.swing.*;

public class JPanelLoader {
    
    public static void load(JFrame frame, JPanel panel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.setTitle(panel.getName());
        frame.revalidate();
        frame.repaint();
    }    
    
}
