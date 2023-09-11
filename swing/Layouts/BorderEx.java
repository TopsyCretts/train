package swing.Layouts;

import swing.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BorderEx {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(new JButton("north"),BorderLayout.NORTH);
        jFrame.add(new JButton("west"),BorderLayout.WEST);
        jFrame.add(new JButton("east"),BorderLayout.EAST);
        jFrame.add(new JButton("center"),BorderLayout.CENTER);
        jFrame.add(new JButton("south"),BorderLayout.SOUTH);

    }
}
