package physics;

import org.jbox2d.common.Vec2;

public interface PlayerBody extends RigidBody {
    
    /**
     * @return the radius
     */
    public float getRadius();
}
