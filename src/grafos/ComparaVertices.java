package grafos;

import java.util.Comparator;

public class ComparaVertices implements Comparator<Vertice> {
	@Override
	public int compare(Vertice arg0, Vertice arg1) {
		if(Integer.parseInt(arg0.inf)>Integer.parseInt(arg1.inf))
			return 1;
		if(Integer.parseInt(arg0.inf)<Integer.parseInt(arg1.inf))
			return -1;
		return 0;
	}
}
