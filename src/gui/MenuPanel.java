package gui;

import logics.GameState;
import logics.GameStateBuilder;
import utils.ImageModifier;
import utils.JComponentLoader;
import utils.ObjectSerializer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;

public class MenuPanel extends AbstractGridBagLayoutJComponent {
    public MenuPanel() {
        super("Air Hockey", new Dimension(GUI.getMinScreenSize()*9/16, GUI.getMinScreenSize()));
        int pad = this.getPreferredSize().width/40;
        c.insets = new Insets(pad, pad, pad/2, pad);
        c.gridx = 0;
        c.gridy = 0;

        // Adjust the logo image size based on the panel size
        Dimension logoDimension = new Dimension(this.getPreferredSize().width-2*pad, this.getPreferredSize().height-2*pad);
        Image logoImage = ImageModifier.scale(new ImageIcon("res/airhockey_logo.png").getImage(), logoDimension);
        // Add the logo image
        JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
        this.add(logoLabel, c);
        c.insets = new Insets(pad/2, pad, pad/2, pad);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 1;
        // New game button
        var b1 = new JButton("New game");
        b1.addActionListener(e -> {
            GamePanel gamePanel = new GamePanel(new GameStateBuilder().build());
            JFrame parent = JComponentLoader.getParentFrame(this);
            JComponentLoader.load(parent, gamePanel);
            gamePanel.startGame();
        });
        this.add(b1, c);
        c.gridx = 0;
        c.gridy = 2;
        // Continue game button
        var b2 = new JButton("Continue");
        b2.setEnabled(Files.exists(GameState.savePath));
        b2.addActionListener(e -> {
            try {
                GameState game = new GameStateBuilder().build();
                game.load(ObjectSerializer.deserialize(GameState.savePath));
                GamePanel gamePanel = new GamePanel(game);
                JFrame parent = JComponentLoader.getParentFrame(this);
                JComponentLoader.load(parent, gamePanel);
                gamePanel.startGame();
            } catch (IOException | ClassNotFoundException ex) {
                new ExceptionPanel(ex,"Failed to load the game");
            }
        });
        this.add(b2, c);
        c.gridx = 0;
        c.gridy = 3;
        // Settings button
        var b3 = new JButton("Settings");
        b3.addActionListener(e -> {
            JFrame parent = JComponentLoader.getParentFrame(this);
            JComponentLoader.load(parent, new SettingsPanel());
        });
        this.add(b3, c);
        c.gridx = 0;
        c.gridy = 4;
        // Credits button
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
        // Exit button
        var b5 = new JButton("Quit");
        b5.addActionListener(e -> {
            System.exit(0);
        });
        this.add(b5, c);
    }
}
