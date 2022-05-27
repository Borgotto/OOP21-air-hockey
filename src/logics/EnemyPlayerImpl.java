package logics;

import java.lang.Math;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import physics.Physics2D;
import physics.PlayerBody;
import physics.RigidBody;
import utils.Pair;

/**
 * The class EnemyAIPlayer represents the enemy player, controlled by the computer.
 */
public class EnemyPlayerImpl implements EnemyPlayer {
    private final PlayerBody body;
    private final Difficulty difficulty;
    private Integer score;

    public EnemyPlayerImpl(Physics2D world, float radius, Vec2 position) {
        this.body = new PlayerBody(radius, position, world);
        this.difficulty = Difficulty.EASY;
        this.score = 0;
    }

    /**
     * Get the difficulty of the enemy player.
     * @return The difficulty set for the enemy.
     */
    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public void update() {
        //TODO
    }
    
    public Vec2 nextPosition() {
        return this.difficulty.getMovingStrategy().apply(this.getPosition());
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

    public void resetBodyPos() {
        this.body.resetBodyPos();
    }
}
