package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class MenuGui extends JFrame {
    private static final long serialVersionUID = 1L;

    public MenuGui(int size) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(9*size, 16*size);
        this.setTitle("Air Hockey");

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.9;
        c.weighty = 0.9;
        c.insets = new Insets(15,15,15,15);  //padding

        c.gridy = 0;
        var logoLabel = new JLabel("inserire immagine logo qua");
        panel.add(logoLabel, c);

        c.gridy = 1;
        var b1 = new JButton("New game");
        panel.add(b1, c);

        c.gridy = 2;
        var b2 = new JButton("Continue");
        b2.setEnabled(false);
        panel.add(b2, c);

        c.gridy = 3;
        var b3 = new JButton("Settings");
        panel.add(b3, c);

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
        panel.add(b4, c);

        c.gridy = 5;
        var b5 = new JButton("Quit");
        b5.addActionListener(e -> {
            System.exit(0);
        });
        panel.add(b5, c);

        this.getContentPane().add(panel);
        this.setVisible(true);
    }
}
