package logics;

import org.jbox2d.common.Vec2;

public interface EnemyPlayer extends Player, EnemyDifficulty {

    public Vec2 nextPosition(GameState gameState);

    public Difficulty getDifficulty();
}
