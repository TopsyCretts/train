package awt;

import swing.MyFrame;

import javax.swing.*;
import java.io.IOException;

public class DragAndDrop {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        JTextField jTextField = new JTextField(10);
        JTextField jTextField2 = new JTextField(10);
        jTextField.setDragEnabled(true);
        jTextField2.setDragEnabled(true);
        jPanel.add(jTextField);
        jPanel.add(jTextField2);
        jPanel.revalidate();
    }
}
