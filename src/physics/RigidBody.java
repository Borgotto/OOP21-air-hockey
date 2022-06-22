package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

/**
 * Interface describing a rigid body.
 * It is a wrapper around the JBox2D body with added functionalities.
 */
public interface RigidBody {
    /**
     * Get the body of the RigidBody
     * @return The {@link Body}.
     */
    Body getBody();
    
    /**
     * @return The {@link Body} position.
     */
    Vec2 getPosition();
    
    /**
     * set the body in a position and resets the speed of the object.
     * @param pos The position to set the object to.
     */
    void setPosition(Vec2 pos);
    
    /**
     * Reset the body position to the start position.
     */
    void resetBodyPos();
}
