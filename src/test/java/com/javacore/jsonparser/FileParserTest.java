package com.javacore.jsonparser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FileParserTest {


    @Test
    @DisplayName("Test parse json values by attribute")
    void testCorrectParseJsonValuesByAttribute() {
        FileParser fileParser = new FileParser();
        ReaderFile fileReader = new ReaderFile();
        FileFinder fileFinder = new FileFinder();
        String expectedAttribute = "first_name";
        List<String> expectedParsedList = new ArrayList<>();
        expectedParsedList.add("Michael");
        expectedParsedList.add("Emily");
        expectedParsedList.add("James");
        expectedParsedList.add("John");
        expectedParsedList.add("Jane");
        Set<String> jsonFilesExpectedSet = fileFinder.findAllJsonFilesInDir(FileFinderTest.PATH_TO_TEST_DIRECTORY);
        List<String>
                fileContent = fileReader.readFilesContent(FileFinderTest.PATH_TO_TEST_DIRECTORY, jsonFilesExpectedSet);
        List<String> actualParsedList = fileParser.parseJsonValuesByAttribute(fileContent, expectedAttribute);
        assertEquals(expectedParsedList, actualParsedList);
    }

    @Test
    @DisplayName("Test throw NullPointerException when input list is null")
    void testThrowNullPointerExceptionWhenInputListIsNull() {
        FileParser fileParser = new FileParser();
        String expectedAttribute = "group_id";
        assertThrows(NullPointerException.class, () -> fileParser.parseJsonValuesByAttribute(null, expectedAttribute));
    }


}