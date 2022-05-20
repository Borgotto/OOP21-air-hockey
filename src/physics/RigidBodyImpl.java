package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.World;

public abstract class RigidBodyImpl implements RigidBody {
	
	World world;
    
    BodyType bodyTypeDef = BodyType.STATIC;
    private Vec2 startPositionDef = new Vec2(0.0f, 0.0f);
    private float linearDampingDef = 0.0f;
   
    private BodyDef bodyDef = new BodyDef();
    private Body body;
    
    /**
     * set the BodyDef data
     */
    protected void configBodyDef() {
        bodyDef.type = getBodyTypeDef();
        bodyDef.position.set(getStartPositionDef());
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
    @Override
    public Vec2 getPosition() {
    	return body.getPosition();
    }
    
    /**
     * set the body in a position and resets the speed of the object.
     * @param pos to set the object
     */
    @Override
    public void setPosition(Vec2 pos) {
        body.setLinearVelocity(new Vec2(0.0f, 0.0f));
    	body.setTransform(pos, 0.0f);
    }

	/**
	 * @return the world
	 */
    @Override
	public World getWorld() {
		return world;
	}
    
    /**
     * @return the body
     */
    @Override
    public Body getBody() {
        return body;
    }
    
    /**
     * resets the body position to the start position.
     */
    @Override
    public void resetBodyPos() {
        body.setLinearVelocity(new Vec2(0.0f, 0.0f));
        body.setTransform(getStartPositionDef(), 0.0f);
    }

    /**
     * @return the bodyTypeDef
     */
    protected BodyType getBodyTypeDef() {
        return bodyTypeDef;
    }

    /**
     * @param bodyTypeDef the bodyTypeDef to set
     */
    protected void setBodyTypeDef(BodyType bodyTypeDef) {
        this.bodyTypeDef = bodyTypeDef;
    }

    /**
     * @return the startPositionDef
     */
    protected Vec2 getStartPositionDef() {
        return startPositionDef;
    }

    /**
     * @param startPositionDef the startPositionDef to set
     */
    protected void setStartPositionDef(Vec2 startPositionDef) {
        this.startPositionDef = startPositionDef;
    }

    /**
     * @return the linearDampingDef
     */
    protected float getLinearDampingDef() {
        return linearDampingDef;
    }

    /**
     * @param linearDampingDef the linearDampingDef to set
     */
    protected void setLinearDampingDef(float linearDampingDef) {
        this.linearDampingDef = linearDampingDef;
    }

    /**
     * @return the bodyDef
     */
    protected BodyDef getBodyDef() {
        return bodyDef;
    }

    /**
     * @param bodyDef the bodyDef to set
     */
    protected void setBodyDef(BodyDef bodyDef) {
        this.bodyDef = bodyDef;
    }

    /**
     * @param world the world to set
     */
    protected void setWorld(World world) {
        this.world = world;
    }

    /**
     * @param body the body to set
     */
    protected void setBody(Body body) {
        this.body = body;
    }
	
}
