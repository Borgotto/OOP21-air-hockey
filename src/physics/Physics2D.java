package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

import utils.Pair;

public class Physics2D {
    
    private final Vec2 gravity = new Vec2(0.0f , 0.0f);
    private World world = new World(gravity);
    
    private final float physicsTime = 1.0f / 60.0f;
    private final int velocityIterations = 6;
    private final int positionIterations = 3;
    
    public Physics2D() {
    	
    }
    
    /**
     * Update the physics world.
     * @param dt the 
     */
    
    public void update() {
    	world.step(physicsTime, velocityIterations, positionIterations);  
    }
    
    /**
     * @param gameBody the RigidBody to search.
     * @return pairPos the position in pixels.
     */
    public Pair<Double,Double> getBodyPos(RigidBody gameBody) {
    	Vec2 vecPos = gameBody.getPosition();
    	
    	/**
    	 * TODO: Implement unit converter between pixels and vectors.
    	 */
    	
    	Pair<Double,Double> pairPos = new Pair<Double,Double>((double)vecPos.x,(double)vecPos.y);
    	return pairPos;
    }
    

    /**
     * @return the world
     */
    public World getWorld() {
        return world;
    }
    
}
