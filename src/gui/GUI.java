package gui;

import logics.Settings;
import utils.ImageModifier;
import utils.JComponentLoader;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Main class to start the GUI process.
 */
public class GUI extends JFrame {
    /**
     * Initializes and shows the main menu JPanel.
     */
    public GUI() {
        // Try to set the custom font and LookAndFeel, if it fails, use the default one
        try {
            Font font = font = Font.createFont(Font.TRUETYPE_FONT, new File("res/aerial.ttf"));
            GUI.setFont(new FontUIResource(font.deriveFont(Font.PLAIN, 14)));
        } catch (FontFormatException | IOException e) {
            GUI.setFont(new FontUIResource("arial", Font.BOLD, 16));
        }
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException |InstantiationException|IllegalAccessException|UnsupportedLookAndFeelException e) {
            // Do nothing
        }
        JComponentLoader.load(this, new MenuPanel()); // Loads the main menu
        this.setLocationRelativeTo(null); // Center the window on the screen
        Color iconColor = new Settings().load().getTheme().getColor();
        Image icon = ImageModifier.color(new ImageIcon("res/airhockey_ico.png").getImage(), iconColor);
        this.setIconImage(icon);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
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
