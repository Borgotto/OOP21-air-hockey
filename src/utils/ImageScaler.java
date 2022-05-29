package utils;

import java.awt.*;

public class ImageScaler {
    public static Image scale(Image img, Dimension dim) {
        return img.getScaledInstance((int) dim.getWidth(), (int) (dim.getHeight()), Image.SCALE_DEFAULT);
    }
}
