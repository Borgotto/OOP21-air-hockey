package gui;

import logics.Achievement;
import logics.AchievementLogicsFactory;
import logics.AchievementLogicsFactoryImpl;
import logics.GameState;
import utils.ImageModifier;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * This class is used to display all the achievementLabels in a scrollable pane
 */
public class AchievementsScrollPane extends JScrollPane {
    private static final long serialVersionUID = -8067292109260697539L;

    public AchievementsScrollPane(GameState game, int parentFrameHeight) {
        this.setBorder(BorderFactory.createEmptyBorder());
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
        achievementList.setCellRenderer(new AchievementLabelCellRenderer(parentFrameHeight));
        achievementList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        achievementList.setLayoutOrientation(JList.VERTICAL);

        // Set the list to the scroll pane
        this.setViewportView(achievementList);
    }

    private static class AchievementLabelCellRenderer extends JLabel implements ListCellRenderer<AchievementLabel> {
        private static final long serialVersionUID = 3905450234338100066L;
        private final int iconSize;

        public AchievementLabelCellRenderer(int parentFrameHeight) {
            setOpaque(true);
            setHorizontalAlignment(LEFT);
            setVerticalAlignment(CENTER);
            this.iconSize = parentFrameHeight / 20;
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends AchievementLabel> jList, AchievementLabel achievementLabel, int i, boolean b, boolean b1) {
            Image scaledImage = ImageModifier.scale(achievementLabel.getIcon().getImage(), new Dimension(this.iconSize, this.iconSize));
            setIcon(new ImageIcon(scaledImage));
            setText(achievementLabel.toString());
            return this;
        }
    }
}


