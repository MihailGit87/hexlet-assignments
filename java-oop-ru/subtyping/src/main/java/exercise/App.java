package exercise;

import java.util.Map;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage map) {
        for (Map.Entry<String, String> item : map.toMap().entrySet()) {
            map.unset(item.getKey());
            map.set(item.getValue(), item.getKey());
        }
    }
}
// END
