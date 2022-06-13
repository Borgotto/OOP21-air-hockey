package physics;

import org.jbox2d.common.Vec2;

/**
 * Interface that defines the physics body of a puck object.
 */
public interface PuckBody extends RigidBody {
    /**
     * Get the position where the {@code Puck} will be in the next physics step
     * @return the {@code Vec2} vector position
     */
    Vec2 getNextPos();

    /**
     * @return the radius of the puck body.
     */
    float getRadius();
}
