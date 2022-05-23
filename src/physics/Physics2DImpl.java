package physics;

import java.util.ArrayList;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

public class Physics2DImpl implements Physics2D {	
    private final Vec2 gravity;
    private World world;
    
    private ArrayList<RigidBody> rigidBodyList = new ArrayList<RigidBody>();
    
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

	@Override
	public World getWorld() {
		return this.world;
	}

	@Override
	public Body addRigidBody(RigidBodyImpl rigidBody) {
		Body body = getWorld().createBody(rigidBody.getBodyDef());
		this.rigidBodyList.add(rigidBody);
		return body;
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
