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
    private final String name;
    private final float radius;
    private final Vec2 startingPosition;
    private Integer score;

    public AbstractPlayer(String name, float radius, Vec2 startingPosition, Physics2D world) {
        this.name = name;
        this.radius = radius;
        this.startingPosition = startingPosition;
        this.body = new PlayerBodyImpl(radius, startingPosition, world);
        this.score = 0;
    }

    public String getName() {
        return this.name;
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

    public void updateSpeedVec(Vec2 speedVec) {
        this.body.updateSpeedVec(speedVec);
    }

    public float getRadius() {
        return this.radius;
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
