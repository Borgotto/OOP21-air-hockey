package gui;

import java.awt.*;
import javax.swing.*;

import logics.GameState;

public class GamePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    
    private final GameState game;
    
    public GamePanel() {
        this.setName("Air Hockey");
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        var b1 = new JButton("lessgo");
        b1.addActionListener(e -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            JPanelLoader.load(parentFrame, new MenuPanel());
        });
        this.add(b1,c);
        
        
        this.game = new GameState();        
    }
}