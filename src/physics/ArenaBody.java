package physics;

import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class ArenaBody extends RigidBody {
	
	/**
	 * Arena body generator
	 * @param world
	 */
    public ArenaBody(World world) {
        setBodyTypeDef(BodyType.STATIC);
        Body arenaBody = world.createBody(getBodyDef());
        
        EdgeShape wallShape = new EdgeShape();
        
        FixtureDef sd = new FixtureDef();
        sd.shape = new EdgeShape();
        sd.density = 0.0f;
        sd.restitution = 0.9f;
        
        //The arena dimensions are 16x32 meters. (Proportion: 9:16)
                
        // Vertical walls of the arena
        wallShape.set(new Vec2(0.0f, 0.0f), new Vec2(0.0f, 32.0f));
        arenaBody.createFixture(sd);
        // Right wall
        wallShape.set(new Vec2(18.0f, 0.0f), new Vec2(18.0f, 32.0f));
        arenaBody.createFixture(sd);
        
        // Horizontal walls of the arena
        // Bottom wall
        wallShape.set(new Vec2(0.0f, 0.0f), new Vec2(18.0f, 0.0f));
        arenaBody.createFixture(sd);
        // Top Wall
        wallShape.set(new Vec2(0.0f, 32.0f), new Vec2(18.0f, 32.0f));
        arenaBody.createFixture(sd);
        
        setBody(arenaBody);
    }
    
}
