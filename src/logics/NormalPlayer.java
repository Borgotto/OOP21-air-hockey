package logics;

import utils.Pair;

/**
 * The class NormalPlayer represents a user-controlled player.
 */
public class NormalPlayer extends Player {
    /**
     * This is the constructor for NormalPlayer. It behaves pretty much the same as its superclass.
     * @param initialPosition The player's initial position.
     * @param name The player's name.
     */
    public NormalPlayer(Pair<Double,Double> initialPosition, String name) {
        super(initialPosition, name);
    }

    @Override
    public Pair<Double, Double> nextPosition() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setPosition(Pair<Double, Double> position) {
        // TODO Auto-generated method stub
    }

    @Override
    public Pair<Double, Double> getPosition() {
        // TODO Auto-generated method stub
        return null;
    }
}
