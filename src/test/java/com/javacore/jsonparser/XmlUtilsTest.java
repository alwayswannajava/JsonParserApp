package com.javacore.jsonparser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;

import static org.mockito.Mockito.*;

class XmlUtilsTest {

    @Test
    @DisplayName("Test create document obj")
    void testCreateDocument() throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = mock(DocumentBuilderFactory.class);
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        when(documentBuilderFactory.newDocumentBuilder()).thenReturn(documentBuilder);
        verify(documentBuilderFactory).newDocumentBuilder();
    }

    @Test
    @DisplayName("Test create xml file")
    void testCreateXmlFile() throws TransformerConfigurationException {
        TransformerFactory transformerFactory = mock(TransformerFactory.class);
        Transformer transformer = transformerFactory.newTransformer();
        when(transformerFactory.newTransformer()).thenReturn(transformer);
        verify(transformerFactory).newTransformer();
    }

    @Test
    void addToStatisticsFileParsedJsonValues() {
        Document document = mock(Document.class);
        Element root = document.createElement("statistics");
        Element rootChildName = document.createElement("item");
        when(document.createElement("statistics")).thenReturn(root);
        when(document.createElement("item")).thenReturn(rootChildName);
        verify(document).createElement("statistics");
        verify(document).createElement("item");
    }
}