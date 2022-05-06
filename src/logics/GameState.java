package logics;

import java.io.Serializable;
import utils.Pair;

/**
 * The class GameState holds a state of the game, usually the current one.
 */
public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private final Integer maxScore;
    private final Arena arena;
    private final NormalPlayer mainPlayer;
    private final EnemyPlayer enemyPlayer;
    private final Puck puck;
    //private static volatile GameState instance = null;

    /**
     * Create a new GameState object.
     * @param mainPlayer The main player.
     * @param enemyPlayer The enemy player.
     * @param maxScore The maximum score of the game.
     */
    public GameState(NormalPlayer mainPlayer, EnemyPlayer enemyPlayer, Integer maxScore, Arena arena, Puck puck) {
        this.mainPlayer = mainPlayer;
        this.enemyPlayer = enemyPlayer;
        this.maxScore = maxScore;
        this.arena = arena;
        this.puck = puck;
    }

    /**
     * Create a new GameState object using default values.
     */
    public GameState() {
        this.arena = new Arena(9.0, 16.0);
        Double halfArenaWidth = this.arena.getWidth() / 2;
        Double halfArenaHeight = this.arena.getHeight() / 2;
        this.mainPlayer = new NormalPlayer(new Pair<Double,Double>(halfArenaWidth, this.arena.getHeight()), "Bob");
        this.enemyPlayer = new EnemyPlayer(new Pair<Double,Double>(halfArenaWidth, 0.0), "Alice", EnemyPlayer.Difficulty.MODERATE);
        this.maxScore = 5;
        this.puck = new Puck(new Pair<Double, Double>(halfArenaWidth, halfArenaHeight));
    }

    /**
     * Get the current GameState instance. (see Singleton pattern)
     * @return The current GameState instance.
     */
    /* TODO
    public GameState getInstance() {

    }
    */


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
    public Integer getMaxScore() {
        return this.maxScore;
    }

    /*
    Move the player by calling the player's move method after checking that it can actually move there.
     */
    private boolean movePlayer(Player p, Pair<Double,Double> newPosition, Double bottomBoundary, Double topBoundary) {
        final Double posX = newPosition.getX();
        final Double posY = newPosition.getY();
        final boolean canMoveX = posX >= 0 && posX < this.arena.getWidth();
        final boolean canMoveY = posY < bottomBoundary && posY >= topBoundary;
        final boolean canMove = canMoveX && canMoveY;

        if (canMove) {
            p.setPosition(newPosition);
        }

        return canMove;
    }

    /**
     * Move the main player in the position (posX, posY) if it is in the lower part of the arena.
     * @param newPosition The player's updated position.
     * @return True if the player could actually move.
     */
    public boolean moveMainPlayer(Pair<Double,Double> newPosition) {
        return movePlayer(this.mainPlayer, newPosition, this.arena.getHeight(), this.arena.getHeight() / 2);
    }

    /**
     * Move the enemy player in the position (posX, posY) if it is in the higher part of the arena.
     * Use this function only if the enemy is not controlled by the computer.
     * @param newPosition The player's updated position.
     * @return True if the player could actually move.
     */
    public boolean moveEnemyPlayer(Pair<Double,Double> newPosition) {
        return movePlayer(this.enemyPlayer, newPosition, this.arena.getHeight() / 2, 0.0);
    }
}
