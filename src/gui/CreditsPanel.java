package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Panel to display the creators of the game.
 */
public class CreditsPanel extends JPanel{
    public CreditsPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // JLabel containing the hyperlink to the game's website.
        JLabel repositoryLabel = new JLabel(" GitHub repository", new ImageIcon("res/GitHub-Mark-32px.png"), SwingConstants.LEFT);
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
        // JLabel containing the creators' name and email.
        JLabel engineersLabel = new JLabel(
                "<html><br>Written by:<ul>\n" +
                        "<li>Emanuele Borghini - emanuele.borghini@studio.unibo.it</li>\n" +
                        "<li>Edoardo La Greca - edoardo.lagreca@studio.unibo.it</li>\n" +
                        "<li>Francesca Lanzi - francesca.lanzi6@studio.unibo.it</li>\n" +
                        "<li>Pablo Sebastian Vargas Grateron - pablo.vargasgrateron@studio.unibo.it</li>\n" +
                        "</ul></html>");

        this.add(repositoryLabel);
        this.add(engineersLabel);
    }
}
