package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

public interface RigidBody {
        
    public Vec2 getPosition();
    
    public void setPosition(Vec2 pos);
    
    public World getWorld();
    
    public void setWorld(World world);
    
    public Body getBody();
    
    public void setBody(Body body);
    
    public void resetBodyPos();
    
}
