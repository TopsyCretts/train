package awt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SystemTrayExample {
    public static void main(String[] args) throws AWTException {
        if (SystemTray.isSupported()){
            SystemTray systemTray = SystemTray.getSystemTray();
            Image image = new ImageIcon("swing\\img\\strb.png", "desc").getImage();
            PopupMenu popupMenu = new PopupMenu();
            MenuItem menuItem = new MenuItem("one");
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("one");
                }
            });
            popupMenu.add(menuItem);
            popupMenu.add(new MenuItem("two"));
            popupMenu.add(new MenuItem("three"));
            systemTray.add(new TrayIcon(image, "tray desc", popupMenu));

        }
    }
}
