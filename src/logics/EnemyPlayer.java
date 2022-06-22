package logics;

/**
 * An AI controlled player.
 */
public interface EnemyPlayer extends Player {
    /**
     * Get the next position of the enemy player.
     * @param game The reference state of the game.
     */
    void setNextMove(GameState game);

    /**
     * Get the difficulty of the enemy player.
     * @return The difficulty set for the enemy.
     */
    Difficulty getDifficulty();
}
