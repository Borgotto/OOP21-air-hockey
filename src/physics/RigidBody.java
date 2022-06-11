package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

public interface RigidBody {
    /**
     * Get the body of the RigidBody
     * @return the body
     */
    public Body getBody();
    
    /**
     * @return the body position
     */
    public Vec2 getPosition();
    
    /**
     * set the body in a position and resets the speed of the object.
     * @param pos to set the object
     */
    public void setPosition(Vec2 pos);
    
    /**
     * reset the body position to the start position.
     */
    public void resetBodyPos();
}
