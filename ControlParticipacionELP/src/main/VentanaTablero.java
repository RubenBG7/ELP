package main;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaTablero extends JFrame implements ActionListener {
	

	private static final long serialVersionUID = 1L;
	private static VentanaTablero instance;
	private JPanel PTableros = new JPanel();
	private JPanel PTablero = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel PTablero2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private JPanel PUndo = new JPanel();
	private JButton Undo;
	private JLabel labelproy;
	private JLabel labelprof;
	private int numAlumnos;
	
	
	ImageIcon face = new ImageIcon("man.png");
	ImageIcon ucm = new ImageIcon("ucm.png");
	Icon faceico = new ImageIcon(face.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH));
	
	private JButton[][] nCasillas;
	
	
	public static VentanaTablero getInstance(int num){
		
		if(instance == null){
			
			instance = new VentanaTablero(num);
			
		}
		
		return instance;
		
	}
	
	
	
	public VentanaTablero(int num){
		
		this.numAlumnos = num;
		
		initComponents();
		
		this.setTitle("Control de Participacion Etica,Legistacion y Profesion");
		
		setIconImage(ucm.getImage());
		
		setResizable(false);
		
	}
	
	
	private void initComponents(){
		
		
		ImageIcon face = new ImageIcon("deshacer.png");
		Icon Undoico = new ImageIcon(face.getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH));
		this.Undo = new JButton(Undoico);
		this.Undo.setEnabled(false);
		this.Undo.addActionListener(this);
		this.Undo.setOpaque(false);
		this.Undo.setContentAreaFilled(false);
		this.Undo.setBorderPainted(false);
		this.labelprof = new JLabel("    PROFESOR");
		this.labelproy = new JLabel("PANTALLA PROYECTOR");
		this.labelprof.setFont(new Font("Monospaced", Font.BOLD, 36));
		this.labelproy.setFont(new Font("Monospaced", Font.BOLD, 35));
		
		//PTablero.add(labelproy);
		/*if(contador == 21){
						PTablero2.add(labelprof);
					}	*/
		
		
		
		
		PTableros.setLayout(new GridLayout(1, 2));
		PUndo.setLayout(new GridLayout(1, 3));
		
		PUndo.add(labelprof);
		PUndo.add(Undo);
		PUndo.add(labelproy);
		
		//PTableros.setSize(new Dimension(200, 700));
		//PContenido.setSize(new Dimension(200, 700));
		
        this.setSize(new Dimension(1200, 800));
        
        this.addWindowListener(new WLVentanaTablero());
        
        this.setMinimumSize(new Dimension(200, 200));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		int contador = 0;
		
		nCasillas = new JButton[8][6];
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				
				if(i == 7 && j > 2) 
				{
					// No creamos ningï¿½n boton
				}
				else
				{
					ImageIcon face0 = new ImageIcon(/*"man.png"*/ "man.png");
					Icon faceico0 = new ImageIcon(face0.getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH));
					JButton aux0 = new JButton(faceico0);
					aux0.setBackground(new Color(212, 163, 107));
					nCasillas[i][j] = aux0;
					nCasillas[i][j].addActionListener(this);
					contador++;
									
					if(contador < 25) // Esta condiciï¿½n es para dividir los botones en dos tableros
					{	
					PTablero.add(aux0);
					}
					else
					{
					PTablero2.add(aux0);
					}
					
				}
			}			
		}
		
		this.setLayout(new BorderLayout());
		
		PTableros.add(PTablero, BorderLayout.WEST);		
		PTableros.add(PTablero2, BorderLayout.EAST);
		this.add(PTableros, BorderLayout.CENTER);
		this.add(PUndo, BorderLayout.SOUTH);

		
		
		
	
		
	}
	
	public void ActivarUndo(){
		
		this.Undo.setEnabled(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		for(int i=0; i< 8; i++)
			for(int j=0; j< 6; j++)
				if(e.getSource() == nCasillas[i][j]) //DETECTA QUE BOTON DE ARRAY HA SIDO PULSADO
				{
					deshacer.coordenada_i = i;
					deshacer.coordenada_j = j;
					ActivarUndo();
					try {						
						VentanaAlumnos.getInstance(numAlumnos).update(i, j, 1, numAlumnos);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		
		if(e.getSource() == Undo){
			
			this.Undo.setEnabled(false);
			
			try {
				VentanaAlumnos.getInstance(numAlumnos).update(deshacer.coordenada_i, deshacer.coordenada_j, -1, numAlumnos);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
	}

	
	
		//****************************************************//
		//***************** Window Listener ******************//
		//****************************************************// 
		
		
		/** 
		 * <!-- begin-UML-doc -->
		 * <!-- end-UML-doc -->
		 * @author Tomas
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
		public class WLVentanaTablero implements WindowListener {

			/* (sin Javadoc)
			 * @see java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Apï¿½ndice de mï¿½todo generado automï¿½ticamente
				
			}

			/* (sin Javadoc)
			 * @see java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowClosed(WindowEvent arg0) {
			}

			/* (sin Javadoc)
			 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowClosing(WindowEvent arg0) {
				try {
					VentanaAlumnos.getInstance(numAlumnos).finalizarPrograma();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			/* (sin Javadoc)
			 * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Apï¿½ndice de mï¿½todo generado automï¿½ticamente
				
			}

			/* (sin Javadoc)
			 * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Apï¿½ndice de mï¿½todo generado automï¿½ticamente
				
			}

			/* (sin Javadoc)
			 * @see java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Apï¿½ndice de mï¿½todo generado automï¿½ticamente
				
			}

			/* (sin Javadoc)
			 * @see java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Apï¿½ndice de mï¿½todo generado automï¿½ticamente
				
			}
		}

	

}
