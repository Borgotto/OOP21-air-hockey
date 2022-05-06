package gui;

import java.awt.*;
import javax.swing.*;

import logics.GameState;
import utils.JPanelLoader;

public class GamePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    
    private final GameState game = new GameState();
    
    public GamePanel() {
        this.setName("Air Hockey - Game");
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.weighty = 1.0;

        // Add the game field as a canvas
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 3.0/4.0;
        c.gridheight = 3;
        c.fill = GridBagConstraints.BOTH;
        Canvas canvas = new Canvas();
        canvas.setBackground(Color.BLACK);
        this.add(canvas, c);
        c.gridheight = 1;
        c.fill = GridBagConstraints.NONE;

        // Add the scores as labels
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1.0/4.0;
        Label enemyScore = new Label(game.getEnemyPlayer().getScore().toString());
        this.add(enemyScore, c);

        c.gridy = 2;
        Label playerScore = new Label(game.getMainPlayer().getScore().toString());
        this.add(playerScore, c);

        // Add the pause button
        c.gridy = 1;
        JButton pauseButton = new JButton("Pause");
        pauseButton.addActionListener(e -> {

        });
        this.add(pauseButton, c);
    }
}