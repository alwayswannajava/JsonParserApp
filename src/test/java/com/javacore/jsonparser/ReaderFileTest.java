package com.javacore.jsonparser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ReaderFileTest {

    @Test
    @DisplayName("Test correct read files content")
    void testReadFilesContent() {
        FileFinder fileFinder = new FileFinder();
        Set<String> foundJsonFiles = fileFinder.findAllJsonFilesInDir(FileFinderTest.PATH_TO_TEST_DIRECTORY);
        List<String> expectedReadContent = new ArrayList<>();


        String expectedReadContentFromFirstFile =
                "[  {    \"student_id\": 3,    \"group_id\": \"103\",    \"courses\": \"Biology, Chemistry, Geography\",    \"first_name\": \"Michael\",    \"last_name\": \"Johnson\"  },  {    \"student_id\": 4,    \"group_id\": \"104\",    \"courses\": \"Computer Science, Literature, Music\",    \"first_name\": \"Emily\",    \"last_name\": \"Williams\"  },  {    \"student_id\": 5,    \"group_id\": \"105\",    \"courses\": \"Economics, Foreign Language, Physical Education\",    \"first_name\": \"James\",    \"last_name\": \"Brown\"  }]";

        String expectedReadContentFromSecondFile = "[  {    \"student_id\": 1,    \"group_id\": \"101\",    \"courses\": \"Math, Science, History\",    \"first_name\": \"John\",    \"last_name\": \"Doe\"  },  {    \"student_id\": 2,    \"group_id\": \"102\",    \"courses\": \"English, Physics, Art\",    \"first_name\": \"Jane\",    \"last_name\": \"Smith\"  }]";

        expectedReadContent.add(expectedReadContentFromFirstFile);
        expectedReadContent.add(expectedReadContentFromSecondFile);
        ReaderFile readerFile = new ReaderFile();
        List<String> actualReadContent =
                readerFile.readFilesContent(FileFinderTest.PATH_TO_TEST_DIRECTORY, foundJsonFiles);
        assertEquals(expectedReadContent, actualReadContent);
    }

    @Test
    @DisplayName("Test throw RuntimeException when directory is wrong")
    void testThrowRuntimeExceptionWhenDirectoryIsWrong() {
        ReaderFile readerFile = new ReaderFile();
        FileFinder fileFinder = new FileFinder();
        Set<String> foundJsonFiles = fileFinder.findAllJsonFilesInDir(FileFinderTest.PATH_TO_TEST_DIRECTORY);
        assertThrows(
                RuntimeException.class,
                () -> readerFile.readFilesContent(FileFinderTest.WRONG_PATH_TO_TEST_DIRECTORY, foundJsonFiles)
        );
    }

    @Test
    @DisplayName("Test throw NullPointerException when input set is null")
    void testThrowNullPointerWhenInputSetIsNull() {
        ReaderFile readerFile = new ReaderFile();
        Set<String> foundJsonFiles = null;
        assertThrows(
                NullPointerException.class,
                () -> readerFile.readFilesContent(FileFinderTest.PATH_TO_TEST_DIRECTORY, foundJsonFiles)
        );
    }

}