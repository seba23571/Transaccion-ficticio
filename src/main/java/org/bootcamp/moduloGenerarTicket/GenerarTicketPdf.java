package org.bootcamp.moduloGenerarTicket;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.*;

public class GenerarTicketPdf {

    public void generarTicketPdf(String texto){

        try {
            StringBuilder htmlString = new StringBuilder();
            htmlString.append(texto);
            OutputStream file = new FileOutputStream(new File("FacturaVenta.pdf"));
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
            InputStream is = new ByteArrayInputStream(htmlString.toString().getBytes());
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
            document.close();
            file.close();

        } catch (DocumentException | IOException   e) {
            e.printStackTrace();
        }
    }
}
