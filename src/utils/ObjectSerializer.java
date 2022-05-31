package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

/**
 * Functional interface to serialize and deserialize a generic object {@code O}
 */
public interface ObjectSerializer <O> {
    static <O> void serialize(O obj, String filename) throws IOException {
        try (FileOutputStream file = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(file);) {
            out.writeObject(obj);
        }
    };

    @SuppressWarnings("unchecked")
    static <O> O deserialize(String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream file = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(file)) {
               return (O)in.readObject();
           }
       };
}
