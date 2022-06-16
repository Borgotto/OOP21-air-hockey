package gui;

import logics.GameState;
import logics.Settings;
import org.jbox2d.common.Vec2;
import utils.ImageModifier;
import utils.ResourceLoader;
import utils.UnitConverter;

import javax.swing.*;
import java.awt.*;

public class ArenaLabel extends JLabel {
    private static final long serialVersionUID = -7722495704378516329L;
    private final JLabel enemyField;
    private final JLabel playerField;
    private final JButton enemyButton;
    private final JButton playerButton;
    private final JButton puckButton;

    public ArenaLabel(Dimension size, GameState game) {
        // Load resources and color the images based on the Theme saved in settings
        Color color = new Settings().load().getTheme().getColor();
        Image strikerImage = ImageModifier.color(ResourceLoader.loadImage("striker.png"), color);
        Image puckImage = ImageModifier.color(ResourceLoader.loadImage("puck.png"), color);
        Image arenaImage = ImageModifier.color(ResourceLoader.loadImage("arena.png"), color);

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

        // Determine the size of the buttons with the help of the UnitConverter
        UnitConverter converter = new UnitConverter(size, new Vec2(game.getArena().getWidth(), game.getArena().getHeight()));

        // Create the enemy button
        int enemyButtonSize = Math.round(game.getEnemyPlayer().getRadius()*2 * converter.xScaling);
        converter.setOffset(new Vec2(-enemyButtonSize/2.0f, -enemyButtonSize/2.0f));
        Point enemyButtonPos = converter.meterToPixel(game.getEnemyPlayer().getPosition());
        enemyButton = new IconButton(strikerImage, new Dimension(enemyButtonSize, enemyButtonSize));
        enemyButton.setBounds(enemyButtonPos.x, enemyButtonPos.y, enemyButton.getPreferredSize().width, enemyButton.getPreferredSize().height);
        enemyField.add(enemyButton);

        // Create the player button
        int playerButtonSize = Math.round(game.getMainPlayer().getRadius()*2 * converter.xScaling);
        converter.setOffset(new Vec2(-playerButtonSize/2.0f, -playerButtonSize/2.0f));
        Point playerButtonPos = converter.meterToPixel(game.getMainPlayer().getPosition());
        playerButton = new IconButton(strikerImage, new Dimension(playerButtonSize, playerButtonSize));
        playerButton.setBounds(playerButtonPos.x, playerButtonPos.y - size.height/2, playerButton.getPreferredSize().width, playerButton.getPreferredSize().height);
        playerField.add(playerButton);

        // Create the puck button
        int puckButtonSize = Math.round(game.getPuck().getRadius()*2 * converter.xScaling);
        converter.setOffset(new Vec2(-puckButtonSize/2.0f, -puckButtonSize/2.0f));
        Point puckButtonPos = converter.meterToPixel(game.getPuck().getPosition());
        puckButton = new IconButton(puckImage, new Dimension(puckButtonSize, puckButtonSize));
        puckButton.setBounds(puckButtonPos.x, puckButtonPos.y, puckButton.getPreferredSize().width, puckButton.getPreferredSize().height);
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
