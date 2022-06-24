package gui;

import logics.GameState;
import utils.JComponentLoader;

import javax.swing.*;
import java.awt.*;

/**
 * This panel displays the status of the game after its completion.
 * It shows the score of the players and the winner.
 * After that it shows the achievementsScrollPane and the button to go back to the main menu.
 */
public class GameOverPanel extends AbstractGridBagLayoutJPanel {
    private static final long serialVersionUID = -6295463075268587222L;

    public GameOverPanel(GameState game, int parentFrameHeight) {
        super("Game Over", new Dimension(GUI.getMinScreenSize(), GUI.getMinScreenSize()/2));

        // JLabel for the winner and final score
        String result = game.getWinner().isPresent() ? "Winner: " + game.getWinner().get().getName() : "Draw";
        String score = "Score: " + game.getMainPlayer().getScore() + " - " + game.getEnemyPlayer().getScore();
        JLabel gameResult = new JLabel(result);
        JLabel gameScore = new JLabel(score);
        // JFrame for the achievements
        AchievementsScrollPane achPanel = new AchievementsScrollPane(game, parentFrameHeight);
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
        int pad = this.getPreferredSize().height/40;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(pad, pad, pad, pad);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        this.add(gameResult,c);
        c.gridy = 1;
        this.add(gameScore,c);
        c.gridy = 2;
        c.insets = new Insets(0,0,0,0);
        this.add(achPanel,c);
        c.insets = new Insets(pad, pad, pad, pad);
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
