package physics;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

public class PuckBodyImpl extends RigidBodyImpl implements PuckBody {
	private static final float DENSITY_VALOR = 0.3f;
	private static final float FRICTION_VALOR = 0.6f;
	private static final int GROUP_FILTER_INDEX = -2;
	private static final float TIME_FACTOR = 1/60;
    private final float radius;
    
	/**
	 * Puck body generator.
	 * @param radius of the body
	 * @param pos Position to be spawned.
	 * @param physics World to be spawned in
	 */
    public PuckBodyImpl(final float radius, final Vec2 pos, final Physics2D physics) {
        this.radius = radius;

    	this.setBodyType(BodyType.DYNAMIC);
    	this.setStartPositionDef(pos);
    	this.configBodyDef();
        
        CircleShape shape = new CircleShape();
        shape.m_radius = getRadius();
        
        FixtureDef fixture = new FixtureDef();
        fixture.shape = shape;
        fixture.density = DENSITY_VALOR ;
        fixture.friction = FRICTION_VALOR;
        fixture.filter.groupIndex = GROUP_FILTER_INDEX;
        
        Body playerBody = physics.getWorld().createBody(this.getBodyDef());
        physics.addRigidBody(this);
        playerBody.createFixture(fixture);
        this.setBody(playerBody);
    }
    
    public Vec2 getNextPos() {
        return new Vec2(getBody().getLinearVelocity().x*TIME_FACTOR + this.getPosition().x, getBody().getLinearVelocity().y*TIME_FACTOR + this.getPosition().y);
    }

    public float getRadius() {
        return this.radius;
    } 
    
}
