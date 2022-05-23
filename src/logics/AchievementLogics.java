package logics;

import java.util.List;

public interface AchievementLogics {
	
	public void addAchievement(Achievement achievement);
	
	public void addAchievements(List<Achievement> achievements);
	
	public List<Achievement> getAchievements();
	
	public void loadFromFile(); /*TODO*/
	
	public void saveToFile(); /*TODO*/
}
