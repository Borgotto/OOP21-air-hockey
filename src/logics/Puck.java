package logics;

import org.jbox2d.common.Vec2;

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
    
    /**
     * Get the position the Puck will be in the next game loop frame
     * @return the {@code Vec2} vector position 
     */
    public Vec2 getNextPos();
    
}
