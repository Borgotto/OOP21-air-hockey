package physics;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

public class PlayerBodyImpl extends RigidBodyImpl implements PlayerBody {
	
	private static final float DENSITY_VALOR = 0.6f;
	private static final float FRICTION_VALOR = 0.8f;
	private static final float ENERGY_RESTITUTION = 0.7f;
	private static final int MIDARENA_BITMASK = 0x0002;

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
        this.setStartPositionDef(pos);
        this.configBodyDef();
        
        CircleShape shape = new CircleShape();
        shape.m_radius = radius;
        
        FixtureDef fixture = new FixtureDef();
        fixture.shape = shape;
        fixture.density = DENSITY_VALOR;
        fixture.friction = FRICTION_VALOR;
        fixture.restitution = ENERGY_RESTITUTION;
        
        // Bit mask for mid arena fixture collision
        fixture.filter.categoryBits = MIDARENA_BITMASK;
        
        Body playerBody = physicsWorld.getWorld().createBody(this.getBodyDef());
        physicsWorld.addRigidBody(this);
        playerBody.createFixture(fixture);
        this.setBody(playerBody);
    }
    
    public float getRadius() {
        return this.radius;
    }
    
}
