package awt.drawing;

import swing.MyFrame;

import javax.swing.*;
import java.awt.*;

import java.awt.geom.Line2D;
import java.io.IOException;

public class Stroke {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        jFrame.add(new MyComponent());
    }
    static class MyComponent extends JComponent{
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 10f, new float[]{30,10},0));
            Line2D line2D = new Line2D.Double(0,0,150,150);
            g2.draw(line2D);
        }
    }
}
