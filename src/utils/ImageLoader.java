package utils;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * A utility class to load images.
 */
public class ImageLoader {
    /**
     * Loads an image from a file.
     * @param path The file path of the image, starting from the "res" directory.
     * @return The image.
     */
    public static Image load(String path) {
        URL url = ImageLoader.class.getResource("/res/" + path);
        assert url != null;
        return new ImageIcon(url).getImage();
    }
}
