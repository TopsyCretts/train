package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuExamples {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);

        JMenuBar jMenuBar = new JMenuBar(); //JMenuBar example

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        jMenuBar.add(file);
        jMenuBar.add(edit);

        file.add(new JMenuItem("Open", 'O'));
        JMenuItem save = file.add(new JMenuItem("Save"));
        save.setEnabled(false);
        file.addSeparator();

        JMenuItem exit = file.add(new JMenuItem("Exit"));
        exit.addActionListener(e -> System.exit(0));
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

        JPopupMenu jPopupMenu = new JPopupMenu(); // JPopupMenu example
        jPopupMenu.add(new JMenuItem("one"));
        jPopupMenu.add(new JMenuItem("two"));
        jPopupMenu.add(new JMenuItem("three"));
        jPanel.setComponentPopupMenu(jPopupMenu);



        jFrame.setJMenuBar(jMenuBar);
        jFrame.revalidate();

        JToolBar jToolBar = new JToolBar("ToolBar");
        JButton jButton1 = new JButton("one");
        jButton1.setToolTipText("1st");
        JButton jButton2 = new JButton("two");
        JButton jButton3 = new JButton("three");
        jToolBar.add(jButton1);
        jToolBar.add(jButton2);
        jToolBar.addSeparator();
        jToolBar.add(jButton3);
        jPanel.add(jToolBar);

    }
}
