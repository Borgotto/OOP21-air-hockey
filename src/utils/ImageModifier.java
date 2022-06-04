package utils;

import java.awt.*;

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
}
