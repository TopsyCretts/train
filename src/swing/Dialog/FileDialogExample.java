package swing.Dialog;

import swing.MyFrame;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

public class FileDialogExample {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        JButton jButton = new JButton("show dialog");
        jPanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setMultiSelectionEnabled(true);
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        if (f.getName().endsWith("gif")){
                            return true;
                        } else return false;
                    }

                    @Override
                    public String getDescription() {
                        return "only gif";
                    }
                });
                JTextField textField = new JTextField("write");
                fileChooser.add(textField, BorderLayout.WEST);
                fileChooser.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        textField.setText(evt.getPropertyName());
                    }
                });
                fileChooser.showDialog(jPanel, "save as");
                jButton.setText(fileChooser.getSelectedFile().getName());

            }
        });
    }
}
