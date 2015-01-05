package grafos;
import java.util.ArrayList;
import java.util.Collections;


public class Vertice {
	public String inf;
	ArrayList<Vertice>arestas;
	Boolean visitado;
	int grau;
	public void profundidade(ArrayList<Vertice> pilha) {
		Collections.sort(arestas, new ComparaVertices());
		if(this.visitado==false){
			this.visitado=true;
			pilha.add(this);
			for(Vertice aux:this.arestas){
				aux.profundidade(pilha);
			}
		}
		
	}
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
	public void largura(ArrayList<Vertice> fila, ArrayList<Vertice> ajuda) {
		for(Vertice aux: this.arestas ){
			if(aux.visitado==false){
				fila.add(aux);
				aux.visitado = true;
				ajuda.add(aux);
			}
		}
		ajuda.remove(this);
		if(ajuda.size()==0)	return;
		ajuda.get(0).largura(fila,ajuda);
	}
}
