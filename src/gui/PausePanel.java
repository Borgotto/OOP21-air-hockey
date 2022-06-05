package gui;

import logics.GameState;
import utils.ObjectSerializer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PausePanel extends AbstractGridBagLayoutJPanel {
    private static final long serialVersionUID = 1L;

    private GameState gameState;

    public PausePanel(GameState gameState) {
        super("Air Hockey - Pause");

        this.gameState = gameState;

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
        JButton quitAndSave = new JButton("Quit and save");
        quitAndSave.addActionListener(e -> {
            try {
                this.gameState.save();
            } catch (IOException ex) {
                new ExceptionPanel(ex);
            }
        });
        this.add(quitAndSave, c);
    }
}
