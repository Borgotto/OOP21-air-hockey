package physics;

import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

public class ArenaBodyImpl extends RigidBodyImpl implements ArenaBody {
	private static final float DENSITY_VALOR = 0.0f;
	private static final float ENERGY_RESTITUTION = 0.9f;
	private static final float FILTER_RESTITUTION = 0.0f;
	private static final int PLAYER_BITMASK = 0x0002;
	private static final float PLAYER_FILTER_DISTANCE = 0.1f;
	private static final float ANGLE_DIVIDER = 14;

	private final float width;
    private final float height;
    private final float goalWidth;
    
    /**
     * ArenaBody constructor
     * @param width The width of the arena.
     * @param height The height of the arena.
     * @param goalWidth The size of the goal hole.
     * @param physics The physics obj to generate the arena in.
     */
    public ArenaBodyImpl(final float width, final float height, final float goalWidth, final Physics2D physics) {
        this.width = width;
        this.height = height;
        this.goalWidth = goalWidth;
        this.setBodyType(BodyType.STATIC);
        Body arenaBody = physics.getWorld().createBody(this.getBodyDef());
        physics.addRigidBody(this);
        
        // Left vertical wall
        arenaBody.createFixture(this.generateWall(new Vec2(0.0f, 0.0f), new Vec2(0.0f, this.getHeight())));
        // Right vertical wall
        arenaBody.createFixture(this.generateWall(new Vec2(this.getWidth(), 0.0f), new Vec2(this.getWidth(), this.getHeight())));
        
        float goalHalfSize = (this.getGoalWidth()/2);
        float widthHalfSize = (this.getWidth()/2);
        // Bottom-left horizontal wall
        arenaBody.createFixture(this.generateWall(new Vec2(0.0f, 0.0f), new Vec2(widthHalfSize - goalHalfSize, 0.0f)));
        // Bottom-right horizontal wall
        arenaBody.createFixture(this.generateWall(new Vec2(widthHalfSize + goalHalfSize, 0.0f), new Vec2(this.getWidth(), 0.0f)));
        // Bottom-left horizontal wall
        arenaBody.createFixture(this.generateWall(new Vec2(0.0f,  this.getHeight()), new Vec2(widthHalfSize - goalHalfSize, this.getHeight())));
        // Bottom-right horizontal wall
        arenaBody.createFixture(this.generateWall(new Vec2(widthHalfSize + goalHalfSize,  this.getHeight()), new Vec2(this.getWidth(),  this.getHeight())));
        // Generation of the mid-arena wall. This wall has the properties of collide only with the player
        arenaBody.createFixture(this.generatePlayerWall(new Vec2(0.0f, this.getHeight()/2), new Vec2(this.getWidth(), this.getHeight()/2)));
        // Generation of the bottom arena wall. This wall has the properties of collide only with the player.
        arenaBody.createFixture(this.generatePlayerWall(new Vec2(0.0f, 0.0f + PLAYER_FILTER_DISTANCE), new Vec2(this.getWidth(), 0.0f + PLAYER_FILTER_DISTANCE)));
        // Generation of the top arena wall. This wall has the properties of collide only with the player.
        arenaBody.createFixture(this.generatePlayerWall(new Vec2(0.0f, this.getHeight() - PLAYER_FILTER_DISTANCE), new Vec2(this.getWidth(), this.getHeight() - PLAYER_FILTER_DISTANCE)));
        // Generation of left vertical wall. This wall has the properties of collide only with the player.
        arenaBody.createFixture(this.generatePlayerWall(new Vec2(0.0f + PLAYER_FILTER_DISTANCE, 0.0f),  new Vec2(0.0f + PLAYER_FILTER_DISTANCE, this.getHeight())));
        // Generation of right vertical wall. This wall has the properties of collide only with the player.
        arenaBody.createFixture(this.generatePlayerWall(new Vec2(this.getWidth() - PLAYER_FILTER_DISTANCE, 0.0f), new Vec2(this.getWidth() - PLAYER_FILTER_DISTANCE, this.getHeight())));
        
        float triangleBase = this.getWidth()/ANGLE_DIVIDER;
        // Generation of the bottom angles of the arena.
        arenaBody.createFixture(this.generateWall(new Vec2(0.0f, triangleBase),  new Vec2(triangleBase, 0.0f)));
        arenaBody.createFixture(this.generateWall(new Vec2(this.getWidth() - triangleBase, 0.0f),  new Vec2(this.getWidth(), triangleBase)));
        // Generation of the top angles of the arena.
        arenaBody.createFixture(this.generateWall(new Vec2(0.0f, this.getHeight() - triangleBase),  new Vec2(triangleBase, this.getHeight())));
        arenaBody.createFixture(this.generateWall(new Vec2(this.getWidth() - triangleBase, this.getHeight()),  new Vec2(this.getWidth(), this.getHeight() - triangleBase)));
        
        this.setBody(arenaBody);
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public float getGoalWidth() {
        return this.goalWidth;
    }
    
    private FixtureDef generateWall(Vec2 firstCord, Vec2 secondCord) {
    	EdgeShape shape = new EdgeShape();

    	FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = DENSITY_VALOR;
        fixtureDef.restitution = ENERGY_RESTITUTION;

        shape.set(firstCord, secondCord);
        return fixtureDef;
    }
    
    private FixtureDef generatePlayerWall(Vec2 firstCord, Vec2 secondCord) {
    	EdgeShape shape = new EdgeShape();
    	
    	FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = DENSITY_VALOR;
        fixtureDef.restitution = FILTER_RESTITUTION;
        fixtureDef.filter.maskBits = PLAYER_BITMASK;
        
        shape.set(firstCord, secondCord);
        return fixtureDef;
    }

}
