package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.World;

public abstract class RigidBodyImpl implements RigidBody {
	
	World world;
    
    BodyType bodyType = BodyType.STATIC;
    private Vec2 startPositionDef = new Vec2(0.0f, 0.0f);
    private float linearDampingDef = 0.0f;
   
    private BodyDef bodyDef = new BodyDef();
    private Body body;
    
    /**
     * set the BodyDef data
     */
    protected void configBodyDef() {
        bodyDef.type = getBodyType();
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
     * reset the body position to the start position.
     */
    @Override
    public void resetBodyPos() {
        resetBodySpeed();
        body.setTransform(getStartPositionDef(), 0.0f);
    }
    
    /**
     * reset the body speed, stops the body
     */
    protected void resetBodySpeed() {
        body.setLinearVelocity(new Vec2(0.0f, 0.0f));
    }

    /**
     * @return the bodyTypeDef
     */
    protected BodyType getBodyType() {
        return bodyType;
    }

    /**
     * @param bodyTypeDef the bodyTypeDef to set
     */
    protected void setBodyType(BodyType bodyTypeDef) {
        this.bodyType = bodyTypeDef;
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
