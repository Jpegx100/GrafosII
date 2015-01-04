package visualization;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

import java.awt.Color;

import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.FlowLayout;

import edu.uci.ics.jung.algorithms.layout.AbstractLayout;
import edu.uci.ics.jung.algorithms.layout.ISOMLayout;

@SuppressWarnings("serial")
public class JFrameEncaminhamentos extends JFrame {

	private JPanel panel;
	private JPanel panel_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEncaminhamentos frame = new JFrameEncaminhamentos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Dimension getPanelSize(){
		return panel.getSize();
	}
	public BasicVisualizationServer<String, String> geraBSFundoTransparente(AbstractLayout<String, String> lay){
		Dimension d = new Dimension( (panel.getSize().width-panel.getSize().width/15), (panel.getSize().height-panel.getSize().height/10) );;
		lay.setSize(d);
		BSFundoTransparente comp = new BSFundoTransparente(lay);
		comp.setPreferredSize(d);
		 comp.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<String>());
		 comp.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);	
		 comp.getRenderContext().setVertexShapeTransformer( new TransformaFormaVertice());
		 comp.getRenderContext().setVertexFillPaintTransformer(new TransformaCorVertice());
		return comp;
	}
	public BasicVisualizationServer<String, String> geraGraphISOM(DirectedSparseGraph<String, String> grafo){		
		ISOMLayout<String, String> lay = new ISOMLayout<String, String>(grafo);
		return geraBSFundoTransparente(lay);
	}
	
	public JFrameEncaminhamentos(String prof, String larg){
		definirEvent();
		DirectedSparseGraph<String, String> grafoProf = new DirectedSparseGraph<String, String>();
		DirectedSparseGraph<String, String> grafoLarg = new DirectedSparseGraph<String, String>();
		String[] vp = prof.split(" - ");
		String[] vl = larg.split(" - ");
		for(int i=0 ; i<(vp.length-1) ; i++){
			grafoProf.addEdge(vp[i]+vp[i+1], vp[i], vp[i+1]);
		}
		for(int i=0 ; i<(vl.length-1) ; i++){
			grafoLarg.addEdge(vl[i]+vl[i+1], vl[i], vl[i+1]);
		}
		panel.removeAll();
		panel.add(geraGraphISOM(grafoProf));
		panel.revalidate();
		panel.updateUI();
		panel.setBackground(Color.WHITE);
		
		panel_1.removeAll();
		panel_1.add(geraGraphISOM(grafoLarg));
		panel_1.revalidate();
		panel_1.updateUI();
		panel_1.setBackground(Color.WHITE);
		setVisible(true);
	}
	
	public JFrameEncaminhamentos() {
		definirEvent();
	}
	public void definirEvent(){
		setResizable(false);
		setTitle("Encaminhamentos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 886, 572);
		
		panel = new JPanel();
		panel.setToolTipText("");
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Profundidade", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel.setBackground(new Color(245, 245, 245));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel_1.setOpaque(false);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Largura", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		GraphPainel graphPainel = new GraphPainel();
		graphPainel.add(panel);
		graphPainel.add(panel_1);
		setContentPane(graphPainel);
		GroupLayout gl_graphPainel = new GroupLayout(graphPainel);
		gl_graphPainel.setHorizontalGroup(
			gl_graphPainel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_graphPainel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_graphPainel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_graphPainel.setVerticalGroup(
			gl_graphPainel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_graphPainel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		graphPainel.setLayout(gl_graphPainel);
	}
	
	public JFrameEncaminhamentos(BasicVisualizationServer<String, String> bp, BasicVisualizationServer<String, String> bl){
		definirEvent();
		panel.removeAll();
		panel.add(bp);
		panel.revalidate();
		panel.updateUI();
		panel.setBackground(Color.WHITE);
		panel_1.removeAll();
		panel_1.add(bl);
		panel_1.revalidate();
		panel_1.updateUI();
		panel_1.setBackground(Color.WHITE);
	}
}
