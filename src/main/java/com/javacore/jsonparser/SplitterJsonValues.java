package com.javacore.jsonparser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitterJsonValues {
    private static final String PUNCTUATION_REGEX_PATTERN = "\\p{Punct}";

    /**
     * Splits input list by regex
     * For example, input list has the following element: [Music, History],
     * but there comma symbol between them, or there would be symbol '#'
     * or something else. So, this method splits elements in array by punct
     * regex, that removes symbols like '?#,[' and so on.
     *
     * @param inputJsonFieldsList input list that will be split
     * @return split list by regex
     */
    public List<String> splitParsedJsonValuesByRegex(List<String> inputJsonFieldsList) {
        List<String> splittedJsonValuesByRegexList = new ArrayList<>();

        for (String currentLine : inputJsonFieldsList) {
            String[] splitLines = currentLine.split(PUNCTUATION_REGEX_PATTERN);
            splittedJsonValuesByRegexList.addAll(Arrays.asList(splitLines));
        }

        return splittedJsonValuesByRegexList;
    }
}
