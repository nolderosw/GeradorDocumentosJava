package gerador_documentos;


import java.io.FileOutputStream;
import java.io.IOException;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
 
public class Contrato {
	int ID_cliente;
	
	public void gerarPDF(String nome, String Clausula) {
		// criação do documento
        Document document = new Document();
        try {
            
            PdfWriter.getInstance(document, new FileOutputStream(Integer.toString(this.ID_cliente) +"/"+nome + ".pdf"));
            document.open();
            
            // adicionando parágrafos no documento
            document.add(new Paragraph(nome + "cliente " + this.ID_cliente));
            document.add(new Paragraph(" Clausula personalizada " + Clausula));
        }
        catch(DocumentException de) {
            System.err.println(de.getMessage());
        }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        document.close();
		System.out.println("Gerado o contrato do cliente de id" + this.ID_cliente + "e clausula personalizada " + Clausula);
	}
	public void setCliente(int ID) {
		this.ID_cliente = ID;
	}
}
