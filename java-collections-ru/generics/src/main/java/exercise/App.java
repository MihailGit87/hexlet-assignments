package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
class App {
    public static <K, V> List<Map<K, V>> findWhere(List<Map<K, V>> books, Map<K, V> where) {
        List<Map<K, V>> result = new ArrayList<>();

        for (Map<K, V> book : books) {
            boolean equals = false;
            for (Map.Entry<K, V> condition : where.entrySet()) {
                equals = book.get(condition.getKey()).equals(condition.getValue());
                if (!equals) {
                    break;
                }
            }
            if (equals) {
                result.add(book);
            }
        }

        return result;
    }
}
//END
