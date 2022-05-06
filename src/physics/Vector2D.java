package physics;

/**
 * The Vector2D class represents a 2-dimensional vector in velocity.
 */

public class Vector2D {
    private Double vectorX = 0.0;
    private Double vectorY = 0.0;
    private final Double SWAPNUMBER = -1.0;
    
    /**
     * Constructor for the 2-dimensional vector.
     * @param xSpeed, the speed in the X axis.
     * @param ySpeed, the speed in the Y axis.
     */
    
    public Vector2D(Double xVector, Double yVector) {
        this.vectorX = xVector;
        this.vectorY = yVector;
    }
    
    /**
     * The addVector method is used to add a vector.
     * @param vector, the other vector to be added.
     */
    
    public void addVector(Vector2D vector) {
        this.vectorX += vector.vectorX;
        this.vectorY += vector.vectorY;
    }
    
    /**
     * Modifies directly the speed of the vector in the X axis.
     * @param speed in X
     */
    
    public void setVectorX(Double xVector) {
        this.vectorX = xVector;
    }
    
    /**
     * Modifies directly the speed of the vector in the Y axis.
     * @param speed in Y
     */
    
    public void setVectorY(Double yVector) {
        this.vectorY = yVector;
    }
    
    /**
     * Swap the X axis.
     */
    
    public void swapSignX() {
        this.vectorX = this.getVectorX()*this.SWAPNUMBER;
    }
    
    /**
     * Swap the Y axis.
     */
    
    public void swapSignY() {
        this.vectorY = this.getVectorY()*this.SWAPNUMBER;
    }
    
    /**
     * Get the X axis speed.
     * @return the speed in the X axis.
     */
    
    public Double getVectorX() {
        return this.vectorX;
    }
    
    /**
     * Get the Y axis speed.
     * @return the speed in the Y axis.
     */
    
    public Double getVectorY() {
        return this.vectorY;
    }
    
    /**
     * toString method of Vector2D class.
     */
    
    public String toString() {
        return "Vector2D [xVector=" + this.vectorX + ", yVector=" + this.vectorY + "]";
    }
}
