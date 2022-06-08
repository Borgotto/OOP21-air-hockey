package logics;

import org.jbox2d.common.Vec2;

public interface EnemyPlayer extends Player {
    /**
     * Get the next position of the enemy player
     * @return the next position
     */
    public Vec2 nextPosition(GameState gameState);

    /**
     * Get the difficulty of the enemy player.
     * @return The difficulty set for the enemy.
     */
    public Difficulty getDifficulty();
}
