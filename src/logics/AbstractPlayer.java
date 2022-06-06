package logics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import physics.Physics2D;
import physics.PlayerBody;
import physics.PlayerBodyImpl;
import physics.RigidBody;

public abstract class AbstractPlayer implements Player {
    private final transient PlayerBody body;
    private Integer score;
    private final String name;

    public AbstractPlayer(String name, Physics2D world, float radius, Vec2 position) {
        this.body = new PlayerBodyImpl(radius, position, world);
        this.score = 0;
        this.name = name;
    }

    public AbstractPlayer(Physics2D world, float radius, Vec2 position) {
        this("", world, radius, position);
    }

    public Integer getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
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

    public RigidBody getRigidBody() {
        return this.body;
    }

    public void resetBodyPos() {
        this.body.resetBodyPos();
    }

    public void update() {
        //TODO
    }
}
