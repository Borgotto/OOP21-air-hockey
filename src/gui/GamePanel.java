package gui;

import logics.Arena;
import logics.GameState;
import utils.JPanelLoader;
import utils.ResourceLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends AbstractGridBagLayoutJPanel {
    private static final long serialVersionUID = 1L;
    
    private GameState game;
    private Canvas canvas;

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

        this.gameLoop();
    }

    private void gameLoop() throws IOException {
        boolean exit = false;

        BufferedImage puck = ResourceLoader.loadImage("puck.png");
        BufferedImage mainPlayer = ResourceLoader.loadImage("main_player.png");
        BufferedImage enemyPlayer = ResourceLoader.loadImage("enemy_player.png");
        BufferedImage arena = ResourceLoader.loadImage("arena.png");

        while (!exit) {
            game.update();
            BufferedImage frame = this.drawFrame(puck, mainPlayer, enemyPlayer, arena);
            canvas.getGraphics().drawImage(frame, 0,0, null);
        }
    }

    private BufferedImage drawFrame(BufferedImage puckImage, BufferedImage mainPlayerImage, BufferedImage enemyPlayerImage, BufferedImage arenaImage) {
        // get the frame's size
        Arena arena = game.getArena();
        int frameWidth = this.metersToPixel(arena.getWidth());
        int frameHeight = this.metersToPixel(arena.getHeight());

        // initialize the frame
        BufferedImage fullFrame = new BufferedImage(frameWidth, frameHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = fullFrame.createGraphics();

        // draw the arena
        g.drawImage(arenaImage, 0, 0, frameWidth, frameHeight, null);

        // draw the puck
        int puckX = this.metersToPixel(game.getPuck().getPosition().x);
        int puckY = this.metersToPixel(game.getPuck().getPosition().y);
        g.drawImage(puckImage, puckX, puckY, null);

        // draw the main player
        int mainPlayerX = this.metersToPixel(game.getMainPlayer().getPosition().x);
        int mainPlayerY = this.metersToPixel(game.getMainPlayer().getPosition().y);
        g.drawImage(mainPlayerImage, mainPlayerX, mainPlayerY, null);

        // draw the enemy player
        int enemyPlayerX = this.metersToPixel(game.getEnemyPlayer().getPosition().x);
        int enemyPlayerY = this.metersToPixel(game.getEnemyPlayer().getPosition().y);
        g.drawImage(enemyPlayerImage, enemyPlayerX, enemyPlayerY, null);

        return fullFrame;
    }

    private BufferedImage loadImage(String filename) throws IOException {
        return ImageIO.read(new File("res/", filename));
    }

    /* Convert meters to pixels */
    private int metersToPixel(float meters) {
        int pixelHeight = this.getHeight();
        float metersHeight = this.game.getArena().getHeight();

        float ratio = pixelHeight / metersHeight;
        return (int) (meters * ratio);
    }
}