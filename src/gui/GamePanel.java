package gui;

import java.awt.*;
import javax.swing.*;

import logics.GameState;
import utils.JPanelLoader;

public class GamePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    
    private final GameState game;
    
    public GamePanel() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();

        // Add the game field as a canvas
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 3;
        Canvas canvas = new Canvas();
        this.add(canvas, c);

        // Add the scores as labels
        c.gridx = 1;
        c.gridy = 0;
        Label enemyScore = new Label("0");
        this.add(enemyScore, c);
        c.gridy = 2;
        Label playerScore = new Label("0");
        this.add(playerScore, c);

        // Add the pause button
        c.gridx = 1;
        c.gridy = 1;
        JButton pauseButton = new JButton("Pause");
        /* TODO
        pauseButton.addActionListener(e -> {
            if (game.isPaused()) {

            }
        });
        */
        this.add(pauseButton, c);



        this.game = new GameState();
    }
}