package utils;

import org.jbox2d.common.Vec2;
import java.awt.Dimension;

public class UnitConverter {
   
    public static double conversionFactor;

	public static Dimension MeterToPixel(final Vec2 pos) {
		int width = (int)(pos.x * conversionFactor);
		int height = (int)(pos.y * conversionFactor);
		return new Dimension(width, height);
	}
	
	public static Vec2 PixelToMeter(final Dimension pos) {
		float xVec = (float)(pos.getWidth() / conversionFactor);
		float yVec = (float)(pos.getHeight() / conversionFactor);
		return new Vec2(xVec, yVec);
	}
	
	public static void setConversionFactor(final double conversionFactor) {
	    UnitConverter.conversionFactor = conversionFactor;
	}
	
}
