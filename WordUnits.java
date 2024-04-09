package vpicnic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class WordUnits {
    public static Map<String, Integer> countWords(String[] textArr) {
        return Arrays.stream(textArr)
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase())
                .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum)); // Count occurrences of each word
    }

    public static String findLongestWord(String[] textArr) {
        return Arrays.stream(textArr)
                .max(Comparator.comparingInt(String::length))
                .orElse(""); // Return an empty string if the array is empty
    }

}