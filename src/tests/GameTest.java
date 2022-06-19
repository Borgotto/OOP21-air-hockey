package tests;

import logics.GameObjectWithPhysics;
import logics.GameState;
import logics.GameStateBuilder;
import org.jbox2d.common.Vec2;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    @org.junit.Test
    public void testBounds() {
        GameState game = new GameStateBuilder().build();
        List<GameObjectWithPhysics> gameObjects = List.of(game.getMainPlayer(), game.getEnemyPlayer(), game.getPuck());
        // apply a strong force to each GameObjectWithPhysics
        for (var go : gameObjects) {
            go.getBody().setLinearVelocity(new Vec2(45000,45000));
        }
        // render the first 10.000 frames (166.66 seconds) of the game
        for(int i=0;i<10000;i++) {
            game.update();
        }
        // check that both the players and the puck are still inside the playable area
        for(var go : gameObjects) {
            assertTrue(go.getPosition().x >= 0 && go.getPosition().x <= game.getArena().getWidth());
            assertTrue(go.getPosition().y >= 0 && go.getPosition().y <= game.getArena().getHeight());
        }
    }

    @org.junit.Test
    public void testLogicalSingleton() {
        GameState game1 = new GameStateBuilder().build();
        GameState game2 = new GameStateBuilder().build();
        assertEquals(game1, game2);
    }
}
