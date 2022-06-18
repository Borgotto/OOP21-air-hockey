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
        this.gameState = new GameStateBuilder().build();
    }

    @org.junit.Test
    public void serializeArena() throws IOException, ClassNotFoundException {
        Arena arena = this.gameState.getArena();
        ObjectSerializer.serialize(arena, this.path);
        Arena dArena = ObjectSerializer.deserialize(this.path);
        assertEquals(dArena, arena);
    }

    @org.junit.Test
    public void serializeMainPlayer() throws IOException, ClassNotFoundException {
        MainPlayer mainPlayer = this.gameState.getMainPlayer();
        ObjectSerializer.serialize(mainPlayer, this.path);
        MainPlayer dMainPlayer = ObjectSerializer.deserialize(this.path);
        assertEquals(dMainPlayer, mainPlayer);
    }

    @org.junit.Test
    public void serializeEnemyPlayer() throws IOException, ClassNotFoundException {
        EnemyPlayer enemyPlayer = this.gameState.getEnemyPlayer();
        ObjectSerializer.serialize(enemyPlayer, this.path);
        EnemyPlayer dEnemyPlayer = ObjectSerializer.deserialize(this.path);
        assertEquals(dEnemyPlayer, enemyPlayer);
    }

    @org.junit.Test
    public void serializePuck() throws IOException, ClassNotFoundException {
        Puck puck = this.gameState.getPuck();
        ObjectSerializer.serialize(puck, this.path);
        Puck dPuck = ObjectSerializer.deserialize(this.path);
        assertEquals(dPuck, puck);
    }

    @org.junit.Test
    public void serializeGameState() throws IOException, ClassNotFoundException {
        ObjectSerializer.serialize(this.gameState, this.path);
        GameState dGameState = ObjectSerializer.deserialize(this.path);
        assertEquals(dGameState, this.gameState);
    }

    @org.junit.After
    public void cleanFiles() {
        boolean deleted = new File(this.path.toString()).delete();
    }
}
