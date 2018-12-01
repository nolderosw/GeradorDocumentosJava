package gerador_documentos;

public class Cliente {

	public static void main(String[] args) {
		SistemaFacade fachada = new SistemaFacade	();
		
		ArquivoComponent pastacliente0 = fachada.criarPastaCliente(0);
		ArquivoComponent pastacliente1 = fachada.criarPastaCliente(1);
		
		ArquivoComponent contratocliente1 = fachada.criarDocumento("contrato", 1, "clausula1", "contrato", pastacliente1);
		ArquivoComponent procuracaocliente1 = fachada.criarDocumento("procuracao", 1, "clausula1", "procuracao", pastacliente1);
		
		ArquivoComponent contratocliente0 = fachada.criarDocumento("contrato", 0, "clausula1", "contrato", pastacliente0);
		ArquivoComponent declaracaocliente0 = fachada.criarDocumento("declaracao", 0, "clausula1", "declaracao", pastacliente0);
		
		fachada.pesquisarDocumento(pastacliente0, contratocliente0);
		fachada.pesquisarDocumento(pastacliente0, declaracaocliente0);
		fachada.removerDocumento(pastacliente0, contratocliente0);
		fachada.pesquisarDocumento(pastacliente0, contratocliente0);
		fachada.pesquisarDocumento(pastacliente1, contratocliente1);
		fachada.pesquisarDocumento(pastacliente1, procuracaocliente1);
	}
}
