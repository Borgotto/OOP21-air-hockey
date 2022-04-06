package logics;

/**
 * The EnemyPlayer class represents a generic enemy player.
 */
public abstract class EnemyPlayer extends Player {

    /**
     * This is the default constructor, and it behaves the same way as the Player constructor.
     * @param posX The player's position on the X-axis.
     * @param posY The player's position on the Y-axis.
     * @param name The player's name.
     */
    public EnemyPlayer(int posX, int posY, String name) {
        super(posX, posY, name);
    }
}
