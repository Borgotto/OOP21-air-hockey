package logics;

/**
 * The abstract class Player contains the common fields and methods that can be found in any player of the game.
 * Instances of the Player class are equivalent to the mallet they control.
 */
public interface Player extends GameObjectWithPhysics {

    /**
     * Returns the name of the player or an empty string if not set.
     * @return the string containing the name of the player
     */
    String getName();

    /**
     * Get the current score of the player.
     * @return The player's current score.
     */
    Integer getScore();

    /**
     * Set the current score of the player.
     * @param score The player's desired score.
     */
    void setScore(Integer score);

    /**
     * Score a point.
     */
    void scorePoint();
}
