package logics;

import javax.swing.*;

import java.io.Serializable;
import java.util.function.Predicate;

public class AchievementImpl implements Achievement {
	private final ImageIcon icon = new ImageIcon("res/achievement.png");
	private final String name;
	private final String description;
	private final Predicate<GameState> condition;

	/**
	 * Create a new Achievement object with given values
	 * @param name The name of the achievement
	 * @param description A brief description of what has been unlocked
	 * @param condition The unlocking condition
	 */
	public AchievementImpl(String name, String description, Predicate<GameState> condition) {
		this.name = name;
		this.description = description;
		this.condition = condition;
	}

	public ImageIcon getIcon() {
		return this.icon;
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