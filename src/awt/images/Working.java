package awt.images;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class Working {
    public static void main(String[] args) throws IOException {
        File file = new File("swing\\img\\result.png");
        BufferedImage image = ImageIO.read(file);

        WritableRaster raster = image.getRaster();
        for (int i = 0; i < raster.getWidth(); i++) {
            int[] pixel = raster.getPixel(i, 0, new int[4]);
            pixel[0] = 255;
            raster.setPixel(i, 0, pixel);
        }

   /*     raster.getPixels(0, 0, image.getWidth(), 5, new int[4 * image.getWidth() * 5]);
        raster.setPixels(0,0, image.getWidth(), 10, new int[4 * image.getWidth() * 10]);*/

       /* Object data = raster.getDataElements(0,0, null);
        ColorModel colorModel = image.getColorModel();
        Color color = new Color(colorModel.getRGB(data), true);
        raster.setDataElements(0,0, data);*/

        image.setData(raster);
        ImageIO.write(image, "png", new File("swing\\img\\result.png"));


    }

}
