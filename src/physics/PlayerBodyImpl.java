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
    	
        setWorld(physicsWorld.getWorld());
        setBodyType(BodyType.DYNAMIC);
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
        
        Body playerBody = physicsWorld.getWorld().createBody(getBodyDef());
        physicsWorld.addRigidBody(this);
        playerBody.createFixture(fixture);
        setBody(playerBody);
    }

    /**
     * Apply a force to the player body.
     * @param force to be applied to the body.
     */
    @Override
    public void updateSpeedVec(final Vec2 force) {
        getBody().applyForceToCenter(force);
    }
    
    /**
     * @return the radius
     */
    @Override
    public float getRadius() {
        return radius;
    }
    
}
