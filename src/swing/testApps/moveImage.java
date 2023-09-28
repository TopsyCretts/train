package swing.testApps;

import swing.MyFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class moveImage {
    public static void main(String[] args) throws IOException {
        JFrame frame = MyFrame.getFrame();
        File imageFile = new File("swing\\img\\strb.jpg");
        BufferedImage image = ImageIO.read(imageFile);
        MyComponent myComponent = new MyComponent(image);
        frame.add(myComponent);

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                    myComponent.x = e.getX();
                    myComponent.y = e.getY();
                    myComponent.repaint();
            }
        });

    }
}
class MyComponent extends JComponent{
    int x;
    int y;
    BufferedImage image;

    public MyComponent(BufferedImage image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, x, y, null);
    }
}
