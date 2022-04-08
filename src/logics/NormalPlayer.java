package logics;

import physics.Position;

/**
 * The class NormalPlayer represents a user-controlled player.
 */
public class NormalPlayer extends Player {
    /**
     * This is the constructor for NormalPlayer. It behaves pretty much the same as its superclass.
     * @param initialPosition The player's initial position.
     * @param name The player's name.
     */
    public NormalPlayer(Position initialPosition, String name) {
        super(initialPosition, name);
    }
}
