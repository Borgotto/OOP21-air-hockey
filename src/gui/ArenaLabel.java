package gui;

import utils.ImageModifier;
import utils.ResourceLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

public class ArenaLabel extends JLabel {
    private final JLabel enemyField;
    private final JLabel playerField;
    private final JButton enemyButton;
    private final JButton playerButton;
    private final JButton puckButton;

    public ArenaLabel(Dimension size){
        // Load resources
        Image strikerImage = null;
        Image puckImage = null;
        Image arenaImage = null;
        try {
            strikerImage = ResourceLoader.load(Path.of("res/striker.png"), BufferedImage.class);
            puckImage = ResourceLoader.load(Path.of("res/puck.png"), BufferedImage.class);
            arenaImage = ResourceLoader.load(Path.of("res/arena.png"), BufferedImage.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
