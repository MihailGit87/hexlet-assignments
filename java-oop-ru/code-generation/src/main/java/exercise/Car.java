package exercise;

import com.google.gson.Gson;
import lombok.Value;

@Value
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    public String serialize() {
        Gson gson = new Gson();
        return gson.toJson(this); //json представление объекта
    }

        public static Car unserialize(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Car.class);
    }
}
