package visualization;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import edu.uci.ics.jung.algorithms.layout.*;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import grafos.Grafo;

import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;

import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;

import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

import java.awt.FlowLayout;

@SuppressWarnings("unused")
public class GrafosGUI {
	String maisImpot="";
	JRadioButton rbCircleLayout;
	JRadioButton rbFRLayout;
	JRadioButton rbFRLayout2;
	JRadioButton rbISOMLayout;
	JRadioButton rbKKLayout;
	JRadioButton rbSpringLayout;
	ButtonGroup btGroup;
	Grafo g;
	private JFrame frame;
	DirectedSparseGraph<String, String> grafoGUI;
	JPanel panel;
	private JPanel panel_2;
	JPanel panel_1;
	private JPanel panel_3;
	private JButton btnEncaminhamentos;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GrafosGUI window = new GrafosGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GrafosGUI() {
		initialize();
	}
	
	private void initialize() {
		panel = new JPanel();
		panel_1 = new JPanel();
		panel.setOpaque(false);
		panel_1.setOpaque(false);
		panel_1.setBackground(new Color(255, 255, 255, 150));
		panel.setBackground(new Color(255, 255, 255, 150));
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(GrafosGUI.class.getResource("/imgs/logoGraph.png")));
		frame.setContentPane(new GraphPainel());
		frame.getContentPane().setBackground(new Color(245, 245, 245));
		frame.setBackground(Color.RED);
		frame.setBounds(200, 50, 900, 642);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

	    panel_2 = new JPanel();
	    panel_2.setBackground(new Color(245, 245, 245));
	    panel_2.setOpaque(false);
	    panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Menu", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBackground(new Color(245, 245, 245));
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Visualiza\u00E7\u00E3o do Grafo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		
		JPanel panel_4 = new JPanel();
		panel_4.setToolTipText("Pricipais informa\u00E7\u00F5es a \r\nrespeito do grafo, assim \r\ncomo o encaminhamento \r\na partir do vertice escolhido.");
		panel_4.setOpaque(false);
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Informa\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel_4.setBackground(new Color(245, 245, 245));
		
		JPanel panel_5 = new JPanel();
		panel_5.setToolTipText("Escolhendo entre os tipos de visualiza\u00E7\u00E3o dispon\u00EDveis \r\npara seu grafo voc\u00EA garante a interpreta\u00E7\u00E3o correta dos \r\ndados apresentados, sejam eles de quaisquer natureza.");
		panel_5.setOpaque(false);
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Tipo de Visualiza\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel_5.setBackground(new Color(245, 245, 245));
		
		rbCircleLayout = new JRadioButton("CircleLayout");
		rbFRLayout = new JRadioButton("FRLayout");
		rbFRLayout2 = new JRadioButton("FRLayout2");
		rbISOMLayout = new JRadioButton("ISOMLayout");
		rbKKLayout = new JRadioButton("KKLayout");
		rbSpringLayout = new JRadioButton("SpringLayout");
		btGroup = new ButtonGroup();
		
