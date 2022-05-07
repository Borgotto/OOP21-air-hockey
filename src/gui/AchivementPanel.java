package gui;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;

public class AchivementPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final String IMAGE_PATH = "res/achivement.png";

	public AchivementPanel() {
		this.setName("Achivement!");
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

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
