package logics;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import physics.Physics2D;
import physics.PuckBody;
import physics.PuckBodyImpl;

/**
 * The Puck class representing the puck of the {@link Arena}
 */
public class PuckImpl implements Puck {
    private static final long serialVersionUID = -6978887898025055114L;
    private transient PuckBody body;
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

    @Override
    public int hashCode() {
        return Objects.hash(body, radius, startingPosition);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PuckImpl)) {
            return false;
        }
        PuckImpl other = (PuckImpl) obj;
        return Objects.equals(body, other.body) && Float.floatToIntBits(radius) == Float.floatToIntBits(other.radius)
                && Objects.equals(startingPosition, other.startingPosition);
    }

	// Override default deserialization to set transient fields
	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
		in.defaultReadObject();
		this.body = new PuckBodyImpl(radius, startingPosition, GameState.gamePhysics);
	}
}
