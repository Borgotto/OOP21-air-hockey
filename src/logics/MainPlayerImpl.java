package logics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import physics.Physics2D;
import physics.PlayerBody;

/**
 * The class NormalPlayer represents a user-controlled player.
 */
public class MainPlayerImpl implements MainPlayer {
    private final PlayerBody body;
    private Integer score;

    public MainPlayerImpl(Physics2D world) {
        this.body = new PlayerBody(7.0f, null, world);
        this.score = 0;
    }

    public void update() {
        //TODO
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(final Integer score) {
        this.score = score;
    }

    public void scorePoint() {
        this.score++;
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
