package utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class ImageModifier {
    public static Image fit(Image img, Dimension dim) {
        return img.getScaledInstance((int) dim.getWidth(), (int) (dim.getHeight()), Image.SCALE_SMOOTH);
    }

    public static Image scale(Image img, Dimension bounds) {
        double ratio = Math.min(bounds.getWidth() / img.getWidth(null),
                                bounds.getHeight() / img.getHeight(null));

        return ImageModifier.fit(img, new Dimension((int) (img.getWidth(null) * ratio),
                                                  (int) (img.getHeight(null) * ratio)));
    }

    public static Image color(Image img, Color color) {
        // Create a copy of the image
        BufferedImage newImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = newImg.createGraphics();
        graphics.drawImage(img, 0, 0, null);
        // Change every pixel to the specified color
        WritableRaster raster = newImg.getRaster();
        for (int x = 0; x < newImg.getWidth(); x++) {
            for (int y = 0; y < newImg.getHeight(); y++) {
                int[] pixel = raster.getPixel(x, y, (int[]) null);
                pixel[0] = (int) (pixel[0] * (1-color.getAlpha()/255d) + color.getRed() * (color.getAlpha()/255d));
                pixel[1] = (int) (pixel[1] * (1-color.getAlpha()/255d) + color.getGreen() * (color.getAlpha()/255d));
                pixel[2] = (int) (pixel[2] * (1-color.getAlpha()/255d) + color.getBlue() * (color.getAlpha()/255d));
                raster.setPixel(x, y, pixel);
            }
        }
        return newImg;
    }
}
