package logics;

import java.util.ArrayList;
import java.util.List;

public class AchievementLogicsImpl implements AchievementLogics {
	private final ArrayList<Achievement> achievements;
	
	public AchievementLogicsImpl() {
		this.achievements = new ArrayList<>();
	}
	
	public void addAchievement(Achievement achievement) {
		this.achievements.add(achievement);
	}

	public void addAchievements(List<Achievement> achievements) {
		this.achievements.addAll(achievements);
	}

	public List<Achievement> getAchievements() {
		return this.achievements;
	}
}
