package xml.creating;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class SaxEx {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter
                (new FileOutputStream("xml\\creating\\sax.xml"));
        writer.writeStartDocument();
        writer.writeCharacters("\n");
        writer.writeStartElement("root");
        writer.writeCharacters("\n");
        writer.writeStartElement("books");
        writer.writeCharacters("\n");
        writer.writeStartElement("book");
        writer.writeAttribute("size", "20");
        writer.writeCharacters("some text");
        writer.writeEndElement();
        writer.writeCharacters("\n");
        writer.writeEndElement();
        writer.writeCharacters("\n");
        writer.writeEndElement();
        writer.writeCharacters("\n");
        writer.writeEndDocument();
    }
}
