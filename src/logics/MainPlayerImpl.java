package logics;

import org.jbox2d.common.Vec2;
import physics.Physics2D;
import physics.PointPhysicsHandler;

/**
 * Implementation of the MainPlayer interface.
 */
public class MainPlayerImpl extends AbstractPlayer implements MainPlayer {
    private static final long serialVersionUID = 5200285706483970366L;
    private final PointPhysicsHandler pointPhysicsHandler;
    private Vec2 direction;

    public MainPlayerImpl(String name, float radius, Vec2 startingPosition, Physics2D physics) {
        super(name, radius, startingPosition, physics);
        this.pointPhysicsHandler = new PointPhysicsHandler(this.getBody());
    }

    public MainPlayerImpl(float radius, Vec2 startingPosition, Physics2D physics) {
        this("Player", radius, startingPosition, physics);
    }

    public void setDirection(Vec2 direction) {
        this.direction = direction;
    }

    public void update() {
        if (this.direction == null){
            this.pointPhysicsHandler.pointReleased();
        } else {
            this.pointPhysicsHandler.update(this.direction);
        }
    }
}
