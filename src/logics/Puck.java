package logics;

import physics.PuckBody;

/**
 * Interface that represents a {@code Puck} object
 */
public interface Puck extends GameObjectWithPhysics, PuckBody {
    
    /**
     * Place the {@link Puck} at the center of the {@link Arena}
     * @param arena Contains the {@link Puck}.
     */
    void center(Arena arena);

    /**
     * Place the {@link Puck} in front of the {@link Player}
     * @param arena Contains the {@link Puck} and the {@link Player}.
     * @param player Is the {@link Arena} side to move the {@link Puck} to.
     */
    void moveToPlayer(Arena arena, Player player);
}
