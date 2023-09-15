package awt.drawing;

import swing.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class Areas {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        jFrame.add(new MyComponent());
    }
    static class MyComponent extends JComponent{
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            Area area = new Area(new Rectangle2D.Double(0,0,100,100));
           /*area.add(new Area(new Ellipse2D.Double(50, 50, 150,150)));
            area.subtract(new Area(new Ellipse2D.Double(50, 50, 150,150)));
            area.intersect(new Area(new Ellipse2D.Double(50, 50, 150,150)));*/
            area.exclusiveOr(new Area(new Ellipse2D.Double(50, 50, 150,150)));

            g2.fill(area);

        }
    }
}
