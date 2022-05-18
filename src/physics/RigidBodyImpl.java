package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.World;

public abstract class RigidBodyImpl implements RigidBody {
	
	World world;
    
    BodyType bodyTypeDef = BodyType.STATIC;
    private Vec2 positionDef = new Vec2(0.0f, 0.0f);
    private float linearDampingDef = 0.0f;
   
    private BodyDef bodyDef = new BodyDef();
    private Body body;
    
    /**
     * set the BodyDef data
     */
    public void configBodyDef() {
        bodyDef.type = getBodyTypeDef();
        bodyDef.position.set(getPositionDef());
        bodyDef.linearDamping = getLinearDampingDef();
        bodyDef.angularDamping = 0.0f;
        bodyDef.gravityScale = 0.0f;
        bodyDef.fixedRotation = true;
        bodyDef.angle = 0.0f;
        bodyDef.bullet = true;
        bodyDef.active = true;
        bodyDef.allowSleep = false;
    }
    
    /**
     * @return the body position
     */
    public Vec2 getPosition() {
    	return body.getPosition();
    }
    
    /**
     * @param pos to set the object
     */
    public void setPosition(Vec2 pos) {
    	body.setTransform(pos, 0.0f);
    	Vec2 resetSpeed = new Vec2(0.0f, 0.0f);
    	body.setLinearVelocity(resetSpeed);
    }

	/**
	 * @return the world
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * @param world the world to set
	 */
	public void setWorld(World world) {
		this.world = world;
	}

	/**
	 * @return the bodyTypeDef
	 */
	public BodyType getBodyTypeDef() {
		return bodyTypeDef;
	}

	/**
	 * @param bodyTypeDef the bodyTypeDef to set
	 */
	public void setBodyTypeDef(BodyType bodyTypeDef) {
		this.bodyTypeDef = bodyTypeDef;
	}

	/**
	 * @return the positionDef
	 */
	public Vec2 getPositionDef() {
		return positionDef;
	}

	/**
	 * @param positionDef the positionDef to set
	 */
	public void setPositionDef(Vec2 positionDef) {
		this.positionDef = positionDef;
	}

	/**
	 * @return the linearDampingDef
	 */
	public float getLinearDampingDef() {
		return linearDampingDef;
	}

	/**
	 * @param linearDampingDef the linearDampingDef to set
	 */
	public void setLinearDampingDef(float linearDampingDef) {
		this.linearDampingDef = linearDampingDef;
	}

	/**
	 * @return the bodyDef
	 */
	public BodyDef getBodyDef() {
		return bodyDef;
	}

	/**
	 * @param bodyDef the bodyDef to set
	 */
	public void setBodyDef(BodyDef bodyDef) {
		this.bodyDef = bodyDef;
	}

	/**
	 * @return the body
	 */
	public Body getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(Body body) {
		this.body = body;
	}
    
	
}
