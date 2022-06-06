package utils;

import javax.swing.*;

public class JComponentLoader {

    public static JFrame getParentFrame(JComponent component) {
        return (JFrame) SwingUtilities.getWindowAncestor(component);
    }
    
    public static void load(JFrame frame, JComponent component) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(component);
        frame.setTitle(component.getName());
        frame.revalidate();
        frame.repaint();
        frame.pack();
    }    
    
}
