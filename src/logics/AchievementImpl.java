package logics;

import utils.ResourceLoader;

import java.awt.*;
import java.util.function.Predicate;

/**
 * Implementation of the Achievement interface.
 */
public class AchievementImpl implements Achievement {
	private final Image icon = ResourceLoader.loadImage("achievement.png");
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

	public Image getIcon() {
		return this.icon;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public Predicate<GameState> getCondition() {
		return this.condition;
	}

	public boolean isUnlocked(GameState game) {
		return this.condition.test(game);
	}
}