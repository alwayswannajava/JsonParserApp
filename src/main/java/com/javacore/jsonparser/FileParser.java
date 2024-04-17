package com.javacore.jsonparser;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.*;

public class FileParser {

    /**
     * Returns list of parsed json values by attribute
     * For example, our content list has json field 'courses', and
     * values for this field: "Math, History, Music". Imagine that input attr is courses,
     * so this method parses this field values and put them in ArrayList
     *
     * @param readContentList a list with files content
     * @param attribute       input attribute for parse values from file content by this attribute
     * @return list of parsed json values by attribute
     */
    public List<String> parseJsonValuesByAttribute(List<String> readContentList, String attribute) {
        List<String> jsonValuesByAttributeList = new ArrayList<>();
        JsonFactory jsonFactory = new JsonFactory();
        String parsedValue;

        for (String currentJsonLine : readContentList) {
            try (JsonParser jsonParser = jsonFactory.createParser(currentJsonLine)) {
                while (jsonParser.nextToken() != JsonToken.END_OBJECT ||
                        jsonParser.nextToken() != JsonToken.END_ARRAY) {

                    String fieldName = jsonParser.getCurrentName();

                    if (attribute.equals(fieldName)) {
                        jsonParser.nextToken();
                        parsedValue = jsonParser.getText();
                        jsonValuesByAttributeList.add(parsedValue);
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return jsonValuesByAttributeList;
    }

}
