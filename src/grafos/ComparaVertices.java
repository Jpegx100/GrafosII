package grafos;

import java.util.Comparator;

public class ComparaVertices implements Comparator<Vertice> {
	@Override
	public int compare(Vertice arg0, Vertice arg1) {
		return arg0.inf.compareTo(arg1.inf);
	}
}
