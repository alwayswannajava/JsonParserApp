package com.javacore.jsonparser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ReaderFile {
    public static final String PATH_DELIMITER = "/";

    /**
     * Reads content of files in input directory from each file
     * and puts read file content to the list
     *
     * @param inputDirectory    a directory where will be search json files
     * @param jsonFilesInputSet a set of json files
     * @return list of each file content
     * @throws RuntimeException if input directory is wrong or something else
     */
    public List<String> readFilesContent(String inputDirectory, Set<String> jsonFilesInputSet) {
        List<String> readLines = new ArrayList<>();

        for (String currentJsonFile : jsonFilesInputSet) {
            StringBuilder contentBuilder = new StringBuilder();

            try (Stream<String> lineStream = Files.lines(
                    Paths.get(inputDirectory + PATH_DELIMITER + currentJsonFile))) {
                lineStream.forEach(contentBuilder::append);
                readLines.add(contentBuilder.toString());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return readLines;
    }

}
