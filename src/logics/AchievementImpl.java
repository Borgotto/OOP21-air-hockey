package logics;

import java.util.function.Predicate;
import javax.swing.ImageIcon;

public class AchievementImpl implements Achievement {
	
	private static final long serialVersionUID = 1L;
	private final ImageIcon icon;
	private final String name;
	private final String description;
	private final Predicate<GameState> condition;
	
	/**
	 * Create a new Achievement object with default values
	 */
	public AchievementImpl() {
		this.icon = new ImageIcon();
		this.name = "";
		this.description = "";
		this.condition = (gameState) -> true; 
	}
	
	/**
	 * Create a new Achievement object with given values
	 * @param icon The icon of the achievement
	 * @param name The name of the achievement
	 * @param description A brief description of what has been unlocked
	 * @param condition The unlocking condition of the achievement
	 */
	public AchievementImpl(ImageIcon icon, String name, String description, Predicate<GameState> condition) {
		this.icon = icon;
		this.name = name;
		this.description = description;
		this.condition = condition;
	}
	
	/**
	 * Get the icon of the achievement
	 * @return The icon of the achievement
	 */
	public ImageIcon getIcon() {
		return this.icon;
	}
	
	 /**
	  * Get the name of the achievement
	  * @return The name of the achievement
	  */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get the description of the achievement
	 * @return The description of the achievement
	 */
	public String getDescr() {
		return this.description;
	}
	
	/**
	 * Get the unlocking condition of the achievement 
	 * @return The Unlocking condition of the achievement
	 */
	public Predicate<GameState> getCondition() {
		return this.condition;
	}
	
	/**
	 * Check if the achievement has been unlocked
	 * @param gamestate The situation of the game
	 * @return true if the condition is satisfy
	 * 
	 */
	public boolean isUnlocked(GameState gamestate) {
		return this.condition.test(gamestate);
	}
}