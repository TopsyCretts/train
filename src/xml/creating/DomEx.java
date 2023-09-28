package xml.creating;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DomEx {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();


        Element root = document.createElement("root");
        Element font = document.createElement("font");
        Text text = document.createTextNode("TimesNewRoman");

        document.appendChild(root);
        root.appendChild(font);
        font.appendChild(text);
        font.setAttribute("size", "20");

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        transformer.transform(new DOMSource(document),
                new StreamResult(new FileOutputStream("xml\\creating\\tempTransform.xml")));

        DOMImplementation implementation = document.getImplementation();
        DOMImplementationLS ls = (DOMImplementationLS) implementation.getFeature("LS", "3.0");
        LSSerializer serializer = ls.createLSSerializer();
        serializer.getDomConfig().setParameter("format-pretty-print", true);
        String str = serializer.writeToString(document);
        System.out.println(str);

       /* LSOutput lsOutput = ls.createLSOutput();
        lsOutput.setEncoding("UTF-8");
        lsOutput.setByteStream(Files.newOutputStream(Paths.get("xml\\creating\\tempLS.xml")));
        serializer.write(document,lsOutput);*/



    }
}
