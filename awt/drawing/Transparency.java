package awt.drawing;

import swing.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class Transparency {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        jFrame.add(new MyComponent());
    }

    static class MyComponent extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Rectangle2D rectangle2D = new Rectangle2D.Double(100,100,100,100);
            Color color = new Color(0f,0f,0f);
            g2.setColor(color);
            g2.fill(rectangle2D);

            Rectangle2D rectangle2D2 = new Rectangle2D.Double(200,100,100,100);
            Color color2 = new Color(0f,0f,0f, 0.5f);
            g2.setColor(color2);
            g2.fill(rectangle2D2);

            Rectangle2D rectangle2D3 = new Rectangle2D.Double(300,100,100,100);
            Color color3 = new Color(0f,0f,0f,0.1f);
            g2.setColor(color3);
            g2.fill(rectangle2D3);




        }
    }
}
