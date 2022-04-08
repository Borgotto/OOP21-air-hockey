package logics;

import physics.Position;

/**
 * The abstract class Player contains the common fields and methods that can be found in any player of the game.
 * Instances of the Player class are equivalent to the mallet they control.
 */
public abstract class Player {
    protected int score = 0;
    protected Position previousPosition;
    protected Position currentPosition;
    protected final String name;

    /**
     * This is the default constructor of the Player subclasses. It creates a new player in the position (posX, posY) and gives it a name.
     * @param initialPosition The player's initial position.
     * @param name The player's name.
     */
    public Player(Position initialPosition, String name) {
        this.currentPosition = initialPosition;
        this.previousPosition = initialPosition;
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
     * Get the current position on the X-axis of the player.
     * @return The position on the X-axis.
     */
    public double getPositionX() {
        return this.currentPosition.getXPos();
    }

    /**
     * Get the current position on the Y-axis of the player.
     * @return The position on the Y-axis.
     */
    public double getPositionY() {
        return this.currentPosition.getYPos();
    }

    /**
     * Move the player in the (x, y) position.
     * @param newPosition The next position of the player.
     */
    public void move(Position newPosition) {
        this.previousPosition = this.currentPosition;
        this.currentPosition = newPosition;
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
