package gui;

import logics.GameState;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PausePanel extends AbstractGridBagLayoutJComponent {
    private final GameState game;

    public PausePanel(GameState game) {
        super("Air Hockey - Pause");
        this.game = game;

        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.SOUTH;
        JButton resume = new JButton("Resume");
        resume.addActionListener(e -> {
            SwingUtilities.getWindowAncestor(this).dispose();
        });
        this.add(resume, c);
        c.gridy = 2;
        c.anchor = GridBagConstraints.CENTER;
        JButton exit = new JButton("Quit");
        exit.addActionListener(e -> {
            int answer = JOptionPane.showConfirmDialog(null, "Confirm exit?", "Exit?", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        this.add(exit, c);
        c.gridy = 3;
        c.anchor = GridBagConstraints.NORTH;
        JButton saveAndQuit = new JButton("Save and quit");
        saveAndQuit.addActionListener(e -> {
            try {
                this.game.save();
            } catch (IOException ex) {
                new ExceptionPanel(ex);
            }
            Runtime.getRuntime().exit(0);
        });
        this.add(saveAndQuit, c);
    }
}
