package logics;

import org.jbox2d.common.Vec2;
import physics.Physics2D;

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
