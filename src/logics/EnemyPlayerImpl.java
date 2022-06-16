package logics;

import java.util.Objects;

import org.jbox2d.common.Vec2;
import physics.Physics2D;

/**
 * Implementation of the EnemyPlayer interface.
 */
public class EnemyPlayerImpl extends AbstractPlayer implements EnemyPlayer {
    private final Difficulty difficulty;
    private Vec2 nextMove;

    public EnemyPlayerImpl(String name, float radius, Vec2 startingPosition, Physics2D physics, Difficulty difficulty) {
        super(name, radius, startingPosition, physics);
        this.difficulty = difficulty;
        this.nextMove = new Vec2(0,0);
    }

    public EnemyPlayerImpl(float radius, Vec2 startingPosition, Physics2D physics, Difficulty difficulty) {
        this("Enemy", radius, startingPosition, physics, difficulty);
    }

    public EnemyPlayerImpl(float radius, Vec2 startingPosition, Physics2D physics) {
        this(radius, startingPosition, physics, Difficulty.EASY);
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(difficulty);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        EnemyPlayerImpl other = (EnemyPlayerImpl) obj;
        return difficulty == other.difficulty && super.equals(obj);
    }
}
