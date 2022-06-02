package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.MouseJoint;
import org.jbox2d.dynamics.joints.MouseJointDef;

/**
 * This class only works with DYNAMIC bodies.
 */
public class MousePhysicsHandler {

	private World world;
	private PlayerBody playerBody;
	private MouseJointDef mouseJointDef = new MouseJointDef();
	private MouseJoint mouseJoint;
	
	public MousePhysicsHandler(PlayerBody playerBody, ArenaBody arenaBody) {
		setWorld(playerBody.getWorld());
		setPlayerBody(playerBody);
		
		mouseJointDef.bodyA = arenaBody.getBody();
		mouseJointDef.bodyB = getPlayerBody().getBody();
		mouseJointDef.dampingRatio = 0.9f;
		mouseJointDef.maxForce = 1000f;
		mouseJointDef.frequencyHz = 5.0f;
	}
	
	/**
	 * Used when the mouse is clicked. The method checks himself if the click was in the player area.
	 * @param mousePos the mouse position
	 * @return true if the mouse was clicked 
	 */
	public void MousePressed(final Vec2 mousePos) {
		mouseJointDef.target.set(mousePos);
		setMouseJoint((MouseJoint)world.createJoint(getMouseJointDef()));
	}
	
	/**
	 * destroy the mouseJoint
	 */
	public void MouseReleased() {
		world.destroyJoint(mouseJoint);
	}
	
	/**
	 * @param mousePos the position of the mouse when updated
	 */
	public void update(Vec2 mousePos) {
		getMouseJoint().setTarget(mousePos);
	}

	/**
	 * @param world the world to set
	 */ 
	public void setWorld(World world) {
		this.world = world;
	}

	/**
	 * @return the playerBody
	 */
	public PlayerBody getPlayerBody() {
		return playerBody;
	}

	/**
	 * @param playerBody the playerBody to set
	 */
	public void setPlayerBody(PlayerBody playerBody) {
		this.playerBody = playerBody;
	}

	/**
	 * @return the mouseJoint
	 */
	public MouseJoint getMouseJoint() {
		return mouseJoint;
	}

	/**
	 * @param mouseJoint the mouseJoint to set
	 */
	public void setMouseJoint(MouseJoint mouseJoint) {
		this.mouseJoint = mouseJoint;
	}

	/**
	 * @return the mouseJointDef
	 */
	public MouseJointDef getMouseJointDef() {
		return mouseJointDef;
	}
	
}
