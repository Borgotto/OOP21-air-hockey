package logics;

import org.jbox2d.common.Vec2;

/**
 * Interface used to represent the main player controlled by the user.
 */
public interface MainPlayer extends Player {
    /**
     * Sets the direction where the player will move towards in the next update.
     * @param direction the direction of the player, if null is passed it will stop the player.
     */
    void setDirection(Vec2 direction);
}
