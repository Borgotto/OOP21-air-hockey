package logics;

import physics.Physics2D;
import utils.ObjectSerializer;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

/**
 * Implementation of GameState interface.
 */
public class GameStateImpl implements GameState {
    private static final long serialVersionUID = 3168735648062117889L;
    private transient final Physics2D gamePhysics;
    private MainPlayer mainPlayer;
    private EnemyPlayer enemyPlayer;
    private Puck puck;
    private Arena arena;
    private Integer maxScore;
    private transient Optional<Player> winner = Optional.empty();
    private boolean isGameOver = false;

    public GameStateImpl(final Physics2D physics, final Arena arena, final MainPlayer mainPlayer, final EnemyPlayer enemyPlayer, final Puck puck, final Integer maxScore) {
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
        }
        if (this.updateWinner()){
            this.isGameOver = true;
        }

        this.enemyPlayer.setNextMove(this);
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

    @Override
    public int hashCode() {
        return Objects.hash(arena, enemyPlayer, isGameOver, mainPlayer, maxScore, puck);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameStateImpl)) {
            return false;
        }
        GameStateImpl other = (GameStateImpl) obj;
        return Objects.equals(arena, other.arena) && Objects.equals(enemyPlayer, other.enemyPlayer)
                && isGameOver == other.isGameOver && Objects.equals(mainPlayer, other.mainPlayer)
                && Objects.equals(maxScore, other.maxScore) && Objects.equals(puck, other.puck);
    }    
    // Override default deserialization to set transient fields
    private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
        GameState.gamePhysics.deleteAllBodies();
        in.defaultReadObject();
        this.updateWinner();
    }
}
