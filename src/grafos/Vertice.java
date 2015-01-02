package grafos;
import java.util.ArrayList;


public class Vertice {
	public String inf;
	ArrayList<Vertice>arestas;
	Boolean visitado;
	int grau;
	public Vertice(String x){
		arestas  = new ArrayList<Vertice>();
		this.inf = x;
		visitado = false;
	}
	public void adicionaAresta(Vertice x){
		if(pesquisa(x.inf)==null){
			arestas.add(x);
		}
	}
	public Vertice pesquisa(String x){
		for(Vertice aux:arestas){
			if(aux.inf.equals(x)){
				return aux;
			}
		}
		return null;
	}
	public String printArestas(){
		String ar="";
		for(Vertice aux:arestas){
			ar+=aux.inf+";";
		}
		return ar;
	}
	public String profundidade(String larg){
			String r = this.inf+" - ";
			this.visitado=true;
			for(Vertice aux:this.arestas){
				 if(!aux.visitado){
					 r+= aux.profundidade(r);	 
				 }
			}
		return larg+r;	
	}
}
