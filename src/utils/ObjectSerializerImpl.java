package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

public class ObjectSerializerImpl<O> implements ObjectSerializer<O> {

    public void serialize(O obj, String filename) throws IOException {
        try (FileOutputStream file = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(file);) {
            out.writeObject(obj);
        }
    }

    @SuppressWarnings("unchecked")
    public Optional<O> deserialize(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
        try (FileInputStream file = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(file);) {
            return Optional.of((O)in.readObject());
        }
    }
}
