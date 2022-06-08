package logics;

import org.jbox2d.common.Vec2;
import physics.Physics2D;
import physics.Physics2DImpl;

public class GameStateBuilder {
    private Physics2D gamePhysics;
    private MainPlayer mainPlayer;
    private EnemyPlayer enemyPlayer;
    private Puck puck;
    private Arena arena;
    private Integer maxScore;

    public GameStateBuilder() {
        this.gamePhysics = new Physics2DImpl();
        this.arena = new ArenaImpl(18.0f,32.0f, 6.0f, this.gamePhysics);
        this.maxScore = 35;

        float arenaWidth = this.arena.getWidth();
        float arenaHeight = this.arena.getHeight();
        float goalSize = this.arena.getGoalWidth();

        this.mainPlayer = new MainPlayerImpl(this.gamePhysics, arenaWidth / 6.0f, new Vec2(arenaWidth / 2.0f, arenaHeight * (1.0f / 4.0f)));
        this.enemyPlayer = new EnemyPlayerImpl(this.gamePhysics, arenaWidth / 6.0f, new Vec2(arenaWidth / 2.0f,  arenaHeight * (3.0f / 4.0f)));
        this.puck = new PuckImpl(this.gamePhysics, goalSize * (4.0f / 5.0f), new Vec2(arenaWidth / 2.0f, arenaHeight / 2.0f));
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
