package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;

import java.util.Objects;

/**
 * Generic implementation of a rigid body with default values.
 */
public abstract class RigidBodyImpl implements RigidBody {
	private static final Vec2 DEFAULT_STARTPOSITION = new Vec2(0.0f, 0.0f);
	private static final float DEFAULT_LINEARDAMPING = 0.0f;
	private static final float DEFAULT_ANGULARDAMPING = 0.0f;
	private static final float DEFAULT_GRAVITYSCALE = 0.0f;
	private static final boolean DEFAULT_FIXEDROTATION = false;
	private static final float DEFAULT_ANGLE = 0.0f;
	private static final boolean DEFAULT_BULLET = true;
	private static final boolean DEFAULT_ACTIVE = true;
	private static final boolean DEFAULT_ALLOWSLEEP = false;

    private BodyType bodyType = BodyType.STATIC;
    private Vec2 startPositionDef = DEFAULT_STARTPOSITION;
    private float linearDampingDef = DEFAULT_LINEARDAMPING;
    private BodyDef bodyDef = new BodyDef();
    private Body body;

    public Body getBody() {
        return this.body;
    }

    public Vec2 getPosition() {
    	return this.body.getPosition();
    }
    
    public void setPosition(Vec2 pos) {
    	this.resetBodySpeed();
    	this.body.setTransform(pos, 0.0f);
    }
    
    public void resetBodyPos() {
    	this.resetBodySpeed();
    	this.body.setTransform(getStartPositionDef(), 0.0f);
    }
    
    /**
     * Set the BodyDef data
     */
    protected void configBodyDef() {
        this.bodyDef.type = this.getBodyType();
        this.bodyDef.position.set(this.getStartPositionDef());
        this.bodyDef.linearDamping = this.getLinearDampingDef();
        this.bodyDef.angularDamping = DEFAULT_ANGULARDAMPING;
        this.bodyDef.gravityScale = DEFAULT_GRAVITYSCALE;
        this.bodyDef.fixedRotation = DEFAULT_FIXEDROTATION;
        this.bodyDef.angle = DEFAULT_ANGLE;
        this.bodyDef.bullet = DEFAULT_BULLET;
        this.bodyDef.active = DEFAULT_ACTIVE;
        this.bodyDef.allowSleep = DEFAULT_ALLOWSLEEP;
    }

    /**
     * Reset the body speed, stops the body
     */
    protected void resetBodySpeed() {
    	this.body.setLinearVelocity(new Vec2(0.0f, 0.0f));
    }

    /**
     * @return The bodyTypeDef.
     */
    protected BodyType getBodyType() {
        return this.bodyType;
    }

    /**
     * @param bodyTypeDef The bodyTypeDef to set.
     */
    protected void setBodyType(BodyType bodyTypeDef) {
        this.bodyType = bodyTypeDef;
    }

    /**
     * @return The startPositionDef.
     */
    protected Vec2 getStartPositionDef() {
        return this.startPositionDef;
    }

    /**
     * @param startPositionDef The startPositionDef to set.
     */
    protected void setStartPositionDef(Vec2 startPositionDef) {
        this.startPositionDef = startPositionDef;
    }

    /**
     * @return The linearDampingDef.
     */
    protected float getLinearDampingDef() {
        return this.linearDampingDef;
    }

    /**
     * @param linearDampingDef The linearDampingDef to set.
     */
    protected void setLinearDampingDef(float linearDampingDef) {
        this.linearDampingDef = linearDampingDef;
    }

    /**
     * @return The bodyDef.
     */
    protected BodyDef getBodyDef() {
        return this.bodyDef;
    }

    /**
     * @param bodyDef The bodyDef to set.
     */
    protected void setBodyDef(BodyDef bodyDef) {
        this.bodyDef = bodyDef;
    }

    /**
     * @param body The body to set.
     */
    protected void setBody(Body body) {
        this.body = body;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bodyType, linearDampingDef, startPositionDef);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RigidBodyImpl)) {
            return false;
        }
        RigidBodyImpl other = (RigidBodyImpl) obj;
        return bodyType == other.bodyType
                && Float.floatToIntBits(linearDampingDef) == Float.floatToIntBits(other.linearDampingDef)
                && Objects.equals(startPositionDef, other.startPositionDef);
    }
	
}
