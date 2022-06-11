package gui;

import logics.Achievement;
import logics.AchievementLogicsFactory;
import logics.AchievementLogicsFactoryImpl;
import logics.GameState;
import utils.ImageModifier;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AchievementsPanel extends JScrollPane {
    public AchievementsPanel(GameState game) {

        //this.setLayout(new ScrollPaneLayout());

        // Get the base achievements
        AchievementLogicsFactory factory = new AchievementLogicsFactoryImpl();
        List<Achievement> achievements = factory.baseAchievements().getAchievements();
        DefaultListModel<AchievementLabel> listModel = new DefaultListModel<>();

        // Add the achievements as JLabels to the list
        for (Achievement achievement : achievements) {
            AchievementLabel achievementLabel = new AchievementLabel(game, achievement);
            listModel.addElement(achievementLabel);
        }

        JList<AchievementLabel> achievementList = new JList<>(listModel);
        achievementList.setCellRenderer(new AchievementLabelCellRenderer());
        achievementList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        achievementList.setLayoutOrientation(JList.VERTICAL);

        // Set the list to the scroll pane
        this.setViewportView(achievementList);
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

