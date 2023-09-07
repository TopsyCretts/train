package swing.actionsExamples;

import swing.JComponentExamples.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class JPanelAndButtonExamples {

    public static void main(String[] args) throws IOException {
        JFrame jFrame = getJFrame("FirstApp", 500, 500);

        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);

        JButton jButton = new JButton("Make red");
        jPanel.add(jButton);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel.setBackground(Color.red);
            }
        };
        jButton.addActionListener(listener);


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
