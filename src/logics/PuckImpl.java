package logics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import physics.Physics2D;
import physics.PuckBody;
import physics.PuckBodyImpl;

/**
 * The Puck class representing the puck of the {@link Arena}
 */
public class PuckImpl implements Puck {

    private final transient PuckBody body;
	private final float radius;
	private final Vec2 startingPosition;
	
    /**
     * @param physics the {@link Physics2D} object to put the puck in
     */
	public PuckImpl(float radius, Vec2 startingPosition, Physics2D physics) {
		this.body = new PuckBodyImpl(radius, startingPosition, physics);
		this.radius = radius;
		this.startingPosition = startingPosition;
	}

	public void update() {
		// nothing to update on a Puck object
	}

	public float getRadius() {
		return this.radius;
	}

	public void center(Arena arena) {
	    this.body.setPosition(new Vec2(arena.getWidth() / 2, arena.getHeight() / 2));
	}

	public void moveToPlayer(Arena arena, Player player) {
		Vec2 position = new Vec2(arena.getWidth()/2, arena.getHeight()/2);
		if (player instanceof MainPlayer) {
			position.y -= arena.getHeight()/4;
		} else if (player instanceof EnemyPlayer) {
			position.y += arena.getHeight()/4;
		}
	    this.setPosition(position);
	}

	public Vec2 getNextPos() {
	    return this.body.getNextPos();
	}

	public Body getBody() {
		return this.body.getBody();
	}

	public Vec2 getPosition() {
		return this.body.getPosition();
	}

    public void setPosition(Vec2 pos) {
        this.body.setPosition(pos);
    }

	public Vec2 getStartingPosition() {
		return this.startingPosition;
	}

    public void resetBodyPos() {
        this.body.resetBodyPos();
    }
}
