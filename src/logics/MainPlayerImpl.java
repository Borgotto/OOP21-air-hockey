package logics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import physics.Physics2D;
import physics.PlayerBody;
import physics.PlayerBodyImpl;
import physics.RigidBody;

/**
 * The class NormalPlayer represents a user-controlled player.
 */
public class MainPlayerImpl extends AbstractPlayer implements MainPlayer {

    public MainPlayerImpl(String name, float radius, Vec2 startingPosition, Physics2D world) {
        super(name, radius, startingPosition, world);
    }

    public MainPlayerImpl(float radius, Vec2 startingPosition, Physics2D world) {
        this("Player", radius, startingPosition, world);
    }

    public void update() {

    }
}
