package physics;

/**
 * Interface that defines the physics body of a player object.
 */
public interface PlayerBody extends RigidBody {
    /**
     * @return The radius of the player body.
     */
    float getRadius();
}
