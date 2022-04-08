package physics;

/**
 * The Position class represents the coordinates in the X and Y axis.
 */

public class Position {
    private double xPos;
    private double yPos;
    
    public Position(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    public double getXPos() {
        return this.xPos;
    }
    
    public double getYPos() {
        return this.yPos;
    }
}
