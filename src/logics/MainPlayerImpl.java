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

    public MainPlayerImpl(String name, Physics2D world, float radius, Vec2 position) {
        super(name, world, radius, position);
    }

    public MainPlayerImpl(Physics2D world, float radius, Vec2 position) {
        this("Player", world, radius, position);
    }
}
