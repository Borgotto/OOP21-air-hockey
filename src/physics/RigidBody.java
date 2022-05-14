package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;

public abstract class RigidBody {
    
    BodyType bodyType = BodyType.STATIC;
    private Vec2 position = new Vec2(0.0f, 0.0f);
    private float linearDamping = 0.0f;
    private float mass = 1;
   
    private BodyDef bodyDef = new BodyDef();
    private Body body = null;
    
    /**
     * set the BodyDef data
     */
    public void configBodyDef() {
        bodyDef.type = getBodyType();
        bodyDef.position.set(getPosition());
        bodyDef.linearDamping = getLinearDamping();
        bodyDef.angularDamping = 0.0f;
        bodyDef.gravityScale = 0.0f;
        bodyDef.fixedRotation = true;
        bodyDef.bullet = true;
        bodyDef.active = true;
        bodyDef.allowSleep = false;
    }

    /**
     * @return the bodyType
     */
    public BodyType getBodyType() {
        return bodyType;
    }

    /**
     * @param bodyType the bodyType to set
     */
    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    /**
     * @return the position
     */
    public Vec2 getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Vec2 position) {
        this.position = position;
    }

    /**
     * @return the linearDamping
     */
    public float getLinearDamping() {
        return linearDamping;
    }

    /**
     * @param linearDamping the linearDamping to set
     */
    public void setLinearDamping(float linearDamping) {
        this.linearDamping = linearDamping;
    }

    /**
     * @return the mass
     */
    public float getMass() {
        return mass;
    }

    /**
     * @param mass the mass to set
     */
    public void setMass(float mass) {
        this.mass = mass;
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
