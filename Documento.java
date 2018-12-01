package gerador_documentos;

public interface Documento {
	void gerarPDF(String nome, String clausula_personalizada,int cliente);
	
}
