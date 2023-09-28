package swing.Layouts;

import swing.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GridEx {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.setLayout(new GridLayout(2,2));
        jPanel.add(new JButton("ome"));
        jPanel.add(new JButton("two"));
        jPanel.add(new JButton("three"));
        jPanel.add(new JButton("four"));
    }
}
