package exercise;

import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

@Value
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() {
        return null; //json представление объекта
    }

    public static Car unserialize(String json) {
        return null; //принимает json и возвращает объект Car
    }

    // END
}
