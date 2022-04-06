package logics;

/*
TODO: Add methods to manage the message exchange via LAN.
 */

public class EnemyLANPlayer extends EnemyPlayer {

    /**
     * This is the default constructor, and it behaves the same way as the Player constructor.
     * @param posX The player's position on the X-axis.
     * @param posY The player's position on the Y-axis.
     * @param name The player's name.
     */
    public EnemyLANPlayer(int posX, int posY, String name) {
        super(posX, posY, name);
    }
}
