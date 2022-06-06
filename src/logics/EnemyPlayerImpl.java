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

    public EnemyPlayerImpl(String name, Physics2D world, float radius, Vec2 position, Difficulty difficulty) {
        super(name, world, radius, position);
        this.difficulty = difficulty;
    }

    public EnemyPlayerImpl(String name, Physics2D world, float radius, Vec2 position) {
        this(name, world, radius, position, Difficulty.EASY);
    }

    public EnemyPlayerImpl(Physics2D world, float radius, Vec2 position, Difficulty difficulty) {
        this("Enemy", world, radius, position, difficulty);
    }

    public EnemyPlayerImpl(Physics2D world, float radius, Vec2 position) {
        this(world, radius, position, Difficulty.EASY);
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }
    
    public Vec2 nextPosition(GameState gameState) {
        return this.difficulty.getMovingStrategy().apply(gameState);
    }
}
