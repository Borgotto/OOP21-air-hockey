package physics;

import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

public interface Physics2D {
    
    public void update();
    
    public World getWorld();
    
    public Body addRigidBody(RigidBodyImpl rigidBody);
    
    public void resetWorld();
    
    public void deleteAllBodies();
}
