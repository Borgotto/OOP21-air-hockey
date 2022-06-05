package logics;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;

public interface GameState extends GameObject, Serializable {
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
     * Get the {@link Puck}
     * @return the {@code Puck}
     */
    Puck getPuck();

    /**
     * Get the maximum score a {@code Player} can have before winning the game.
     * @return the integer representing the maxScore
     */
    Integer getMaxScore();

    /**
     * Update the game state via internal logic
     */
    void update();

    /**
     * Save the current {@link GameState} to a serialized file.
     * @throws IOException if an I/O error occurs
     */
    void save() throws IOException;

    /**
     * Loads the game state from a serialized save file.
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException if the serialized object cannot be deserialized
     */
    void load() throws IOException, ClassNotFoundException;
}
