package logics;

import org.jbox2d.common.Vec2;
import physics.Physics2D;
import physics.Physics2DImpl;
import utils.ObjectSerializer;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;

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

    public void update() {
        // Uncomment for funny physics
        //Random rng = new Random();
        //this.puck.getBody().applyForceToCenter(new Vec2(10000f*(rng.nextFloat()-0.5f), 10000*(rng.nextFloat()-0.5f)));
        //this.mainPlayer.getBody().applyForceToCenter(new Vec2(14000f*(rng.nextFloat()-0.5f), 11000*(rng.nextFloat()-0.5f)));
        //this.enemyPlayer.getBody().applyForceToCenter(new Vec2(14000f*(rng.nextFloat()-0.5f), 11000*(rng.nextFloat()-0.5f)));

        if (this.updateScore()) {
            this.mainPlayer.resetBodyPos();
            this.enemyPlayer.resetBodyPos();
            if (this.updateWinner()){
                this.isGameOver = true;
            }
        }

        //this.enemyPlayer.setNextMove(this);
        this.enemyPlayer.update();

        this.gamePhysics.update();
    }

    private boolean updateWinner() {
        if (this.mainPlayer.getScore() >= this.maxScore) {
            this.winner = Optional.of(this.mainPlayer);
            return true;
        } else if (this.enemyPlayer.getScore() >= this.maxScore) {
            this.winner = Optional.of(this.enemyPlayer);
            return true;
        }
        return false;
    }

    private boolean updateScore() {
        if (this.puck.getPosition().y > 0 && this.puck.getPosition().y < this.arena.getHeight()) {
            return false;
        }
        if (this.puck.getBody().getPosition().y < 0) {
            this.enemyPlayer.scorePoint();
            this.puck.moveToPlayer(this.arena, this.mainPlayer);
        } else if (this.puck.getBody().getPosition().y > this.arena.getHeight()) {
            this.mainPlayer.scorePoint();
            this.puck.moveToPlayer(this.arena, this.enemyPlayer);
        }
        return true;
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
