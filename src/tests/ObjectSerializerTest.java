package tests;

import static org.junit.Assert.*;

import java.io.*;
import java.nio.file.Path;

import utils.ObjectSerializer;

public class ObjectSerializerTest {

    private final Path path = Path.of("string.ser");
    
    @org.junit.Before
    void initTests() {
        try (FileOutputStream file = new FileOutputStream("string.ser");
                ObjectOutputStream out = new ObjectOutputStream(file);) {
            out.writeObject("string");
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
    
    @org.junit.Test
    void testSerialization() {
        try {
            ObjectSerializer.serialize("string", this.path);
        } catch (IOException e) {
            e.printStackTrace();
            fail("failed to serialize");
        }
    }
    
    @org.junit.Test
    void testDeserialization() {
        try {
            assertTrue(ObjectSerializer.deserialize(this.path).equals("string"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            fail("failed to deserialize");
        }
    }
    
    @org.junit.Test
    void testSerializationAndDeserialization() {
        try {
            ObjectSerializer.serialize("string", this.path);
            assertTrue(ObjectSerializer.deserialize(this.path).equals("string"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            fail("failed to serialize and deserialize");
        }
    }

    @org.junit.Test
    void testDeserializationAndSerialization() {
        try {
            ObjectSerializer.deserialize(this.path);
            ObjectSerializer.serialize("string", this.path);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            fail("failed to serialize and deserialize");
        }
    }
    
    @org.junit.After
    void destroyTests() {
       new File(this.path.toString()).delete();
    }
}
