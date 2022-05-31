package gui;

import logics.Arena;
import logics.GameState;
import org.jbox2d.common.Vec2;
import utils.JPanelLoader;
import utils.Pair;
import utils.ResourceLoader;
import utils.UnitConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

public class GamePanel extends AbstractGridBagLayoutJPanel {
    private static final long serialVersionUID = 1L;
    
    private GameState game;
    private Canvas canvas;

    private final JButton puckButton;
    private final JButton mainPlayerButton;
    private final JButton enemyPlayerButton;
    private final BufferedImage arenaImage;

    public GamePanel() throws IOException {
        this(new GameState());
    }
    
    public GamePanel(GameState game) throws IOException {
        super("Air Hockey - Game", new Dimension(GUI.getMinScreenSize(), GUI.getMinScreenSize()));

        c.anchor = GridBagConstraints.CENTER;
        c.weighty = 1.0;

        // Add the game field as a canvas
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 3.0/4.0;
        c.gridheight = 3;
        c.fill = GridBagConstraints.BOTH;
        this.canvas = new Canvas();

        this.add(this.canvas, c);
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
            JPanelLoader.load(JPanelLoader.getParentFrame(this), new PausePanel());
        });
        this.add(pauseButton, c);
        this.game = game;

        // Load resources
        BufferedImage mainPlayerImage = ResourceLoader.load(Path.of("res/main_player.png"), BufferedImage.class);
        BufferedImage enemyPlayerImage = ResourceLoader.load(Path.of("res/enemy_player.png"), BufferedImage.class);
        BufferedImage puckImage = ResourceLoader.load(Path.of("res/puck.png"), BufferedImage.class);
        this.arenaImage = ResourceLoader.load(Path.of("res/arena.png"), BufferedImage.class);

        // Create buttons to handle the puck and the two players
        this.mainPlayerButton = new JButton("", new ImageIcon(mainPlayerImage));
        this.enemyPlayerButton = new JButton("", new ImageIcon(enemyPlayerImage));
        this.puckButton = new JButton("", new ImageIcon(puckImage));
    }

    public void start() {
        this.canvas.getGraphics().drawImage(this.arenaImage, 0, 0, null);

        this.gameLoop();
    }

    private void gameLoop() {
        boolean exit = false;

        while (!exit) {
            this.game.update();
            updatePositions();
        }
    }

    private void updatePositions() {
        // get the positions
        Pair<Integer, Integer> mainPlayerPosition = UnitConverter.MeterToPixel(this.game.getMainPlayer().getPosition());
        Pair<Integer, Integer> enemyPlayerPosition = UnitConverter.MeterToPixel(this.game.getEnemyPlayer().getPosition());
        Pair<Integer, Integer> puckPosition = UnitConverter.MeterToPixel(this.game.getPuck().getPosition());

        int arenaHeight = this.canvas.getHeight();

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