package physics;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

public class PlayerBodyImpl extends RigidBodyImpl implements PlayerBody {
	
	private static final float DENSITY_VALOR = 0.6f;
	private static final float FRICTION_VALOR = 0.8f;
	private static final float ENERGY_RESTITUTION = 0.8f;
	private static final float FILTER_RESTITUTION = 0.0f;
	private static final int PLAYER_BITMASK = 0x0002;
	private static final float FILTER_DISTANCE = 0.1f;
	private static final int GROUP_FILTER_INDEX = -2;

	
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

        Body playerBody = physicsWorld.getWorld().createBody(this.getBodyDef());
        physicsWorld.addRigidBody(this);
        playerBody.createFixture(this.generateCircleFixture(radius));
        playerBody.createFixture(this.generateMaskedCircleFixture(radius + FILTER_DISTANCE));
        
        this.setBody(playerBody);
    }
    
    public float getRadius() {
        return this.radius;
    }
    
    private FixtureDef generateCircleFixture(final float radius) {
    	CircleShape shape = new CircleShape();
        shape.m_radius = radius;
        
        FixtureDef fixture = new FixtureDef();
        fixture.shape = shape;
        fixture.density = DENSITY_VALOR;
        fixture.friction = FRICTION_VALOR;
        fixture.restitution = ENERGY_RESTITUTION;
        
        return fixture;
    }
    
    private FixtureDef generateMaskedCircleFixture(final float radius) {
    	CircleShape shape = new CircleShape();
        shape.m_radius = radius;
        
        FixtureDef fixture = new FixtureDef();
        fixture.shape = shape;
        fixture.density = DENSITY_VALOR;
        fixture.friction = FRICTION_VALOR;
        fixture.restitution = FILTER_RESTITUTION;
        fixture.filter.categoryBits = PLAYER_BITMASK;
        fixture.filter.groupIndex = GROUP_FILTER_INDEX;
        
        return fixture;
    }
    
}
