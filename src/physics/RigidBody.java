package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

public interface RigidBody {
    
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
	 * @return the world
	 */
    public World getWorld();
    
    /**
     * @return the body
     */
    public Body getBody();
    
    /**
     * reset the body position to the start position.
     */
    public void resetBodyPos();
    
}
