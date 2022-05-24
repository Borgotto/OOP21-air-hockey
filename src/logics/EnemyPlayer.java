package logics;

import org.jbox2d.common.Vec2;

import java.util.function.Function;

public interface EnemyPlayer extends Player {
    /**
     * The difficulty the enemy AI.
     * It can be:
     *  - DUMB: the enemy makes random movements (random directions and speed) around the arena
     *  - EASY: the enemy mostly makes random movements, but sometimes it tries to score a goal
     *  - NORMAL: the enemy tries to predict the puck's direction
     */
    public enum Difficulty {
        DUMB(null),
        EASY(null),
        NORMAL(null);

        private Function<Vec2, Vec2> movingStrategy;

        private Difficulty(Function<Vec2, Vec2> movingStrategy) {
            this.movingStrategy = movingStrategy;
        }

        public Function<Vec2, Vec2> getMovingStrategy() {
            return this.movingStrategy;
        }
    }

    public Vec2 nextPosition();

    public Difficulty getDifficulty();
}
