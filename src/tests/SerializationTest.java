package tests;

import logics.*;
import utils.ObjectSerializer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;

public class SerializationTest {

    private GameState gameState;
    private final Path path = Path.of("test.ser");

    @org.junit.Before
    public void initTests() {
        this.gameState = new GameState();
    }

    @org.junit.Test
    public void serializeArena() throws IOException, ClassNotFoundException {
        Arena arena = this.gameState.getArena();
        ObjectSerializer.serialize(arena, this.path);
        assertEquals(ObjectSerializer.deserialize(this.path), arena);
    }

    @org.junit.Test
    public void serializeMainPlayer() throws IOException, ClassNotFoundException {
        MainPlayer mainPlayer = this.gameState.getMainPlayer();
        ObjectSerializer.serialize(mainPlayer, this.path);
        assertEquals(ObjectSerializer.deserialize(this.path), mainPlayer);
    }

    @org.junit.Test
    public void serializeEnemyPlayer() throws IOException, ClassNotFoundException {
        EnemyPlayer enemyPlayer = this.gameState.getEnemyPlayer();
        ObjectSerializer.serialize(enemyPlayer, this.path);
        assertEquals(ObjectSerializer.deserialize(this.path), enemyPlayer);
    }

    @org.junit.Test
    public void serializePuck() throws IOException, ClassNotFoundException {
        Puck puck = this.gameState.getPuck();
        ObjectSerializer.serialize(puck, this.path);
        assertEquals(ObjectSerializer.deserialize(this.path), puck);
    }

    @org.junit.Test
    public void serializeGameState() throws IOException, ClassNotFoundException {
        ObjectSerializer.serialize(this.gameState, this.path);
        assertEquals(ObjectSerializer.deserialize(this.path), this.gameState);
    }

    @org.junit.After
    public void cleanFiles() {
        new File(this.path.toString()).delete();
    }
}
