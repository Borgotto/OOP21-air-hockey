
package physics;

import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

public class ArenaBodyImpl extends RigidBodyImpl implements ArenaBody {
	
    private final float width;
    private final float height;
    private final float goalSize;
    
    /**
     * ArenaBody constructor
     * @param width the width of the arena
     * @param height the height of the arena
     * @param goalSize the size of the goal hole
     * @param world the world to generate the arena
     */
    public ArenaBodyImpl(final float width, final float height, final float goalSize, final Physics2D physicsWorld) {
        this.width = width;
        this.height = height;
        this.goalSize = goalSize;
        
        this.setBodyType(BodyType.STATIC);
        Body arenaBody = physicsWorld.getWorld().createBody(getBodyDef());
        physicsWorld.addRigidBody(this);
        
        EdgeShape shape = new EdgeShape();
        
        FixtureDef arenaFixtureDef = new FixtureDef();
        arenaFixtureDef.shape = shape;
        arenaFixtureDef.density = 0.0f;
        arenaFixtureDef.restitution = 1.0f;
        
        // Left vertical wall
        shape.set(new Vec2(0.0f, 0.0f), new Vec2(0.0f, getHeight()));
        arenaBody.createFixture(arenaFixtureDef);
        // Right vertical wall
        shape.set(new Vec2(getWidth(), 0.0f), new Vec2(getWidth(), getHeight()));
        arenaBody.createFixture(arenaFixtureDef);
        
        float goalHalfSize = (getGoalSize()/2);
        float widthHalfSize = (getWidth()/2);
        
        // Bottom-left horizontal wall
        shape.set(new Vec2(0.0f, 0.0f), new Vec2(widthHalfSize - goalHalfSize, 0.0f));
        arenaBody.createFixture(arenaFixtureDef);
        // Bottom-right horizontal wall
        shape.set(new Vec2(widthHalfSize + goalHalfSize, 0.0f), new Vec2(getWidth(), 0.0f));
        arenaBody.createFixture(arenaFixtureDef);
        
        // Bottom-left horizontal wall
        shape.set(new Vec2(0.0f,  getHeight()), new Vec2(widthHalfSize - goalHalfSize, getHeight()));
        arenaBody.createFixture(arenaFixtureDef);
        // Bottom-right horizontal wall
        shape.set(new Vec2(widthHalfSize + goalHalfSize,  getHeight()), new Vec2(getWidth(),  getHeight()));
        arenaBody.createFixture(arenaFixtureDef);
        
        // Generation of the mid arena wall. This wall has the properties of collide only with the player, not the puck.
        shape.set(new Vec2(0.0f, (float)(getHeight()/2)), new Vec2(getWidth(), (float)(getHeight()/2)));
        arenaFixtureDef.filter.maskBits = 0x0002;
        arenaBody.createFixture(arenaFixtureDef);
        
        // Generation of the bottom arena wall. This wall has the properties of collide only with the player, not the puck.
        shape.set(new Vec2(0.0f, 0.0f), new Vec2(getWidth(), 0.0f));
        arenaFixtureDef.filter.maskBits = 0x0002;
        arenaBody.createFixture(arenaFixtureDef);
        
        // Generation of the top arena wall. This wall has the properties of collide only with the player, not the puck.
        shape.set(new Vec2(0.0f, getHeight()), new Vec2(getWidth(), getHeight()));
        arenaFixtureDef.filter.maskBits = 0x0002;
        arenaBody.createFixture(arenaFixtureDef);
        
        this.setBody(arenaBody);
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public float getGoalWidth() {
        return this.goalSize;
    }

    public float getGoalSize() {
        return this.goalSize;
    }
 
}
