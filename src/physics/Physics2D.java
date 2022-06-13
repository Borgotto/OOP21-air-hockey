package physics;

import org.jbox2d.dynamics.World;

/**
 * Interface for a 2D physics world.
 */
public interface Physics2D {
    /**
     * Makes the physics world advance by one step.
     */
    void update();

    /**
     * Get the physics {@link World}.
     * @return the physics {@link World}.
     */
    World getWorld();

    /**
     * Add a RigidBody to the physics world.
     * @param rigidBody the RigidBody to add.
     */
    void addRigidBody(RigidBody rigidBody);

    /**
     * Reset the position of every RigidBody in the physics world to its initial position.
     */
    void resetWorld();

    /**
     * Remove all the {@link RigidBody} from the physics {@link World}.
     */
    void deleteAllBodies();
}
