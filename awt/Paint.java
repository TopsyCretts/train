package awt;

import swing.MyFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

public class Paint {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        jFrame.add(new MyComponent());
    }
    static class MyComponent extends JComponent{
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            //g2.setPaint(new GradientPaint(new Point(50,100), Color.RED, new Point(150,100),Color.YELLOW));

            try {
                g2.setPaint(new TexturePaint(ImageIO.read(new File("swing\\img\\strb.jpg")),new Rectangle2D.Double(200,200,30,30) ));
                Ellipse2D ellipse2D = new Ellipse2D.Double(50,100,300,150);
                g2.fill(ellipse2D);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
