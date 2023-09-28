package awt.BufferExamples;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class BufferText {
    public static void main(String[] args) throws InterruptedException, IOException, UnsupportedFlavorException {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection("blabla");
        clipboard.setContents(stringSelection, null);

        DataFlavor dataFlavor = DataFlavor.stringFlavor;
        if (clipboard.isDataFlavorAvailable(dataFlavor)){
            System.out.println(clipboard.getData(dataFlavor));
        }

    }
}
