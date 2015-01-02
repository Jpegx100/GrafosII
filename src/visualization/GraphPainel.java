package visualization;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphPainel extends JPanel{
	private ImageIcon fundo = new ImageIcon(getClass().getResource("fundol.jpg"));
	@Override  
	protected void paintComponent(Graphics g) {  
	    super.paintComponent(g);  
	    Graphics2D g2d = (Graphics2D) g.create();  
	    g2d.drawImage(fundo.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);  
	    g2d.dispose();  
	}  
}
