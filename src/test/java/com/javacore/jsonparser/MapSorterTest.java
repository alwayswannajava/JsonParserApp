package com.javacore.jsonparser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapSorterTest {

    @Test
    @DisplayName("Test sort map by value in reverse order case #1")
    void testSortMapByValueInReverseOrder() {
        MapSorter mapSorter = new MapSorter();
        Map<String, Integer> expectedUnsortedMap = new HashMap<>();
        expectedUnsortedMap.put("Boxing", 1);
        expectedUnsortedMap.put("Football", 3);
        expectedUnsortedMap.put("Music", 2);
        Map<String, Integer> actualSortedMap = mapSorter.sortMapByValueInReverseOrder(expectedUnsortedMap);
        assertEquals(expectedUnsortedMap, actualSortedMap);
    }

    @Test
    @DisplayName("Test sort map by value in reverse order case #2")
    void testSortMapByValueInReverseOrderNumberTwo() {
        MapSorter mapSorter = new MapSorter();
        Map<String, Integer> expectedUnsortedMap = new HashMap<>();
        expectedUnsortedMap.put("Literature", 3);
        expectedUnsortedMap.put("Foreign language", 5);
        expectedUnsortedMap.put("Chemistry", 1);
        Map<String, Integer> actualSortedMap = mapSorter.sortMapByValueInReverseOrder(expectedUnsortedMap);
        assertEquals(expectedUnsortedMap, actualSortedMap);
    }

    @Test
    @DisplayName("Test throw NullPointerException when map is null")
    void testThrowNullPointerExceptionWhenMapIsNull(){
        MapSorter mapSorter = new MapSorter();
        assertThrows(NullPointerException.class, () -> mapSorter.sortMapByValueInReverseOrder(null));
    }
}