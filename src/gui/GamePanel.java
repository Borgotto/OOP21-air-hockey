package gui;

import logics.GameState;
import org.jbox2d.common.Vec2;
import utils.*;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends AbstractGridBagLayoutJComponent {
    private static final long serialVersionUID = 1L;

    private final GameState game;

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

    public GamePanel(GameState game) {
        super("Air Hockey - Game", new Dimension(GUI.getMinScreenSize()*3/4, GUI.getMinScreenSize()));
        this.game = game;

        // Add the game field as a JLabel
        c.weighty = 1.0;
        c.gridheight = 3;
        c.gridx = 0;
        c.gridy = 0;
        this.arenaLabel = new ArenaLabel(new Dimension(this.getPreferredSize().width*3/4, this.getPreferredSize().height), this.game);
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
            this.timer.stop();
            JOptionPane.showOptionDialog(this, new PausePanel(this.game), "Pause", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            this.timer.start();
        });
        this.add(this.pauseButton, c);

        // handler for the mouse inputs on the player button
        this.componentMover = new ComponentMover();
    }

    /**
     * Sets up the JLabels and JButtons to the initial game state and starts the timer.
     */
    public void startGame() {
        this.pauseButton.setEnabled(true);
        this.componentMover.registerComponent(this.arenaLabel.getPlayerButton());
        this.timer.start();
    }

    /**
     * Method to be called to render the next frame
     * It will update the game state and update the GUI
     */
    private void updateGame() {
        // Tell the game logics to update the game state
        this.game.update();
        // Update the scores
        this.playerScoreLabel.setText(String.valueOf(this.game.getMainPlayer().getScore()));
        this.enemyScoreLabel.setText(String.valueOf(this.game.getEnemyPlayer().getScore()));
        // Update the Components based on the new game state
        this.updatePositions();
        // Check if the game is over
        if (this.game.isGameOver()) {
           this.endGame();
        }
    }

    /**
     * Method called automatically by the timer function
     * Can be called manually to end the game
     */
    private void endGame() {
        this.timer.stop();
        JFrame parent = JComponentLoader.getParentFrame(this);
        JComponentLoader.load(parent, new GameOverPanel(game));
    }

    /**
     * Method to update the positions of the components.
     * It converts the GameObject positions to the JLabel positions
     */
    private void updatePositions() {
        // Convert physics coordinates [(0,0) is bottom left] to awt coordinates [(0,0) is top left corner]
        UnitConverter uc = new UnitConverter(this.arenaLabel.getPreferredSize(), new Vec2(this.game.getArena().getWidth(), this.game.getArena().getHeight()));
        // Update the player, enemy and puck positions
        JButton playerButton = this.arenaLabel.getPlayerButton();
        uc.setOffset(new Vec2(-playerButton.getWidth()/2.0f, -playerButton.getHeight()/2.0f - this.arenaLabel.getEnemyField().getHeight()));
        playerButton.setLocation(uc.MeterToPixel(this.game.getMainPlayer().getPosition()));
        JButton enemyButton = this.arenaLabel.getEnemyButton();
        uc.setOffset(new Vec2(-enemyButton.getWidth()/2.0f, -enemyButton.getHeight()/2.0f));
        enemyButton.setLocation(uc.MeterToPixel(this.game.getEnemyPlayer().getPosition()));
        JButton puckButton = this.arenaLabel.getPuckButton();
        uc.setOffset(new Vec2(-puckButton.getWidth()/2.0f, -puckButton.getHeight()/2.0f));
        puckButton.setLocation(uc.MeterToPixel(this.game.getPuck().getPosition()));
    }
}