package logics;

import java.lang.Math;
import utils.Pair;

/**
 * The class EnemyAIPlayer represents the enemy player, controlled by the computer.
 */
public class EnemyPlayer extends Player {
    
    private Pair<Double,Double> position;
    /**
     * The difficulty the enemy AI.
     * It can be:
     *  - DUMB: the enemy makes random movements (random directions and speed) around the arena
     *  - EASY: the enemy mostly makes random movements, but sometimes it tries to score a goal
     *  - MODERATE: the enemy often makes random movements, but when it detects that the player tried to score a goal, it defends its goal
     *  - HARD: the enemy rarely makes random movements, it often either tries to score a goal or defend its area
     *  - EXTREME: the enemy never makes random movements, it is always alert, it always tries to score a goal and when it is not possible, it defends its area
     */
    public enum Difficulty {
        DUMB, EASY, MODERATE, HARD, EXTREME
    }

    protected final Difficulty difficulty;

    /**
     * This is the constructor for EnemyAIPlayer. It behaves the same as its superclass, but it also adds a level of difficulty.
     * @param initialPosition The enemy's initial position.
     * @param name The enemy's name.
     * @param difficulty The enemy's difficulty.
     */
    public EnemyPlayer(Pair<Double,Double> initialPosition, String name, Difficulty difficulty) {
        super(initialPosition, name);
        this.difficulty = difficulty;
    }

    /**
     * Get the difficulty of the enemy player.
     * @return The difficulty set for the enemy.
     */
    public Difficulty getDifficulty() {
        return this.difficulty;
    }
    
    /**
     * The enemy moves in accordance with its difficulty
     * @return
     */
    public Pair<Double,Double> move() {
        switch(getDifficulty()) {
            case DUMB:
                this.position = moveRandom();
            case EASY:
            case MODERATE:
            case HARD:
            case EXTREME:
        }
        return this.position;
    }
    
    private Pair<Double,Double> moveRandom() {
        return new Pair<Double,Double>(Math.random(), Math.random());
    }
}
