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
     * @return the initial position of the GameObject
     */
    public Vec2 getStartingPosition();

    /**
     * Get the radius of the GameObject
     * @return the radius of the GameObject
     */
    public float getRadius();

    /**
     * @return the {@link physics.RigidBody} of the current {@code GameObjectWithPhysics}
     */
    public RigidBody getRigidBody();
    
}
