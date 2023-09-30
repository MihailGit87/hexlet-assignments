package exercise;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int countOfApartments) {
        return homes.stream()
                .limit(countOfApartments)
                .sorted(Home::compareTo)
                .map(Home::toString)
                .collect(Collectors.toList());
    }
}
// END
