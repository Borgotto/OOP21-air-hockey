package logics;

import java.awt.Color;

/**
 * The available game themes.
 */
public enum Theme {
	DEFAULT(new Color(0, 0, 0, 0)),
	RED(new Color(255, 0, 0, 100)),
	GREEN(new Color(0, 255, 0, 100)),
	BLUE(new Color(0, 0, 255, 100)),
	BLACK(new Color(0, 0, 0, 100));
	
	private final Color color;
	
	Theme(Color color) {
		this.color = color;
	}

	/**
	 * Get the color of the theme.
	 * @return the color
	 */
	public Color getColor() {
		return this.color;
	}
}
