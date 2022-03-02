/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.util;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import sun.print.PSPrinterJob;
/**
 *
 * @author Wellington
 */
public class UtilImprimir {
    
    public static void printPanel(JPanel panel) {

        PrinterJob printJob = new PSPrinterJob();
        printJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                Paper paper = pageFormat.getPaper();

                Graphics2D graphics2D = (Graphics2D) graphics;
                graphics2D.translate(pageFormat.getImageableX() * 2, pageFormat.getImageableY() * 2);
                graphics2D.scale(0.5, 0.5);
                paper.setImageableArea(30, 35, pageFormat.getHeight(), pageFormat.getWidth());
                pageFormat.setPaper(paper);

                panel.paint(graphics2D);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean returningResult = printJob.printDialog();

        if (returningResult) {
            try {
                printJob.print();
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(null, "\nErro ao imprimir documento" + e);
            }
        }
    }

    public static void printPanel(JTabbedPane jTabbedPane1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
