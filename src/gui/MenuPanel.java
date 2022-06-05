package gui;

import logics.GameState;
import logics.GameStateImpl;
import utils.ImageModifier;
import utils.JPanelLoader;
import utils.ResourceLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MenuPanel extends AbstractGridBagLayoutJPanel {
    public MenuPanel() {
        super("Air Hockey", new Dimension(GUI.getMinScreenSize()*9/16, GUI.getMinScreenSize()));

        int pad = this.getPreferredSize().width/40;
        c.insets = new Insets(pad, pad, pad/2, pad);
        c.gridx = 0;
        c.gridy = 0;

        // adjust the logo image size based on the panel size
        BufferedImage logoImage = ResourceLoader.load(Path.of("res/airhockey_logo.png"), BufferedImage.class);
        Dimension logoDimension = new Dimension(this.getPreferredSize().width-2*pad, this.getPreferredSize().height-2*pad);
        ImageIcon logoIconScaled = new ImageIcon(ImageModifier.scale(logoImage, logoDimension));
        JLabel logoLabel = new JLabel(logoIconScaled);
        this.add(logoLabel, c);

        c.insets = new Insets(pad/2, pad, pad/2, pad);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 1;

        var b1 = new JButton("New game");
        b1.addActionListener(e -> {
            GamePanel gamePanel = new GamePanel();
            JPanelLoader.load((JFrame) SwingUtilities.getWindowAncestor(this), gamePanel);
            gamePanel.startGame(new GameStateImpl());
        });
        this.add(b1, c);

        c.gridx = 0;
        c.gridy = 2;

        var b2 = new JButton("Continue");
        b2.setEnabled(Files.exists(GameState.savePath));
        b2.addActionListener(e -> {
            try {
                GameState game = new GameStateImpl();
                game.load();
                GamePanel gamePanel = new GamePanel();
                JPanelLoader.load((JFrame) SwingUtilities.getWindowAncestor(this), gamePanel);
                gamePanel.startGame(game);
            } catch (IOException | ClassNotFoundException ex) {
                new ExceptionPanel("Failed to load the game", ex);
            }
        });
        this.add(b2, c);

        c.gridx = 0;
        c.gridy = 3;

        var b3 = new JButton("Settings");
        b3.addActionListener(e -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            JPanelLoader.load(parentFrame, new SettingsPanel());
        });
        this.add(b3, c);

        c.gridx = 0;
        c.gridy = 4;

        var b4 = new JButton("Credits");
        b4.addActionListener(e -> {
            var messagePanel = new JPanel();
            messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));

            var repositoryLabel = new JLabel(" GitHub repository", new ImageIcon("res/GitHub-Mark-32px.png"), SwingConstants.LEFT);
            repositoryLabel.setForeground(Color.BLUE.darker());
            repositoryLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            repositoryLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://github.com/Borgotto/OOP21-air-hockey"));
                    } catch (IOException | URISyntaxException e1) {
                        e1.printStackTrace();
                    }
                }
            });

            var engineersLabel = new JLabel(
                    "<html><br>Written by:<ul>\n" +
                      "<li>Emanuele Borghini - emanuele.borghini@studio.unibo.it</li>\n" +
                      "<li>Edoardo La Greca - edoardo.lagreca@studio.unibo.it</li>\n" +
                      "<li>Francesca Lanzi - francesca.lanzi6@studio.unibo.it</li>\n" +
                      "<li>Pablo Sebastian Vargas Grateron - pablo.vargasgrateron@studio.unibo.it</li>\n" +
                    "</ul></html>");

            messagePanel.add(repositoryLabel);
            messagePanel.add(engineersLabel);
            JOptionPane.showMessageDialog(this, messagePanel, b4.getText(), JOptionPane.PLAIN_MESSAGE);
        });
        this.add(b4, c);

        c.insets = new Insets(pad/2, pad, pad, pad);
        c.gridx = 0;
        c.gridy = 5;

        var b5 = new JButton("Quit");
        b5.addActionListener(e -> {
            System.exit(0);
        });
        this.add(b5, c);
    }
}
