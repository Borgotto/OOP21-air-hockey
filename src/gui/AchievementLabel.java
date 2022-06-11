package gui;

import logics.*;
import utils.ImageModifier;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class AchievementLabel extends JLabel {

    private final JLabel iconLabel;
    private final JLabel nameLabel;
    private final JLabel descriptionLabel;

    public AchievementLabel(GameState game, Achievement achievement) {
        this.setLayout(new GridBagLayout());

        // Create label Components
        ImageIcon icon = achievement.getIcon();
        if (!achievement.isUnlocked(game)) {
            icon = new ImageIcon(ImageModifier.color(icon.getImage(), Color.GRAY));
        }
        this.iconLabel = new JLabel(icon);
        this.nameLabel = new JLabel(achievement.getName());
        this.descriptionLabel = new JLabel(achievement.getDescr());
        // Add Components to the label
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 2;
        this.add(this.iconLabel, c);
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1;
        this.add(this.nameLabel, c);
        c.gridy = 1;
        this.add(this.descriptionLabel, c);
    }
}
