package utils;

import logics.Settings;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Functional interface to serialize and deserialize a generic object {@code O}
 */
public interface ObjectSerializer <O> {
    /**
     * Serialize an object {@code o} to a file {@code path}
     * @param obj object to serialize
     * @param filePath path to the file to serialize to
     */
    static <O> void serialize(final O obj, final Path filePath) throws IOException {
        Path directories= filePath.getParent();
        if (directories != null) {
            Files.createDirectories(directories);
        }
        try (FileOutputStream file = new FileOutputStream(filePath.toString());
                ObjectOutputStream out = new ObjectOutputStream(file);) {
            out.writeObject(obj);
        }
    }

    /**
     * Deserialize an object from a file
     * @param filePath path to the file
     * @return the object deserialized from the file
     * @param <O> object type
     * @throws IOException if the file does not exist
     * @throws ClassNotFoundException if the class of the object is not the same as the one expected
     */
    @SuppressWarnings("unchecked")
    static <O> O deserialize(final Path filePath) throws IOException, ClassNotFoundException {
        try (FileInputStream file = new FileInputStream(filePath.toString());
             ObjectInputStream in = new ObjectInputStream(file)) {
               return (O)in.readObject();
        }
    }
}
