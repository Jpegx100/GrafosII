package grafos;

import java.util.ArrayList;

public class Grafo {
        public ArrayList<Vertice> vertices;
        public ArrayList<Vertice> pilha;
        public ArrayList<Vertice> fila;
        
        public Grafo(){
        	vertices = new ArrayList<Vertice>();
        	pilha = new ArrayList<Vertice>();
        	fila = new ArrayList<Vertice>();
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
       public void profundidade(String x){
    	   Vertice aux = pesquisa(x);
    	   if(aux!=null){
    		   aux.profundidade(pilha);
    	   } 
       }
       public String printProfundidade(String x){
    	   setNaoVisitado();
    	   profundidade(x);
    	   String s="";
    	   for(Vertice aux:pilha){
    		   s+=aux.inf+" - ";
    	   }
    	   pilha = new ArrayList<Vertice>();
    	   return s;
       }
       public Vertice algumNaoVisitado(Vertice c){
    	   for(Vertice aux:c.arestas){
    		   if(!aux.visitado) return aux;
    	   }
    	   return null;
       }
}
