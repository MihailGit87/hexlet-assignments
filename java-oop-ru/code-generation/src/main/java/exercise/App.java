package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

// BEGIN
public class App {

    public static String save(Path path, Car car) throws IOException {
        String carSerialize = car.serialize();
        return String.valueOf(Files.writeString(path, carSerialize));
    }

    public static Car extract(Path path) throws IOException {
        String json = Files.readString(path);
        return Car.unserialize(json);
    }
}
