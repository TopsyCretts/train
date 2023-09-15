package awt.printing;

import javax.print.*;
import java.awt.*;
import java.awt.print.PrinterJob;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class printDocks {
    public static void main(String[] args) throws FileNotFoundException, PrintException {
        DocFlavor docFlavor = DocFlavor.INPUT_STREAM.PNG;
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(docFlavor, null);
        InputStream inputStream = new FileInputStream("swing\\img\\strb.png");
        Doc doc = new SimpleDoc(inputStream, docFlavor, null);
        if (printService.length > 0){
            DocPrintJob docPrintJob = printService[0].createPrintJob();
            docPrintJob.print(doc, null);
        }
    }
}
