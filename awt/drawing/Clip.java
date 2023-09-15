package awt.drawing;

import swing.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class Clip {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        jFrame.add(new MyComponent());
    }

    static class MyComponent extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Rectangle2D rectangle2D = new Rectangle2D.Double(100,100,200,100);
            Ellipse2D ellipse2D = new Ellipse2D.Float(100,100,200, 100);
            g2.clip(ellipse2D);
            g2.fill(rectangle2D);
        }
    }
}
