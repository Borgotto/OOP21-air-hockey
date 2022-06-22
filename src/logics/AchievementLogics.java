package logics;

import java.util.List;

/**
 * An achievement logics manager, holds the current achievements.
 */
public interface AchievementLogics {

	/**
	 * Add an achievement to the list of achievements
	 * @param achievement The achievement to add.
	 */
	void addAchievement(Achievement achievement);

	/**
	 * Add a list of achievements to the list of achievements
	 * @param achievements The list of achievements to add.
	 */
	void addAchievements(List<Achievement> achievements);

	/**
	 * Get the list of achievements
	 * @return The list of achievements.
	 */
	List<Achievement> getAchievements();
}
