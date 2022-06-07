package gui;

import logics.GameState;
import utils.*;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends AbstractGridBagLayoutJComponent {
    private static final long serialVersionUID = 1L;

    private GameState game;

    // create a timer to update the game state
    private static final int delay = 1000/60; // 60 FPS
    private final Timer timer = new Timer(delay, e -> this.updateGame());

    // GUI elements to be updated every frame by the updateGame() method
    private final ArenaLabel arenaLabel;
    private final JLabel playerScoreLabel;
    private final JLabel enemyScoreLabel;
    private final JButton pauseButton;

    // class used to handle the mouse inputs on the player button
    private final ComponentMover componentMover;

    public GamePanel() {
        super("Air Hockey - Game", new Dimension(GUI.getMinScreenSize()*3/4, GUI.getMinScreenSize()));

        // Add the game field as a JLabel
        c.weighty = 1.0;
        c.gridheight = 3;
        c.gridx = 0;
        c.gridy = 0;
        this.arenaLabel = new ArenaLabel(new Dimension(this.getPreferredSize().width*3/4, this.getPreferredSize().height));
        this.add(arenaLabel, c);

        // Create labels to show the players scores
        c.weightx = 1/4d;
        c.gridheight = 1;
        c.gridx = 1;
        c.gridy = 0;
        this.enemyScoreLabel = new JLabel();
        this.add(this.enemyScoreLabel, c);
        c.gridy = 2;
        this.playerScoreLabel = new JLabel();
        this.add(this.playerScoreLabel, c);

        // Create the pause button
        c.gridy = 1;
        this.pauseButton = new JButton("Pause");
        this.pauseButton.setEnabled(false); // prevent the user from pausing the game before it is started
        this.pauseButton.addActionListener(e -> {
            JOptionPane.showOptionDialog(this, new PausePanel(this.game), "Pause", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
        });
        this.add(this.pauseButton, c);

        // handler for the mouse inputs on the player button
        this.componentMover = new ComponentMover();
    }

    /**
     * Sets up the JLabels and JButtons to the initial game state and starts the timer.
     */
    public void startGame(GameState game) {
        this.game = game;
        this.pauseButton.setEnabled(true);
        this.componentMover.registerComponent(this.arenaLabel.getPlayerButton());
        this.playerScoreLabel.setText(String.valueOf(game.getMainPlayer().getScore()));
        this.enemyScoreLabel.setText(String.valueOf(game.getEnemyPlayer().getScore()));
        this.timer.start();
    }

    /**
     * Method to be called to render the next frame
     * It will update the game state and update the GUI
     */
    private void updateGame() {
        // Tell the game logics to update the game state
        this.game.update();
        // Update the Components based on the new game state
        this.updatePositions();
        this.repaint();

        // Check if the game is over
        if (this.game.isGameOver()) {
           this.endGame(game);
        }
    }

    /**
     * Method called automatically by the timer function
     * Can be called manually to end the game
     */
    private void endGame(GameState game) {
        this.timer.stop();
        //JFrame parent = JComponentLoader.getParentFrame(this);
        //JComponentLoader.load(parent, new GameOverPanel(game));
    }

    /**
     * Method to update the positions of the components
     */
    private void updatePositions() {
        // Get the positions
        Pair<Integer, Integer> mainPlayerPosition = UnitConverter.MeterToPixel(this.game.getMainPlayer().getPosition());
        Pair<Integer, Integer> enemyPlayerPosition = UnitConverter.MeterToPixel(this.game.getEnemyPlayer().getPosition());
        Pair<Integer, Integer> puckPosition = UnitConverter.MeterToPixel(this.game.getPuck().getPosition());

        int arenaHeight = this.arenaLabel.getHeight();

        // Invert the Y axis since (0,0) is in the top left corner of the screen in the GUI while it's in the bottom
        // left corner in the game logics
        mainPlayerPosition = new Pair<>(mainPlayerPosition.getX(), arenaHeight - mainPlayerPosition.getY());
        enemyPlayerPosition = new Pair<>(enemyPlayerPosition.getX(), arenaHeight - enemyPlayerPosition.getY());
        puckPosition = new Pair<>(puckPosition.getX(), arenaHeight - puckPosition.getY());

        // Adjust the positions so that they refer to the center of the button
        mainPlayerPosition = new Pair<>(mainPlayerPosition.getX() - this.arenaLabel.getPlayerButton().getWidth()/2, mainPlayerPosition.getY() - this.arenaLabel.getPlayerButton().getHeight()/2);
        enemyPlayerPosition = new Pair<>(enemyPlayerPosition.getX() - this.arenaLabel.getEnemyButton().getWidth()/2, enemyPlayerPosition.getY() - this.arenaLabel.getEnemyButton().getHeight()/2);
        puckPosition = new Pair<>(puckPosition.getX() - this.arenaLabel.getPuckButton().getWidth()/2, puckPosition.getY() - this.arenaLabel.getPuckButton().getHeight()/2);

        // Update the positions of the buttons
        this.arenaLabel.getPlayerButton().setLocation(mainPlayerPosition.getX(), mainPlayerPosition.getY());
        this.arenaLabel.getEnemyButton().setLocation(enemyPlayerPosition.getX(), enemyPlayerPosition.getY());
        this.arenaLabel.getPuckButton().setLocation(puckPosition.getX(), puckPosition.getY());
    }
}