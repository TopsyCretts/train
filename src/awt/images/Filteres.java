package awt.images;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

public class Filteres {
    public static void main(String[] args) throws IOException {
        File file = new File("swing\\img\\result.png");
        BufferedImage image = ImageIO.read(file);

        BufferedImage imageFiltered = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        AffineTransform transform = AffineTransform.getRotateInstance(45, image.getWidth() / 2, image.getHeight() / 2);
        BufferedImageOp bufferedImageOp = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
        bufferedImageOp.filter(image, imageFiltered);

        ImageIO.write(imageFiltered, "png",new File("swing\\img\\result.png" ));

    }
}
