package swing.Dialog;

import swing.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ColorDialog {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        JPanel jPanel = new JPanel();
        JButton jButton = new JButton("open dialog color");
        jFrame.add(jPanel);
        jPanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(jPanel, "title", Color.BLACK);
                jPanel.setBackground(color);
            }
        });
        jPanel.revalidate();
    }
}
