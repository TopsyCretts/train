package awt.BufferExamples;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

public class BufferImg {
    public static void main(String[] args) throws IOException, UnsupportedFlavorException {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        BufferedImage image = ImageIO.read(new File("swing\\img\\strb.png"));
        ImageTransferable imageTransferable = new ImageTransferable(image);
        clipboard.setContents(imageTransferable, null);

        DataFlavor flavor = DataFlavor.imageFlavor;
        if (clipboard.isDataFlavorAvailable(flavor)){
            BufferedImage result = (BufferedImage) clipboard.getData(flavor);
            ImageIO.write(result, "tiff", new File("swing\\img\\result.tiff"));
        }

    }
}

class ImageTransferable implements Transferable {
    private Image theImage;

    public ImageTransferable(Image theImage) {
        this.theImage = theImage;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{DataFlavor.imageFlavor};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(DataFlavor.imageFlavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (flavor.equals(DataFlavor.imageFlavor)) {
            return theImage;
        } else throw new UnsupportedFlavorException(flavor);
    }
}
