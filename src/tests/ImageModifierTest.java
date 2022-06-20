package tests;

import utils.ImageModifier;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.assertEquals;

public class ImageModifierTest {
    private BufferedImage originalImg;

    @org.junit.Before
    public void initTest() {
        originalImg = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        originalImg.createGraphics();
    }

    @org.junit.Test
    public void testFit() {
        Image img = ImageModifier.fit(originalImg, new Dimension(200, 200));
        assertEquals(200, img.getWidth(null));
        assertEquals(200, img.getHeight(null));
    }

    @org.junit.Test
    public void testScale() {
        Image img = ImageModifier.scale(originalImg, new Dimension(100, 200));
        assertEquals(100, img.getWidth(null));
        assertEquals(100, img.getHeight(null));
    }

    @org.junit.Test
    public void testColor() {
        assertEquals(Color.BLACK, new Color(originalImg.getRGB(0, 0)));
        Image img = ImageModifier.color(originalImg, Color.BLUE);
        BufferedImage newImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = newImg.createGraphics();
        graphics.drawImage(img, 0, 0, null);
        assertEquals(Color.BLUE, new Color(newImg.getRGB(0, 0)));
    }
}
