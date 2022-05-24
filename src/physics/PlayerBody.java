package physics;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

public class PlayerBody extends RigidBodyImpl {
	
	/**
	 * Player body generator
	 * @param radius
	 * @param pos Position to be spawned
	 * @param world
	 */
    public PlayerBody(final float radius, final Vec2 pos, final Physics2D physicsWorld) {
    	setWorld(world);
        setBodyTypeDef(BodyType.DYNAMIC);
        setLinearDampingDef(0.0f);
        setStartPositionDef(pos);
        configBodyDef();
        
        CircleShape shape = new CircleShape();
        shape.m_radius = radius;
        
        FixtureDef fixture = new FixtureDef();
        fixture.shape = shape;
        fixture.density = 0.4f;
        fixture.friction = 0.3f;
        
        // Bit mask for mid arena fixture collision
        fixture.filter.categoryBits = 0x0002;
        
        Body playerBody = physicsWorld.addRigidBody(this);
        playerBody.createFixture(fixture);
        setBody(playerBody);
    }
    
    // Methods only for Enemy IA
    
    /**
     * Apply a force to the player body.
     * @param force to be applied to the body.
     */
    public void applyForce(final Vec2 force) {
        getBody().applyForceToCenter(force);
    }
    
}
