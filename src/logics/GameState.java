package logics;

import physics.Physics2D;
import physics.Physics2DImpl;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

/**
 * Interface describing a Game of Air Hockey
 */
public interface GameState extends GameObject {
    /**
     * Game physics
     */
    Physics2D gamePhysics = new Physics2DImpl();

    /**
     * Save file directory.
     */
    Path savePath = Path.of(System.getProperty("user.dir") + "/config/save/save.ser");

    /**
     * Get the current {@link Arena}
     * @return the arena
     */
    Arena getArena();

    /**
     * Get the {@link Player} controlled by the user
     * @return the {@code Player}
     */
    MainPlayer getMainPlayer();

    /**
     * Get the {@link Player} controlled by the CPU
     * @return the {@code Player}
     */
    EnemyPlayer getEnemyPlayer();

    /**
     * Get the {@link Player} that has won the game
     * @return the {@code Player} or {@code Optional.empty()} if the game is not over
     */
    Optional<Player> getWinner();

    /**
     * Check if the game is over
     * @return {@code true} if the game is over, {@code false} otherwise
     */
    boolean isGameOver();

    /**
     * Get the {@link Puck}
     * @return the {@code Puck}
     */
    Puck getPuck();

    /**
     * Get the maximum score a {@code Player} can have before winning the game.
     * @return the integer representing the maxScore
     */
    Integer getMaxScore();
}
