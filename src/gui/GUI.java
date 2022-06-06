package gui;

import utils.JComponentLoader;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

/**
 * Main class to start the GUI process.
 */
public class GUI extends JFrame {
    /**
     * Initializes and shows the main menu JPanel.
     */
    public GUI() {
        GUI.setFont(new FontUIResource(new Font("Arial", Font.PLAIN, 14)));

        JComponentLoader.load(this, new MenuPanel());

        this.setIconImage(new ImageIcon("res/airhockey_ico.png").getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Method used to get the screen dimensions.
     * @return the size of the screen in pixels.
     */
    public static Dimension getScreenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    /**
     * Method used to get minimum safe screen dimension that's visible on the screen.
     * @return the minimum safe screen dimension.
     */
    public static int getMinScreenSize() {
        final Dimension screenSize = GUI.getScreenSize();
        return Math.min(screenSize.width, screenSize.height) * 8/10;
    }

    /**
     * Method used to set the font for all components.
     * @param f the font to set.
     */
    public static void setFont (FontUIResource f){
        UIManager.getDefaults().keys().asIterator().forEachRemaining(key -> {
            if (UIManager.get(key) instanceof FontUIResource) {
                UIManager.put(key, f);
            }
        });
    }
}
