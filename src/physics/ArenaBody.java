
package physics;

import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class ArenaBody extends RigidBodyImpl {
	
	/**
	 * Arena body generator
	 * @param world
	 */
    public ArenaBody(final float width, final float height, final World world) {

        setBodyTypeDef(BodyType.STATIC);
        Body arenaBody = world.createBody(getBodyDef());
        
        EdgeShape shape = new EdgeShape();
        
        FixtureDef arenaFixtureDef = new FixtureDef();
        arenaFixtureDef.shape = shape;
        arenaFixtureDef.density = 0.0f;
        arenaFixtureDef.restitution = 0.9f;
        
        // The arena proportion is 9:16
                
        // Vertical walls of the arena
        shape.set(new Vec2(0.0f, 0.0f), new Vec2(0.0f, height));
        arenaBody.createFixture(arenaFixtureDef);
        // Right wall
        shape.set(new Vec2(width, 0.0f), new Vec2(width, height));
        arenaBody.createFixture(arenaFixtureDef);
        
        // Horizontal walls of the arena
        // Bottom wall
        shape.set(new Vec2(0.0f, 0.0f), new Vec2(width, 0.0f));
        arenaBody.createFixture(arenaFixtureDef);
        // Top Wall
        shape.set(new Vec2(0.0f, height), new Vec2(width, height));
        arenaBody.createFixture(arenaFixtureDef);
        
        // Generation of the mid arena wall. This wall has the properties of collide only with the player, not the puck.
        shape.set(new Vec2(0.0f, (float)(height/2)), new Vec2(width, (float)(height/2)));
        arenaFixtureDef.filter.maskBits = 0x0002;
        arenaBody.createFixture(arenaFixtureDef);

        
        setBody(arenaBody);
    }
    
    /*
     * TODO: method that register a PlayerBody to the mid wall arena filter.
     */
}
