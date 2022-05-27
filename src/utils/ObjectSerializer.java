package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

/**
 * Functional interface to serialize a generic object {@code O}
 */
public interface ObjectSerializer <O> {
    void serialize(O obj, String filename) throws IOException;
    Optional<O> deserialize(String filename) throws IOException, FileNotFoundException, ClassNotFoundException;
}
