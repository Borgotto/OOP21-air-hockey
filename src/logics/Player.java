package logics;

/**
 * The abstract class Player contains the common fields and methods that can be found in any player of the game.
 * Instances of the Player class are equivalent to the mallet they control.
 */
public abstract class Player {
    protected int score = 0;
    protected int positionX;
    protected int positionY;
    protected final String name;

    /**
     * This is the default constructor of the Player subclasses. It creates a new player in the position (posX, posY) and gives it a name.
     * @param posX The player's position on the X-axis.
     * @param posY The player's position on the Y-axis.
     * @param name The player's name.
     */
    public Player(int posX, int posY, String name) {
        this.positionX = posX;
        this.positionY = posY;
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
    public int getPositionX() {
        return this.positionX;
    }

    /**
     * Get the current position on the Y-axis of the player.
     * @return The position on the Y-axis.
     */
    public int getPositionY() {
        return this.positionY;
    }

    /**
     * Move the player in the (x, y) position.
     * @param x The position on the X-axis.
     * @param y The position on the Y-axis.
     */
    public void move(int x, int y) {
        this.positionX = x;
        this.positionY = y;
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
