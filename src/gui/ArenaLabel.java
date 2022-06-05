package gui;

import utils.ImageModifier;
import utils.ResourceLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.file.Path;

public class ArenaLabel extends JLabel {
    private final JLabel enemyField;
    private final JLabel playerField;
    private final JButton enemyButton;
    private final JButton playerButton;
    private final JButton puckButton;

    public ArenaLabel(Dimension size){
        // Load resources
        BufferedImage strikerImag = ResourceLoader.load(Path.of("res/striker.png"), BufferedImage.class);
        BufferedImage puckImag = ResourceLoader.load(Path.of("res/puck.png"), BufferedImage.class);
        BufferedImage arenaImag = ResourceLoader.load(Path.of("res/arena.png"), BufferedImage.class);
        Image strikerImage = ImageModifier.color(strikerImag, new Color(200,0,200, 150));
        Image puckImage = ImageModifier.color(puckImag, new Color(255,100,255,125));
        Image arenaImage = ImageModifier.color(arenaImag, new Color(255,0,255,200));

        // Manually manage the label's layout
        this.setLayout(null);
        this.setBounds(0,0,size.width,size.height);
        this.setIcon(new ImageIcon(ImageModifier.scale(arenaImage, size)));

        // Create the enemy field
        enemyField = new JLabel();
        enemyField.setBounds(0,0,size.width,size.height/2);
        this.add(enemyField);

        // Create the player field
        playerField = new JLabel();
        playerField.setBounds(0,size.height/2, size.width,size.height/2);
        this.add(playerField);

        // Buttons dimension
        int buttonSize = size.width/8;

        // Create the enemy button
        enemyButton = new IconButton(strikerImage, new Dimension(buttonSize, buttonSize));
        enemyButton.setBounds(size.width/2-enemyButton.getWidth()/2,size.height/4-enemyButton.getHeight(),enemyButton.getWidth(),enemyButton.getHeight());
        enemyField.add(enemyButton);

        // Create the player button
        playerButton = new IconButton(strikerImage, new Dimension(buttonSize, buttonSize));
        playerButton.setBounds(size.width/2-playerButton.getWidth()/2,size.height/4,playerButton.getWidth(),playerButton.getHeight());
        playerField.add(playerButton);

        // Create the puck button
        puckButton = new IconButton(puckImage, new Dimension(buttonSize, buttonSize));
        puckButton.setBounds(size.width/2-puckButton.getWidth()/2,size.height/2-puckButton.getWidth()/2,puckButton.getWidth(),puckButton.getHeight());
        this.add(puckButton);
    }

    public JLabel getEnemyField() {
        return this.enemyField;
    }

    public JLabel getPlayerField() {
        return this.playerField;
    }

    public JButton getEnemyButton() {
        return this.enemyButton;
    }

    public JButton getPlayerButton() {
        return this.playerButton;
    }

    public JButton getPuckButton() {
        return this.puckButton;
    }
}
