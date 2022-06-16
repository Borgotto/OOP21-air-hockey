package logics;

import org.jbox2d.common.Vec2;
import physics.Physics2D;

/**
 * Implementation of the MainPlayer interface.
 */
public class MainPlayerImpl extends AbstractPlayer implements MainPlayer {
    private static final long serialVersionUID = 5200285706483970366L;

    public MainPlayerImpl(String name, float radius, Vec2 startingPosition, Physics2D physics) {
        super(name, radius, startingPosition, physics);
    }

    public MainPlayerImpl(float radius, Vec2 startingPosition, Physics2D physics) {
        this("Player", radius, startingPosition, physics);
    }

    public void update() {

    }
}
