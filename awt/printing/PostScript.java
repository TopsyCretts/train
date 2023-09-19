package awt.printing;

import javax.print.*;
import java.io.*;

public class PostScript {
    public static void main(String[] args) throws FileNotFoundException, PrintException {
        DocFlavor docFlavor = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
        String mimeType = "application/postscript";
        StreamPrintServiceFactory[] factories = StreamPrintServiceFactory.lookupStreamPrintServiceFactories(docFlavor, mimeType);
        OutputStream out = new FileOutputStream("awt/printing/resultPostScript.odd");
        StreamPrintService service = factories[0].getPrintService(out);

        InputStream inputStream = new FileInputStream(new File("swing\\img\\strb.png"));
        DocPrintJob job = service.createPrintJob();
        Doc doc = new SimpleDoc(inputStream,DocFlavor.INPUT_STREAM.PNG,null);
        job.print(doc, null);


    }
}
