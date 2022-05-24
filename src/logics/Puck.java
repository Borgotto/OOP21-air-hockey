package logics;

/**
 * Interface that represents a {@code Puck} object *
 */
public interface Puck extends GameObjectWithPhysics {
    
    /**
     * Place the puck at the center of the arena
     * @param the arena that contains the {@code Puck}
     */
    public void center(ArenaImpl arena);

    /**
     * Place the puck in front of the {@code Player}
     * @param arena that contains the {@code Puck} and the {@code Player}
     * @param player to give the puck to
     */
    public void moveToPlayer(ArenaImpl arena, Player player);
}
