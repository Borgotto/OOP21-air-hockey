package gui;

import utils.ImageModifier;

import javax.swing.*;
import java.awt.*;

public class IconButton extends JButton {
    public IconButton(Image icon) {
        this(icon, new Dimension(icon.getWidth(null), icon.getHeight(null)));
    }

    public IconButton(Image icon, Dimension size) {
        super();
        setSize(size);
        setIcon(new ImageIcon(ImageModifier.fit(icon, size)));
        setOpaque(false);
        setBorder(null);
        setContentAreaFilled(false);
    }
}
