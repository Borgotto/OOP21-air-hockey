package tests;

import physics.ArenaBody;
import physics.ArenaBodyImpl;
import physics.Physics2D;
import physics.Physics2DImpl;
import physics.PlayerBody;
import physics.PlayerBodyImpl;
import physics.PuckBody;
import physics.PuckBodyImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.jbox2d.common.Vec2;

public class PhysicsTest {
	
    private Physics2D physicsTestWorld;
    private PuckBody puckBody;
    private PlayerBody playerBody;
    private ArenaBody arenaBody;
    
    @org.junit.Before
    public void initTests() {
    	physicsTestWorld = new Physics2DImpl();
    	puckBody = new PuckBodyImpl(1.0f, new Vec2(9.0f, 24.0f), physicsTestWorld);
    	playerBody = new PlayerBodyImpl(1.0f, new Vec2(9.0f, 8.0f), physicsTestWorld);
    	arenaBody = new ArenaBodyImpl(16.0f, 32.0f, 0.0f, physicsTestWorld);
    }
    
    @org.junit.Test
    public void testBodyCount() {
    	int bodyNum = physicsTestWorld.getWorld().getBodyCount();
    	assertEquals(3, bodyNum);
    }
    
    @org.junit.Test
    public void testBodyPos() {
    	assertEquals(new Vec2(9.0f, 24.0f), puckBody.getPosition());
    	assertEquals(new Vec2(9.0f, 8.0f), playerBody.getPosition());
    }
    
    @org.junit.Test
    public void testPlayerForceApply() {
    	playerBody.updateSpeedVec(new Vec2(5.0f, 0.0f)); // Moved to the right
    	for(int i = 0; i < 3; i++) physicsTestWorld.update();
    	assertNotEquals(new Vec2(9.0f, 8.0f), puckBody.getPosition());
    	assertNotEquals(new Vec2(0.0f, 0.0f), playerBody.getBody().getLinearVelocity());
    	playerBody.resetBodyPos();
    	assertEquals(new Vec2(0.0f, 0.0f), playerBody.getBody().getLinearVelocity());
    }
    
    @org.junit.Test
    public void destroyBodies() {
    	physicsTestWorld.deleteAllBodies();
    	int bodyNum = physicsTestWorld.getWorld().getBodyCount();
    	assertEquals(0, bodyNum);
    }
}
