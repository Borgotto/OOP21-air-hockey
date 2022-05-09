package logics;

import utils.Pair;

/**
 * The Puck class represents the gaming puck.
 */
public class Puck implements GameObjectWithPhysics {
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

    @Override
    public boolean update() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setPosition(Pair<Double, Double> position) {
        this.position = position;
    }

    @Override
    public Pair<Double, Double> nextPosition() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean canMove() {
        // TODO Auto-generated method stub
        return false;
    }
}
