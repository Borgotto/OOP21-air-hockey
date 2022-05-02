package logics;

import utils.Pair;

/**
 * The abstract class Player contains the common fields and methods that can be found in any player of the game.
 * Instances of the Player class are equivalent to the mallet they control.
 */
public abstract class Player implements GameObjectWithPhysics {
    protected int score = 0;
    protected Pair<Double,Double> position;
    protected final String name;

    /**
     * This is the default constructor of the Player subclasses. It creates a new player in the position (posX, posY) and gives it a name.
     * @param initialPosition The player's initial position.
     * @param name The player's name.
     */
    public Player(Pair<Double,Double> initialPosition, String name) {
        this.position = initialPosition;
        this.name = name;
    }

    /**
     * Get the current score of the player.
     * @return The player's current score.
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Get the player name.
     * @return The player name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Score a point.
     */
    public void scorePoint() {
        this.score++;
    }
}
