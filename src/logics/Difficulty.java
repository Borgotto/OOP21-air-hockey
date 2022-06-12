package logics;

import java.util.Random;
import java.util.function.Function;
import org.jbox2d.common.Vec2;

/**
 * The difficulty the enemy AI.
 * It can be:
 *  - DUMB: the enemy makes random movements (random directions and speed) around the arena
 *  - EASY: the enemy mostly makes random movements, but sometimes it tries to score a goal
 *  - NORMAL: the enemy tries to predict the puck's direction
 */
public enum Difficulty {
	DUMB((GameState gameState) -> {
		Random random = new Random();
		float angle = random.nextFloat()*360;
		float module = ((float) Math.random()*(gameState.getArena().getWidth()/4));
		return new Vec2((float)Math.cos(angle)*module, (float)Math.sin(angle)*module);
	}),
	
	EASY((GameState gameState) -> {
		float module = 15.0f;
		
		// Aggressive behavior		
		if(gameState.getPuck().getPosition().y > gameState.getArena().getHeight()/2) {
			double angle = Math.atan2(
					(gameState.getPuck().getPosition().y - gameState.getEnemyPlayer().getPosition().y - 2.0f),
					(gameState.getPuck().getPosition().x - gameState.getEnemyPlayer().getPosition().x)
				);
			return new Vec2((float)Math.cos(angle)*module, (float)Math.sin(angle)*module);
		} else { // Passive behavior
			if(gameState.getEnemyPlayer().getPosition().y == (gameState.getArena().getHeight() - 5.0f)) {
				return new Vec2(0.0f, 0.0f);
			}
			double angle = Math.atan2(
					((gameState.getArena().getHeight() - 5.0f) - gameState.getEnemyPlayer().getPosition().y),
					((gameState.getArena().getWidth()/2) - gameState.getEnemyPlayer().getPosition().x)
				);
			return new Vec2((float)Math.cos(angle)*module, (float)Math.sin(angle)*module);
		}
	}),
	
	NORMAL((GameState gameState) -> {
		float module = 20.0f;
				
		// Aggressive behavior		
		if(gameState.getPuck().getPosition().y > gameState.getArena().getHeight()/2) {
			double angle = Math.atan2(
					(gameState.getPuck().getPosition().y - gameState.getEnemyPlayer().getPosition().y - 2.0f),
					(gameState.getPuck().getPosition().x - gameState.getEnemyPlayer().getPosition().x)
				);
			return new Vec2((float)Math.cos(angle)*module, (float)Math.sin(angle)*module);
		} else { // Passive behavior
			if(gameState.getEnemyPlayer().getPosition().y == (gameState.getArena().getHeight() - 5.0f)) {
				return new Vec2(0.0f, 0.0f);
			}
			double angle = Math.atan2(
					((gameState.getArena().getHeight() - 5.0f) - gameState.getEnemyPlayer().getPosition().y),
					((gameState.getArena().getWidth()/2) - gameState.getEnemyPlayer().getPosition().x)
				);
			return new Vec2((float)Math.cos(angle)*module, (float)Math.sin(angle)*module);
		}
	});
	
	private final Function<GameState, Vec2> movingStrategy;

	private Difficulty(Function<GameState, Vec2> movingStrategy) {
		this.movingStrategy = movingStrategy;
	}

	public Function<GameState, Vec2> getMovingStrategy() {
		return this.movingStrategy;
	}
	
}
