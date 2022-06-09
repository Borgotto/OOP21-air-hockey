package physics;

import org.jbox2d.dynamics.World;

public interface Physics2D {
    
    public void update();
    
    public World getWorld();
    
    public void addRigidBody(RigidBody rigidBody);
    
    public void resetWorld();
    
    public void deleteAllBodies();
}
