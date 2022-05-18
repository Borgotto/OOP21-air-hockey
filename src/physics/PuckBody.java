package physics;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class PuckBody extends RigidBodyImpl {
	
	/**
	 * Puck body generator.
	 * @param radius
	 * @param pos Position to be spawned.
	 * @param friction The puck friction in the game.
	 * @param world
	 */
    public PuckBody(float radius, Vec2 pos, float friction, World world) {
    	setWorld(world);
        setBodyTypeDef(BodyType.DYNAMIC);
        setPositionDef(pos);
        setLinearDampingDef(0.0f);
        configBodyDef();
        
        CircleShape shape = new CircleShape();
        shape.m_radius = radius;
        
        FixtureDef fixture = new FixtureDef();
        fixture.shape = shape;
        fixture.density = 1.0f;
        fixture.friction = friction;
        
        Body playerBody = world.createBody(getBodyDef());
        playerBody.createFixture(fixture);
        setBody(playerBody);
    }
    
}
