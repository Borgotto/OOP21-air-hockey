package physics;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class PlayerBody extends RigidBody {
	
	/**
	 * Player body generator
	 * @param radius
	 * @param pos Position to be spawned
	 * @param world
	 */
        
    public PlayerBody(float radius, Vec2 pos, World world) {
    	setWorld(world);
        setBodyType(BodyType.KINEMATIC);
        setPosition(pos);
        setLinearDamping(0.1f);
        configBodyDef();
        
        CircleShape shape = new CircleShape();
        shape.m_radius = radius;
        
        FixtureDef fixture = new FixtureDef();
        fixture.shape = shape;
        fixture.density = 0.4f;
        
        Body playerBody = world.createBody(getBodyDef());
        playerBody.createFixture(fixture);
        setBody(playerBody);
    }
    
}
