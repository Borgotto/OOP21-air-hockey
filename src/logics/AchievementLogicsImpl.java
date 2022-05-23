package logics;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AchievementLogicsImpl implements AchievementLogics {
	
	private List<Achievement> achievements;
	
	public AchievementLogicsImpl() {
		this.achievements = new ArrayList<>();
	}
	
	public AchievementLogicsImpl(File file) {
		/*TODO*/
	}

	@Override
	public void addAchievement(Achievement achievement) {
		this.achievements.add(achievement);
	}

	@Override
	public void addAchievements(List<Achievement> achievements) {
		this.achievements.addAll(achievements);
	}

	@Override
	public List<Achievement> getAchievements() {
		return this.achievements;
	}

	@Override
	public void loadFromFile() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveToFile() {
		// TODO Auto-generated method stub

	}

}
