package utils;

import gui.ExceptionPanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Path;
import java.util.Optional;

/**
 * Load resources from the JAR file.
 */
public interface ResourceLoader {
    /**
     * Load a generic F file from the JAR file.
     * Currently supported:
     * - Images
     * @param resourcePath The resource name (with path).
     * @param fileType The file type.
     * @return The file as {@code fileType} class.
     */
    @SuppressWarnings("unchecked")
    public static <F> F load(Path resourcePath, Class<F> fileType) {
        File file = resourcePath.toFile();

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            switch (fileType.getName()) {
                case "java.awt.image.BufferedImage":
                    return (F) ImageIO.read(fileInputStream);
                default:
                    throw new IllegalArgumentException("Unsupported file type: " + fileType.getName());
            }
        } catch (IOException e) {
            new ExceptionPanel(e);
            return null;
        }
    }
}
