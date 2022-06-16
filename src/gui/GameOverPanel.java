package gui;

import logics.GameState;
import utils.JComponentLoader;

import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends AbstractGridBagLayoutJComponent {
    private static final long serialVersionUID = -6295463075268587222L;

    public GameOverPanel(GameState game, int parentFrameHeight) {
        super("Game Over", new Dimension(GUI.getMinScreenSize(), GUI.getMinScreenSize()/2));

        // JLabel for the winner and final score
        String result = game.getWinner().isPresent() ? "Winner: " + game.getWinner().get().getName() : "Draw";
        String score = "Score: " + game.getMainPlayer().getScore() + " - " + game.getEnemyPlayer().getScore();
        JLabel gameResult = new JLabel(result);
        JLabel gameScore = new JLabel(score);
        // JFrame for the achievements
        AchievementsPanel achPanel = new AchievementsPanel(game, parentFrameHeight);
        achPanel.setPreferredSize(new Dimension(this.getPreferredSize().width, this.getPreferredSize().height/2));
        // Back to menu and quit buttons
        JButton backToMenu = new JButton("Back to main menu");
        backToMenu.addActionListener(e -> {
            JFrame parent = JComponentLoader.getParentFrame(this);
            JComponentLoader.load(parent, new MenuPanel());
        });
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> {
            System.exit(0);
        });
        // Add all components to this panel
        c.anchor = GridBagConstraints.CENTER;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        this.add(gameResult,c);
        c.gridy = 1;
        this.add(gameScore,c);
        c.gridy = 2;
        this.add(achPanel,c);
        c.gridwidth = 1;
        c.gridy = 3;
        c.weightx = 1/2d;
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 0;
        this.add(backToMenu,c);
        //c.insets = new Insets(pad, 0, pad, pad);
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        this.add(quitButton,c);
    }
}
