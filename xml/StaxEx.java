package xml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StaxEx {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream("xml\\library.xml"));
        while (reader.hasNext()){
            int event = reader.next();
            if (event == XMLStreamReader.START_ELEMENT){
                System.out.println(reader.getLocalName());
            }
        }
    }
}
