package tests;

import logics.GameState;
import logics.GameStateImpl;

import static org.junit.Assert.*;

public class GameTest {
    private GameState game;

    @org.junit.Before
    public void initTests() {
        this.game = new GameStateImpl();

        // render the first 1.000 frames (16.66 seconds) of the game
        for(int i=0;i<1000;i++) {
            this.game.update();
        }
    }

    @org.junit.Test
    public void testGoals() {
        // check out the scores
        assertEquals(0, (int) this.game.getMainPlayer().getScore());
        assertEquals(0, (int) this.game.getEnemyPlayer().getScore());
    }
}
