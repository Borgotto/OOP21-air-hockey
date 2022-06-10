package utils;

import org.jbox2d.common.Vec2;
import java.awt.*;

/**
 * Utility class for converting units from one Coordinate System to another.
 * The first being the awt-based coordinate system and the second being the JBox2D one.
 * awt uses the top left corner as the origin, while JBox2D uses the bottom left corner.
 */
public class UnitConverter {

	public final Dimension cs1;
	public final Vec2 cs2;
	public final float xScaling;
	public final float yScaling;
	private Vec2 offset;

	/**
	 * Constructs a new UnitConverter.
	 * @param cs1 The first Coordinate System (awt-based Dimension).
	 * @param cs2 The second Coordinate System (JBox2D's Vec2).
	 * Both Coordinate Systems should represent the maximum area available on the x and y axis.
	 */
	public UnitConverter(final Dimension cs1, final Vec2 cs2) {
		this.cs1 = cs1;
		this.cs2 = cs2;
		this.xScaling = cs1.width / cs2.x;
		this.yScaling = cs1.height / cs2.y;
		offset = new Vec2(0, 0);
	}

	/**
	 * Get the current offset.
	 * @return The offset.
	 */
	public Vec2 getOffset() {
		return this.offset;
	}

	/**
	 * Sets the offset to add to the converted coordinates.
	 * @param offset The offset to set
	 */
	public void setOffset(Vec2 offset) {
		this.offset = offset;
	}

	/**
	 * Convert a {@link Vec2} of {@link org.jbox2d} to {@link Point} from {@link java.awt}.
	 * @param position the {@link Vec2} position to convert
	 * @return The converted position as a {@link Point}.
	 */
	public Point MeterToPixel(final Vec2 position) {
		return new Point(Math.round(position.x * this.xScaling + offset.x), cs1.height - Math.round(position.y * this.yScaling - offset.y));
	}

	/**
	 * Convert a {@link Point} from {@link java.awt} to a {@link Vec2} of {@link org.jbox2d}.
	 * @param position The {@link Point} to convert.
	 * @return The converted position as a {@link Vec2}.
	 */
	public Vec2 PixelToMeter(final Point position) {
		return new Vec2(position.x * this.xScaling + offset.x, position.y * this.yScaling + offset.y);
	}
}
