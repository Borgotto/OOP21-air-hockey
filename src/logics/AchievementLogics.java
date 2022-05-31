package logics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface AchievementLogics {
	
	public void addAchievement(Achievement achievement);
	
	public void addAchievements(ArrayList<Achievement> achievements);
	
	public List<Achievement> getAchievements();
	
	public void loadFromFile() throws IOException, FileNotFoundException, ClassNotFoundException;
	
	public void saveToFile() throws IOException;
}
