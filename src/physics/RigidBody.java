package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.World;

public interface RigidBody {
    
    public void configBodyDef();
    
    public Vec2 getPosition();
    
    public void setPosition(Vec2 pos);
    
    public World getWorld();
    
    public void setWorld(World world);
    
    public BodyType getBodyTypeDef();
    
    public void setBodyTypeDef(BodyType bodyTypeDef);
    
    public Vec2 getPositionDef();
    
    public void setPositionDef(Vec2 positionDef);
    
    public float getLinearDampingDef();
    
    public void setLinearDampingDef(float linearDampingDef);
    
    public BodyDef getBodyDef();
    
    public void setBodyDef(BodyDef bodyDef);
    
    public Body getBody();
    
    public void setBody(Body body);
    
}
