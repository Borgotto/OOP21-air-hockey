package logics;

import java.io.Serializable;
import physics.Position;

/**
 * The class GameState holds a state of the game, usually the current one.
 */
public class GameState implements Serializable {
    private final Player mainPlayer;
    private final EnemyPlayer enemyPlayer;
    private final int maxScore;
    private final boolean isEnemyAi;
    private final Arena arena;

    /**
     * Create a new GameState object.
     * @param mainPlayer The main player.
     * @param enemyPlayer The enemy player.
     * @param maxScore The maximum score of the game.
     */
    public GameState(Player mainPlayer, EnemyPlayer enemyPlayer, int maxScore, boolean isEnemyAi, Arena arena) {
        this.mainPlayer = mainPlayer;
        this.enemyPlayer = enemyPlayer;
        this.maxScore = maxScore;
        this.isEnemyAi = isEnemyAi;
        this.arena = arena;
    }

    /**
     * Create a new GameState object using default values.
     */
    public GameState() {
        this.arena = new Arena(9.0, 16.0);
        double halfArenaWidth = this.arena.getWidth() / 2;

        this.mainPlayer = new NormalPlayer(new Position(halfArenaWidth, this.arena.getHeight()), "Bob");
        this.enemyPlayer = new EnemyAIPlayer(new Position(halfArenaWidth, 0.0), "Alice", EnemyAIPlayer.EnemyDifficulty.MODERATE);
        this.maxScore = 5;
        this.isEnemyAi = true;
    }

    /**
     * Get the main player's object.
     * @return The main player's object.
     */
    public Player getMainPlayer() {
        return this.mainPlayer;
    }

    /**
     * Get the enemy player's object.
     * @return The enemy player's object.
     */
    public Player getEnemyPlayer() {
        return this.enemyPlayer;
    }

    /**
     * Get the maximum score.
     * @return The maximum score.
     */
    public int getMaxScore() {
        return this.maxScore;
    }

    /*
    Move the player by calling the player's move method after checking that it can actually move there.
     */
    private boolean movePlayer(Player p, Position newPosition, double bottomBoundary, double topBoundary) {
        final double posX = newPosition.getXPos();
        final double posY = newPosition.getYPos();
        final boolean canMoveX = posX >= 0 && posX < this.arena.getWidth();
        final boolean canMoveY = posY < bottomBoundary && posY >= topBoundary;
        final boolean canMove = canMoveX && canMoveY;

        if (canMove) {
            p.move(newPosition);
        }

        return canMove;
    }

    /**
     * Move the main player in the position (posX, posY) if it is in the lower part of the arena.
     * @param newPosition The player's updated position.
     * @return True if the player could actually move.
     */
    public boolean moveMainPlayer(Position newPosition) {
        return movePlayer(this.mainPlayer, newPosition, this.arena.getHeight(), this.arena.getHeight() / 2);
    }

    /**
     * Move the enemy player in the position (posX, posY) if it is in the higher part of the arena.
     * Use this function only if the enemy is not controlled by the computer.
     * @param newPosition The player's updated position.
     * @return True if the player could actually move.
     */
    public boolean moveEnemyPlayer(Position newPosition) {
        // block attempts to move the enemy if it is AI
        if (this.isEnemyAi) {
            return false;
        }

        return movePlayer(this.enemyPlayer, newPosition, this.arena.getHeight() / 2, 0);
    }
}
