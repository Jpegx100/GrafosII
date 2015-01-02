package visualization;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import org.apache.commons.collections15.Transformer;

public class TransformaFormaVertice implements Transformer < String ,Shape >{
	@Override
	public Shape transform(String arg0) {
		int leng = 24;
		if(arg0.length()>2) leng = arg0.length()*12;
		return new Ellipse2D.Float ( -(leng/2), -12, leng, 24);
	}
}
