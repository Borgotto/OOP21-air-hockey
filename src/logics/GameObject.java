package logics;

import utils.Pair;

/**
 * interface that defines a game object that needs its state to be updated every
 * frame
 */
public interface GameObject {
    boolean update();
    
    void setPosition(Pair<Double, Double> position);
    
    Pair<Double, Double> getPosition();
}
