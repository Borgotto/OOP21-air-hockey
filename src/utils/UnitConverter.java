package utils;

import org.jbox2d.common.Vec2;

public class UnitConverter {
   
    private static double deltaConversion = 1.0;

	public static Pair<Integer,Integer> MeterToPixel(final Vec2 posVector) {
		int xPair = (int)(posVector.x*deltaConversion);
		int yPair = (int)(posVector.y*deltaConversion);
		Pair<Integer,Integer> posPair = new Pair<Integer,Integer>(xPair, yPair);
		return posPair;
	}
	
	public static Vec2 PixelToMeter(final Pair<Integer,Integer> posPair) {
		float xVec = (float)(posPair.getX()/deltaConversion);
		float yVec = (float)(posPair.getY()/deltaConversion);
		Vec2 posVector = new Vec2(xVec, yVec);
		return posVector;
	}
	
	public static void setDeltaConversion(double constant) {
	    deltaConversion = constant;
	}
	
	public static double getDeltaConversion() {
	    return deltaConversion;
	}
	
}
