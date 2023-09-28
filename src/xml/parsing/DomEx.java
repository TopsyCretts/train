package xml.parsing;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomEx {

    private static Node node;

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("xml\\library.xml"));

        Element element = document.getDocumentElement();

        System.out.println(element.getTagName());
        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element) {
                System.out.println(((Element) nodeList.item(i)).getTagName());
            }
        }
        System.out.println("Print elements method:");
        printElements(element.getChildNodes());

    }

    public static void printElements(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            node = nodeList.item(i);
            if (node instanceof Element) {
                printContent(node);
                printAttributes(node);

                System.out.println(((Element) nodeList.item(i)).getTagName());
                if (((Element) nodeList.item(i)).getTagName().equals("book")){
                    System.out.println(((Element) nodeList.item(i)).getAttribute("pages"));
                }
                if (nodeList.item(i).hasChildNodes()) {
                    printElements(nodeList.item(i).getChildNodes());
                }
            }
        }
    }
    public static void printContent(Node node){
        String value = "";
        if (!node.getTextContent().trim().isEmpty() && !((Text)node.getFirstChild()).getData().trim().isEmpty()
                &&!((Text) node.getFirstChild()).getData().trim().equals("\n")){
            Text text = (Text) node.getFirstChild();
            value = "=" + text.getData().trim();
            System.out.println(node.getNodeName()+value);

        }
    }
    public static void printAttributes(Node node){
        NamedNodeMap nodeMap = node.getAttributes();
        for (int i = 0; i < nodeMap.getLength(); i++) {
            Node attribute = nodeMap.item(i);
            String name = attribute.getNodeName();
            String value = attribute.getNodeValue();
            System.out.println("Attribute - "+name+". Value: "+value);
        }
    }
}
