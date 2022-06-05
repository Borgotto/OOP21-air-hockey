package logics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import physics.ArenaBody;
import physics.ArenaBodyImpl;
import physics.Physics2D;
import physics.RigidBody;


/**
 * Class that represent arenas the player can play in.
 */
public class ArenaImpl implements Arena {

    private final transient ArenaBody body;
    private float goalWidth;

    /**
     * Create a new Arena with a certain goal size.
     * @param goalWidth the arena's goal size in meters.
     * @param world the game world to put the arena in.
     */
    public ArenaImpl(float goalWidth, Physics2D world) {
        this.goalWidth = goalWidth;
        this.body = new ArenaBodyImpl(18.0f, 32.0f, goalWidth, world);
    }

    public float getGoalWidth() {
        return this.goalWidth;
    }

    public void setGoalWidth(float goalWidth) {
        this.goalWidth = goalWidth;
    }

    public Vec2 getPosition() {
        return this.body.getPosition();
    }

    public void setPosition(Vec2 pos) { 
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

    public float getWidth() {
        return this.body.getWidth();
    }

    public float getHeight() {
        return this.body.getHeight();
    }

    public void resetBodyPos() {
        this.body.resetBodyPos();
    }

    public void update() {
        //TODO
    }
}
