package utils;

import org.jbox2d.common.Vec2;

public class UnitConverter {
   
    public static double conversionFactor;

	public static Pair<Integer,Integer> MeterToPixel(final Vec2 posVector) {
		int xPair = (int)(posVector.x * conversionFactor);
		int yPair = (int)(posVector.y * conversionFactor);
		return new Pair<Integer,Integer>(xPair, yPair);
	}
	
	public Vec2 PixelToMeter(final Pair<Integer,Integer> posPair) {
		float xVec = (float)(posPair.getX() / conversionFactor);
		float yVec = (float)(posPair.getY() / conversionFactor);
		return new Vec2(xVec, yVec);
	}
	
	public void setConversionFactor(final double conversionFactor) {
	    UnitConverter.conversionFactor = conversionFactor;
	}
	
}
