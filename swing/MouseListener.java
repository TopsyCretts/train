package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MouseListener {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = MyFrame.getFrame();

        MyComponent myComponent = new MyComponent();
        jFrame.add(myComponent);

        /*jPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jPanel.setBackground(Color.black);
            }
        });*/
        jFrame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                myComponent.y = e.getY();
                myComponent.x = e.getX();
                myComponent.repaint();
            }
        });

    }
}
class MyComponent extends JComponent{
    int x;
    int y;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D)g).drawString("Cord x:"+x+" y:"+y, 50,50);
    }
}
