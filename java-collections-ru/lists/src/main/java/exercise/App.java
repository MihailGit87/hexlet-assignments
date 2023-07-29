package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String str, String word) {

        if (str.length() < word.length()) {
            return false;
        }

        String[] strArr = str.split("");
        List<String> list = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            list.add(word.substring(i,i + 1).toLowerCase());
        }

        for (int i = 0; i < strArr.length; i++) {
            if (list.contains(strArr[i])){
                list.remove(strArr[i]);
            }
        }

        if (list.size() == 0) {
            return true;
        }

        return false;
    }
}
//END
