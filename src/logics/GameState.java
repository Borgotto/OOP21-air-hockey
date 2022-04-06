package logics;

import java.io.Serializable;

/**
 * The class GameState holds a state of the game, usually the current one.
 */
public class GameState implements Serializable {
    private final Player mainPlayer;
    private final Player enemyPlayer;
    private final int maxScore;
    private final boolean isEnemyAi;
    private final int arenaWidth;
    private final int arenaHeight;

    /**
     * Create a new GameState object.
     * @param mainPlayer The main player.
     * @param enemyPlayer The enemy player.
     * @param maxScore The maximum score of the game.
     */
    public GameState(Player mainPlayer, Player enemyPlayer, int maxScore, boolean isEnemyAi, int arenaWidth, int arenaHeight) {
        this.mainPlayer = mainPlayer;
        this.enemyPlayer = enemyPlayer;
        this.maxScore = maxScore;
        this.isEnemyAi = isEnemyAi;
        this.arenaWidth = arenaWidth;
        this.arenaHeight = arenaHeight;
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
    private boolean movePlayer(Player p, int posX, int posY, int bottomBoundary, int topBoundary) {
        final boolean canMoveX = posX >= 0 && posX < this.arenaWidth;
        final boolean canMoveY = posY < bottomBoundary && posY >= topBoundary;
        final boolean canMove = canMoveX && canMoveY;

        if (canMove) {
            p.move(posX, posY);
        }

        return canMove;
    }

    /**
     * Move the main player in the position (posX, posY) if it is in the lower part of the arena.
     * @param posX The player's position on the X-axis.
     * @param posY The player's position on the Y-axis.
     * @return True if the player could actually move.
     */
    public boolean moveMainPlayer(int posX, int posY) {
        return movePlayer(this.mainPlayer, posX, posY, this.arenaHeight, this.arenaHeight / 2);
    }

    /**
     * Move the enemy player in the position (posX, posY) if it is in the higher part of the arena.
     * Use this function only if the enemy is not controlled by the computer.
     * @param posX The player's position on the X-axis.
     * @param posY The player's position on the Y-axis.
     * @return True if the player could actually move.
     */
    public boolean moveEnemyPlayer(int posX, int posY) {
        // block attempts to move the enemy if it is AI
        if (this.isEnemyAi) {
            return false;
        }

        return movePlayer(this.enemyPlayer, posX, posY, this.arenaHeight / 2, 0);
    }
}
