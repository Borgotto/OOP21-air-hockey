package physics;

import org.jbox2d.common.Vec2;

public interface PlayerBody extends RigidBody {
    
    /**
     * Apply a force to the player body.
     * @param force to be applied to the body.
     */
    public void updateSpeedVec(final Vec2 force);
    
    /**
     * @return the radius
     */
    public float getRadius();
}
