package utils;

import org.jbox2d.common.Vec2;

public class UnitConverter {

	public static Pair<Int,Int> MeterToPixel(final Vec2 posVector, final double delta) {
		int xPair = (int)(posVector.x*delta);
		int yPair = (int)(posVector.y*delta);
		Pair<Int,Int> posPair = new Pair<Int,Int>(xPair, yPair);
		return posPair;
	}
	
	public static Vec2 PixelToMeter(final Pair<Int,Int> posPair, final double delta) {
		float xVec = (float)(posPair.getX()/delta);
		float yVec = (float)(posPair.getY()/delta);
		Vec2 posVector = new Vec2(xVec, yVec);
		return posVector;
	}
	
}
