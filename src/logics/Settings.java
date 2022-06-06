package logics;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * The game settings.
 */
public class Settings {
    Color theme;
    int maxScore;

    public Settings(Color theme, int maxScore) {
        this.theme = theme;
        this.maxScore = maxScore;
    }

    public Color getTheme() {
        return this.theme;
    }

    public void setTheme(Color theme) {
        this.theme = theme;
    }

    public int getMaxScore() {
        return this.maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public void load() throws IOException, IllegalAccessException {
        ObjectMapper mapper = new ObjectMapper();
        Settings s = mapper.readValue(new File("settings.json"), Settings.class);

        // Use reflection to set the field values
        for (Field f : this.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            f.set(this, f.get(s));
        }

    }

    public void save() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("settings.json"), this);
    }
}
