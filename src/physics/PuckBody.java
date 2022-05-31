package physics;

import org.jbox2d.common.Vec2;

public interface PuckBody extends RigidBody {
    
    public Vec2 getNextPos();
    
    public float getRadius();
    
}
