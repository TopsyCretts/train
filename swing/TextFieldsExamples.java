package swing;

import javax.swing.*;
import java.io.IOException;

public class TextFieldsExamples {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.add(new JLabel("search"));
        jPanel.add(new JTextField("pornHub", 10));
        jPanel.add(new JPasswordField(10));
        JTextArea area = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(area);
        area.setLineWrap(true);
        jPanel.add(scrollPane);
        jPanel.revalidate();
    }
}
