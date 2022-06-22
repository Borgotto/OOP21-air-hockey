package physics;

import logics.Arena;

/**
 * Interface that defines the physics body of an arena object.
 */
public interface ArenaBody extends RigidBody {
    /**
     * Get the {@link Arena} width.
     * @return The {@code Arena} width in meters.
     */
    float getWidth();

    /**
     * Get the {@link Arena} height.
     * @return The {@link Arena} height in meters.
     */
    float getHeight();

    /**
     * Get the {@link Arena} goal size.
     * @return The {@link Arena} goal size in meters.
     */
    float getGoalWidth();
}
