package utils;

import org.jbox2d.common.Vec2;

public class UnitConverter {
   
    private double conversionFactor;
    
    public UnitConverter() {
        this.conversionFactor = 1.0;
    }
    
    public UnitConverter(final double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

	public Pair<Integer,Integer> MeterToPixel(final Vec2 posVector) {
		int xPair = (int)(posVector.x*this.conversionFactor);
		int yPair = (int)(posVector.y*this.conversionFactor);
		Pair<Integer,Integer> posPair = new Pair<Integer,Integer>(xPair, yPair);
		return posPair;
	}
	
	public Vec2 PixelToMeter(final Pair<Integer,Integer> posPair) {
		float xVec = (float)(posPair.getX()/this.conversionFactor);
		float yVec = (float)(posPair.getY()/this.conversionFactor);
		Vec2 posVector = new Vec2(xVec, yVec);
		return posVector;
	}
	
	public void setConversionFactor(final double conversionFactor) {
	    this.conversionFactor = conversionFactor;
	}
	
}
