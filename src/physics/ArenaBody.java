package physics;

public interface ArenaBody extends RigidBody {
    
    /**
     * @return the width of the arena
     */
    public float getWidth();
    
    /**
     * @return the height of the arena
     */
    public float getHeight();
    
    /**
     * @return the goal size of the arena
     */
    public float getGoalSize();
    
}
