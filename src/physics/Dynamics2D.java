package physics;

import utilities.Pair;

/**
 * The Dynamic2D class represent the physics laws in a 2 dimensional horizontal area.
 */

public class Dynamics2D {

    private final double frictionConst;
    
    /**
     * Constructor for the class.
     * @param friction, a floating point number to reduce the speed during the movement.
     */
    
    public Dynamics2D(double friction) {
        this.frictionConst = friction;
    }
    
    /**
     * The velociryCalc method calculates the speed of the object in a frame.
     * @param last, the previous position of the object
     * @param current, the current position of the object
     * @return a Vector2D object that contains the speed of the object.
     */
    
    public Vector2D velocityCalc(Pair<Float,Float> lastCord, Pair <Float,Float> newCord) {
        Vector2D velVector = new Vector2D(newCord.getX() - lastCord.getX(), newCord.getY() - lastCord.getY());
        return velVector;
    }
    
    /**
     * The applyFriction method applies friction to a vector of speed.
     * @param vector, the vector to be modified.
     */
    
    public void applyFriction(Vector2D vector) {
        vector.mulVectorConst(frictionConst);
    }
    
}
