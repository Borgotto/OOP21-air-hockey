package logics;

import physics.RigidBody;

/**
 * interface that extends {@link logics.GameObject} and adds physics related
 * methods to the GameObject
 *
 */
public interface GameObjectWithPhysics extends GameObject, RigidBody {
    
}
