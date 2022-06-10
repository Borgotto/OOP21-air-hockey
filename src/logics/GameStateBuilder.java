package logics;

import org.jbox2d.common.Vec2;
import physics.Physics2D;
import physics.Physics2DImpl;

import java.io.IOException;

public class GameStateBuilder {
    private Physics2D gamePhysics;
    private MainPlayer mainPlayer;
    private EnemyPlayer enemyPlayer;
    private Puck puck;
    private Arena arena;
    private Integer maxScore;
    
    /*
     * Initializes GameState with default values based on a real game
     */
    public GameStateBuilder() {
        // Load settings to get the MaxScore and Enemy Difficulty
        Settings settings = new Settings().load();
        // Create the GameObjects with default values
        this.gamePhysics = new Physics2DImpl();
        this.arena = new ArenaImpl(18.0f, 32.0f, 6.0f, this.gamePhysics);
        this.maxScore = settings.getMaxScore();
        this.mainPlayer = new MainPlayerImpl(2.0f, new Vec2(9.0f,8.0f), this.gamePhysics);
        this.enemyPlayer = new EnemyPlayerImpl(2.0f, new Vec2(9.0f,24.0f), this.gamePhysics, settings.getDifficulty());
        this.puck = new PuckImpl(1.8f, new Vec2(9.0f,16.0f), this.gamePhysics);
    }

    public GameStateBuilder setPhysics(Physics2D physics) {
        this.gamePhysics = physics;
        return this;
    }

    public GameStateBuilder setArena(Arena arena) {
        this.arena = arena;
        return this;
    }

    public GameStateBuilder setMainPlayer(MainPlayer mainPlayer) {
        this.mainPlayer = mainPlayer;
        return this;
    }

    public GameStateBuilder setEnemyPlayer(EnemyPlayer enemyPlayer) {
        this.enemyPlayer = enemyPlayer;
        return this;
    }

    public GameStateBuilder setPuck(Puck puck) {
        this.puck = puck;
        return this;
    }

    public GameStateBuilder setMaxScore(int maxScore) {
        this.maxScore = maxScore;
        return this;
    }

    public GameState build() {
        return new GameStateImpl(this.gamePhysics, this.arena, this.mainPlayer, this.enemyPlayer, this.puck, this.maxScore);
    }
}
