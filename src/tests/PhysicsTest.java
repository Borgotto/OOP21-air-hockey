package tests;

import org.jbox2d.common.Vec2;
import physics.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Test for the Physics package.
 */
public class PhysicsTest {
    private Physics2D physicsTestWorld;
    private PuckBody puckBody;
    private PlayerBody playerBody;
    
    @org.junit.Before
    public void initTests() {
    	physicsTestWorld = new Physics2DImpl();
    	puckBody = new PuckBodyImpl(1.0f, new Vec2(9.0f, 24.0f), physicsTestWorld);
    	playerBody = new PlayerBodyImpl(1.0f, new Vec2(9.0f, 8.0f), physicsTestWorld);
    }
    
    @org.junit.Test
    public void testBodyCount() {
    	int bodyNum = physicsTestWorld.getWorld().getBodyCount();
    	assertEquals(2, bodyNum);
    }
    
    @org.junit.Test
    public void testBodyPos() {
    	assertEquals(new Vec2(9.0f, 24.0f), puckBody.getPosition());
    	assertEquals(new Vec2(9.0f, 8.0f), playerBody.getPosition());
    }
    
    @org.junit.Test
    public void testPlayerForceApply() {
    	playerBody.getBody().setLinearVelocity(new Vec2(5.0f, 0.0f)); // Moved to the right
    	for(int i = 0; i < 3; i++) physicsTestWorld.update();
    	assertNotEquals(new Vec2(9.0f, 8.0f), puckBody.getPosition());
    	assertNotEquals(new Vec2(0.0f, 0.0f), playerBody.getBody().getLinearVelocity());
    }
    
    @org.junit.Test
    public void testResetPosition() {
    	playerBody.resetBodyPos();
    	assertEquals(new Vec2(0.0f, 0.0f), playerBody.getBody().getLinearVelocity());
    }
    
    @org.junit.Test
    public void testDestroyBodies() {
    	physicsTestWorld.deleteAllBodies();
    	int bodyNum = physicsTestWorld.getWorld().getBodyCount();
    	assertEquals(0, bodyNum);
    }
}
