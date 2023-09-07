package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuExamples {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();

        JMenuBar jMenuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        jMenuBar.add(file);
        jMenuBar.add(edit);

        file.add(new JMenuItem("Open", 'O'));
        JMenuItem save = file.add(new JMenuItem("Save"));
        save.setEnabled(false);
        file.addSeparator();

        JMenuItem exit = file.add(new JMenuItem("Exit"));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exit.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));



        edit.add(new JMenuItem("Cut"));
        edit.add(new JMenuItem("Copy"));

        JMenu options = new JMenu("Options");
        edit.add(options);
        options.add(new JMenuItem("one"));
        options.add(new JMenuItem("two"));

        edit.add(new JCheckBoxMenuItem("check"));

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButtonMenuItem radioButton1 = new JRadioButtonMenuItem("radio1");
        JRadioButtonMenuItem radioButton2 = new JRadioButtonMenuItem("radio2");
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        edit.add(radioButton1);
        edit.add(radioButton2);


        jFrame.setJMenuBar(jMenuBar);
        jFrame.revalidate();
    }
}
