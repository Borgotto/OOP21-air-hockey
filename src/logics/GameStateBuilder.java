package logics;

import org.jbox2d.common.Vec2;

/**
 * Builder class for GameState.
 */
public class GameStateBuilder {
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
        setArena(new ArenaImpl(18.0f, 32.0f, 6.0f, GameState.gamePhysics));
        setMainPlayer(new MainPlayerImpl(settings.getUsername(),1.4f, new Vec2(9.0f,4.0f), GameState.gamePhysics));
        setEnemyPlayer(new EnemyPlayerImpl(1.4f, new Vec2(9.0f,28.0f), GameState.gamePhysics, settings.getDifficulty()));
        setPuck(new PuckImpl(1.2f, new Vec2(9.0f,16.0f), GameState.gamePhysics));
        setMaxScore(settings.getMaxScore());
    }

    public GameStateBuilder setArena(final Arena arena) {
        this.arena = arena;
        return this;
    }

    public GameStateBuilder setMainPlayer(final MainPlayer mainPlayer) {
        this.mainPlayer = mainPlayer;
        return this;
    }

    public GameStateBuilder setEnemyPlayer(final EnemyPlayer enemyPlayer) {
        this.enemyPlayer = enemyPlayer;
        return this;
    }

    public GameStateBuilder setPuck(final Puck puck) {
        this.puck = puck;
        return this;
    }

    public GameStateBuilder setMaxScore(final int maxScore) {
        this.maxScore = maxScore;
        return this;
    }

    public GameState build() {
        return new GameStateImpl(this.arena, this.mainPlayer, this.enemyPlayer, this.puck, this.maxScore);
    }
}