package logics;

import java.util.List;

/**
 * An achievement logics manager, holds the current achievements.
 */
public interface AchievementLogics {

	/**
	 * Add an achievement to the list of achievements
	 * @param achievement the achievement to add
	 */
	void addAchievement(Achievement achievement);

	/**
	 * Add a list of achievements to the list of achievements
	 * @param achievements the list of achievements to add
	 */
	void addAchievements(List<Achievement> achievements);

	/**
	 * Get the list of achievements
	 * @return The list of achievements
	 */
	List<Achievement> getAchievements();
}
