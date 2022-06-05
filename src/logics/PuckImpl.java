package logics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import physics.Physics2D;
import physics.PuckBody;
import physics.PuckBodyImpl;
import physics.RigidBody;

/**
 * The Puck class representing the puck of the {@link Arena}
 */
public class PuckImpl implements Puck {

    protected final transient PuckBody body;
	
    /**
     * Constructor with default values
     * @param world the {@link Physics2D} object to put the puck in
     */
	public PuckImpl(Physics2D world, float radius, Vec2 position) {
		this.body = new PuckBodyImpl(radius, position, world);
	}
	
	public void update() {
	    //TODO
	}
	
	public void center(Arena arena) {
	    //TODO
	}
	
	public void moveToPlayer(Arena arena, Player player) {
	    //TODO
	}
	
	public Vec2 getNextPos() {
	    //TODO
	    return null;
	}
	
	public Vec2 getPosition() {
		return this.body.getPosition();
	}

    public void setPosition(Vec2 pos) {
        this.body.setPosition(pos);
    }

    public World getWorld() {
        return this.body.getWorld();
    }

    public Body getBody() {
        return this.body.getBody();
    }

	public RigidBody getRigidBody() {
		return this.body;
	}

    public void resetBodyPos() {
        this.body.resetBodyPos();
    }
}
