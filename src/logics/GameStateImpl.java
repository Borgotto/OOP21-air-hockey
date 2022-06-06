package logics;

import org.jbox2d.common.Vec2;
import physics.Physics2D;
import physics.Physics2DImpl;
import utils.ObjectSerializer;

import java.io.IOException;
import java.util.Optional;

/**
 * The class GameState holds the state of the game.
 */
public class GameStateImpl implements GameState {
    private final Physics2D gamePhysics;
    private final MainPlayer mainPlayer;
    private final EnemyPlayer enemyPlayer;
    private final Puck puck;
    private final Arena arena;
    private Integer maxScore;
    private Optional<Player> winner = Optional.empty();
    private boolean isGameOver = false;

    /**
     * Create a new GameState object using default values.
     */
    public GameStateImpl() {
        this.gamePhysics = new Physics2DImpl();
        this.arena = new ArenaImpl(50.0f, gamePhysics);
        this.maxScore = 5;

        float arenaWidth = this.getArena().getWidth();
        float arenaHeight = this.getArena().getHeight();
        float goalSize = this.getArena().getGoalWidth();

        this.mainPlayer = new MainPlayerImpl(gamePhysics,arenaWidth/6.0f,new Vec2(arenaWidth/2.0f,arenaHeight*(1.0f/4.0f)));
        this.enemyPlayer = new EnemyPlayerImpl(gamePhysics,arenaWidth/6.0f,new Vec2(arenaWidth/2.0f,arenaHeight*(3.0f/4.0f)));
        this.puck = new PuckImpl(gamePhysics,goalSize*(4.0f/5.0f),new Vec2(arenaWidth/2.0f,arenaHeight/2.0f));
    }

    public Arena getArena() {
        return this.arena;
    }

    public MainPlayer getMainPlayer() {
        return this.mainPlayer;
    }

    public EnemyPlayer getEnemyPlayer() {
        return this.enemyPlayer;
    }

    public Optional<Player> getWinner() {
        return this.winner;
    }

    public boolean isGameOver() {
        return this.isGameOver;
    }

    public Puck getPuck() {
        return this.puck;
    }

    public Integer getMaxScore() {
        return this.maxScore;
    }

    public void update() {
        this.gamePhysics.update();

        if (this.mainPlayer.getScore() >= this.maxScore) {
            this.winner = Optional.of(this.mainPlayer);
            this.isGameOver = true;
        } else if (this.enemyPlayer.getScore() >= this.maxScore) {
            this.winner = Optional.of(this.enemyPlayer);
            this.isGameOver = true;
        }
    }

    public void save() throws IOException {
        ObjectSerializer.serialize(this, GameState.savePath);
    }

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
