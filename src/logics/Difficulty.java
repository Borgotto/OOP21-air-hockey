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
		double angle = Math.random()*360;
		double module = Math.random()*gameState.getArena().getHeight();
		
		return new Vec2((float)(Math.cos(angle)*module), (float)(Math.sin(angle)*module));
	}),
	
	EASY((GameState gameState) -> {
		float module = 15.0f;
		float distanceRatio = 1.5f;
		float defenseDistance = 5.0f;
		
		return calculateSpeedVector(module, distanceRatio, defenseDistance, gameState);
	}),
	
	NORMAL((GameState gameState) -> {
		float module = 30.0f;
		float distanceRatio = 1.5f;
		float defenseDistance = 5.0f;

		return calculateSpeedVector(module, distanceRatio, defenseDistance, gameState);
	}),
	
	INSANE((GameState gameState) -> {
		float module = 45.0f;
		float distanceRatio = 1.5f;
		float defenseDistance = 5.0f;

		return calculateSpeedVector(module, distanceRatio, defenseDistance, gameState);
	});
	
	private static Vec2 calculateSpeedVector(final float module, final float distanceRatio, final float defenseDistance, GameState gameState) {
		final float delta = 0.5f; // this is used to correct bad floating point precision

		// Aggressive behavior
		if(gameState.getPuck().getPosition().y > gameState.getArena().getHeight()/2) {
			double angle = Math.atan2(
					(gameState.getPuck().getPosition().y - gameState.getEnemyPlayer().getPosition().y + (gameState.getPuck().getRadius()/distanceRatio)),
					(gameState.getPuck().getPosition().x - gameState.getEnemyPlayer().getPosition().x)
				);
			return new Vec2((float)Math.cos(angle)*module, (float)Math.sin(angle)*module);
		} else { // Passive behavior
			if (Math.abs(gameState.getEnemyPlayer().getPosition().y - (gameState.getArena().getHeight() - defenseDistance)) < delta) {
				return new Vec2(0.0f, 0.0f);
			}
			double angle = Math.atan2(
					((gameState.getArena().getHeight() - defenseDistance) - gameState.getEnemyPlayer().getPosition().y),
					((gameState.getArena().getWidth()/2) - gameState.getEnemyPlayer().getPosition().x)
				);
			return new Vec2((float)Math.cos(angle)*module, (float)Math.sin(angle)*module);
		}
	}

	private final Function<GameState, Vec2> movingStrategy;

	private Difficulty(Function<GameState, Vec2> movingStrategy) {
		this.movingStrategy = movingStrategy;
	}

	public Function<GameState, Vec2> getMovingStrategy() {
		return this.movingStrategy;
	}
}
