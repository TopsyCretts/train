package swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = getJFrame("FirstApp", 500, 500);
        Font font = new Font("Arial Black", Font.BOLD, 24);
        printText("I love u bby", jFrame, font);


    }
    static void printText(String text, JFrame jFrame, Font font){
        JComponent jComponent = new MyComponent(font, text);
        jFrame.add(jComponent);

    }
    static class MyComponent extends JComponent{
        Font font;
        String text;

        public MyComponent(Font font, String text) {
            this.font = font;
            this.text = text;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setFont(font);
            g2.drawString(text, 40, 40);

            Point2D p1 = new Point2D.Double(100,100);
            Point2D p2 = new Point2D.Double(200, 100);
            Point2D p3 = new Point2D.Double(150, 200);
            Point2D p4 = new Point2D.Double();
            Line2D l1 = new Line2D.Double(p1,p2);
            Line2D l2 = new Line2D.Double(p2,p3);
            Line2D l3 = new Line2D.Double(p1,p3);

            Rectangle2D rectangle2D = new Rectangle2D.Double(100,200, 100, 50);
            g2.draw(l1);
            g2.draw(l2);
            g2.draw(l3);
            g2.draw(rectangle2D);
            g2.setPaint(new Color(250,100,0));
            g2.fill(rectangle2D);
            try {
                URL url = new URL("https://sun9-33.userapi.com/impg/N7F2KHqrjsT4soqy-10JtoGMtO4mAV86MLMQ6g/c" +
                        "Ek_sFO-cYE.jpg?size=1024x683&quality=96&sign=4589eb82e7249fc1084d64ca07a13aca&type=album");
                Image image = new ImageIcon(url).getImage();
                g2.drawImage(image, 300, 300, null);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    static JFrame getJFrame(String name, int width, int height) throws IOException {
        JFrame frame = new JFrame(name);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds((dimension.width - width) / 2, (dimension.height - height) / 2, width, height);
        BufferedImage image = ImageIO.read(new File("C:\\Users\\User\\Desktop\\java\\swing\\img\\strb.jpg"));
        frame.setIconImage(image);
        return frame;
    }
}
