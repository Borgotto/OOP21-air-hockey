package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

import java.util.ArrayList;

public class Physics2DImpl implements Physics2D {	
    private final Vec2 gravity;
    private World world;
    
    private ArrayList<RigidBody> rigidBodyList;
    
    private final float physicsTime;
    private final int velocityIterations;
    private final int positionIterations;
    
    public Physics2DImpl() {
        this.gravity = new Vec2(0.0f, 0.0f);
        this.world = new World(gravity);
        
        rigidBodyList = new ArrayList<RigidBody>();
        
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
			getWorld().destroyBody(rigidBody.getBody());
		}
		rigidBodyList.clear();
	}

}
