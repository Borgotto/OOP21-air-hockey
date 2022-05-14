package physics;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class PuckBody extends RigidBody {
    
    public PuckBody(float radius, Vec2 pos, float density, float friction, World world) {        
        setBodyType(BodyType.DYNAMIC);
        setPosition(pos);
        setLinearDamping(0.0f);
        configBodyDef();
        
        CircleShape shape = new CircleShape();
        shape.m_radius = radius;
        
        FixtureDef fixture = new FixtureDef();
        fixture.shape = shape;
        fixture.density = density;
        fixture.friction = friction;
        
        Body playerBody = world.createBody(getBodyDef());
        playerBody.createFixture(fixture);
        setBody(playerBody);
    }

    public void update(float dt) {
        
    }
}
