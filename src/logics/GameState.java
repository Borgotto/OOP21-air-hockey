package logics;

import org.jbox2d.common.Vec2;
import physics.Physics2D;
import physics.Physics2DImpl;
import utils.ObjectSerializer;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * The class GameState holds the state of the game.
 */
public class GameState implements GameObject, Serializable {
    private static final long serialVersionUID = 1L;

    public static final Path savePath = Path.of(System.getProperty("user.dir") + "/config/save/save.ser");

    private final transient Physics2D gamePhysics;
    private final MainPlayer mainPlayer;
    private final EnemyPlayer enemyPlayer;
    private final Puck puck;
    private final Arena arena;
    private Integer maxScore;

    /**
     * Create a new GameState object using default values.
     */
    public GameState() {
        this.gamePhysics = new Physics2DImpl();
        this.arena = new ArenaImpl(50.0f, this.gamePhysics);
        this.maxScore = 35;

        float arenaWidth = this.getArena().getWidth();
        float arenaHeight = this.getArena().getHeight();
        float goalSize = this.getArena().getGoalWidth();

        this.mainPlayer = new MainPlayerImpl(this.gamePhysics, arenaWidth / 6.0f, new Vec2(arenaWidth / 2.0f, arenaHeight * (1.0f / 4.0f)));
        this.enemyPlayer = new EnemyPlayerImpl(this.gamePhysics, arenaWidth / 6.0f, new Vec2(arenaWidth / 2.0f,  arenaHeight * (3.0f / 4.0f)));
        this.puck = new PuckImpl(this.gamePhysics, goalSize * (4.0f / 5.0f), new Vec2(arenaWidth / 2.0f, arenaHeight / 2.0f));
    }

    /**
     * Get the current {@link Arena}
     * @return the arena
     */
    public Arena getArena() {
        return this.arena;
    }

    /**
     * Get the {@link Player} controlled by the user
     * @return the {@code Player}
     */
    public MainPlayer getMainPlayer() {
        return this.mainPlayer;
    }

    /**
     * Get the {@link Player} controlled by the CPU
     * @return the {@code Player}
     */
    public EnemyPlayer getEnemyPlayer() {
        return this.enemyPlayer;
    }

    /**
     * Get the {@link Puck} 
     * @return the {@code Puck}
     */
    public Puck getPuck() {
        return this.puck;
    }

    /**
     * Get the maximum score a {@code Player} can have before
     * winning the game
     * @return the integer representing the maxScore
     */
    public Integer getMaxScore() {
        return this.maxScore;
    }

    public void update() {
        /*TODO*/
    }

    /**
     * Save the current {@link GameState} to a serialized file.
     * @throws IOException
     */
    public void save() throws IOException {
        ObjectSerializer.serialize(this, GameState.savePath);
    }

    /**
     * Loads the game state from a serialized save file.
     * @throws IOException, ClassNotFoundException
     */
    public void load() throws IOException, ClassNotFoundException {
        // Load the game state from the save file
        GameState savedGame = ObjectSerializer.deserialize(GameState.savePath);
        // Set the current game state to the saved game state
        this.arena.setGoalWidth(savedGame.getArena().getGoalWidth());
        this.mainPlayer.setScore(savedGame.mainPlayer.getScore());
        this.enemyPlayer.setScore(savedGame.enemyPlayer.getScore());
        this.maxScore = savedGame.maxScore;
    }
}
