package visualization;

import java.awt.Color;
import java.awt.Graphics;

import edu.uci.ics.jung.algorithms.layout.AbstractLayout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;

@SuppressWarnings("serial")
public class BSFundoTransparente extends BasicVisualizationServer<String, String>{
	public BSFundoTransparente(AbstractLayout<String, String> a) {  
        super(a);  
        setOpaque( false ); 
        setBackground(new Color(255, 255, 255, 0));
    }  
    public void paintComponent( Graphics g ) {  
        super.paintComponent( g );  
        g.setColor( new Color( 255, 255, 255, 0));  
        g.fillRect( 0, 0, getWidth(), getHeight() );  
  
    }  
}
