package com.javacore.jsonparser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CounterJsonValuesOccurrenceTest {

    @Test
    @DisplayName("Test count json values occurrences in splitted list case #1")
    void testCountJsonValuesOccurrencesInSplittedList() {
        CounterJsonValuesOccurrence counterJsonValuesOccurrence = new CounterJsonValuesOccurrence();
        List<String> expectedInputList = new ArrayList<>();
        expectedInputList.add(new String("Boxing"));
        expectedInputList.add(new String("Boxing"));
        expectedInputList.add(new String("Math"));
        expectedInputList.add(new String("Physics"));
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("Boxing", 2);
        expectedMap.put("Math", 1);
        expectedMap.put("Physics", 1);
        Map<String, Integer> actualMap =
                counterJsonValuesOccurrence.countJsonValuesOccurrencesInSplittedList(expectedInputList);
        assertEquals(expectedMap, actualMap);
    }

    @Test
    @DisplayName("Test count json values occurrences in splitted list case #2")
    void testCountJsonValuesOccurrencesInSplittedListNumberTwo() {
        CounterJsonValuesOccurrence counterJsonValuesOccurrence = new CounterJsonValuesOccurrence();
        List<String> expectedInputList = new ArrayList<>();
        expectedInputList.add(new String("Football"));
        expectedInputList.add(new String("Football"));
        expectedInputList.add(new String("Football"));
        expectedInputList.add(new String("Music"));
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("Football", 3);
        expectedMap.put("Music", 1);
        Map<String, Integer> actualMap =
                counterJsonValuesOccurrence.countJsonValuesOccurrencesInSplittedList(expectedInputList);
        assertEquals(expectedMap, actualMap);
    }

}