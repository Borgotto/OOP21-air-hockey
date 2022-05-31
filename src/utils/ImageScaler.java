package utils;

import java.awt.*;

public class ImageScaler {
    public static Image fit(Image img, Dimension dim) {
        return img.getScaledInstance((int) dim.getWidth(), (int) (dim.getHeight()), Image.SCALE_DEFAULT);
    }

    public static Image scale(Image img, Dimension bounds) {
        Dimension imgDim = new Dimension(img.getWidth(null), img.getHeight(null));
        Dimension newDim = new Dimension(imgDim.width, imgDim.height);

        // Scale the image dimension to fit the bounds width
        if (imgDim.getWidth() > bounds.getWidth()) {
            newDim.setSize(bounds.getWidth(), (bounds.getWidth()*imgDim.getHeight())/imgDim.getWidth());
        }

        // Scale the image dimension to fit the bounds height
        if (newDim.getHeight() > bounds.getHeight()) {
            newDim.setSize((bounds.getHeight()*imgDim.getWidth())/imgDim.getHeight(), bounds.getHeight());
        }

        // fit the image to the new dimensions
        return ImageScaler.fit(img, newDim);
    }
}
