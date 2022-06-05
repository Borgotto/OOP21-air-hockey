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

    public EnemyPlayerImpl(Physics2D world, float radius, Vec2 position) {
        super(world, radius, position);
        this.difficulty = Difficulty.EASY;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }
    
    public Vec2 nextPosition(GameState gameState) {
        return this.difficulty.getMovingStrategy().apply(gameState);
    }
}
