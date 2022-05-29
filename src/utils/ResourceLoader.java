package utils;

import gui.ExceptionPanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Load resources from the JAR file.
 */
public class ResourceLoader {
    /**
     * Load an image from the JAR file.
     * @param resourceName The resource name (without path).
     * @return The image as a BufferedImage.
     */
    public static BufferedImage loadImage(String resourceName) {
        BufferedImage img;

        try {
            img = ImageIO.read(new FileInputStream("res/" + resourceName));
        } catch (IOException e) {
            new ExceptionPanel(e);

            // this won't be executed anyway
            img = new BufferedImage(0, 0, BufferedImage.TYPE_INT_RGB);
        }

        return img;
    }
}
