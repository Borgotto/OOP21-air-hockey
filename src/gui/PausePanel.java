package gui;

import utils.JPanelLoader;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

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
            SwingUtilities.getWindowAncestor(this).dispose();
        });
        this.add(resume, c);

        c.gridy = 2;
        c.anchor = GridBagConstraints.CENTER;
        JButton restart = new JButton("Restart");
        restart.addActionListener(e -> {
            JFrame parentFrame = JPanelLoader.getParentFrame(this);

            try {
                JPanelLoader.load(parentFrame, new GamePanel());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(parentFrame, ex.getMessage(), "Error while creating GamePanel", JOptionPane.ERROR_MESSAGE);
            }
        });
        this.add(restart, c);

        c.gridy = 3;
        c.anchor = GridBagConstraints.NORTH;
        JButton exit = new JButton("Exit");
        exit.addActionListener(e -> {
            int answer = JOptionPane.showConfirmDialog(null, "Confirm exit?", "Exit?", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                frame.dispose();
            }
        });
        this.add(exit, c);
    }
}
