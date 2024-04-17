package com.javacore.jsonparser;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        String inputDir = args[0];
        String inputAttribute = args[1];
        ReaderFile readerFile = new ReaderFile();
        FileFinder fileFinder = new FileFinder();
        Set<String> foundFilesInDirSet = fileFinder.findAllJsonFilesInDir(inputDir);
        FileParser fileParser = new FileParser();
        List<String> filesContent = readerFile.readFilesContent(inputDir, foundFilesInDirSet);
        List<String> parsedJson = fileParser.parseJsonValuesByAttribute(filesContent, inputAttribute);
        SplitterJsonValues splitterJsonValues = new SplitterJsonValues();
        List<String> splittedLines = splitterJsonValues.splitParsedJsonValuesByRegex(parsedJson);
        CounterJsonValuesOccurrence counterJsonValuesOccurrence = new CounterJsonValuesOccurrence();
        Map<String, Integer> countJsonValuesMap = counterJsonValuesOccurrence.countJsonValuesOccurrencesInSplittedList(splittedLines);
        MapSorter mapSorter = new MapSorter();
        Map<String, Integer> sortedMapByValues = mapSorter.sortMapByValueInReverseOrder(countJsonValuesMap);
        XmlUtils xmlUtils = new XmlUtils();
        xmlUtils.createDocument();
        xmlUtils.addToDocumentParsedJsonValues(sortedMapByValues);
        xmlUtils.createXmlFile(inputDir, "statistics_by_" + inputAttribute);
    }
}
