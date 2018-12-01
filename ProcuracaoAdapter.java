package gerador_documentos;

public class ProcuracaoAdapter extends Procuracao implements Documento{

	@Override
	public void gerarPDF(String nome, String clausula_personalizada, int cliente) {
		setCliente(cliente);
		gerarPDF(nome);
		
	}

}
