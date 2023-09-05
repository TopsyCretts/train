package swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.io.IOException;

public class EventHandlerExample {
    public static void main(String[] args) throws IOException {
        JFrame frame = MyFrame.getFrame();
        JPanel jPanel = new JPanel();
        frame.add(jPanel);
        JButton jButton = new JButton("testApp");
        jPanel.add(jButton);
        /*jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setTitle(((JButton)e.getSource()).getText());
            }
        });*/
        jButton.addActionListener(EventHandler.create(ActionListener.class, frame, "title", "source.text"));
    }
}
