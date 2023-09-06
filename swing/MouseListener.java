package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MouseListener {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jPanel.setBackground(Color.black);
            }
        });
    }
}
