package awt.testApps;

import swing.MyFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class TransparencyExamples {
    public static void main(String[] args) throws IOException {

        JFrame jFrame = MyFrame.getFrame();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jFrame.add(jPanel);

        JPanel comboPanel = new JPanel();
        AlphaComposite[] rules = getCompRules();
        Border border = BorderFactory.createTitledBorder("Choose mode");
        comboPanel.setBorder(border);
        JComboBox<String> boxRules = getComboBoxRules(rules);
        MyComponent myComponent = new MyComponent();
        boxRules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myComponent.setCurrentMode(AlphaComposite.getInstance(boxRules.getSelectedIndex()));
            }
        });
        comboPanel.add(boxRules).setLocation(20,20);
        comboPanel.setSize(200,100);
        jPanel.add(comboPanel);

        JPanel shapesPanel = new JPanel();
        shapesPanel.setBounds(0,120,350,300);
        shapesPanel.setBorder(BorderFactory.createTitledBorder("Shapes"));
        shapesPanel.add(myComponent);

        jPanel.add(shapesPanel);
        jPanel.revalidate();

    }

    private static AlphaComposite[] getCompRules(){
        AlphaComposite[] rules = new AlphaComposite[12];
        for (int i = 0; i < 10; i++ ){
            rules[i] = AlphaComposite.getInstance(i+1);
        }
        return rules;
    }

    private static JComboBox<String> getComboBoxRules (AlphaComposite[] rules){
        JComboBox<String> result = new JComboBox<>();
        for (int i = 0; i < 12; i++ ){
            result.addItem(getRule(i+1));
        }
        return result;
    }
    private static String getRule(int number) {
        switch (number) {
            case 1:
                return "1-Clear";
            case 2:
                return "2-Src";
            case 3:
                return "3-Dst";
            case 4:
                return "4-SrcOver";
            case 5:
                return "5-DstOver";
            case 6:
                return "6-SrcIn";
            case 7:
                return "7-DstIn";
            case 8:
                return "8-SrcOut";
            case 9:
                return "9-DstOut";
            case 10:
                return "10-SrcAtop";
            case 11:
                return "11-DstAtop";
            case 12:
                return "12-Xor";
            default:
                throw new IllegalArgumentException("unknown composite rule");
        }
    }
    static class MyComponent extends JComponent{
        public void setCurrentMode(AlphaComposite currentMode) {
            this.currentMode = currentMode;
        }

        AlphaComposite currentMode;
        @Override
        protected void printComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Rectangle2D rectangle2D = new Rectangle2D.Double(10,130,50,20);
            Ellipse2D ellipse2D = new Ellipse2D.Double(25,150,300,20);

            g2.draw(rectangle2D);
            g2.draw(ellipse2D);
        }
    }
}

