package logics;

import javax.swing.*;

import java.io.Serializable;
import java.util.function.Predicate;

public class AchievementImpl implements Achievement {
	
	private static final long serialVersionUID = 1L;
	private final String iconPath;
	private final String name;
	private final String description;
	private Predicate<GameState> condition;
	
	/**
	 * Create a new Achievement object with default values
	 */
	@SuppressWarnings("unchecked")
	public AchievementImpl() {
		this.iconPath = "";
		this.name = "";
		this.description = "";
		this.condition = (Predicate & Serializable) (game)->true; 
	}
	
	/**
	 * Create a new Achievement object with given values
	 * @param iconPath The path to the file
	 * @param name The name of the achievement
	 * @param description A brief description of what has been unlocked
	 * @param condition The unlocking condition
	 */
	public AchievementImpl(String iconPath, String name, String description, Predicate<GameState> condition) {
		this.iconPath = iconPath;
		this.name = name;
		this.description = description;
		this.condition = (Predicate & Serializable) condition;
	}

	public ImageIcon getIcon() {
		return new ImageIcon(this.iconPath);
	}

	public String getName() {
		return this.name;
	}

	public String getDescr() {
		return this.description;
	}

	public Predicate<GameState> getCondition() {
		return this.condition;
	}

	public boolean isUnlocked(GameState gamestate) {
		return this.condition.test(gamestate);
	}
}