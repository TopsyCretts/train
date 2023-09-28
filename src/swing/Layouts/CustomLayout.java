package swing.Layouts;

import swing.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CustomLayout {
    public static void main(String[] args) throws IOException {
        JFrame frame = MyFrame.getFrame();
        JPanel jPanel = new JPanel();
        frame.add(jPanel);
        jPanel.add(new JButton("1"));
        jPanel.add(new JButton("2"));
        jPanel.add(new JButton("3"));
        jPanel.setLayout(new MyLayout());
        jPanel.revalidate();

    }
}
class MyLayout implements LayoutManager{
    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    @Override
    public void layoutContainer(Container parent) {
        for (int i =0; i< parent.getComponentCount(); i++){
            Component component = parent.getComponent(i);
            component.setBounds(i*100, i*40, 100, 40);
        }
    }
}
