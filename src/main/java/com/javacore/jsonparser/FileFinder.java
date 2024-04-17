package com.javacore.jsonparser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileFinder {
    private static final String JSON_FILE_FORMAT = ".json";

    /**
     * Returns set of json files in input directory
     *
     * @param inputDirectory a directory where will be searching of json files
     * @return set of all found json files
     * @throws RuntimeException if input directory is wrong or something else
     */
    public Set<String> findAllJsonFilesInDir(String inputDirectory) {
        Set<String> foundJsonFilesInDirSet = new HashSet<>();

        try (Stream<Path> stream = Files.list(Paths.get(inputDirectory))) {
            foundJsonFilesInDirSet = stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .filter(file -> file.endsWith(JSON_FILE_FORMAT))
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException("There is no such as path to dir like this. Please, input correct path to dir");
        }

        return foundJsonFilesInDirSet;
    }
}
