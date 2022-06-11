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
    private final float width;
    private final float height;
    private final float goalWidth;

    /**
     * Create a new Arena with a certain goal size.
     * @param goalWidth the arena's goal size in meters.
     * @param world the game world to put the arena in.
     */
    public ArenaImpl(float width, float height, float goalWidth, Physics2D world) {
        this.body = new ArenaBodyImpl(width,height, goalWidth, world);
        this.width = width;
        this.height = height;
        this.goalWidth = goalWidth;
    }

    public void update() {
        //TODO
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public float getGoalWidth() {
        return this.goalWidth;
    }

    public Body getBody() {
        return this.body.getBody();
    }

    public Vec2 getPosition() {
        return this.body.getPosition();
    }

    public void setPosition(Vec2 pos) {
    }

    public Vec2 getStartingPosition() {
        return new Vec2(0,0);
    }

    public void resetBodyPos() {
        this.body.resetBodyPos();
    }
}
