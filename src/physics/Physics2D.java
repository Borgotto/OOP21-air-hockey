package physics;

import org.jbox2d.dynamics.World;

public interface Physics2D {
    
    public void update();
    
    public World getWorld();
    
    public void setWorld(World world);
    
    public void deleteWorld();
    
    public void resetWorld();
    
}
