package logics;

import org.jbox2d.common.Vec2;

/**
 * Interface that represents a {@code Puck} object
 */
public interface Puck extends GameObjectWithPhysics {
    
    /**
     * Place the {@code Puck} at the center of the {@code Arena}
     * @param arena contains the {@code Puck}
     */
    public void center(Arena arena);

    /**
     * Place the {@code Puck} in front of the {@code Player}
     * @param arena contains the {@code Puck} and the {@code Player}
     * @param player is the {@code Arena} side to move the {@code Puck} to
     */
    public void moveToPlayer(Arena arena, Player player);
    
    /**
     * Get the position where the {@code Puck} will be in the next game loop frame
     * @return the {@code Vec2} vector position
     */
    public Vec2 getNextPos();
    
}
