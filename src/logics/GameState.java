package logics;

import physics.Physics2D;
import physics.Physics2DImpl;

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
     * @return The {@link Arena}.
     */
    Arena getArena();

    /**
     * Get the {@link Player} controlled by the user
     * @return The {@link Player}.
     */
    MainPlayer getMainPlayer();

    /**
     * Get the {@link Player} controlled by the CPU
     * @return The {@link Player}.
     */
    EnemyPlayer getEnemyPlayer();

    /**
     * Get the {@link Player} that has won the game
     * @return The {@link Player} or {@code Optional.empty()} if the game is not over.
     */
    Optional<Player> getWinner();

    /**
     * Check if the game is over
     * @return {@code true} if the game is over, {@code false} otherwise.
     */
    boolean isGameOver();

    /**
     * Get the {@link Puck}
     * @return The {@link Puck}.
     */
    Puck getPuck();

    /**
     * Get the maximum score a {@link Player} can have before winning the game.
     * @return The integer representing the maximum score.
     */
    Integer getMaxScore();
}
