package grafos;

import java.util.ArrayList;

public class Grafo {
        public ArrayList<Vertice> vertices;
        
        public Grafo(){
        	vertices = new ArrayList<Vertice>();
        }
        public void adiciona(String x){
        	if(this.pesquisa(x)==null){
        		vertices.add(new Vertice(x));
        	}
        }
        public void adicionaAresta(String pai,String filho){
        	Vertice filhoo = this.pesquisa(filho);
        	Vertice paii = this.pesquisa(pai);
        	if(paii==null) adiciona(pai);
        	if(filhoo==null) adiciona(filho);
        		paii.adicionaAresta(filhoo);
        }
       public Vertice pesquisa(String x){
    	   for(Vertice aux:vertices){
    		   if(aux.inf.equals(x)){
    			   return aux;
    		   }
    	   }
    	   return null;
       }
       public String printGrafo(){
    	   String s="";
    	   for(Vertice aux:vertices){
    		   s+=aux.inf+"-"+aux.printArestas()+"\r\n";
    	   }
    	   return s;
       }
       public void setNaoVisitado(){
    	   for(Vertice aux:vertices){
    			   aux.visitado=false;
    	   }
       }
       public String profundidade(String init){
    	   setNaoVisitado();
    	   if(pesquisa(init)!=null){
    		   return "Profundidade:\n" + pesquisa(init).profundidade(""); 
    	   }
    	   return "ponto nao encontrado";
       }
       public Vertice algumNaoVisitado(Vertice c){
    	   for(Vertice aux:c.arestas){
    		   if(!aux.visitado) return aux;
    	   }
    	   return null;
       }
}
