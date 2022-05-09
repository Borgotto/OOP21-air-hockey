package logics;

import utils.Pair;

/**
 * interface that extends {@link logics.GameObject} and adds physics related
 * methods to the GameObject
 *
 */
public interface GameObjectWithPhysics extends GameObject {
    boolean canMove();
    
    Pair<Double,Double> nextPosition();
    
    void setPosition(Pair<Double, Double> position);
    
    Pair<Double, Double> getPosition();
}
