package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class ActionsAndKeyStrokeExample {
    static JFrame frame;
    static JPanel jPanel;

    static {
        try {
            frame = MyFrame.getFrame();
            jPanel = new JPanel();
            frame.add(jPanel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        JButton jButton = new JButton(new MyAction());
        jButton.setText("submit");
        jPanel.add(jButton);

        KeyStroke keyStroke = KeyStroke.getKeyStroke("ctrl B");
        InputMap inputMap = jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(keyStroke, "change color");
        ActionMap actionMap = jPanel.getActionMap();
        actionMap.put("change color", new MyAction());

    }
    static class MyAction extends AbstractAction{
        public MyAction() {
            putValue(Action.SHORT_DESCRIPTION, "just button");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            jPanel.setBackground(Color.black);
        }
    }
}
