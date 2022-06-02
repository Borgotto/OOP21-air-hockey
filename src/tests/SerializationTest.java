package tests;

import logics.*;
import utils.ObjectSerializer;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SerializationTest {

    GameState gameState = new GameState();

    @org.junit.Test
    public void serializeArena() throws IOException, ClassNotFoundException {
        Arena arena = this.gameState.getArena();
        ObjectSerializer.serialize(arena, "test.ser");
        assertEquals(ObjectSerializer.deserialize("test.ser"), arena);
    }

    @org.junit.Test
    public void serializeMainPlayer() throws IOException, ClassNotFoundException {
        MainPlayer mainPlayer = this.gameState.getMainPlayer();
        ObjectSerializer.serialize(mainPlayer, "test.ser");
        assertEquals(ObjectSerializer.deserialize("test.ser"), mainPlayer);
    }

    @org.junit.Test
    public void serializeEnemyPlayer() throws IOException, ClassNotFoundException {
        EnemyPlayer enemyPlayer = this.gameState.getEnemyPlayer();
        ObjectSerializer.serialize(enemyPlayer, "test.ser");
        assertEquals(ObjectSerializer.deserialize("test.ser"), enemyPlayer);
    }

    @org.junit.Test
    public void serializePuck() throws IOException, ClassNotFoundException {
        Puck puck = this.gameState.getPuck();
        ObjectSerializer.serialize(puck, "test.ser");
        assertEquals(ObjectSerializer.deserialize("test.ser"), puck);
    }

    @org.junit.Test
    public void serializeGameState() throws IOException, ClassNotFoundException {
        ObjectSerializer.serialize(this.gameState, "test.ser");
        assertEquals(ObjectSerializer.deserialize("test.ser"), this.gameState);
    }
}
