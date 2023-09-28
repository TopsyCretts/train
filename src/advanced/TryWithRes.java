package advanced;

import java.io.*;

public class TryWithRes {
    public static void main(String[] args) {
/*        Reader reader = null;
        try {
            reader = new FileReader( new File("bla"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }*/
        //jdbc Connection, Statement, ResultSet
        //streams Reader, Writer, InputStream, OutputStream
        try (Reader reader = new FileReader(new File("bla"))) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(MyClass myClass = new MyClass()) {

        }
    }

}

class MyClass implements AutoCloseable {
    @Override
    public void close() {

    }
}