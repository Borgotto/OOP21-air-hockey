package gui;

import utils.JPanelLoader;
import utils.ResourceLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MenuPanel extends AbstractGridBagLayoutJPanel {
    private static final long serialVersionUID = 1L;

    public MenuPanel() {
        super("Air Hockey");
     
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.9;
        c.weighty = 0.9;
        c.insets = new Insets(15,15,15,15);  //padding

        c.gridy = 0;
        var logoLabel = new JLabel(new ImageIcon(ResourceLoader.loadImage("airhockey_logo.png")));
        this.add(logoLabel, c);

        c.gridy = 1;
        var b1 = new JButton("New game");
        b1.addActionListener(e -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

            try {
                JPanelLoader.load(parentFrame, new GamePanel());
            } catch (IOException ex) {
                new ExceptionPanel(ex);
            }
        });
        this.add(b1, c);

        c.gridy = 2;
        var b2 = new JButton("Continue");
        b2.setEnabled(false);
        this.add(b2, c);

        c.gridy = 3;
        var b3 = new JButton("Settings");
        b3.addActionListener(e -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            JPanelLoader.load(parentFrame, new SettingsPanel());
        });
        this.add(b3, c);

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

        c.gridy = 5;
        var b5 = new JButton("Quit");
        b5.addActionListener(e -> {
            System.exit(0);
        });
        this.add(b5, c);
    }
}
