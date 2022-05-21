package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

public class Physics2DImpl implements Physics2D {	
    private final Vec2 gravity;
    private World world;
    
    private final float physicsTime;
    private final int velocityIterations;
    private final int positionIterations;
    
    public Physics2DImpl() {
        this.gravity = new Vec2(0.0f, 0.0f);
        this.world = new World(gravity);
        this.physicsTime = 1.0f / 60.0f;
        this.velocityIterations = 6;
        this.positionIterations = 3;
    }
    
    /**
     * Update the physics world
     */
    @Override
    public void update() {
    	world.step(physicsTime, velocityIterations, positionIterations);  
    }

	/**
	 * @return the world
	 */
    @Override
	public World getWorld() {
		return world;
	}

    @Override
    public void resetWorld() {
        // TODO Auto-generated method stub
        
    }
	
}
