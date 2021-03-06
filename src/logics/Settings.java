package logics;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * The game settings.
 */
public class Settings {
	private static final Path path = Path.of(System.getProperty("user.dir") + "/config/settings.json");
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

	public Integer getMaxScore() {
		return this.maxScore;
	}

	public void setMaxScore(Integer maxScore) {
		this.maxScore = Math.abs(maxScore);
	}

	public Difficulty getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public Settings load() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Settings s = mapper.readValue(new File(Settings.path.toString()), Settings.class);
			this.setUsername(s.getUsername());
			this.setTheme(s.getTheme());
			this.setMaxScore(s.getMaxScore());
			this.setDifficulty(s.getDifficulty());
		} catch (IOException e) {
			// ignore exception, return default settings
		}
        return this;
    }

    public void save() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
		Path directories = Settings.path.getParent();
        if (directories != null) {
            Files.createDirectories(directories);
        }
        mapper.writeValue(new File(Settings.path.toString()), this);
    }
}
