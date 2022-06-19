package tests;

import logics.GameState;
import logics.GameStateBuilder;

import static org.junit.Assert.*;

public class GameTest {
    private GameState game;

    @org.junit.Before
    public void initTests() {
        this.game = new GameStateBuilder().build();

        // render the first 10.000 frames (166.66 seconds) of the game
        for(int i=0;i<10000;i++) {
            this.game.update();
        }
    }

    @org.junit.Test
    public void testBounds() {
        // check that both the players and the puck are still inside the playable area
        assertTrue(this.game.getPuck().getPosition().x >= 0);
        assertTrue(this.game.getPuck().getPosition().x <= this.game.getArena().getWidth());
        assertTrue(this.game.getPuck().getPosition().y >= 0);
        assertTrue(this.game.getPuck().getPosition().y <= this.game.getArena().getHeight());

        assertTrue(this.game.getMainPlayer().getPosition().x >= 0);
        assertTrue(this.game.getMainPlayer().getPosition().x <= this.game.getArena().getWidth());
        assertTrue(this.game.getMainPlayer().getPosition().y >= 0);
        assertTrue(this.game.getMainPlayer().getPosition().y <= this.game.getArena().getHeight());

        assertTrue(this.game.getEnemyPlayer().getPosition().x >= 0);
        assertTrue(this.game.getEnemyPlayer().getPosition().x <= this.game.getArena().getWidth());
        assertTrue(this.game.getEnemyPlayer().getPosition().y >= 0);
        assertTrue(this.game.getEnemyPlayer().getPosition().y <= this.game.getArena().getHeight());
    }

    @org.junit.Test
    public void testLogicalSingleton() {
        GameState game = new GameStateBuilder().build();
        assertEquals(this.game, game);
    }
}
