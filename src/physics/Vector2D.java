package physics;

/**
 * The Vector2D class represents a 2 dimensional vector in velocity.
 */

public class Vector2D {
    private double xSpeed;
    private double ySpeed;
    
    /**
     * Constructor for the bidimensional vector.
     * @param xSpeed, the speed in the X axis.
     * @param ySpeed, the speed in the Y axis.
     */
    
    public Vector2D(double xSpeed, double ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    
    /**
     * The addVector method is used to modify the vector with another vector.
     * @param vector, the other vector to be added.
     */
    
    public void addVector(Vector2D vector) {
        this.xSpeed += vector.xSpeed;
        this.ySpeed += vector.ySpeed;
    }
    
    /**
     * Modifies directly the speed of the vector in the X axis.
     * @param speed in X
     */
    
    public void setXSpeed(double speed) {
        this.xSpeed = speed;
    }
    
    /**
     * Modifies directly the speed of the vector in the Y axis.
     * @param speed in Y
     */
    
    public void setYSpeed(double speed) {
        this.xSpeed = speed;
    }
    
    /**
     * Get the X axis speed.
     * @return the speed in the X axis.
     */
    
    public double getXSpeed() {
        return this.xSpeed;
    }
    
    /**
     * Get the Y axis speed.
     * @return the speed in the Y axis.
     */
    
    public double getYSpeed() {
        return this.ySpeed;
    }
}
