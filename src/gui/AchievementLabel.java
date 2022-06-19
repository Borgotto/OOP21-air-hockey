package gui;

import logics.Achievement;
import logics.GameState;
import utils.ImageModifier;

import javax.swing.*;
import java.awt.*;

public class AchievementLabel extends AbstractGridBagLayoutJPanel {
    private static final long serialVersionUID = 5723510034229737L;
    private final JLabel iconLabel;
    private final JLabel nameLabel;
    private final JLabel descriptionLabel;

    public AchievementLabel(GameState game, Achievement achievement) {
        super();

        // Create label Components
        ImageIcon icon = new ImageIcon(achievement.getIcon());
        if (!achievement.isUnlocked(game)) {
            icon = new ImageIcon(ImageModifier.color(icon.getImage(), Color.GRAY));
        }
        this.iconLabel = new JLabel(icon);
        this.nameLabel = new JLabel(achievement.getName());
        this.descriptionLabel = new JLabel(achievement.getDescription());
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

    public String toString() {
        return this.nameLabel.getText() + ": " + this.descriptionLabel.getText();
    }

    public ImageIcon getIcon() {
        return (ImageIcon) this.iconLabel.getIcon();
    }

    public String getName() {
        return this.nameLabel.getText();
    }

    public String getDescription() {
        return this.descriptionLabel.getText();
    }
}
