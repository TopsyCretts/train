package awt.printing;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class Print2DGraphicsObjects {
    public static void main(String[] args) throws PrinterException {
        Printable printable = new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex == 0 ){
                    Graphics2D graphics2D = (Graphics2D) graphics;
                    Line2D line2D = new Line2D.Double(0,0,100,200);
                    graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                    graphics2D.draw(line2D);
                    return PAGE_EXISTS;
                }
                return NO_SUCH_PAGE;
            }
        };
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(printable);
        if (printerJob.printDialog()){
            printerJob.print();
        }
    }
}
