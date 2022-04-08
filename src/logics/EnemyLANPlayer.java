package logics;

import physics.Position;

/*
TODO: Add methods to manage the message exchange via LAN.
 */

public class EnemyLANPlayer extends EnemyPlayer {

    /**
     * This is the default constructor, and it behaves the same way as the Player constructor.
     * @param initialPosition The player's initial position.
     * @param name The player's name.
     */
    public EnemyLANPlayer(Position initialPosition, String name) {
        super(initialPosition, name);
    }
}
