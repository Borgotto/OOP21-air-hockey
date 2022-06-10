package logics;

import com.fasterxml.jackson.databind.ObjectMapper;

import gui.Theme;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * The game settings.
 */
public class Settings {
	private static final Path path = Path.of("config/settings.json");
	
	private String username;
    private Theme theme;
    private Integer maxScore;
    private Difficulty difficulty;
    
    public Settings() {
    	this.username = "Player";
    	this.theme = Theme.DEFAULT;
    	this.maxScore = 5;
    	this.difficulty = Difficulty.EASY;
    }

    public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Theme getTheme() {
		return this.theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public int getMaxScore() {
		return this.maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	public Difficulty getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public void load() throws IOException, IllegalAccessException {
        ObjectMapper mapper = new ObjectMapper();
        Settings s = mapper.readValue(new File(Settings.path.toString()), Settings.class);
        
        this.setUsername(s.getUsername());
        this.setTheme(s.getTheme());
        this.setMaxScore(s.getMaxScore());
        this.setDifficulty(s.getDifficulty());
    }

    public void save() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(Settings.path.toString()), this);
    }
}
