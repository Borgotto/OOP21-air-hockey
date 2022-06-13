package gui;

import utils.ImageModifier;

import javax.swing.*;
import java.awt.*;

/**
 * Class that creates a button with an icon and predetermined size.
 */
public class IconButton extends JButton {
    public IconButton(Image icon) {
        this(icon, new Dimension(icon.getWidth(null), icon.getHeight(null)));
    }

    public IconButton(Image icon, Dimension size) {
        super();
        setPreferredSize(size);
        setIcon(new ImageIcon(ImageModifier.fit(icon, size)));
        setOpaque(false);
        setBorder(null);
        setContentAreaFilled(false);
    }
}
