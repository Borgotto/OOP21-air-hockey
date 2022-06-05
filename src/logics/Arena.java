package logics;

/**
 * Interface that defines Arena specifics
 */
public interface Arena extends GameObjectWithPhysics {
    
    /**
     * Get the {@code Arena} goal size.
     * @return the {@code Arena} goal size in meters.
     */
    public float getGoalWidth();

    /**
     * Set the {@code Arena} goal size.
     * @param goalWidth the {@code Arena} goal size in meters.
     */
    public void setGoalWidth(float goalWidth);

    /**
     * Get the {@code Arena} width.
     * @return the {@code Arena} width in meters.
     */
    public float getWidth();

    /**
     * Get the {@code Arena} height.
     * @return the {@code Arena} height in meters.
     */
    public float getHeight();
}
