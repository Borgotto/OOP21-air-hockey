package logics;

import utils.Pair;

/**
 * The Puck class represents the gaming puck.
 */
public class Puck {
private Pair<Double, Double> position;
	
	public Puck(Pair<Double, Double> position) {
		this.position=position;
	}
	
	public Pair<Double, Double> getPosition() {
		return this.position;
	}
	
	public void move(Pair<Double,Double> newPosition) {
        this.position = newPosition;
	}
}
