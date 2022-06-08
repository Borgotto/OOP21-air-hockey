package logics;

import javax.swing.*;
import java.io.Serializable;
import java.util.function.Predicate;

/**
 * Interface describing an achievement
 */
public interface Achievement {

	/**
	 * Get the image representing the achievement or an empty image if imagePath is not set
	 * @return The image icon
	 */
	public ImageIcon getIcon();

	/**
	 * Get the name of the achievement
	 * @return The name of the achievement
	 */
	public String getName();

	/**
	 * Get the description of the achievement
	 * @return The description of the achievement
	 */
	public String getDescr();

	/**
	 * Get the condition necessary to unlock the achievement
	 * @return The condition of the achievement
	 */
	public Predicate<GameState> getCondition();

	/**
	 * Check if the achievement has been unlocked, this is equal to getCondition().test(gamestate)
	 * @param gamestate
	 * @return True if the achievement has been unlocked, false otherwise
	 */
	public boolean isUnlocked(GameState gamestate);
}
