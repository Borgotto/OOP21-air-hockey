package logics;

import physics.Position;

/**
 * The EnemyPlayer class represents a generic enemy player.
 */
public abstract class EnemyPlayer extends Player {

    /**
     * This is the default constructor, and it behaves the same way as the Player constructor.
     * @param initialPosition The player's initial position.
     * @param name The player's name.
     */
    public EnemyPlayer(Position initialPosition, String name) {
        super(initialPosition, name);
    }
}
