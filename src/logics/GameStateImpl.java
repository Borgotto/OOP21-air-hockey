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
    private transient final Physics2D gamePhysics;
    private MainPlayer mainPlayer;
    private EnemyPlayer enemyPlayer;
    private Puck puck;
    private Arena arena;
    private Integer maxScore;
    private transient Optional<Player> winner = Optional.empty();
    private boolean isGameOver = false;

    public GameStateImpl(Physics2D physics, Arena arena, MainPlayer mainPlayer, EnemyPlayer enemyPlayer, Puck puck, Integer maxScore) {
        this.gamePhysics = physics;
        this.arena = arena;
        this.mainPlayer = mainPlayer;
        this.enemyPlayer = enemyPlayer;
        this.puck = puck;
        this.maxScore = maxScore;
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

    private void updateWinner() {
        if (this.mainPlayer.getScore() >= this.maxScore) {
            this.winner = Optional.of(this.mainPlayer);
        } else if (this.enemyPlayer.getScore() >= this.maxScore) {
            this.winner = Optional.of(this.enemyPlayer);
        }
    }

    public void update() {
        this.gamePhysics.update();
        this.updateWinner();

    }

    public void save() throws IOException {
        ObjectSerializer.serialize(this, GameState.savePath);
    }

    public void load(GameState savedGame) {
        // Set the current game state to the saved game state
        this.gamePhysics.deleteAllBodies();

        var savedArena = savedGame.getArena();
        this.arena = new ArenaImpl(savedArena.getWidth(), savedArena.getHeight(), savedArena.getGoalWidth(), this.gamePhysics);

        var savedMainPlayer = savedGame.getMainPlayer();
        this.mainPlayer = new MainPlayerImpl(savedMainPlayer.getName(), savedMainPlayer.getRadius(), savedMainPlayer.getStartingPosition(), this.gamePhysics);

        var savedEnemyPlayer = savedGame.getEnemyPlayer();
        this.enemyPlayer = new EnemyPlayerImpl(savedEnemyPlayer.getName(), savedEnemyPlayer.getRadius(), savedEnemyPlayer.getStartingPosition(), this.gamePhysics, savedEnemyPlayer.getDifficulty());

        var savedPuck = savedGame.getPuck();
        this.puck = new PuckImpl(savedPuck.getRadius(), savedPuck.getStartingPosition(), this.gamePhysics);

        this.mainPlayer.setScore(savedGame.getMainPlayer().getScore());
        this.enemyPlayer.setScore(savedGame.getEnemyPlayer().getScore());
        this.maxScore = savedGame.getMaxScore();
        this.updateWinner();
        this.isGameOver = savedGame.isGameOver();
    }
}
