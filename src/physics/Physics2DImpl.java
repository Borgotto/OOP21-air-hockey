package physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

import java.util.ArrayList;

public class Physics2DImpl implements Physics2D {
	private static final Vec2 GRAVITY = new Vec2(0.0f, 0.0f);
	private static final float PHYSICS_TIME = 1.0f/60.0f;
	private static final int VELOCITY_ITERATIONS = 12;
	private static final int POSITION_ITERATIONS = 6;
    private final World world;
    private final ArrayList<RigidBody> rigidBodyList;
    private final float physicsTime;
    private final int velocityIterations;
    private final int positionIterations;
    
    public Physics2DImpl() {
        this.physicsTime = PHYSICS_TIME;
		this.velocityIterations = VELOCITY_ITERATIONS;
		this.positionIterations = POSITION_ITERATIONS;
		this.world = new World(GRAVITY);
		this.rigidBodyList = new ArrayList<>();
	}

    public void update() {
    	this.world.step(physicsTime, velocityIterations, positionIterations);  
    }

	public World getWorld() {
		return this.world;
	}

	public void addRigidBody(RigidBody rigidBody) {
		this.rigidBodyList.add(rigidBody);
	}

	public void resetWorld() {
		for(RigidBody rigidBody : this.rigidBodyList) {
			rigidBody.resetBodyPos();
		}
	}

	public void deleteAllBodies() {
		for(RigidBody rigidBody : this.rigidBodyList) {
			this.getWorld().destroyBody(rigidBody.getBody());
		}
		this.rigidBodyList.clear();
	}

}
