package physics;

/**
 * Interface that defines the physics body of an arena object.
 */
public interface ArenaBody extends RigidBody {
    /**
     * Get the {@code Arena} width.
     * @return the {@code Arena} width in meters.
     */
    float getWidth();

    /**
     * Get the {@code Arena} height.
     * @return the {@code Arena} height in meters.
     */
    float getHeight();

    /**
     * Get the {@code Arena} goal size.
     * @return the {@code Arena} goal size in meters.
     */
    float getGoalWidth();
}
