package swing.Dialog;

import swing.MyFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DialogsExamples {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        JButton jButton = new JButton("message");
        jPanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jPanel, "message dialog", "title", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton jButton2 = new JButton("confirm");
        jPanel.add(jButton2);
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(jPanel, "confirm dialog", "confirm title", JOptionPane.YES_NO_CANCEL_OPTION);
            }
        });

        JButton jButton3 = new JButton("input");
        jPanel.add(jButton3);
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog(jPanel, "input dialog", "input title",JOptionPane.WARNING_MESSAGE);
            }
        });

        JButton jButton4 = new JButton("message");
        jPanel.add(jButton4);
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showOptionDialog(jPanel, "option dialog","option title",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,  new Object[]{"one", "two", "three"}, null);
            }
        });
    }
}
