package logics;

import utils.Pair;

/**
 * The objects of the Arena class represent specific arenas the player can play in.
 */
public class Arena implements GameObject{
    private final double width;
    private final double height;
    private final double friction;
    private final double goalWidth;

    /**
     * Create a new Arena with a certain width, height, friction and goal size.
     * @param width The new arena's height.
     * @param height The new arena's width.
     * @param friction The new arena's friction.
     * @param goalWidth The new arena's goal size.
     */
    public Arena(double width, double height, double friction, double goalWidth) {
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
    public Arena(double width, double height, double friction) {
        this(width, height, friction, width / 3);
    }

    /**
     * Create a new Arena with a certain width and height.
     * The default value for friction is 1.0.
     * @param width The new arena's width.
     * @param height The new arena's height.
     */
    public Arena(double width, double height) {
        this(width, height, 1.0);
    }

    /**
     * Get the arena's width.
     * @return The arena's width.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Get the arena's height.
     * @return The arena's height.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Get the arena's friction.
     * @return The arena's friction.
     */
    public double getFriction() {
        return this.friction;
    }

    /**
     * Get the arena's goal size.
     * @return The arena's goal size.
     */
    public double getgoalWidth() {
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
