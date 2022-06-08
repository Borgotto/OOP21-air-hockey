package tests;

import static org.junit.Assert.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import utils.ObjectSerializer;

public class ObjectSerializerTest {

    private final Path path = Path.of("string.ser");
    
    @org.junit.Before
    public void initTests() {
        try (FileOutputStream file = new FileOutputStream("string.ser");
                ObjectOutputStream out = new ObjectOutputStream(file);) {
            out.writeObject("string");
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
    
    @org.junit.Test
    public void testSerialization() {
        try {
            ObjectSerializer.serialize("string", this.path);
        } catch (IOException e) {
            e.printStackTrace();
            fail("failed to serialize");
        }
    }
    
    @org.junit.Test
    public void testDeserialization() {
        try {
            assertEquals("string", ObjectSerializer.deserialize(this.path));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            fail("failed to deserialize");
        }
    }
    
    @org.junit.Test
    public void testSerializationAndDeserialization() {
        try {
            ObjectSerializer.serialize("string", this.path);
            assertEquals("string", ObjectSerializer.deserialize(this.path));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            fail("failed to serialize and deserialize");
        }
    }

    @org.junit.Test
    public void testDeserializationAndSerialization() {
        try {
            ObjectSerializer.deserialize(this.path);
            ObjectSerializer.serialize("string", this.path);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            fail("failed to serialize and deserialize");
        }
    }
    
    @org.junit.After
    public void destroyTests() {
        try {
            Files.deleteIfExists(this.path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
