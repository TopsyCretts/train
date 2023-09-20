package differents.debugging.swingDebugging;

import swing.MyFrame;

import javax.swing.*;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        JButton jButton = new JButton("submit");
        jPanel.add(jButton);

    }
}
