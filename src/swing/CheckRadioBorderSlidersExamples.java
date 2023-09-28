package swing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;

public class CheckRadioBorderSlidersExamples {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);

        jPanel.add(new JCheckBox("checkbox label"));

        JRadioButton b1 = new JRadioButton("one");
        b1.setSelected(true);
        JRadioButton b2 = new JRadioButton("two");

        ButtonGroup bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        jPanel.add(b1);
        jPanel.add(b2);

        Border border = BorderFactory.createEtchedBorder(Color.BLACK, Color.RED);
        Border titledBorder = BorderFactory.createTitledBorder(border, "title");

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.insertItemAt("red", 0);
        comboBox.insertItemAt("black", 1);
        comboBox.insertItemAt("blue", 2);
        comboBox.addItemListener(e -> {
            switch ((String) e.getItem()){
                case "red":
                    jPanel.setBackground(Color.red);
                    break;
                case "black":
                    jPanel.setBackground(Color.black);
                    break;
                case "blue":
                    jPanel.setBackground(Color.blue);
                    break;
            }
        });
        jPanel.add(comboBox);

        JSlider jSlider = new JSlider(0, 100, 50);
        jSlider.setMinorTickSpacing(5);
        jSlider.setMajorTickSpacing(10);
        jSlider.setPaintTicks(true);
        jSlider.setSnapToTicks(true);
        jSlider.setPaintLabels(true);
        jPanel.add(jSlider);

        jPanel.setBorder(titledBorder);


    }
}
