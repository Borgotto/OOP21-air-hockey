package logics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface AchievementLogics {

	/**
	 * Add an achievement to the list of achievements
	 * @param achievement the achievement to add
	 */
	public void addAchievement(Achievement achievement);

	/**
	 * Add a list of achievements to the list of achievements
	 * @param achievements the list of achievements to add
	 */
	public void addAchievements(List<Achievement> achievements);

	/**
	 * Get the list of achievements
	 * @return The list of achievements
	 */
	public List<Achievement> getAchievements();
}
