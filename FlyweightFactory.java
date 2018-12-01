package gerador_documentos;

import java.util.ArrayList;

public class FlyweightFactory {
	 protected ArrayList<FlyweightConcreto> flyweights;
	 
	 public static FlyweightFactory instancia;
	 
	 protected /*singleton*/ FlyweightFactory() {
	        flyweights = new ArrayList<FlyweightConcreto>();
	        flyweights.add(new FlyweightConcreto("contrato"));
	        flyweights.add(new FlyweightConcreto("declaracao"));
	        flyweights.add(new FlyweightConcreto("procuracao"));
	 }
	 public static FlyweightFactory get_instancia() { //singleton
		 if(instancia == null) {
			 instancia = new FlyweightFactory();
		 }
		 return instancia;
	 }
	 
	 public Flyweight getFlyweight (String tipo) {
		 switch (tipo) {
		 	case "contrato":
		 		return flyweights.get(0);
		 	case "declaracao":
		 		return flyweights.get(1);
		 	case "procuracao":
		 		return flyweights.get(2);
		 	default:
		 		return flyweights.get(0);
		 }
	 }
	 
}
