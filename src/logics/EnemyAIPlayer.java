package logics;

/**
 * The class EnemyAIPlayer represents the enemy player, controlled by the computer.
 */
public class EnemyAIPlayer extends Player {

    /**
     * The difficulty the enemy AI.
     * It can be:
     *  - DUMB: the enemy makes random movements (random directions and speed) around the arena
     *  - EASY: the enemy mostly makes random movements, but sometimes it tries to score a goal
     *  - MODERATE: the enemy often makes random movements, but when it detects that the player tried to score a goal, it defends its goal
     *  - HARD: the enemy rarely makes random movements, it often either tries to score a goal or defend its area
     *  - EXTREME: the enemy never makes random movements, it is always alert, it always tries to score a goal and when it is not possible, it defends its area
     */
    public enum EnemyDifficulty {
        DUMB, EASY, MODERATE, HARD, EXTREME
    }

    protected final EnemyDifficulty difficulty;

    /**
     * This is the constructor for EnemyAIPlayer. It behaves the same as its superclass, but it also adds a level of difficulty.
     * @param posX The enemy's position on the X-axis.
     * @param posY The enemy's position on the Y-axis.
     * @param name The enemy's name.
     * @param difficulty The enemy's difficulty.
     */
    public EnemyAIPlayer(int posX, int posY, String name, EnemyDifficulty difficulty) {
        super(posX, posY, name);
        this.difficulty = difficulty;
    }

    /**
     * Get the difficulty of the enemy player.
     * @return The difficulty set for the enemy.
     */
    public EnemyDifficulty getDifficulty() {
        return this.difficulty;
    }
}
