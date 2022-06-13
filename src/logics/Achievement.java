package logics;

import javax.swing.*;
import java.util.function.Predicate;

/**
 * Interface describing an achievement
 */
public interface Achievement {

	/**
	 * Get the image representing the achievement or an empty image if imagePath is not set
	 * @return The image icon
	 */
	ImageIcon getIcon();

	/**
	 * Get the name of the achievement
	 * @return The name of the achievement
	 */
	String getName();

	/**
	 * Get the description of the achievement
	 * @return The description of the achievement
	 */
	String getDescription();

	/**
	 * Get the condition necessary to unlock the achievement
	 * @return The condition of the achievement
	 */
	Predicate<GameState> getCondition();

	/**
	 * Check if the achievement has been unlocked, this is equal to getCondition().test(gamestate)
	 * @param game The game state to check if the achievement has been unlocked
	 * @return True if the achievement has been unlocked, false otherwise
	 */
	boolean isUnlocked(GameState game);
}
