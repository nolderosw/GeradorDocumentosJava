package gerador_documentos;

import java.io.File;

import javax.swing.JOptionPane;

public class SistemaFacade {
	
	public ArquivoComponent criarDocumento(String nome, int cliente, String clausula, String tipo, ArquivoComponent pastaCliente) {
		FlyweightFactory factory = FlyweightFactory.get_instancia(); //singleton
		
		factory.getFlyweight(tipo).gerarDocumento(cliente, clausula, tipo);
		
		ArquivoComponent documento = new PDF(tipo);
		
		//composite
		
		try {
			pastaCliente.adicionar(documento);
		 }
		 catch (Exception e) {
			 System.out.println(e.getMessage());
		 }
		return documento;
	}
	public ArquivoComponent criarPastaCliente(int cliente) {
		try {
            File diretorio = new File(Integer.toString(cliente));
            diretorio.mkdir();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio do cliente " + cliente);
            System.out.println(ex);
        }
		return new ArquivoComposite(Integer.toString(cliente));
	}
	
	public void pesquisarDocumento (ArquivoComponent pasta, ArquivoComponent documento) {
		try {
	        documento = pasta.getArquivo(documento.getNomeDoArquivo());
	        System.out.println("\nArquivo " + documento.getNomeDoArquivo()+" do cliente" + pasta.getNomeDoArquivo() +" encontrado com sucesso!" );
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void removerDocumento (ArquivoComponent pasta, ArquivoComponent documento) {
		try {
	        pasta.remover(documento.getNomeDoArquivo());
	        try {
	            File file = new File(pasta.getNomeDoArquivo()+"/"+documento.getNomeDoArquivo()+".pdf");
	            file.delete();
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, "Erro ao deletar arquivo");
	            System.out.println(ex);
	        }
	        System.out.println("\nArquivo " + documento.getNomeDoArquivo() +  " do cliente" + pasta.getNomeDoArquivo() + " removido com sucesso da pasta!");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
