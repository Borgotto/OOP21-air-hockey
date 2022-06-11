package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

import java.util.ArrayList;

public class Physics2DImpl implements Physics2D {	
	
	private static final Vec2 GRAVITY = new Vec2(0.0f, 0.0f);
	private static final float PHYSICS_TIME = 1.0f/60.0f;
	private static final int VELOCITY_ITERATIONS = 6;
	private static final int POSITION_ITERATIONS = 3;

	
	private final Vec2 gravity;
    private World world;
    
    private ArrayList<RigidBody> rigidBodyList;
    
    private final float physicsTime;
    private final int velocityIterations;
    private final int positionIterations;
    
    public Physics2DImpl() {
        this.gravity = GRAVITY;
        this.world = new World(gravity);
        
        rigidBodyList = new ArrayList<RigidBody>();
        
        this.physicsTime = PHYSICS_TIME;
        this.velocityIterations = VELOCITY_ITERATIONS;
        this.positionIterations = POSITION_ITERATIONS;
    }
    
    /**
     * Update the physics world
     */
    @Override
    public void update() {
    	this.world.step(physicsTime, velocityIterations, positionIterations);  
    }

	@Override
	public World getWorld() {
		return this.world;
	}

	@Override
	public void addRigidBody(RigidBody rigidBody) {
		this.rigidBodyList.add(rigidBody);
	}

	@Override
	public void resetWorld() {
		for(RigidBody rigidBody : rigidBodyList) {
			rigidBody.resetBodyPos();
		}
	}

	@Override
	public void deleteAllBodies() {
		for(RigidBody rigidBody : rigidBodyList) {
			this.getWorld().destroyBody(rigidBody.getBody());
		}
		rigidBodyList.clear();
	}

}
