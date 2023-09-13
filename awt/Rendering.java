package awt;

import swing.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class Rendering {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        jFrame.add(new MyComponent());
    }

    static class MyComponent extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Ellipse2D ellipse2D = new Ellipse2D.Double(50,50,100,100);
            g2.draw(ellipse2D);

            RenderingHints renderingHints = new RenderingHints(null);
            renderingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            Ellipse2D ellipse2D1 = new Ellipse2D.Double( 200,50,100,100);
            g2.setRenderingHints(renderingHints);
            g2.draw(ellipse2D1);


        }
    }
}
