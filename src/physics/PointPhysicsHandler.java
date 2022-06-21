package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

/**
 * Class used to handle point physics.
 * It works based on the point position and the body position.
 * This class only works with DYNAMIC bodies.
 */
public class PointPhysicsHandler {
	private final static int ACCELERATION = 60;
	private final Body boundBody;
	
	public PointPhysicsHandler(Body boundBody) {
		this.boundBody = boundBody;
	}
	
	/**
	 * Updates the body position based on the point position.
	 * @param pointPos the position of the point when updated
	 */
	public void update(Vec2 pointPos) {
		double angle = Math.atan2(
				(pointPos.y - boundBody.getPosition().y),
				(pointPos.x - boundBody.getPosition().x)
			);
		double module = ACCELERATION*Math.sqrt(Math.pow(pointPos.y - boundBody.getPosition().y, 2) + Math.pow(pointPos.x - boundBody.getPosition().x, 2));
		this.getBoundedBody().setLinearVelocity(new Vec2((float)(Math.cos(angle)*module), (float)(Math.sin(angle)*module)));
	}
	
	/**
	 * Method to be called when the point click is released.
	 * It destroys the pointJoint and stops the body movement.
	 */
	public void pointReleased() {
		this.boundBody.setLinearVelocity(new Vec2(0.0f, 0.0f));
	}

	/**
	 * Get the body that is bound to the point.
	 * @return the playerBody
	 */
	public Body getBoundedBody() {
		return this.boundBody;
	}
}
