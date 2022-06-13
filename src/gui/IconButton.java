package gui;

import utils.ImageModifier;

import javax.swing.*;
import java.awt.*;

/**
 * Class that creates a button with an icon and predetermined size.
 */
public class IconButton extends JButton {
    public IconButton(Image icon, Dimension size) {
        super();
        this.setPreferredSize(size);
        this.setIcon(new ImageIcon(ImageModifier.fit(icon, size)));
        this.setOpaque(false);
        this.setBorder(null);
        this.setContentAreaFilled(false);
        this.setFocusable(false);
    }

    public IconButton(Image icon) {
        this(icon, new Dimension(icon.getWidth(null), icon.getHeight(null)));
    }
}
