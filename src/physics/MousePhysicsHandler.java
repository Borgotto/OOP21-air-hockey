package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.MouseJoint;
import org.jbox2d.dynamics.joints.MouseJointDef;

/**
 * This class only works with DYNAMIC bodies.
 */
public class MousePhysicsHandler {

	private final World world;
	private final Body boundBody;
	private MouseJointDef mouseJointDef;
	private MouseJoint mouseJoint;
	
	public MousePhysicsHandler(Body boundBody, Body groundBody) {
		this.boundBody = boundBody;
		this.world = boundBody.getWorld();
		
		this.mouseJointDef = new MouseJointDef();
		this.mouseJointDef.bodyA = groundBody;
		this.mouseJointDef.bodyB = this.boundBody;
		this.mouseJointDef.dampingRatio = 0.9f;
		this.mouseJointDef.maxForce = 1000f;
		this.mouseJointDef.frequencyHz = 5.0f;
	}
	
	/**
	 * Used when the mouse is clicked. The method checks himself if the click was in the player area.
	 * @param mousePos the mouse position
	 * @return true if the mouse was clicked 
	 */
	public void mousePressed() {
		this.mouseJointDef.target.set(boundBody.getPosition());
		this.setMouseJoint((MouseJoint)world.createJoint(this.getMouseJointDef()));
	}
	
	/**
	 * @param mousePos the position of the mouse when updated
	 */
	public void update(Vec2 mousePos) {
		this.getMouseJoint().setTarget(mousePos);
	}
	
	/**
	 * destroy the mouseJoint
	 */
	public void mouseReleased() {
		this.world.destroyJoint(mouseJoint);
		this.boundBody.setLinearVelocity(new Vec2(0.0f, 0.0f));;
	}

	/**
	 * @return the playerBody
	 */
	public Body getBoundedBody() {
		return this.boundBody;
	}

	/**
	 * @return the mouseJoint
	 */
	private MouseJoint getMouseJoint() {
		return this.mouseJoint;
	}

	/**
	 * @param mouseJoint the mouseJoint to set
	 */
	private void setMouseJoint(MouseJoint mouseJoint) {
		this.mouseJoint = mouseJoint;
	}

	/**
	 * @return the mouseJointDef
	 */
	private MouseJointDef getMouseJointDef() {
		return this.mouseJointDef;
	}
	
}
