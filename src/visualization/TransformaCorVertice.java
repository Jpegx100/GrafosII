package visualization;
import java.awt.*;

import org.apache.commons.collections15.Transformer;

public class TransformaCorVertice implements Transformer < String ,Paint >{
	@Override
	public Paint transform(String arg0) {
		if(arg0.toLowerCase().contains("a") || arg0.toLowerCase().contains("i")) return new Color(255, 153, 51);
		if(arg0.toLowerCase().contains("b") || arg0.toLowerCase().contains("j")) return new Color(102, 153, 255);
		if(arg0.toLowerCase().contains("c") || arg0.toLowerCase().contains("l")) return new Color(230, 230, 230);
		if(arg0.toLowerCase().contains("d") || arg0.toLowerCase().contains("m")) return new Color(255, 255, 103);
		if(arg0.toLowerCase().contains("e") || arg0.toLowerCase().contains("n")) return new Color(255, 204, 204);
		if(arg0.toLowerCase().contains("f") || arg0.toLowerCase().contains("o")) return new Color(255, 153, 255);
		if(arg0.toLowerCase().contains("g") || arg0.toLowerCase().contains("p")) return new Color(204, 204, 255);
		if(arg0.toLowerCase().contains("h") || arg0.toLowerCase().contains("q")) return new Color(153, 255, 0);
		
		if(arg0.toLowerCase().contains("r") || arg0.toLowerCase().contains("v")) return new Color(206, 235, 216);
		if(arg0.toLowerCase().contains("s") || arg0.toLowerCase().contains("x")) return new Color(196, 186, 245);
		if(arg0.toLowerCase().contains("t") || arg0.toLowerCase().contains("z")) return new Color(231, 186, 245);
		if(arg0.toLowerCase().contains("u") || arg0.toLowerCase().contains("0")) return new Color(210, 245, 186);
		
		if(arg0.toLowerCase().contains("1") || arg0.toLowerCase().contains("5")) return new Color(231, 186, 245);
		if(arg0.toLowerCase().contains("2") || arg0.toLowerCase().contains("6")) return new Color(210, 245, 186);
		if(arg0.toLowerCase().contains("3") || arg0.toLowerCase().contains("7")) return new Color(231, 186, 245);
		if(arg0.toLowerCase().contains("4") || arg0.toLowerCase().contains("8")) return new Color(210, 245, 186);
		return new Color(204, 255, 102);
	}
}