		rbCircleLayout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(grafoGUI!=null){
					panel_3.removeAll();
					panel_3.add(geraGraphCircle(grafoGUI));
					panel_3.revalidate();
			        panel_3.updateUI();
			        panel_3.setOpaque(true);
			        panel_3.setBackground(Color.WHITE);
				}
			}
		});
		rbFRLayout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(grafoGUI!=null){
					panel_3.removeAll();
					panel_3.add(geraGraphFR(grafoGUI));
					panel_3.revalidate();
		        	panel_3.updateUI();
		        	panel_3.setOpaque(true);
		        	panel_3.setBackground(Color.WHITE);
				}
			}
		});
		rbFRLayout2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(grafoGUI!=null){
					panel_3.removeAll();
					panel_3.add(geraGraphFR2(grafoGUI));
					panel_3.revalidate();
		        	panel_3.updateUI();
		        	panel_3.setOpaque(true);
		        	panel_3.setBackground(Color.WHITE);
				}
			}
		});
		rbISOMLayout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(grafoGUI!=null){
					panel_3.removeAll();
					panel_3.add(geraGraphISOM(grafoGUI));
					panel_3.revalidate();
		        	panel_3.updateUI();
		        	panel_3.setOpaque(true);
		        	panel_3.setBackground(Color.WHITE);
				}
			}
		});
		rbKKLayout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(grafoGUI!=null){
					panel_3.removeAll();
					panel_3.add(geraGraphKk(grafoGUI));
					panel_3.revalidate();
		        	panel_3.updateUI();
		        	panel_3.setOpaque(true);
		        	panel_3.setBackground(Color.WHITE);
				}
			}
		});
		rbSpringLayout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(grafoGUI!=null){
					panel_3.removeAll();
					panel_3.add(geraGraphSpring(grafoGUI));
					panel_3.revalidate();
		        	panel_3.updateUI();
		        	panel_3.setOpaque(true);
		        	panel_3.setBackground(Color.WHITE);
				}
			}
		});
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		rbCircleLayout.setBackground(Color.WHITE);
		panel_5.add(rbCircleLayout);
		rbFRLayout.setBackground(Color.WHITE);
		panel_5.add(rbFRLayout);
		rbFRLayout2.setBackground(Color.WHITE);
		panel_5.add(rbFRLayout2);
		rbISOMLayout.setBackground(Color.WHITE);
		panel_5.add(rbISOMLayout);
		rbKKLayout.setBackground(Color.WHITE);
		panel_5.add(rbKKLayout);
		rbSpringLayout.setBackground(Color.WHITE);
		panel_5.add(rbSpringLayout);
		btGroup.add(rbSpringLayout);
		btGroup.add(rbCircleLayout);
		btGroup.add(rbFRLayout);
		btGroup.add(rbFRLayout2);
		btGroup.add(rbISOMLayout);
		btGroup.add(rbKKLayout);
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 157, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 512, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		final JTextArea textArea = new JTextArea();
		textArea.setMinimumSize(new Dimension(299, 499));
		textArea.setMaximumSize(new Dimension(300, 500));
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setOpaque(false);
		panel_4.add(textArea);

		JButton btnAbrirArquivo = new JButton("");
		btnAbrirArquivo.setMnemonic('o');
		btnAbrirArquivo.setToolTipText("Abrir grafo de arquivo");
		btnAbrirArquivo.setBackground(Color.WHITE);
		btnAbrirArquivo.setIcon(new ImageIcon(GrafosGUI.class.getResource("/imgs/open131.png")));
		btnAbrirArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				int retorno = chooser.showOpenDialog(null);
				if (retorno == JFileChooser.APPROVE_OPTION) {
					panel_1.removeAll();
					g = gravarGrafo(chooser);
					g.setNaoVisitado();
					System.out.println(g.printGrafo());
					System.out.println("Numero de vertices "+ grafoGUI.getVertexCount());
				}
			}
		});
		panel_2.add(btnAbrirArquivo);
		frame.getContentPane().add(panel_3);
		frame.getContentPane().add(panel_2);
		
		btnEncaminhamentos = new JButton("");
		btnEncaminhamentos.setMnemonic('e');
		btnEncaminhamentos.setToolTipText("Exibir encaminhamentos \r\ndo grafo");
		btnEncaminhamentos.setIcon(new ImageIcon(GrafosGUI.class.getResource("/imgs/ic_action_split.png")));
		btnEncaminhamentos.setBackground(Color.WHITE);
		btnEncaminhamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(g!=null){
					String vert = JOptionPane.showInputDialog("Digite o vertice de início:");
					if(vert!=null && vert.length()>0){
						JOptionPane.showMessageDialog(null, g.profundidade(vert));
					}
				}else{
					JOptionPane.showMessageDialog(null, "Grafo ainda não gerado!");
				}
			}
		});
		panel_2.add(btnEncaminhamentos);
		frame.getContentPane().setLayout(groupLayout);
	}

	@SuppressWarnings("resource")
	public Grafo gravarGrafo(JFileChooser chooser) {
		Grafo grafo = new Grafo();
		FileReader arquivo;
		try {
			arquivo = new FileReader(chooser.getSelectedFile());
			BufferedReader lerArq = new BufferedReader(arquivo);
			ArrayList<String> todasLinhas = new ArrayList<String>();
			while (lerArq.ready()) {
				todasLinhas.add(lerArq.readLine());
			}
			String todosEmUmaLinha = "";
			for (String aux : todasLinhas) {
				todosEmUmaLinha += aux;
			}
			todosEmUmaLinha = todosEmUmaLinha.replace("-", ";");
			String[] todos = todosEmUmaLinha.split(";");
			for (String aux : todos) {
				if (grafo.pesquisa(aux) == null) {
					if (!aux.equals(""))
						grafo.adiciona(aux);
				}
			}
			grafoGUI = new DirectedSparseGraph<String, String>();
			for (String aux : todasLinhas) {
				String[] linha = aux.split("-");
				String[] arestas = linha[1].split(";");
				for (int i = 0; i < arestas.length; i++) {
					grafo.adicionaAresta(linha[0], arestas[i]);
					grafoGUI.addEdge(linha[0]+"-"+arestas[i], linha[0], arestas[i]);
				}
			}
			panel_3.removeAll();
			if(rbCircleLayout.isSelected())	panel_3.add(geraGraphCircle(grafoGUI));
			else if(rbFRLayout.isSelected())	panel_3.add(geraGraphFR(grafoGUI));
			else if(rbFRLayout2.isSelected())	panel_3.add(geraGraphFR2(grafoGUI));
			else if(rbISOMLayout.isSelected())	panel_3.add(geraGraphISOM(grafoGUI));
			else if(rbKKLayout.isSelected())	panel_3.add(geraGraphKk(grafoGUI));
			else if(rbSpringLayout.isSelected())	panel_3.add(geraGraphSpring(grafoGUI));
			else panel_3.add(geraGraphCircle(grafoGUI));
			panel_3.revalidate();
	        panel_3.updateUI();
	        panel_3.setOpaque(true);
	        panel_3.setBackground(Color.WHITE);	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return grafo;
	}
	
	public BasicVisualizationServer<String, String> geraGraphSpring2(DirectedSparseGraph<String, String> grafo){		
		SpringLayout2<String, String> lay = new SpringLayout2<String, String>(grafo);
		lay.setSize(new Dimension(650, 450));
		BasicVisualizationServer<String, String> comp = new BasicVisualizationServer<String, String>(lay);
		comp.setPreferredSize(new Dimension(650, 450));
		 comp.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<String>());
		 comp.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);	
		 comp.getRenderContext().setVertexShapeTransformer( new TransformaFormaVertice());
		 comp.setBackground(Color.WHITE);
		 comp.getRenderContext().setVertexFillPaintTransformer(new TransformaCorVertice());
		return comp;
	}
	public BasicVisualizationServer<String, String> geraGraphSpring(DirectedSparseGraph<String, String> grafo){		
		SpringLayout<String, String> lay = new SpringLayout<String, String>(grafo);
		lay.setSize(new Dimension(650, 450));
		BasicVisualizationServer<String, String> comp = new BasicVisualizationServer<String, String>(lay);
		comp.setPreferredSize(new Dimension(650, 450));
		 comp.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<String>());
		 comp.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);	
		 comp.getRenderContext().setVertexShapeTransformer( new TransformaFormaVertice());
		 comp.setBackground(Color.WHITE);
		 comp.getRenderContext().setVertexFillPaintTransformer(new TransformaCorVertice());
		return comp;
	}
	public BasicVisualizationServer<String, String> geraGraphKk(DirectedSparseGraph<String, String> grafo){		
		KKLayout<String, String> lay = new KKLayout<String, String>(grafo);
		lay.setSize(new Dimension(650, 450));
		BasicVisualizationServer<String, String> comp = new BasicVisualizationServer<String, String>(lay);
		comp.setPreferredSize(new Dimension(650, 450));
		 comp.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<String>());
		 comp.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);	
		 comp.getRenderContext().setVertexShapeTransformer( new TransformaFormaVertice());
		 comp.setBackground(Color.WHITE);
		 comp.getRenderContext().setVertexFillPaintTransformer(new TransformaCorVertice());
		return comp;
	}
	public BasicVisualizationServer<String, String> geraGraphISOM(DirectedSparseGraph<String, String> grafo){		
		ISOMLayout<String, String> lay = new ISOMLayout<String, String>(grafo);
		lay.setSize(new Dimension(650, 450));
		BasicVisualizationServer<String, String> comp = new BasicVisualizationServer<String, String>(lay);
		comp.setPreferredSize(new Dimension(650, 450));
		 comp.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<String>());
		 comp.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);	
		 comp.getRenderContext().setVertexShapeTransformer( new TransformaFormaVertice());
		 comp.setBackground(Color.WHITE);
		 comp.getRenderContext().setVertexFillPaintTransformer(new TransformaCorVertice());
		return comp;
	}
	public BasicVisualizationServer<String, String> geraGraphFR2(DirectedSparseGraph<String, String> grafo){		
		FRLayout2<String, String> lay = new FRLayout2<String, String>(grafo);
		lay.setSize(new Dimension(650, 450));
		BasicVisualizationServer<String, String> comp = new BasicVisualizationServer<String, String>(lay);
		comp.setPreferredSize(new Dimension(650, 450));
		 comp.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<String>());
		 comp.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);	
		 comp.getRenderContext().setVertexShapeTransformer( new TransformaFormaVertice());
		 comp.setBackground(Color.WHITE);
		 comp.getRenderContext().setVertexFillPaintTransformer(new TransformaCorVertice());
		return comp;
	}
	public BasicVisualizationServer<String, String> geraGraphFR(DirectedSparseGraph<String, String> grafo){		
		FRLayout<String, String> lay = new FRLayout<String, String>(grafo);
		lay.setSize(new Dimension(650, 450));
		BasicVisualizationServer<String, String> comp = new BasicVisualizationServer<String, String>(lay);
		comp.setPreferredSize(new Dimension(650, 450));
		 comp.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<String>());
		 comp.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);	
		 comp.getRenderContext().setVertexShapeTransformer( new TransformaFormaVertice());
		 comp.setBackground(Color.WHITE);
		 comp.getRenderContext().setVertexFillPaintTransformer(new TransformaCorVertice());
		return comp;
	}
	public BasicVisualizationServer<String, String> geraGraphCircle(DirectedSparseGraph<String, String> grafo){		
		CircleLayout<String, String> lay = new CircleLayout<String, String>(grafo);
		lay.setSize(new Dimension(650, 450));
		BasicVisualizationServer<String, String> comp = new BasicVisualizationServer<String, String>(lay);
		comp.setPreferredSize(new Dimension(650, 450));
		 comp.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<String>());
		 comp.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);	
		 comp.getRenderContext().setVertexShapeTransformer( new TransformaFormaVertice());
		 comp.setBackground(Color.WHITE);
		 comp.getRenderContext().setVertexFillPaintTransformer(new TransformaCorVertice());
		return comp;
	}
}