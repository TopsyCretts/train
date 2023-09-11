package swing.Layouts;

import swing.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GridBagEx {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        GridBagLayout layout = new GridBagLayout();
        jPanel.setLayout(layout);

        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.weightx = 0;
        constraints1.weighty = 0;
        constraints1.gridx = 0;
        constraints1.gridy = 0;
        constraints1.gridwidth = 2;
        constraints1.gridheight = 2;
        jPanel.add(new JTextArea(4, 20), constraints1);

        /*constraints1.weightx = 0;
        constraints1.weighty = 0;
        constraints1.gridx = 2;
        constraints1.gridy = 0;
        constraints1.gridwidth = 1;
        constraints1.gridheight = 1;
        jPanel.add(new JButton("submit longName"), constraints1);*/

        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.weightx = 0;
        constraints2.weighty = 0;
        constraints2.gridx = 2;
        constraints2.gridy = 0;
        constraints2.gridwidth = 2;
        constraints2.gridheight = 1;
        jPanel.add(new JButton("submit longName"), constraints2);

        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.weightx = 0;
        constraints3.weighty = 0;
        constraints3.gridx = 2;
        constraints3.gridy = 1;
        constraints3.gridwidth = 1;
        constraints3.gridheight = 1;
        jPanel.add(new JButton("submit"), constraints3);

        GridBagConstraints constraints4 = new GridBagConstraints();
        constraints4.weightx = 0;
        constraints4.weighty = 0;
        constraints4.gridx = 3;
        constraints4.gridy = 1;
        constraints4.gridwidth = 1;
        constraints4.gridheight = 1;
        jPanel.add(new JButton("submit 2"), constraints4);

        jPanel.revalidate();



    }
}
