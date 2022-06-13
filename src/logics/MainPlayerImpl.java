package logics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import physics.Physics2D;
import physics.PlayerBody;
import physics.PlayerBodyImpl;
import physics.RigidBody;

/**
 * Implementation of the MainPlayer interface.
 */
public class MainPlayerImpl extends AbstractPlayer implements MainPlayer {

    public MainPlayerImpl(String name, float radius, Vec2 startingPosition, Physics2D physics) {
        super(name, radius, startingPosition, physics);
    }

    public MainPlayerImpl(float radius, Vec2 startingPosition, Physics2D physics) {
        this("Player", radius, startingPosition, physics);
    }

    public void update() {

    }
}
