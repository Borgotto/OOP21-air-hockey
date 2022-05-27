package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AchivementPanel extends AbstractGridBagLayoutJPanel {
	private static final long serialVersionUID = 1L;
	private static final String IMAGE_PATH = "res/achivement.png";

	public AchivementPanel() {
		super("Achievement");

		c.fill = GridBagConstraints.BOTH;

		c.gridx = 0;
		try {
			BufferedImage img = ImageIO.read(new File(IMAGE_PATH));
			ImageIcon icon = new ImageIcon(img);
			JLabel label = new JLabel(icon);
			JOptionPane.showMessageDialog(null, label);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		c.gridx = 1;
		var achivementMessage = new JLabel();
	}
}
