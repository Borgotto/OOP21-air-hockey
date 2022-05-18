
package physics;

import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class ArenaBody extends RigidBodyImpl {
	
	private final float width;
	private final float height;
	
	/**
	 * Arena body generator
	 * @param world
	 */
    public ArenaBody(final float width, final float height, final World world) {
    	this.width = width;
    	this.height = height;
    	
        setBodyTypeDef(BodyType.STATIC);
        Body arenaBody = world.createBody(getBodyDef());
        
        EdgeShape shape = new EdgeShape();
        
        FixtureDef arenaFixtureDef = new FixtureDef();
        arenaFixtureDef.shape = shape;
        arenaFixtureDef.density = 0.0f;
        arenaFixtureDef.restitution = 0.9f;
        
        // The arena proportion is 9:16
                
        // Vertical walls of the arena
        shape.set(new Vec2(0.0f, 0.0f), new Vec2(0.0f, getHeight()));
        arenaBody.createFixture(arenaFixtureDef);
        // Right wall
        shape.set(new Vec2(getWidth(), 0.0f), new Vec2(getWidth(), getHeight()));
        arenaBody.createFixture(arenaFixtureDef);
        
        // Horizontal walls of the arena
        // Bottom wall
        shape.set(new Vec2(0.0f, 0.0f), new Vec2(getWidth(), 0.0f));
        arenaBody.createFixture(arenaFixtureDef);
        // Top Wall
        shape.set(new Vec2(0.0f, getHeight()), new Vec2(getWidth(), getHeight()));
        arenaBody.createFixture(arenaFixtureDef);
        
        setBody(arenaBody);
    }
    
    /**
     * Generates a wall where only the player collides with.
     * @param playerBody the player to be limited
     */
    public void setPlayerArenaLimit(PlayerBody playerBody) {
    	EdgeShape shape = new EdgeShape();
    	
    	FixtureDef midArenaFixtureDef = new FixtureDef();
    	
    	midArenaFixtureDef.shape = shape;
    	midArenaFixtureDef.density = 0.0f;
    	midArenaFixtureDef.restitution = 0.9f;
    	
    	shape.set(new Vec2(0.0f, (float)(getWidth()/2)), new Vec2(getHeight(), (float)(getWidth()/2)));
    	
    	/**
    	 * TODO: create filtering for playerBody.
    	 */
    	
    	getBody().createFixture(midArenaFixtureDef);
    	
    }

	/**
	 * @return the width
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public float getHeight() {
		return height;
	}
    
}
