package logics;

import utils.Pair;

/**
 * The objects of the Arena class represent specific arenas the player can play in.
 */
public class Arena implements GameObject{
    private final Double width;
    private final Double height;
    private final Double friction;
    private final Double goalWidth;

    /**
     * Create a new Arena with a certain width, height, friction and goal size.
     * @param width The new arena's height.
     * @param height The new arena's width.
     * @param friction The new arena's friction.
     * @param goalWidth The new arena's goal size.
     */
    public Arena(Double width, Double height, Double friction, Double goalWidth) {
        this.width = width;
        this.height = height;
        this.friction = friction;
        this.goalWidth = goalWidth;
    }

    /**
     * Create a new Arena with a certain width, height and friction.
     * The size of the goal is proportional to the size of the Arena.
     * @param width The new arena's height.
     * @param height The new arena's width.
     * @param friction The new arena's friction.
     */
    public Arena(Double width, Double height, Double friction) {
        this(width, height, friction, width / 3);
    }

    /**
     * Create a new Arena with a certain width and height.
     * The default value for friction is 1.0.
     * @param width The new arena's width.
     * @param height The new arena's height.
     */
    public Arena(Double width, Double height) {
        this(width, height, 1.0);
    }

    /**
     * Get the arena's width.
     * @return The arena's width.
     */
    public Double getWidth() {
        return this.width;
    }

    /**
     * Get the arena's height.
     * @return The arena's height.
     */
    public Double getHeight() {
        return this.height;
    }

    /**
     * Get the arena's friction.
     * @return The arena's friction.
     */
    public Double getFriction() {
        return this.friction;
    }

    /**
     * Get the arena's goal size.
     * @return The arena's goal size.
     */
    public Double getgoalWidth() {
        return this.goalWidth;
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
