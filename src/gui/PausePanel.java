package gui;

import utils.JPanelLoader;

import javax.swing.*;
import java.awt.*;

public class PausePanel extends AbstractGridBagLayoutJPanel {
    private static final long serialVersionUID = 1L;

    public PausePanel() {
        super("Air Hockey - Pause");
        
        this.setBackground(Color.BLACK);
        c.gridx = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;

        c.gridy = 1;
        c.anchor = GridBagConstraints.SOUTH;
        JButton resume = new JButton("Resume");
        resume.addActionListener(e -> {
            JPanelLoader.load(JPanelLoader.getParentFrame(this), new GamePanel());
        });
        this.add(resume, c);

        c.gridy = 2;
        c.anchor = GridBagConstraints.CENTER;
        JButton restart = new JButton("Restart");
        this.add(restart, c);

        c.gridy = 3;
        c.anchor = GridBagConstraints.NORTH;
        JButton exit = new JButton("Exit");
        this.add(exit, c);
    }
}
