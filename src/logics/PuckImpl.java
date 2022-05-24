package logics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import physics.Physics2D;
import physics.PuckBody;

/**
 * The Puck class representing the puck of the {@link Arena}
 */
public class PuckImpl implements Puck {

    protected final PuckBody body;
	
    /**
     * Constructor with default values
     * @param world the {@link Physics2D} object to put the puck in
     */
	public PuckImpl(Physics2D world) {
		this.body = new PuckBody(7.0f,null, world);
	}
	
	public void update() {
	    //TODO
	}
	
	public void center(ArenaImpl arena) {
	    //TODO
	}
	
	public void moveToPlayer(ArenaImpl arena, Player player) {
	    //TODO
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

    public void resetBodyPos() {
        this.body.resetBodyPos();
    }
}