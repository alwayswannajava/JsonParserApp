package com.javacore.jsonparser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FileFinderTest {

    public static final String PATH_TO_TEST_DIRECTORY = "src/test/resources";
    public static final String WRONG_PATH_TO_TEST_DIRECTORY = "asaaa..wat121242";

    @Test
    @DisplayName("Test find all json files in directory")
    void testCorrectFindJsonFilesInDirectory() {
        FileFinder fileFinder = new FileFinder();
        Set<String> expectedJsonFilesSet = new HashSet<>();
        expectedJsonFilesSet.add("TestStudent1.json");
        expectedJsonFilesSet.add("TestStudent2.json");
        Set<String> actualJsonFilesSet = fileFinder.findAllJsonFilesInDir(PATH_TO_TEST_DIRECTORY);
        assertEquals(expectedJsonFilesSet, actualJsonFilesSet);
    }

    @Test
    @DisplayName("Test throw NullPointerException when input directory is null")
    void testCorrectThrowNullPointerExceptionWhenDirectoryIsNull() {
        FileFinder fileFinder = new FileFinder();
        assertThrows(NullPointerException.class, () -> fileFinder.findAllJsonFilesInDir(null));
    }

    @Test
    @DisplayName("Test throw RuntimeException when input directory is wrong")
    void testCorrectThrowRuntimeExceptionWhenDirectoryIsWrong() {
        FileFinder fileFinder = new FileFinder();
        assertThrows(RuntimeException.class, () -> fileFinder.findAllJsonFilesInDir(WRONG_PATH_TO_TEST_DIRECTORY));
    }

    @Test
    @DisplayName("Test throw correct message when input directory is wrong")
    void testCorrectThrowMessageWhenDirectoryIsWrong() {
        FileFinder fileFinder = new FileFinder();
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> fileFinder.findAllJsonFilesInDir(WRONG_PATH_TO_TEST_DIRECTORY)
        );
        String expectedThrowMessage = "There is no such as path to dir like this. Please, input correct path to dir";
        String actualThrowMessage = thrown.getMessage();
        assertEquals(expectedThrowMessage, actualThrowMessage);
    }

}