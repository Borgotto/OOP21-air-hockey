package physics;

public class Vector2D {
    private double xSpeed = 0;
    private double ySpeed = 0;
    private double xPos;
    private double yPos;
    
    public Vector2D(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    public Vector2D(double xPos, double yPos, double xSpeed, double ySpeed) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    
    public void add(Vector2D vector) {
        this.xSpeed += vector.xSpeed;
        this.ySpeed += vector.ySpeed;
    }
    
    
}
