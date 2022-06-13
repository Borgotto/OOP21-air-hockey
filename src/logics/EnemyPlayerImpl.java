package logics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import physics.Physics2D;
import physics.PlayerBody;
import physics.PlayerBodyImpl;
import physics.RigidBody;

/**
 * Implementation of the EnemyPlayer interface.
 */
public class EnemyPlayerImpl extends AbstractPlayer implements EnemyPlayer {
    private final Difficulty difficulty;
    private Vec2 nextMove;

    public EnemyPlayerImpl(String name, float radius, Vec2 startingPosition, Physics2D world, Difficulty difficulty) {
        super(name, radius, startingPosition, world);
        this.difficulty = difficulty;
        this.nextMove = new Vec2(0,0);
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
    
    public void setNextMove(GameState game) {
        this.nextMove = this.difficulty.getMovingStrategy().apply(game);
    }

    public void update() {
        this.getBody().setLinearVelocity(this.nextMove);
    }
}
