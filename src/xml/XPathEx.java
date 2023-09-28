package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class XPathEx {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("xml\\parsing\\library.xml"));

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        System.out.println(xPath.evaluate("root/books/book",document));
        System.out.println(xPath.evaluate("root/books/book[2]",document));

        NodeList nodeList = (NodeList) xPath.evaluate("/root",document, XPathConstants.NODESET);
        Node node = (Node) xPath.evaluate("/root/books",document,XPathConstants.NODE);
        int count = ((Number) xPath.evaluate("count(root/books/book)", document,XPathConstants.NUMBER)).intValue();
        System.out.println(count);;

    }
}
