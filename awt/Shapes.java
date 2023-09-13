package awt;

import swing.MyFrame;

import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.IOException;

public class Shapes {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        jFrame.add(new MyComponent());


    }
    static class MyComponent extends JComponent{

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            Point first = new Point(50,50);
            Point second = new Point(100,100);
            Line2D line = new Line2D.Double(first, second);
            g2.draw(line);

            Rectangle2D rectangle = new Rectangle2D.Double(100,100,200,100);
            g2.draw(rectangle);

            RoundRectangle2D roundRectangle = new RoundRectangle2D.Double(200, 250, 200,100,40,40);
            g2.draw(roundRectangle);

            Ellipse2D ellipse = new Ellipse2D.Double(400,400, 50,50);
            g2.draw(ellipse);


            QuadCurve2D quadCurve = new QuadCurve2D.Double(300, 0, 350, 50, 400,0);
            g2.draw(quadCurve);

            CubicCurve2D cubicCurve = new CubicCurve2D.Double(450,50, 470,150,500,-50,550,100);
            g2.draw(cubicCurve);

            Arc2D arc = new Arc2D.Double(600, 100,50,100,90,170,Arc2D.PIE);
            g2.draw(arc);

            GeneralPath generalPath = new GeneralPath();
            generalPath.moveTo(200,300);
            generalPath.lineTo(400,300);
            generalPath.quadTo(450,350,500,300);
            generalPath.curveTo(600,350,650,250,700,300);
            generalPath.closePath();
            g2.draw(generalPath);
        }

    }
}
