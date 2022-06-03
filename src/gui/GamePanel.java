package gui;

import logics.GameState;
import utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

public class GamePanel extends AbstractGridBagLayoutJPanel {
    private static final long serialVersionUID = 1L;

    private GameState game;

    // create a timer to update the game state
    private static final int delay = 1000/60; // 60 FPS
    private final Timer timer = new Timer(delay, e -> this.updateGame());

    private final JLabel arenaLabel;
    private final JLabel playerScoreLabel;
    private final JLabel enemyScoreLabel;
    private final JButton puckButton;
    private final JButton mainPlayerButton;
    private final JButton enemyPlayerButton;

    public GamePanel() throws IOException {
        super("Air Hockey - Game", new Dimension(GUI.getMinScreenSize()*3/4, GUI.getMinScreenSize()));

        // Add the game field as a JLabel
        c.weighty = 1.0;
        c.gridheight = 3;
        c.gridx = 0;
        c.gridy = 0;
        this.arenaLabel = new JLabel();
        this.arenaLabel.setLayout(new GridBagLayout());
        this.add(this.arenaLabel, c);

        // Create labels to show the players scores
        c.weightx = 1/4d;
        c.gridheight = 1;
        c.gridx = 1;
        c.gridy = 0;
        this.enemyScoreLabel = new JLabel();
        this.add(enemyScoreLabel, c);
        c.gridy = 2;
        this.playerScoreLabel = new JLabel();
        this.add(playerScoreLabel, c);

        // Create the pause button
        c.gridy = 1;
        JButton pauseButton = new JButton("Pause");
        pauseButton.addActionListener(e -> {
            JOptionPane.showOptionDialog(this, new PausePanel(this.game), "Pause", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
        });
        this.add(pauseButton, c);

        // Create buttons to show the puck and the two players
        this.mainPlayerButton = new JButton("player");
        this.enemyPlayerButton = new JButton("enemy");
        this.puckButton = new JButton("puck");
        this.enemyPlayerButton.setEnabled(false);
        this.puckButton.setEnabled(false);

        // Load resources
        Image mainPlayerImage = ResourceLoader.load(Path.of("res/main_player.png"), BufferedImage.class);
        Image enemyPlayerImage = ResourceLoader.load(Path.of("res/enemy_player.png"), BufferedImage.class);
        Image puckImage = ResourceLoader.load(Path.of("res/puck.png"), BufferedImage.class);
        Image arenaImage = ResourceLoader.load(Path.of("res/arena.png"), BufferedImage.class);
        arenaImage = ImageScaler.scale(arenaImage, new Dimension(this.getPreferredSize().width*3/4, this.getPreferredSize().height));

        this.arenaLabel.add(this.mainPlayerButton, new GridBagConstraints());
        this.arenaLabel.add(this.enemyPlayerButton, new GridBagConstraints());
        this.arenaLabel.add(this.puckButton, new GridBagConstraints());

        // Set the component images
        this.mainPlayerButton.setIcon(new ImageIcon(mainPlayerImage));
        this.enemyPlayerButton.setIcon(new ImageIcon(enemyPlayerImage));
        this.puckButton.setIcon(new ImageIcon(puckImage));
        this.arenaLabel.setIcon(new ImageIcon(arenaImage));

        this.mainPlayerButton.setBackground(Color.RED);
        this.enemyPlayerButton.setBackground(Color.BLUE);
        this.puckButton.setBackground(Color.GREEN);

    }

    /**
     * Sets up the JLabels and JButtons to the initial game state and starts the timer.
     */
    public void startGame(GameState game) {
        this.game = game;
        this.playerScoreLabel.setText(String.valueOf(game.getMainPlayer().getScore()));
        this.enemyScoreLabel.setText(String.valueOf(game.getEnemyPlayer().getScore()));
        this.repaint();
        this.timer.start();
    }

    /**
     * Method to be called to render the next frame
     * It will update the game state and update the GUI
     */
    private void updateGame() {
        // tell the game logics to update the game state
        this.game.update();
        // update the Components based on the new game state
        this.updatePositions();
        this.repaint();
    }

    /**
     * Method called automatically by the timer function
     * Can be called manually to end the game
     */
    private void endGame() {
        this.timer.stop();
        JOptionPane.showMessageDialog(this, "Game over!");
        //JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        //JPanelLoader.load(parentFrame, new GameOverPanel());
    }

    /**
     * Method to update the positions of the components
     */
    private void updatePositions() {
        // get the positions
        Pair<Integer, Integer> mainPlayerPosition = UnitConverter.MeterToPixel(this.game.getMainPlayer().getPosition());
        Pair<Integer, Integer> enemyPlayerPosition = UnitConverter.MeterToPixel(this.game.getEnemyPlayer().getPosition());
        Pair<Integer, Integer> puckPosition = UnitConverter.MeterToPixel(this.game.getPuck().getPosition());

        int arenaHeight = this.arenaLabel.getHeight();

        // Invert the Y axis since (0,0) is in the top left corner of the screen in the GUI while it's in the bottom
        // left corner in the game logics
        mainPlayerPosition = new Pair<>(mainPlayerPosition.getX(), arenaHeight - mainPlayerPosition.getY());
        enemyPlayerPosition = new Pair<>(enemyPlayerPosition.getX(), arenaHeight - enemyPlayerPosition.getY());
        puckPosition = new Pair<>(puckPosition.getX(), arenaHeight - puckPosition.getY());

        // Update the positions of the buttons
        this.mainPlayerButton.setLocation(mainPlayerPosition.getX(), mainPlayerPosition.getY());
        this.enemyPlayerButton.setLocation(enemyPlayerPosition.getX(), enemyPlayerPosition.getY());
        this.puckButton.setLocation(puckPosition.getX(), puckPosition.getY());
    }
}