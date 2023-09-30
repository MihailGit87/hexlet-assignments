package exercise;

import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static Map<String, String> swapKeyValue(KeyValueStorage map) {
        return map.toMap()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }
}
// END
