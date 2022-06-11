package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

/**
 * This class only works with DYNAMIC bodies.
 */
public class MousePhysicsHandler {

	private final static int MOUSE_ACCELERATION = 100;
	private final Body boundBody;
	
	public MousePhysicsHandler(Body boundBody) {
		this.boundBody = boundBody;
	}
	
	/**
	 * @param mousePos the position of the mouse when updated
	 */
	public void update(Vec2 mousePos) {
		double angle = Math.atan2(
				(mousePos.y - boundBody.getPosition().y),
				(mousePos.x - boundBody.getPosition().x)
			);
		double module = MOUSE_ACCELERATION*Math.sqrt(Math.pow(mousePos.y - boundBody.getPosition().y, 2) + Math.pow(mousePos.x - boundBody.getPosition().x, 2));
		this.getBoundedBody().setLinearVelocity(new Vec2((float)(Math.cos(angle)*module), (float)(Math.sin(angle)*module)));
	}
	
	/**
	 * destroy the mouseJoint
	 */
	public void mouseReleased() {
		this.boundBody.setLinearVelocity(new Vec2(0.0f, 0.0f));
	}

	/**
	 * @return the playerBody
	 */
	public Body getBoundedBody() {
		return this.boundBody;
	}
}
