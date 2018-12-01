package gerador_documentos;

public class ContratoAdapter extends Contrato implements Documento{

	@Override
	public void gerarPDF(String nome, String clausula_personalizada,int cliente) {
		setCliente(cliente);
		gerarPDF(nome, clausula_personalizada);
		
	}
	
}
