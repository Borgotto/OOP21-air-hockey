package logics;

import org.jbox2d.common.Vec2;
import physics.RigidBody;

/**
 * interface that extends {@link logics.GameObject} and adds physics related
 * methods to the GameObject
 *
 */
public interface GameObjectWithPhysics extends GameObject, RigidBody {

    /**
     * Get the initial position of the GameObject
     * @return The initial position of the GameObject.
     */
    Vec2 getStartingPosition();
}
