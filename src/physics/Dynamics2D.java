package physics;

/**
 * The Dynamic2D class represent the physics laws in a 2 dimensional horizontal area.
 */

public class Dynamics2D {

    private final Vector2D frictionVector;
    
    /**
     * Constructor for the class.
     * @param friction, a floating point number to reduce the speed during the movement.
     */
    
    public Dynamics2D(double friction) {
        frictionVector = new Vector2D(friction, friction);
    }
    
    /**
     * The velociryCalc method calculates the speed of the object in a frame.
     * @param last, the previous position of the object
     * @param current, the current position of the object
     * @return a Vector2D object that contains the speed of the object.
     */
    
    public Vector2D velocityCalc(Position last, Position current) {
        Vector2D velVector = new Vector2D(current.getXPos() - last.getXPos(), current.getYPos() - last.getYPos());
        return velVector;
    }
    
    /**
     * The applyFriction method applies friction to a vector of speed.
     * @param vector, the vector to be modified.
     */
    
    public void applyFriction(Vector2D vector) {
        vector.addVector(frictionVector);
        if(vector.getXSpeed() < 0 || vector.getYSpeed() < 0) {
            vector.setXSpeed(0);
            vector.setYSpeed(0);
        }
    }
}
