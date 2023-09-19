package differents;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExamples {
    public static void main(String[] args) throws IOException {
       /* Properties defaultProp = new Properties();
        defaultProp.setProperty("bla", "default");
        Properties properties = new Properties(defaultProp);
        properties.setProperty("Gleb", "19");
        properties.setProperty("Tanya", "18");
        properties.store(new FileWriter("differents\\prop.properties"), "my comments");*/
        Properties properties = new Properties();
        properties.load(new FileReader("differents\\prop.properties"));
        for (Object value : properties.values()){
            System.out.println(value);
        }


    }
}
