package logics;

import java.util.List;

/**
 * An achievement factory with basic creation methods.
 */
public interface AchievementLogicsFactory {

    /**
     * Create a new instance of AchievementLogics with a predefined list of achievements.
     * @return The new instance of AchievementLogics.
     */
    AchievementLogics baseAchievements();

    /**
     * Create a new instance of AchievementLogics from a list of achievements.
     * @param achievements The list of achievements.
     * @return The new instance of AchievementLogics.
     */
    AchievementLogics fromList(List<Achievement> achievements);
}
