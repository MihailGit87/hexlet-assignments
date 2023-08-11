package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
class App {
    public static <T> List<Map<T, T>> findWhere(List<Map<T, T>> books, Map<T, T> where) {
        List<Map<T, T>> result = new ArrayList<>();

        if (books.isEmpty()) {
            return result;
        } else if (where.containsKey("title")) {
            for (Map<T, T> book : books) {
                if (book.get("author").equals(where.get("author"))
                        && book.get("year").equals(where.get("year")) && book.get("title").equals(where.get("title"))) {
                    result.add(book);
                }
            }
        } else {
            for (Map<T, T> book : books) {
                if (book.get("author").equals(where.get("author")) && book.get("year").equals(where.get("year"))) {
                    result.add(book);
                }
            }
        }

        return result;
    }
}
//END
