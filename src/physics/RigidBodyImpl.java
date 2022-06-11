package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.World;

public abstract class RigidBodyImpl implements RigidBody {
	    
    private BodyType bodyType = BodyType.STATIC;
    private Vec2 startPositionDef = new Vec2(0.0f, 0.0f);
    private float linearDampingDef = 0.0f;
   
    private BodyDef bodyDef = new BodyDef();
    private Body body;
    
    /**
     * set the BodyDef data
     */
    protected void configBodyDef() {
        this.bodyDef.type = getBodyType();
        this.bodyDef.position.set(getStartPositionDef());
        this.bodyDef.linearDamping = getLinearDampingDef();
        this.bodyDef.angularDamping = 0.0f;
        this.bodyDef.gravityScale = 0.0f;
        this.bodyDef.fixedRotation = true;
        this.bodyDef.angle = 0.0f;
        this.bodyDef.bullet = true;
        this.bodyDef.active = true;
        this.bodyDef.allowSleep = false;
    }
    
    public Vec2 getPosition() {
    	return this.body.getPosition();
    }
    
    public void setPosition(Vec2 pos) {
    	this.body.setLinearVelocity(new Vec2(0.0f, 0.0f));
    	this.body.setTransform(pos, 0.0f);
    }
    
    public void resetBodyPos() {
    	this.resetBodySpeed();
    	this.body.setTransform(getStartPositionDef(), 0.0f);
    }
    
    /**
     * @return the body
     */
    public Body getBody() {
        return this.body;
    }
    
    /**
     * reset the body speed, stops the body
     */
    protected void resetBodySpeed() {
    	this.body.setLinearVelocity(new Vec2(0.0f, 0.0f));
    }

    /**
     * @return the bodyTypeDef
     */
    protected BodyType getBodyType() {
        return this.bodyType;
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
        return this.startPositionDef;
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
        return this.linearDampingDef;
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
        return this.bodyDef;
    }

    /**
     * @param bodyDef the bodyDef to set
     */
    protected void setBodyDef(BodyDef bodyDef) {
        this.bodyDef = bodyDef;
    }

    /**
     * @param body the body to set
     */
    protected void setBody(Body body) {
        this.body = body;
    }
	
}
