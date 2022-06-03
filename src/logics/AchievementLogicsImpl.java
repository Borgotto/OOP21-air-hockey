package logics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import utils.ObjectSerializer;

public class AchievementLogicsImpl implements AchievementLogics {
	
	private ArrayList<Achievement> achievements;
	
	public AchievementLogicsImpl() {
		try {
			this.loadFromFile();
		} catch (IOException | ClassNotFoundException e) {			
			this.achievements = new ArrayList<>();
		}
	}
	
	public void addAchievement(Achievement achievement) {
		this.achievements.add(achievement);
	}

	public void addAchievements(ArrayList<Achievement> achievements) {
		this.achievements.addAll(achievements);
	}

	public List<Achievement> getAchievements() {
		return this.achievements;
	}

	@SuppressWarnings("unchecked")
	public void loadFromFile() throws IOException, FileNotFoundException, ClassNotFoundException {
		this.achievements = (ArrayList<Achievement>) ObjectSerializer.deserialize(Path.of("achievements.ser"));
	}

	public void saveToFile() throws IOException {		
		ObjectSerializer.serialize(this.achievements, Path.of("achievements.ser"));
	}

}
