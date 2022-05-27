package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
            fail("failed to serialize");
        }
    }
    
    @org.junit.Test
    void testDeserialization() {
        
    }
    
    @org.junit.Test
    void testSerializationAndDeserialization() {
        
    }
    
    @org.junit.After
    void destroyTests() {
       new File("string.ser").delete();
    }
}
