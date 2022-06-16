package utils;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * A utility class to load images.
 */
public class ResourceLoader {
    /**
     * The directory where the resources are stored. The root directory is the JAR archive's root.
     */
    public static String resourcePath = "/res/";

    /**
     * Load an image from a file.
     * @param path The file path of the image, starting from the "res" directory.
     * @return The image.
     */
    public static Image loadImage(String path) {
        URL url = ResourceLoader.class.getResource(resourcePath + path);
        assert url != null;
        return new ImageIcon(url).getImage();
    }

    /**
     * Load a font from a file.
     * @param path The file path of the font, starting from the "res" directory.
     * @return The font.
     */
    public static Font loadFont(String path) {
        InputStream inputStream = ResourceLoader.class.getResourceAsStream(resourcePath + path);
        assert inputStream != null;
        Font font;

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
        } catch (FontFormatException | IOException e) {
            font = new Font("arial", Font.BOLD, 16);
        }

        return font;
    }
}
