package logics;

import physics.PuckBody;

/**
 * Interface that represents a {@code Puck} object
 */
public interface Puck extends GameObjectWithPhysics, PuckBody {
    
    /**
     * Place the {@code Puck} at the center of the {@code Arena}
     * @param arena contains the {@code Puck}
     */
    void center(Arena arena);

    /**
     * Place the {@code Puck} in front of the {@code Player}
     * @param arena contains the {@code Puck} and the {@code Player}
     * @param player is the {@code Arena} side to move the {@code Puck} to
     */
    void moveToPlayer(Arena arena, Player player);
}
