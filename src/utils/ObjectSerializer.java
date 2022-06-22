package utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Functional interface to serialize and deserialize a generic object {@code O}
 */
public interface ObjectSerializer <O> {
    /**
     * Serialize an object {@code o} to a file {@code path}
     * @param obj The object to serialize.
     * @param filePath The path to the file to serialize to.
     * @param <O> The type of the object to serialize.
     * @throws IOException If the file does not exist.
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
     * @param filePath The path to the file.
     * @param <O> The type of the object to serialize.
     * @return The object deserialized from the file.
     * @throws IOException If the file does not exist.
     * @throws ClassNotFoundException If the class of the object is not the same as the one expected.
     */
    @SuppressWarnings("unchecked")
    static <O> O deserialize(final Path filePath) throws IOException, ClassNotFoundException {
        try (FileInputStream file = new FileInputStream(filePath.toString());
             ObjectInputStream in = new ObjectInputStream(file)) {
               return (O)in.readObject();
        }
    }
}
