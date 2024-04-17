package com.javacore.jsonparser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Map;

/**
 * Class provides creating of xml files generate elements in it
 */
public class XmlUtils {
    private static final String XML_FILE_FORMAT = ".xml";
    private static final String ROOT_NAME = "statistics";
    private static final String ROOT_CHILD_NAME = "item";
    private static final String VALUE_NODE_TAG_NAME = "value";
    private static final String COUNT_NODE_TAG_NAME = "count";
    private Document document;

    public void createDocument() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.newDocument();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Generates root elements in xml file.
     * Our root element is 'statistics'
     *
     * @return root
     */
    private Element generateRoot() {
        Element root = document.createElement(ROOT_NAME);
        document.appendChild(root);
        return root;
    }

    /**
     * Add child element to root element.
     * Our root element is 'statistics', but our child element is 'item',
     * so this method add child element 'item' to element 'statistics'
     *
     * @param root root element in xml file
     * @return element
     */
    private Element addElement(Element root) {
        Element element = document.createElement(ROOT_CHILD_NAME);
        root.appendChild(element);
        return element;
    }

    /**
     * Add element inside other elements. For example,
     * our root element is 'statistics', also, our root element
     * has child element like 'item', so this method add element
     * to inside 'item' element
     *
     * @param element input element where inside will be tagName param
     * @param tagName element that will be inside 'item' element
     * @param content content that will be inside 'item' element
     */
    private void addNode(Element element, String tagName, String content) {
        Element tagElement = document.createElement(tagName);
        tagElement.appendChild(document.createTextNode(content));
        element.appendChild(tagElement);
    }

    public void createXmlFile(String inputDir, String fileName) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer;

        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        }

        DOMSource source = new DOMSource(document);
        File xml = new File(inputDir + ReaderFile.PATH_DELIMITER + fileName + XML_FILE_FORMAT);
        StreamResult streamResult = new StreamResult(xml);

        try {
            transformer.transform(source, streamResult);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Add to document object values from input map.
     * For example, our input map has next elements:
     * {Music - 2, History - 1}, so this method puts
     * the following elements to document. The first one, it
     * generates root element 'statistics', then, when
     * we make for each in map, it generates element 'item',
     * and finally, it generates element inside 'item'
     * by key and values from input map. So, above mentioned
     * map elements would be in document in the next one format:
     * <statistics>
     * <item>
     * <value>Music</value>
     * <count>2</count>
     * </item>
     * <item>
     * <value>History</value>
     * <count>1</count>
     * </item>
     * </statistics>
     */
    public void addToDocumentParsedJsonValues(Map<String, Integer> inputMap) {
        Element root = generateRoot();

        inputMap.forEach((key, value) -> {
            Element itemElement = addElement(root);
            addNode(itemElement, VALUE_NODE_TAG_NAME, key);
            addNode(itemElement, COUNT_NODE_TAG_NAME, value.toString());
        });
    }
}
