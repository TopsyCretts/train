package swing.JComponentExamples;

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
        JComponent jComponent = new MyComponent(font);
        jFrame.add(jComponent);

    }

    static class MyComponent extends JComponent{
        Font font;

        public MyComponent(Font font) {
            this.font = font;
        }
        static void printText(String text, Graphics2D g){
            g.drawString(text, 40, 40);
        }
        static void printTriangle(Graphics2D g){
            Point2D p1 = new Point2D.Double(100,100);
            Point2D p2 = new Point2D.Double(200, 100);
            Point2D p3 = new Point2D.Double(150, 200);

            Line2D l1 = new Line2D.Double(p1,p2);
            Line2D l2 = new Line2D.Double(p2,p3);
            Line2D l3 = new Line2D.Double(p1,p3);

            g.draw(l1);
            g.draw(l2);
            g.draw(l3);

        }
        static void printRectangle ( double x, double y, double width, double high, Graphics2D g2){
            Rectangle2D rectangle2D = new Rectangle2D.Double(x,y,width,high);

            g2.draw(rectangle2D);
            g2.setPaint(Color.RED);
            g2.fill(rectangle2D);
        }
        static void printImage(URL url, Graphics2D g2){
            Image image = new ImageIcon(url).getImage();
            g2.drawImage(image, 300, 300, null);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setFont(font);
            printText("I love u bby", g2);
            printTriangle(g2);
            printRectangle(100, 200, 100, 50, g2);
            try {
                printImage(new URL("https://sun9-33.userapi.com/impg/N7F2KHqrjsT4soqy-10JtoGMtO4mAV86MLMQ6g/c" +
                        "Ek_sFO-cYE.jpg?size=1024x683&quality=96&sign=4589eb82e7249fc1084d64ca07a13aca&type=album"), g2);
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
        BufferedImage image = ImageIO.read(new File("C:\\Users\\wwwgl\\IdeaProjects\\train\\swing\\img\\strb.jpg"));
        frame.setIconImage(image);
        return frame;
    }
}
