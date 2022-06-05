package logics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import physics.Physics2D;
import physics.PlayerBody;
import physics.PlayerBodyImpl;
import physics.RigidBody;

/**
 * The class EnemyAIPlayer represents the enemy player, controlled by the computer.
 */
public class EnemyPlayerImpl implements EnemyPlayer {
    private final transient PlayerBody body;
    private final Difficulty difficulty;
    private Integer score;

    public EnemyPlayerImpl(Physics2D world, float radius, Vec2 position) {
        this.body = new PlayerBodyImpl(radius, position, world);
        this.difficulty = Difficulty.EASY;
        this.score = 0;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public void update() {
        //TODO
    }
    
    public Vec2 nextPosition(GameState gameState) {
        return this.difficulty.getMovingStrategy().apply(gameState);
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(final Integer score) {
        this.score = score;
    }

    public void scorePoint() {
        this.score += 1;
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
