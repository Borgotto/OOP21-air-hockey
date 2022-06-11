package gui;

import logics.Achievement;
import logics.AchievementLogicsFactory;
import logics.AchievementLogicsFactoryImpl;
import logics.GameState;
import utils.ImageModifier;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AchievementsPanel extends JPanel {
    public AchievementsPanel(GameState game) {
        //this.setLayout(new ScrollPaneLayout());
        this.setLayout(new GridBagLayout());

        // Get the base achievements
        AchievementLogicsFactory factory = new AchievementLogicsFactoryImpl();
        List<Achievement> achievements = factory.baseAchievements().getAchievements();

        // for each achievement create a label
        for (Achievement achievement : achievements) {
            AchievementLabel achievementLabel = new AchievementLabel(game, achievement);
            this.add(achievementLabel);
        }
    }
}


class AchievementLabelCellRenderer extends JLabel implements ListCellRenderer<AchievementLabel> {

    public AchievementLabelCellRenderer() {
        setOpaque(true);
        setHorizontalAlignment(LEFT);
        setVerticalAlignment(CENTER);
    }


    @Override
    public Component getListCellRendererComponent(JList<? extends AchievementLabel> jList, AchievementLabel achievementLabel, int i, boolean b, boolean b1) {
        ImageIcon icon = achievementLabel.getIcon();
        Image scaledImage = ImageModifier.scale(icon.getImage(), new Dimension(50, 50));

        setIcon(new ImageIcon(scaledImage));
        setText(achievementLabel.toString());
        return this;
    }
}

