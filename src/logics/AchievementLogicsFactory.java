package logics;

import java.util.List;

public interface AchievementLogicsFactory {

    /**
     * Create a new instance of AchievementLogics with a predefined list of achievements.
     * @return the new instance of AchievementLogics
     */
    AchievementLogics baseAchievements();

    /**
     * Create a new instance of AchievementLogics from a list of achievements.
     * @param achievements the list of achievements
     * @return the new instance of AchievementLogics
     */
    AchievementLogics fromList(List<Achievement> achievements);
}
