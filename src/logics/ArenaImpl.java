package logics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import physics.ArenaBody;
import physics.ArenaBodyImpl;
import physics.Physics2D;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

/**
 * Class that represent arenas the player can play in.
 */
public class ArenaImpl implements Arena {
    private static final long serialVersionUID = -798220930915565977L;
    private transient ArenaBody body;
    private final float width;
    private final float height;
    private final float goalWidth;

    /**
     * Create a new Arena with a certain goal size.
     * @param width The arena's width in meters.
     * @param height The arena's height in meters.
     * @param goalWidth The arena's goal width in meters.
     * @param physics The {@link Physics2D} object to put the {@link Arena} in.
     */
    public ArenaImpl(float width, float height, float goalWidth, Physics2D physics) {
        this.body = new ArenaBodyImpl(width,height, goalWidth, physics);
        this.width = width;
        this.height = height;
        this.goalWidth = goalWidth;
    }

    public void update() {
        // nothing to update on an Arena object
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
        // can't set position of arena
    }

    public Vec2 getStartingPosition() {
        return new Vec2(0,0);
    }

    public void resetBodyPos() {
        this.body.resetBodyPos();
    }

    @Override
    public int hashCode() {
        return Objects.hash(body, goalWidth, height, width);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArenaImpl)) {
            return false;
        }
        ArenaImpl other = (ArenaImpl) obj;
        return Objects.equals(body, other.body)
                && Float.floatToIntBits(goalWidth) == Float.floatToIntBits(other.goalWidth)
                && Float.floatToIntBits(height) == Float.floatToIntBits(other.height)
                && Float.floatToIntBits(width) == Float.floatToIntBits(other.width);
    }

    // Override default deserialization to set transient fields
    private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
        in.defaultReadObject();
        this.body = new ArenaBodyImpl(width,height, goalWidth, GameState.gamePhysics);
    }
}
