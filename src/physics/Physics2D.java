package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

public class Physics2D {
    private final double conversionDelta;
	
    private final Vec2 gravity = new Vec2(0.0f , 0.0f);
    private World world = new World(gravity);
    
    private final float physicsTime = 1.0f / 60.0f;
    private final int velocityIterations = 6;
    private final int positionIterations = 3;
    
    public Physics2D(final double conversionDelta) {
    	this.conversionDelta = conversionDelta;
    }
    
    /**
     * Update the physics world
     */
    public void update() {
    	world.step(physicsTime, velocityIterations, positionIterations);  
    }

	/**
	 * @return the world
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * @param world the world to set
	 */
	public void setWorld(World world) {
		this.world = world;
	}

	/**
	 * @return the conversionDelta
	 */
	public double getConversionDelta() {
		return conversionDelta;
	}
    
}
