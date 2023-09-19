package awt;

import swing.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SplashScreenExample {
    public static void main(String[] args) throws InterruptedException, IOException {
        SplashScreen splash = SplashScreen.getSplashScreen();
    /*    Rectangle bounds = splash.getBounds();
        Graphics2D g2 = splash.createGraphics();
        g2.setColor(Color.WHITE);
        for (int i = 0; i < 100; i++) {
            g2.fillRect(0,0,bounds.width * i/100,20);
            splash.update();
            Thread.sleep(50);
        }*/
        final Image image = new ImageIcon(splash.getImageURL()).getImage();
        final JFrame jFrame = new JFrame();
        final JPanel jPanel = new JPanel();
        jPanel.add(new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(image, 0,0, null);
            }
        });
        final JProgressBar jProgressBar = new JProgressBar();
        jProgressBar.setStringPainted(true);
        jPanel.setLayout(new BorderLayout());
        jPanel.add(jProgressBar,BorderLayout.NORTH);
        jFrame.add(jPanel);
        jFrame.setBounds(splash.getBounds());
        jFrame.setVisible(true);
        try {
            for (int i = 0; i <= 100 ; i++) {
                jProgressBar.setString("Loading module " + i);
                jProgressBar.setValue(i);
                jPanel.repaint();
                Thread.sleep(50);
            }

        } catch (InterruptedException e){

        }
        jFrame.setVisible(false);

    }
}
