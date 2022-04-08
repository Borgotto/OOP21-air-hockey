package physics;

/**
 * The Position class represents the coordinates in the X and Y axis.
 */

public class Position {
    private double xPos;
    private double yPos;
    
    /**
     * Constructor for the coordinates.
     * @param xPos, the position in the X axis.
     * @param yPos, the position in the Y axis.
     */
    
    public Position(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    /**
     * Get the X axis position.
     * @return the X axis position.
     */
    
    public double getXPos() {
        return this.xPos;
    }
    
    /**
     * Get the Y axis position.
     * @return the Y axis position.
     */
    
    public double getYPos() {
        return this.yPos;
    }
}
