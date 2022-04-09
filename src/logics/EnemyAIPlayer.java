package logics;

import physics.Position;
import java.lang.Math;

/**
 * The class EnemyAIPlayer represents the enemy player, controlled by the computer.
 */
public class EnemyAIPlayer extends EnemyPlayer {
	
	private Position position;
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
     * @param initialPosition The enemy's initial position.
     * @param name The enemy's name.
     * @param difficulty The enemy's difficulty.
     */
    public EnemyAIPlayer(Position initialPosition, String name, EnemyDifficulty difficulty) {
        super(initialPosition, name);
        this.difficulty = difficulty;
    }

    /**
     * Get the difficulty of the enemy player.
     * @return The difficulty set for the enemy.
     */
    public EnemyDifficulty getDifficulty() {
        return this.difficulty;
    }
    
    /**
     * The ene,y moves in accordance with its difficulty
     * @return
     */
    public Position move() {
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
    
    private Position moveRandom() {
    	return new Position(Math.random(), Math.random());
    }
}
