package swing.Layouts;

import swing.MyFrame;

import javax.swing.*;
import java.io.IOException;

public class NoLayout {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jFrame.add(jPanel);
        JButton jButton = new JButton("submit");
        jButton.setBounds(50,50, 150,40);
        jPanel.add(jButton);
    }
}
