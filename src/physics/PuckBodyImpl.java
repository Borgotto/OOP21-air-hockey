package physics;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

public class PuckBodyImpl extends RigidBodyImpl implements PuckBody {
	
    private final float radius;
    
	/**
	 * Puck body generator.
	 * @param radius
	 * @param pos Position to be spawned.
	 * @param friction The puck friction in the game.
	 * @param world
	 */
    public PuckBodyImpl(final float radius, final Vec2 pos, final Physics2D physicsWorld) {
        this.radius = radius;
        
    	setWorld(world);
        setBodyType(BodyType.DYNAMIC);
        setStartPositionDef(pos);
        setLinearDampingDef(0.1f);
        configBodyDef();
        
        CircleShape shape = new CircleShape();
        shape.m_radius = getRadius();
        
        FixtureDef fixture = new FixtureDef();
        fixture.shape = shape;
        fixture.density = 1.0f;
        fixture.restitution = 1.0f;
        
        Body playerBody = physicsWorld.addRigidBody(this);
        playerBody.createFixture(fixture);
        setBody(playerBody);
    }
    
    // Methods only for Enemy IA
    
    /**
     * @return the predicted position 1 second after the current position of the puck.
     */
    public Vec2 getNextPos() {
        return new Vec2(getBody().getLinearVelocity().x + getPosition().x, getBody().getLinearVelocity().y + getPosition().y);
    }

    /**
     * @return the radius
     */
    public float getRadius() {
        return radius;
    } 
    
}
