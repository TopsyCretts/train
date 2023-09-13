package awt;

import swing.MyFrame;

import javax.swing.*;
import java.awt.*;

import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class Transformation {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        jFrame.add(new MyComponent());
    }

    static class MyComponent extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Rectangle2D rectangle2D = new Rectangle2D.Double(100,100,100,100);

            //g2.scale(0.5,0.5);
            //g2.translate(50,0);
            //g2.shear(0.2,0.1);
            g2.rotate(2, 200,200);

            g2.draw(rectangle2D);


        }
    }
}
