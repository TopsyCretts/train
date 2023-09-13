package swing.Dialog;

import swing.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CustomDialog {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        JButton jButton = new JButton("show dialog");
        jPanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyDialog myDialog = new MyDialog(jFrame, "dialog title", true);
                myDialog.setVisible(true);
            }
        });

    }
    static class MyDialog extends JDialog{
        public MyDialog(Frame owner, String title, boolean modal) {
            super(owner, title, modal);
            add(new JButton("button"),BorderLayout.NORTH);
            add(new JTextField("field"), BorderLayout.SOUTH);
            setBounds(100, 100, 200, 100);

        }
    }

}

