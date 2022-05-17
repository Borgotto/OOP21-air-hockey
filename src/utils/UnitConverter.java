package utils;

import org.jbox2d.common.Vec2;

public class UnitConverter {

	public static Pair<Double,Double> MeterToPixel(final Vec2 posVector, final double delta) {
		double xPair = (double)(posVector.x*delta);
		double yPair = (double)(posVector.y*delta);
		Pair<Double,Double> posPair = new Pair<Double,Double>(xPair, yPair);
		return posPair;
	}
	
	public static Vec2 PixelToMeter(final Pair<Double,Double> posPair, final double delta) {
		float xVec = (float)(posPair.getX()/delta);
		float yVec = (float)(posPair.getY()/delta);
		Vec2 posVector = new Vec2(xVec, yVec);
		return posVector;
	}
	
}
