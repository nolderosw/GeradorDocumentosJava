package gerador_documentos;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Declaracao {
	int ID_cliente;
	
	public void gerarPDF(String nome) {
		// criação do documento
        Document document = new Document();
        try {
            
            PdfWriter.getInstance(document, new FileOutputStream(Integer.toString(this.ID_cliente) +"/"+nome + ".pdf"));
            document.open();
            
            // adicionando parágrafos no documento
            document.add(new Paragraph(nome + "cliente " + this.ID_cliente));
        }
        catch(DocumentException de) {
            System.err.println(de.getMessage());
        }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        document.close();
		System.out.println("Gerada a declaracao do cliente de id" + this.ID_cliente );
	}
	public void setCliente(int ID) {
		this.ID_cliente = ID;
	}
}
