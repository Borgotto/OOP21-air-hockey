package logics;

import utils.Pair;

/**
 * interface that extends {@link logics.GameObject} and adds the {@code nextPosition()}
 * method to calculate the next position the game object should have
 *
 */
public interface GameObjectWithPhysics extends GameObject {
    Pair<Double,Double> nextPosition();
}
