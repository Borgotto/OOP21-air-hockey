package physics;

import utilities.Pair;

/**
 * The Dynamic2D class represent the physics laws in a 2 dimensional horizontal area.
 */

public class Dynamics2D {

    private Vector2D speedVector;
    private final double frictionConst;
    
    /**
     * Constructor for the class.
     * @param friction, a floating point number to reduce the speed during the movement.
     */
    
    public Dynamics2D() {
        this.speedVector = new Vector2D(0,0);
        this.frictionConst = 0.1;
    }
    
    public Dynamics2D(double friction) {
        this.speedVector = new Vector2D(0,0);
        this.frictionConst = friction;
    }
    
    public Dynamics2D(double xSpeed, double ySpeed, double friction) {
        this.speedVector = new Vector2D(xSpeed, ySpeed);
        this.frictionConst = friction;
    }
    
    /**
     * The velociryCalc method calculates the speed of the object in a frame.
     * @param last, the previous position of the object
     * @param current, the current position of the object
     * @return a Vector2D object that contains the speed of the object.
     */
    
    public Pair<Double,Double> updatePos(Pair<Double,Double> lastPos) {
        Pair<Double,Double> newPos = new Pair<Double,Double>(lastPos.getX() + this.speedVector.getVectorX(), lastPos.getY() + this.speedVector.getVectorY());
        return newPos;
    }
    
    /**
     * The applyFriction method applies friction to a vector of speed.
     * @param vector, the vector to be modified.
     */
    
    public void applyFriction(Vector2D vector) {
        
    }
    
}
