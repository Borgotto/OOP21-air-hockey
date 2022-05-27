package logics;

import java.util.function.Function;

import org.jbox2d.common.Vec2;

public interface EnemyPlayer extends Player {
    
	/**
     * The difficulty the enemy AI.
     * It can be:
     *  - DUMB: the enemy makes random movements (random directions and speed) around the arena
     *  - EASY: the enemy mostly makes random movements, but sometimes it tries to score a goal
     *  - NORMAL: the enemy tries to predict the puck's direction
     */
    public enum Difficulty {
        DUMB((GameState gamestate) -> {
        	float angle = (float) Math.random()*360;
        	float module = (float) Math.random()*(gamestate.getArena().getWidth()/4);
        	return new Vec2((float)Math.cos(angle)*module, (float)Math.sin(angle)*module);
        }),
        EASY((GameState gamestate) -> {
        	float xEnemy = gamestate.getEnemyPlayer().getPosition().x;
        	float xPuckCurr = gamestate.getPuck().getPosition().x;
        	float xPuckNext = gamestate.getPuck().getNextPos().x;
        	float yEnemy =  gamestate.getEnemyPlayer().getPosition().y;
        	float yPuckCurr = gamestate.getPuck().getPosition().y;
        	float yPuckNext = gamestate.getPuck().getNextPos().y;
        	float xDefPos = gamestate.getArena().getWidth()/2;
        	float yDefPos = gamestate.getArena().getHeight()/12;
        	
        	if (xPuckCurr < gamestate.getArena().getHeight()/2) {
	        	if (Math.abs((xPuckCurr - xEnemy)/(yPuckCurr - yEnemy)) > gamestate.getArena().getWidth()/7) {
	        		float angle = (float)Math.atan((yPuckNext - yEnemy)/(xPuckNext - xEnemy));
	        		float module = gamestate.getArena().getWidth()/8;
	        		return new Vec2((float)Math.cos(angle)*module, (float)Math.sin(angle)*module);
	        	} else {
	        		float angle = (float)Math.atan((yPuckCurr - yEnemy)/(xPuckCurr - xEnemy));
	        		float module = gamestate.getArena().getWidth()/6;
	        		return new Vec2((float)Math.cos(angle)*module, (float)Math.sin(angle)*module);
	        	}
        	} else {
        		float angle = (float)Math.atan((yDefPos - yEnemy)/(xDefPos - xEnemy));
        		float module = gamestate.getArena().getWidth()/6;
        		return new Vec2((float)Math.cos(angle)*module, (float)Math.sin(angle)*module);
        	}
        }),
        NORMAL((GameState gamestate) -> {
        	float xEnemy = gamestate.getEnemyPlayer().getPosition().x;
        	float xPuckCurr = gamestate.getPuck().getPosition().x;
        	float xPuckNext = gamestate.getPuck().getNextPos().x;
        	float yEnemy =  gamestate.getEnemyPlayer().getPosition().y;
        	float yPuckCurr = gamestate.getPuck().getPosition().y;
        	float yPuckNext = gamestate.getPuck().getNextPos().y;
        	
        	if (Math.abs((xPuckCurr - xEnemy)/(yPuckCurr - yEnemy)) > gamestate.getArena().getWidth()/7) {
        		float angle = (float)Math.atan((yPuckNext - yEnemy)/(xPuckNext - xEnemy));
        		float module = gamestate.getArena().getWidth()/4;
        		return new Vec2((float)Math.cos(angle)*module, (float)Math.sin(angle)*module);
        	} else {
        		float angle = (float)Math.atan((yPuckCurr - yEnemy)/(xPuckCurr - xEnemy));
        		float module = gamestate.getArena().getWidth()/3;
        		return new Vec2((float)Math.cos(angle)*module, (float)Math.sin(angle)*module);
        	}
        });

        private Function<GameState, Vec2> movingStrategy;

        private Difficulty(Function<GameState, Vec2> movingStrategy) {
            this.movingStrategy = movingStrategy;
        }

        public Function<GameState, Vec2> getMovingStrategy() {
            return this.movingStrategy;
        }
    }

	
    public Vec2 nextPosition();

    public Difficulty getDifficulty();
}
