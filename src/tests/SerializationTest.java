package tests;

import static org.junit.Assert.*;

import java.io.*;

import utils.ObjectSerializer;

public class SerializationTest {
    
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
            ObjectSerializer.serialize("string", "string.ser");
        } catch (IOException e) {
            e.printStackTrace();
            fail("failed to serialize");
        }
    }
    
    @org.junit.Test
    void testDeserialization() {
        try {
            assertTrue(ObjectSerializer.deserialize("string.ser").equals("string"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            fail("failed to deserialize");
        }
    }
    
    @org.junit.Test
    void testSerializationAndDeserialization() {
        try {
            ObjectSerializer.serialize("string", "string.ser");
            assertTrue(ObjectSerializer.deserialize("string.ser").equals("string"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            fail("failed to serialize and deserialize");
        }
    }

    @org.junit.Test
    void testDeserializationAndSerialization() {
        try {
            ObjectSerializer.deserialize("string.ser");
            ObjectSerializer.serialize("string", "string.ser");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            fail("failed to serialize and deserialize");
        }
    }
    
    @org.junit.After
    void destroyTests() {
       new File("string.ser").delete();
    }
}
