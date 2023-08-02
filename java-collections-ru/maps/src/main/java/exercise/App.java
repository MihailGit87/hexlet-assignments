package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App{
    public static Map getWordCount(String sentence) {
        String[] sentenceArr = sentence.split(" ");
        Map<String, Integer> wordCountMap = new HashMap<>();

        if (sentence.isEmpty()) {
            return wordCountMap;
        }

        int i2;
        for (String s : sentenceArr) {
            i2 = wordCountCalc(sentenceArr, s);
            wordCountMap.put(s, i2);
        }

        return wordCountMap;
    }
    public static int wordCountCalc (String[] sentenceArr, String countingWord) {
        int wordcount = 0;
        for (String s : sentenceArr) {
            if (s.equals(countingWord)) {
                wordcount++;
            }
        }
        return wordcount;
    }

    public static String toString(Map<String, Integer> wordcountMap) {

        if (wordcountMap.isEmpty()) {
            return "{}";
        }
        String result = "{\n";
        for (Map.Entry<String, Integer> word : wordcountMap.entrySet()) {
            result = result + "  " + word.getKey() + ": " + word.getValue() + "\n";
        }
        result = result + "}";
        return result;
    }
}
//END