package awt.images;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class ReadingAndWriting {
    public static void main(String[] args) throws IOException {
        File file = new File("swing\\img\\strb.jpg");
        BufferedImage image = ImageIO.read(file);
        ImageIO.write(image, "png", new File("swing\\img\\strb.png"));


        String[] extensions = ImageIO.getReaderFileSuffixes();
        for (String string : extensions){
            System.out.println(string);
        }
        ImageReader reader = null;
        Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName("jpg");
        if (iterator.hasNext()) reader = iterator.next();

        InputStream inputStream = new FileInputStream("swing\\img\\strb.jpg");
        ImageInputStream imageInputStream = ImageIO.createImageInputStream(inputStream);
        reader.setInput(imageInputStream, true);
        BufferedImage image1 = reader.read(0);


        /*int count = reader.getNumThumbnails(0);
        BufferedImage image2 = reader.readThumbnail(0, count);
        System.out.println(reader.getHeight(0));
        reader.getWidth(0);*/

        ImageWriter writer = null;
        Iterator<ImageWriter> imageWriterIterator = ImageIO.getImageWritersByFormatName("png");
        if (imageWriterIterator.hasNext()) writer = imageWriterIterator.next();

        ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(new File("swing\\img\\result.png"));
        writer.setOutput(imageOutputStream);
        writer.write(image1);

    }


}
