package com.javacore.jsonparser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SplitterJsonValuesTest {

    @Test
    @DisplayName("Test correct split list by punctuation regex")
    void testSplitParsedJsonFieldsValuesByRegex() {
        SplitterJsonValues splitterJsonValues = new SplitterJsonValues();
        List<String> expectedSplittedList = new ArrayList<>();
        expectedSplittedList.add(new String("Math, Football, Computer Science"));
        List<String> actualSplittedList = new ArrayList<>();
        actualSplittedList.add(new String("Math"));
        actualSplittedList.add(new String(" Football"));
        actualSplittedList.add(new String(" Computer Science"));
        expectedSplittedList = splitterJsonValues.splitParsedJsonValuesByRegex(expectedSplittedList);
        assertEquals(expectedSplittedList, actualSplittedList);

    }

    @Test
    @DisplayName("Test throw NullPointerException when list is null")
    void testThrowNullPointerExceptionWhenListIsNull() {
        SplitterJsonValues splitterJsonValues = new SplitterJsonValues();
        assertThrows(NullPointerException.class, () -> splitterJsonValues.splitParsedJsonValuesByRegex(null));
    }

}