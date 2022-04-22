package physics;

public class Collision2D {
    
    public void wallCollisionX(Vector2D vector) {
        vector.swapSignX();
    }
    
    public void wallCollisionY(Vector2D vector) {
        vector.swapSignY();
    }
}
