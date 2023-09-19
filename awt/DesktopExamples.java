package awt;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class DesktopExamples {
    public static void main(String[] args) throws URISyntaxException, IOException {
        if (Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)){
                desktop.browse(new URI("https://google.com"));
            }
        }

    }
}
