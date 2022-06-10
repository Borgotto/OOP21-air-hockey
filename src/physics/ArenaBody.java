package physics;

public interface ArenaBody extends RigidBody {
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

    /**
     * Get the {@code Arena} goal size.
     * @return the {@code Arena} goal size in meters.
     */
    public float getGoalWidth();
}
