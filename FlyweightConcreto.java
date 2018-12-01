package gerador_documentos;

public class FlyweightConcreto extends Flyweight{
	String nome_documento;
	
	public FlyweightConcreto(String nome) {
		this.nome_documento = nome;
	}
	
	@Override
	public void gerarDocumento(int cliente, String clausula, String tipo) {
		Documento doc = new ContratoAdapter();
		switch (tipo) {
			case "contrato":
				break;
			case "declaracao":
				doc = new DeclaracaoAdapter();
				break;
			case "procuracao":
				doc = new ProcuracaoAdapter();
				break;
		
		}
		doc.gerarPDF(this.nome_documento, clausula, cliente);
		
	}

}
