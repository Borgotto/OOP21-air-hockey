package logics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface AchievementLogics {

	/**
	 * Add an achievement to the list of achievements
	 * @param achievement
	 */
	public void addAchievement(Achievement achievement);

	/**
	 * Add a list of achievements to the list of achievements
	 * @param achievements
	 */
	public void addAchievements(ArrayList<Achievement> achievements);

	/**
	 * Get the list of achievements
	 * @return The list of achievements
	 */
	public List<Achievement> getAchievements();

	/**
	 * Load the list of achievements from a previously serialized file
	 * @throws IOException if an I/O error occurs
	 * @throws FileNotFoundException if the file does not exist
	 * @throws ClassNotFoundException if the serialized object cannot be deserialized
	 */
	public void loadFromFile() throws IOException, FileNotFoundException, ClassNotFoundException;
	
	public void saveToFile() throws IOException;
}
