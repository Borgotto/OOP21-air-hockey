package gui;

import logics.Achievement;
import logics.AchievementLogicsFactory;
import logics.AchievementLogicsFactoryImpl;
import logics.GameState;

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
