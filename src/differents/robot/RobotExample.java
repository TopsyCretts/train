package differents.robot;

import swing.MyFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RobotExample {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        JButton jButton = new JButton("add 1");
        jPanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setTitle(jFrame.getTitle()+"1");
            }
        });
        JButton jButton1 = new JButton("go to 1st button");
        jPanel.add(jButton1);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();
                try {
                    Robot robot = new Robot(graphicsDevice);
                    robot.mouseMove(jFrame.getX()+jButton.getX()+25, jFrame.getY()+jButton.getY()+40);
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_TAB);

                    Rectangle rectangle = new Rectangle(0,0,1000,1000);
                    BufferedImage image = robot.createScreenCapture(rectangle);
                    ImageIO.write(image, "png", new File("differents\\robot\\screen.png"));
                } catch (AWTException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        jPanel.revalidate();

    }
}
