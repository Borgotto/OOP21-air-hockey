package utils;

import org.jbox2d.common.Vec2;

public class UnitConverter {
    
    private static final const double deltaConversion;
    
    public UnitConverter(double deltaConversion) {
        this.deltaConversion = deltaConversion;
    }
    
	public static Pair<Integer,Integer> MeterToPixel(final Vec2 posVector, final double delta) {
		int xPair = (int)(posVector.x*delta);
		int yPair = (int)(posVector.y*delta);
		Pair<Integer,Integer> posPair = new Pair<Integer,Integer>(xPair, yPair);
		return posPair;
	}
	
	public static Vec2 PixelToMeter(final Pair<Integer,Integer> posPair, final double delta) {
		float xVec = (float)(posPair.getX()/delta);
		float yVec = (float)(posPair.getY()/delta);
		Vec2 posVector = new Vec2(xVec, yVec);
		return posVector;
	}
	
}
