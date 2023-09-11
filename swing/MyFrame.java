package swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyFrame {
    static String name = "Example";
    static int height = 500;
    static int width = 500;
    public static JFrame getFrame() throws IOException {
        JFrame frame = new JFrame(name);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds((dimension.width - width) / 2, (dimension.height - height) / 2, width, height);
        return frame;
    }
}
