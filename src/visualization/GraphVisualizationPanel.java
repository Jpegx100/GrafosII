package visualization;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphVisualizationPanel extends JPanel{
	public GraphVisualizationPanel() {  
        super();  
        setOpaque( false );  
    }  
    public void paintComponent( Graphics g ) {  
        super.paintComponent( g );  
        g.setColor( new Color( 255, 255, 255, 0));  
        g.fillRect( 0, 0, getWidth(), getHeight() );  
  
    }  
}
