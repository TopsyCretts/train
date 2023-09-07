package swing.actionsExamples;

import swing.MyFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class LookAndFeelExample {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        /*UIManager.LookAndFeelInfo[] lookAndFeelInfos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : lookAndFeelInfos){
            System.out.println(info.getName());
            System.out.println(info.getClassName());
        }*/
        JButton metal = new JButton("Metal");
        JButton nimbus = new JButton("Nimbus");
        JButton motif = new JButton("Motif");
        JButton windows = new JButton("Windows");

        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);

        jPanel.add(metal);
        jPanel.add(nimbus);
        jPanel.add(motif);
        jPanel.add(windows);

        metal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        nimbus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        motif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        windows.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }
}
