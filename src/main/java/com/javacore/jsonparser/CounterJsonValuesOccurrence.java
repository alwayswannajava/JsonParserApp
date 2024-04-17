package com.javacore.jsonparser;

import java.util.*;

public class CounterJsonValuesOccurrence {
    /**
     * Count json values occurrences in split list
     * For example, our input list has the following elements:[Music, Music, History].
     * So, this method counts frequency of each element in this list. For example,
     * count for element 'Music' would be 2, for 'History' 1. Then this method
     * put count of frequency element and element itself to the map. Element itself
     * is a key, count is a value in map.
     *
     * @param inputSplittedList a list which was split
     * @return map of count occurrences json values
     */
    public Map<String, Integer> countJsonValuesOccurrencesInSplittedList(List<String> inputSplittedList) {
        Map<String, Integer> countOccurJsonValueMap = new HashMap<>();
        Set<String> jsonFieldValuesSet = new HashSet<>(inputSplittedList);

        for (String currentJsonValue : jsonFieldValuesSet) {
            int count = Collections.frequency(inputSplittedList, currentJsonValue);
            String currentJsonValueWithoutSpace = currentJsonValue.trim();
            countOccurJsonValueMap.put(currentJsonValueWithoutSpace, count);
        }

        return countOccurJsonValueMap;
    }
}
