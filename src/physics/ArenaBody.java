
package physics;

import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

public class ArenaBody extends RigidBodyImpl {
	
    public final float width;
    public final float height;
    public final float goalSize;
    
    /**
     * ArenaBody constructor
     * @param width the width of the arena
     * @param height the height of the arena
     * @param goalSize the size of the goal hole
     * @param world the world to generate the arena
     */
    public ArenaBody(final float width, final float height, final float goalSize, final Physics2D physicsWorld) {
        this.width = width;
        this.height = height;
        this.goalSize = goalSize;
        
        setBodyTypeDef(BodyType.STATIC);
        Body arenaBody = physicsWorld.addRigidBody(this);
        
        EdgeShape shape = new EdgeShape();
        
        FixtureDef arenaFixtureDef = new FixtureDef();
        arenaFixtureDef.shape = shape;
        arenaFixtureDef.density = 0.0f;
        arenaFixtureDef.restitution = 0.9f;

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
        
        setBody(arenaBody);
    }

    /**
     * @return the width of the arena
     */
    public float getWidth() {
        return width;
    }

    /**
     * @return the height of the arena
     */
    public float getHeight() {
        return height;
    }

	/**
	 * @return the goal size of the arena
	 */
	public float getGoalSize() {
		return goalSize;
	}
 
}
