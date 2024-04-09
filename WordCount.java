package vpicnic;

import java.util.*;

public class WordCount {
    /**
     * Подсчёт слов в тексте
     *
     * @param textArr String
     * @return Map<String, Integer>
     */
    public static Map<String, Integer> getStringIntegerMap(String[] textArr) {
        Map<String, Integer> mapWords = new TreeMap<>();

        for (int i = 0; i < textArr.length; i++) {
            if (!mapWords.containsKey(textArr[i])) {
                mapWords.put(textArr[i], 1);
            } else {
                mapWords.put(textArr[i], mapWords.get(textArr[i]) + 1);

            }
        }
        return mapWords;
    }

    /**
     * Сортировка
     * Sort Map by Value (Integeer)
     *
     * @param map<String, Onteger>
     * @param <K>
     * @param <V>
     * @return SortedSet<Map.Entry < K, V>>
     */
    public static <K, V extends Comparable<? super V>>
    SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
        SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(
                new Comparator<Map.Entry<K, V>>() {
                    @Override
                    public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                        int res = e1.getValue().compareTo(e2.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}