package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter{
    public static List<String> takeOldestMans(List<Map<String, String>> users) {

        return users.stream()
                .filter(gender -> gender.get("gender").equals("male"))
                .sorted((man1, man2) -> man1.get("birthday").compareTo(man2.get("birthday")))
                .map(man -> man.get("name"))
                .collect(Collectors.toList());

//       return users.stream()
//                .filter(man -> man.get("gender").equals("male"))
//                .sorted(Sorter::compare)
//                .map(man -> man.get("name"))
//                .collect(Collectors.toList());
    }
//    private static int compare(Map<String, String> man1, Map<String, String> man2) {
//        LocalDate man1Birthday = LocalDate.parse(man1.get("birthday"));
//        LocalDate man2Birthday = LocalDate.parse(man2.get("birthday"));
//        return man1Birthday.compareTo(man2Birthday);
//    }
}
// END
