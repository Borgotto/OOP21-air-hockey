package physics;

import org.jbox2d.common.Vec2;

public interface PuckBody extends RigidBody {
    
    /**
     * @return the predicted position 1 second after the current position of the puck.
     */
    public Vec2 getNextPos();
    
    /**
     * @return the radius
     */
    public float getRadius();
    
}
