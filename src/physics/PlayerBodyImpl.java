package physics;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

public class PlayerBodyImpl extends RigidBodyImpl implements PlayerBody {
	
    private final float radius;
    
	/**
	 * Player body generator
	 * @param radius of the body
	 * @param pos Position to be spawned
	 * @param physicsWorld World to be spawned in
	 */
    public PlayerBodyImpl(final float radius, final Vec2 pos, final Physics2D physicsWorld) {
    	this.radius = radius;
    	
        this.setBodyType(BodyType.DYNAMIC);
        this.setLinearDampingDef(4.0f);
        this.setStartPositionDef(pos);
        this.configBodyDef();
        
        CircleShape shape = new CircleShape();
        shape.m_radius = radius;
        
        FixtureDef fixture = new FixtureDef();
        fixture.shape = shape;
        fixture.density = 10.0f;
        fixture.friction = 1.0f;
        fixture.restitution = 0.6f;
        
        // Bit mask for mid arena fixture collision
        fixture.filter.categoryBits = 0x0002;
        
        Body playerBody = physicsWorld.getWorld().createBody(getBodyDef());
        physicsWorld.addRigidBody(this);
        playerBody.createFixture(fixture);
        this.setBody(playerBody);
    }

    public void updateSpeedVec(final Vec2 force) {
        this.getBody().applyForceToCenter(force);
    }
    
    public float getRadius() {
        return this.radius;
    }
    
}
