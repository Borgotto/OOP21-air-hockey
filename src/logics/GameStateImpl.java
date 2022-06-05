package logics;

import org.jbox2d.common.Vec2;
import physics.Physics2D;
import physics.Physics2DImpl;
import utils.ObjectSerializer;

import java.io.IOException;

/**
 * The class GameState holds the state of the game.
 */
public class GameStateImpl implements GameState {
    private static final long serialVersionUID = 1L;

    private final MainPlayer mainPlayer;
    private final EnemyPlayer enemyPlayer;
    private final Puck puck;
    private final Arena arena;
    private Integer maxScore;

    /**
     * Create a new GameState object using default values.
     */
    public GameStateImpl() {
        Physics2D gamePhysics = new Physics2DImpl();
        this.arena = new ArenaImpl(50.0f, gamePhysics);
        this.maxScore = 35;

        float arenaWidth = this.getArena().getWidth();
        float arenaHeight = this.getArena().getHeight();
        float goalSize = this.getArena().getGoalWidth();

        this.mainPlayer = new MainPlayerImpl(gamePhysics, arenaWidth / 6.0f, new Vec2(arenaWidth / 2.0f, arenaHeight * (1.0f / 4.0f)));
        this.enemyPlayer = new EnemyPlayerImpl(gamePhysics, arenaWidth / 6.0f, new Vec2(arenaWidth / 2.0f,  arenaHeight * (3.0f / 4.0f)));
        this.puck = new PuckImpl(gamePhysics, goalSize * (4.0f / 5.0f), new Vec2(arenaWidth / 2.0f, arenaHeight / 2.0f));
    }

    @Override
    public Arena getArena() {
        return this.arena;
    }

    @Override
    public MainPlayer getMainPlayer() {
        return this.mainPlayer;
    }

    @Override
    public EnemyPlayer getEnemyPlayer() {
        return this.enemyPlayer;
    }

    @Override
    public Puck getPuck() {
        return this.puck;
    }

    @Override
    public Integer getMaxScore() {
        return this.maxScore;
    }

    @Override
    public void update() {
        /*TODO*/
    }

    @Override
    public void save() throws IOException {
        ObjectSerializer.serialize(this, GameState.savePath);
    }

    @Override
    public void load() throws IOException, ClassNotFoundException {
        // Load the game state from the save file
        GameStateImpl savedGame = ObjectSerializer.deserialize(GameState.savePath);
        // Set the current game state to the saved game state
        this.arena.setGoalWidth(savedGame.getArena().getGoalWidth());
        this.mainPlayer.setScore(savedGame.mainPlayer.getScore());
        this.enemyPlayer.setScore(savedGame.enemyPlayer.getScore());
        this.maxScore = savedGame.maxScore;
    }
}
