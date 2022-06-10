package physics;

import org.jbox2d.common.Vec2;

public interface PuckBody extends RigidBody {

    /**
     * Get the position where the {@code Puck} will be in the next game loop frame
     * @return the {@code Vec2} vector position
     */
    public Vec2 getNextPos();
    
    /**
     * @return the radius
     */
    public float getRadius();
    
}
