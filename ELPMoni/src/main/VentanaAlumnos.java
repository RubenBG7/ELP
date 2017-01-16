package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaAlumnos extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tabla tablaNombres;
	private int [][] alum = new int[8][6];
	private int cont = 0;
	public Alumno[] alumnos = new Alumno[45];
	
	ImageIcon ucm = new ImageIcon("ucm.png");
	private static VentanaAlumnos instancia = null;
	
	public static VentanaAlumnos getInstance() throws IOException{
		
		if(instancia == null) instancia = new VentanaAlumnos();
		
		return instancia;
		
	}
	

	public VentanaAlumnos() throws IOException{
		
		
		this.setSize(new Dimension(700, 500));
        
        this.setMinimumSize(new Dimension(200, 200));
		
		this.setTitle("Control de Participacion Etica,Legistacion y Profesion");
		
		setIconImage(ucm.getImage());
		
		setResizable(false);
		
		inicializarAlumnos("alumnos.txt");
		
		this.tablaNombres = new Tabla(this.alumnos);
		
		this.add(tablaNombres, null);
		
		for(int i=0; i< 8; i++)
			for(int j=0; j< 6; j++){
				
				this.alum[i][j] = cont;
				cont++;
				
			}
					
				
		
		
	}
	
	public void inicializarAlumnos(String archivo) throws IOException{
		
		//Inicializamos los alumnos que vamos a tener 1 a 1;
		String cadena = "";
		char[] array = new char[100];
		int numCaracteres = 0;
		int i = 0;
        FileReader f = new FileReader(archivo);
        
        char caract = (char) f.read();
        
        while(caract != ' '){
        
        	while(caract != ','){
        		
	        	array[numCaracteres] = caract;
	        	numCaracteres++;
	        	caract = (char) f.read();
	            
        	}
        	
        	for(int j = 0; j < numCaracteres; j++){
        		
        		cadena += array[j];
        		
        	}
        	
        	this.alumnos[i] = new Alumno(cadena);
        	numCaracteres = 0;
        	cadena = "";
        	caract = (char) f.read();
            while(caract != '\r'){            	
            	
            	array[numCaracteres] = caract;
	        	numCaracteres++;
	        	caract = (char) f.read();
            	
            }
            caract = (char) f.read();
            
            for(int j = 0; j < numCaracteres; j++){
        		
        		cadena += array[j];
        		
        	}
            
            this.alumnos[i].setIntervencionesTotales(Integer.parseInt(cadena));;
            i++;
            numCaracteres = 0;
            cadena = "";
            caract = (char) f.read();
        }
        f.close();
        
        
		
		
	
	}
	
	public void update(int a, int b, int cantidad){

		
		actualizarAlumno(this.alum[a][b], cantidad);
		
		this.setVisible(false);
		
		this.remove(tablaNombres);
		
		this.tablaNombres = null;
			
		this.tablaNombres = new Tabla(this.alumnos);
		
		this.add(tablaNombres);
		
		this.setVisible(true);

		
	}
	
	
	
	public void actualizarAlumno(int a, int cantidad){
		
		this.alumnos[a].sumarIntervenciones(cantidad);
		
		
	}
	
	public void finalizarPrograma() throws IOException{
		
		String ruta = "alumnos.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            for(int i = 0; i < this.alumnos.length; i++)
            {
            	bw.write(this.alumnos[i].getNombre());
            	bw.write(",");
            	bw.write(String.valueOf(this.alumnos[i].getIntervencionesTotales()));
            	bw.newLine();
            	
            }
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            for(int i = 0; i < this.alumnos.length; i++)
            {
            	bw.write(this.alumnos[i].getNombre());
            	bw.write(",");
            	bw.write(String.valueOf(this.alumnos[i].getIntervencionesTotales()));
            	bw.newLine();
            }
        }
        bw.write(" ");
        bw.close();
		
		
	}
	
	
	
	class Tabla extends JPanel 
	{
		  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		  private JTable tabla;
		  private JScrollPane panelScroll;
		  private String titColumna[];
		  private String datoColumna[][];
		 
		  private int contador = 0;
		  
		  public Tabla(Alumno[] alumnos) {
					
		    setLayout( new BorderLayout() );
		    
		    // Creamos las columnas y las cargamos con los datos que van a aparecer en la pantalla
		    CreaColumnas();
		    CargaDatos(alumnos);
		    
		    // Creamos una instancia del componente Swing
		    tabla = new JTable( datoColumna,titColumna );
		    
		    // Aquí se configuran algunos de los parámetros que permite variar la JTable
		    tabla.setShowHorizontalLines( false );
		    tabla.setRowSelectionAllowed( true );
		    tabla.setColumnSelectionAllowed( true );
		    
		    
		    // Cambiamos el color de la zona seleccionada (rojo/blanco)		    
		    tabla.setFont(new java.awt.Font("Calibri", 0, 15));		    
		    tabla.setSelectionForeground( Color.white );
		    tabla.setSelectionBackground( Color.red );
		    
		    // Incorporamos la tabla a un panel que incorpora ya una barra
		    // de desplazamiento, para que la visibilidad de la tabla sea automática
		    panelScroll = new JScrollPane( tabla );
		    add( panelScroll, BorderLayout.CENTER );
		    
		  }
		  
		  
		  // Creamos las etiquetas que sirven de título a cada una de
		  // las columnas de la tabla
		  public void CreaColumnas() {
		    titColumna = new String[3];
		    
		    for( int i=0; i < 3; i++ ) {
		    	
		    	if(i == 0) titColumna[i] = "Nombre Alumnos";
		    	if(i == 1) titColumna[i] = "Participaciones";
		    	if(i == 2) titColumna[i] = "Participaciones Totales";
		    	
		    }
		  }
		  
		  // Creamos los datos para cada uno de los elementos de la tabla
		  public void CargaDatos(Alumno[] alumnos)
		  {
			  datoColumna = new String[45][3];
		    
			  for( int iX=0; iX < 3; iX++ ) 
			  {
				  contador = 0;
				  for( int iY=0; iY < 45; iY++ ) 
				  {		      	  	  
			    	  if(iX == 0)
			    	  datoColumna[iY][iX] = alumnos[contador].getNombre();
			    	  if(iX == 1)
			          datoColumna[iY][iX] = Integer.toString(alumnos[contador].getInterveciones());
			    	  if(iX == 2)
			    	  datoColumna[iY][iX] = Integer.toString(alumnos[contador].getIntervencionesTotales());
			    	  
			    	  contador++;
				  }
			  }
		  }	
	}
	
	
}
