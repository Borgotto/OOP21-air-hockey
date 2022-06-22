package gui;

import logics.GameState;
import utils.ObjectSerializer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Class that extends JPanel and works as a pause menu.
 */
public class PausePanel extends AbstractGridBagLayoutJPanel {
    private static final long serialVersionUID = -4465167712375078735L;

    public PausePanel(GameState game) {
        super("Air Hockey - Pause");

        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.SOUTH;
        JButton resume = new JButton("Resume");
        resume.addActionListener(e -> SwingUtilities.getWindowAncestor(this).dispose());
        this.add(resume, c);
        c.gridy = 2;
        c.anchor = GridBagConstraints.CENTER;
        JButton exit = new JButton("Quit");
        exit.addActionListener(e -> Runtime.getRuntime().exit(0));
        this.add(exit, c);
        c.gridy = 3;
        c.anchor = GridBagConstraints.NORTH;
        JButton saveAndQuit = new JButton("Save and quit");
        saveAndQuit.addActionListener(e -> {
            try {
                ObjectSerializer.serialize(game, GameState.savePath);
            } catch (IOException ex) {
                new ExceptionPanel(ex);
            }
            Runtime.getRuntime().exit(0);
        });
        this.add(saveAndQuit, c);
    }
}
