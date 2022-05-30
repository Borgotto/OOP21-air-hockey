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

    private final BufferedImage puckImage;
    private final BufferedImage mainPlayerImage;
    private final BufferedImage enemyPlayerImage;
    private final BufferedImage arenaImage;

    public GamePanel() throws IOException {
        this(new GameState());
    }
    
    public GamePanel(GameState game) throws IOException {
        super("Air Hockey - Game");

        c.anchor = GridBagConstraints.CENTER;
        c.weighty = 1.0;

        // Add the game field as a canvas
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 3.0/4.0;
        c.gridheight = 3;
        c.fill = GridBagConstraints.BOTH;
        this.canvas = new Canvas();
        this.canvas.setBackground(Color.BLACK);
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
        this.puckImage = ResourceLoader.load(Path.of("res/puck.png"), BufferedImage.class);
        this.mainPlayerImage = ResourceLoader.load(Path.of("res/puck.png"), BufferedImage.class);
        this.enemyPlayerImage = ResourceLoader.load(Path.of("res/puck.png"), BufferedImage.class);
        this.arenaImage = ResourceLoader.load(Path.of("res/puck.png"), BufferedImage.class);

        this.gameLoop();
    }

    private void gameLoop() {
        boolean exit = false;

        // Create buttons to handle the puck and the two players
        JButton mainPlayerButton = new JButton("", new ImageIcon(this.mainPlayerImage));
        JButton enemyPlayerButton = new JButton("", new ImageIcon(this.enemyPlayerImage));
        JButton puckButton = new JButton("", new ImageIcon(this.puckImage));

        while (!exit) {
            BufferedImage frame = this.drawFrame();
            this.canvas.getGraphics().drawImage(frame, 0,0, null);
            this.game.update();
        }
    }

    private BufferedImage drawFrame() {
        // get the positions
        Pair<Integer, Integer> mainPlayerPosition = UnitConverter.MeterToPixel(this.game.getMainPlayer().getPosition());
        Pair<Integer, Integer> enemyPlayerPosition = UnitConverter.MeterToPixel(this.game.getEnemyPlayer().getPosition());
        Pair<Integer, Integer> puckPosition = UnitConverter.MeterToPixel(this.game.getPuck().getPosition());

        // get the frame's size
        Arena arena = this.game.getArena();
        Pair<Integer, Integer> frameSize = UnitConverter.MeterToPixel(new Vec2(arena.getWidth(), arena.getHeight()));

        // initialize the frame
        BufferedImage fullFrame = new BufferedImage(frameSize.getX(), frameSize.getY(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = fullFrame.createGraphics();

        // draw the arena
        g.drawImage(this.arenaImage, 0, 0, frameSize.getX(), frameSize.getY(), null);

        // draw the puck
        g.drawImage(this.puckImage, puckPosition.getX(), puckPosition.getY(), null);

        // draw the main player
        g.drawImage(this.mainPlayerImage, mainPlayerPosition.getX(), mainPlayerPosition.getY(), null);

        // draw the enemy player
        g.drawImage(this.enemyPlayerImage, enemyPlayerPosition.getX(), enemyPlayerPosition.getY(), null);

        return fullFrame;
    }

    /* Convert meters to pixels */
    private int metersToPixel(float meters) {
        int pixelHeight = this.getHeight();
        float metersHeight = this.game.getArena().getHeight();

        float ratio = pixelHeight / metersHeight;
        return (int) (meters * ratio);
    }
}