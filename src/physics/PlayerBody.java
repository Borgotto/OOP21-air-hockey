package physics;

import org.jbox2d.common.Vec2;

public interface PlayerBody extends RigidBody {
    
    public void updateSpeedVec(final Vec2 force);
    
    public float getRadius();
    
}
