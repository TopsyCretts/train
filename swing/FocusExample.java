package swing;

import javax.swing.*;
import java.io.IOException;

public class FocusExample {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.add(new JButton("1"));
        jPanel.add(new JButton("2")).setFocusable(false);
        jPanel.add(new JButton("3")).requestFocus();
    }
}
