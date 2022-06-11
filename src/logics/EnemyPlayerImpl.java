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
public class EnemyPlayerImpl extends AbstractPlayer implements EnemyPlayer {
    private final Difficulty difficulty;

    public EnemyPlayerImpl(String name, float radius, Vec2 startingPosition, Physics2D world, Difficulty difficulty) {
        super(name, radius, startingPosition, world);
        this.difficulty = difficulty;
    }

    public EnemyPlayerImpl(float radius, Vec2 startingPosition, Physics2D world, Difficulty difficulty) {
        this("Enemy", radius, startingPosition, world, difficulty);
    }

    public EnemyPlayerImpl(float radius, Vec2 startingPosition, Physics2D world) {
        this(radius, startingPosition, world, Difficulty.EASY);
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }
    
    public Vec2 nextPosition(GameState gameState) {
        return this.difficulty.getMovingStrategy().apply(gameState);
    }

    public void update() {

    }
}
