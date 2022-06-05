package utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Functional interface to serialize and deserialize a generic object {@code O}
 */
public interface ObjectSerializer <O> {
    static <O> void serialize(O obj, Path filePath) throws IOException {
        Files.createDirectories(filePath.getParent()); // create directory if needed
        try (FileOutputStream file = new FileOutputStream(filePath.toString());
                ObjectOutputStream out = new ObjectOutputStream(file);) {
            out.writeObject(obj);
        }
    }

    @SuppressWarnings("unchecked")
    static <O> O deserialize(Path filePath) throws IOException, ClassNotFoundException {
        try (FileInputStream file = new FileInputStream(filePath.toString());
             ObjectInputStream in = new ObjectInputStream(file)) {
               return (O)in.readObject();
        }
    }
}
