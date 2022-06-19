package gui;

import logics.GameState;
import org.jbox2d.common.Vec2;
import physics.MousePhysicsHandler;
import utils.JComponentLoader;
import utils.UnitConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends AbstractGridBagLayoutJComponent {
    private static final long serialVersionUID = 2068452932127099196L;
    private final GameState game;
    // create a timer to update the game state
    private static final int delay = 1000/60; // 60 FPS
    private final Timer timer = new Timer(delay, e -> this.updateGame());
    // GUI elements to be updated every frame by the updateGame() method
    private final ArenaLabel arenaLabel;
    private final JLabel playerScoreLabel;
    private final JLabel enemyScoreLabel;
    private final JButton pauseButton;
    // Gui to physics unit converter and mouse input handler
    private final UnitConverter uc;
    private boolean isMainPlayerMoving;
    private final MousePhysicsHandler mouseHandler;

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

        // Convert physics coordinates [(0,0) is bottom left] to awt coordinates [(0,0) is top left corner]
        this.uc = new UnitConverter(this.arenaLabel.getPreferredSize(), new Vec2(this.game.getArena().getWidth(), this.game.getArena().getHeight()));
        // Handle mouse movement on the Player button
        this.isMainPlayerMoving = false;
        this.mouseHandler = new MousePhysicsHandler(this.game.getMainPlayer().getBody());
    }

    /**
     * Sets up the JLabels and JButtons to the initial game state and starts the timer.
     */
    public void startGame() {
        this.pauseButton.setEnabled(true);
        this.arenaLabel.getPlayerButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.arenaLabel.getPlayerButton().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                isMainPlayerMoving = true;
            }
            public void mouseReleased(MouseEvent e) {
                isMainPlayerMoving = false;
                mouseHandler.mouseReleased();
            }
        });
        this.timer.start();
    }

    /**
     * Method to be called to render the next frame
     * It will update the game state and update the GUI
     */
    private void updateGame() {
        // Update the Player position
        if (this.isMainPlayerMoving) {
            Point mousePosition = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(mousePosition, this.arenaLabel);
            this.uc.setOffset(new Vec2(0,0));
            this.mouseHandler.update(this.uc.pixelToMeter(mousePosition));
        }
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
     * Method called automatically by the updateGame method when the game ends
     * Can be called manually to end the game
     */
    public void endGame() {
        this.timer.stop();
        JFrame parent = JComponentLoader.getParentFrame(this);
        JComponentLoader.load(parent, new GameOverPanel(game, JComponentLoader.getParentFrame(this).getHeight()));
    }

    /**
     * Method to update the positions of the components.
     * It converts the GameObject positions to the JLabel positions
     */
    private void updatePositions() {
        // Update the player, enemy and puck positions
        JButton playerButton = this.arenaLabel.getPlayerButton();
        this.uc.setOffset(new Vec2(-playerButton.getWidth()/2.0f, -playerButton.getHeight()/2.0f - this.arenaLabel.getEnemyField().getHeight()));
        playerButton.setLocation(this.uc.meterToPixel(this.game.getMainPlayer().getPosition()));
        JButton enemyButton = this.arenaLabel.getEnemyButton();
        this.uc.setOffset(new Vec2(-enemyButton.getWidth()/2.0f, -enemyButton.getHeight()/2.0f));
        enemyButton.setLocation(this.uc.meterToPixel(this.game.getEnemyPlayer().getPosition()));
        JButton puckButton = this.arenaLabel.getPuckButton();
        this.uc.setOffset(new Vec2(-puckButton.getWidth()/2.0f, -puckButton.getHeight()/2.0f));
        puckButton.setLocation(this.uc.meterToPixel(this.game.getPuck().getPosition()));
    }
}