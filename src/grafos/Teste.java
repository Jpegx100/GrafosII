package grafos;

public class Teste {
	public void testaCasoIrva(){
		Grafo g = new Grafo();
		g.adiciona("a");
		g.adiciona("b");
		g.adiciona("c");
		g.adiciona("d");
		g.adiciona("e");
		g.adiciona("f");
		g.adiciona("g");
		g.adicionaAresta("a", "b");
		g.adicionaAresta("a", "c");
		g.adicionaAresta("b", "a");
		g.adicionaAresta("b", "c");
		g.adicionaAresta("b", "e");
		g.adicionaAresta("c", "a");
		g.adicionaAresta("c", "b");
		g.adicionaAresta("c", "d");
		g.adicionaAresta("d", "c");
		g.adicionaAresta("d", "e");
		g.adicionaAresta("d", "f");
		g.adicionaAresta("d", "g");
		g.adicionaAresta("e", "b");
		g.adicionaAresta("e", "d");
		g.adicionaAresta("f", "d");
		g.adicionaAresta("f", "g");
		g.adicionaAresta("g", "d");
		g.adicionaAresta("g", "f");
		g.setNaoVisitado();
		g.profundidade("a");
		
		for(Vertice aux:g.pilha){
			System.out.println(aux.inf);
		}
		System.out.println("---------");
		g.setNaoVisitado();
		g.largura("a");
		
			
		
		
	}
	public void testaPesquisa(){
		Grafo g = new Grafo();
		g.adiciona("A");
		g.adiciona("X");
		g.adiciona("W");
		g.adiciona("B");
		//Assert.assertEquals("B", g.pesquisa("B").inf);
	}
	public void testePrint(){
		Grafo g = new Grafo();
		g.adiciona("A");
		g.adiciona("X");
		g.adiciona("W");
		g.adiciona("B");
		g.adicionaAresta("A", "X");
		g.adicionaAresta("X", "W");
		g.adicionaAresta("X", "A");
		g.adicionaAresta("X", "B");
		g.adicionaAresta("B", "B");
		//System.out.println(g.printGrafo());
	}
	
	
	
}
