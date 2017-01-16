package main;



public class Alumno {
	
	private int intervenciones = 0;
	private int intervencionesTotales = 0;
	private String nombre;
	
	public Alumno(String Nombre){
		
		this.nombre = Nombre;
		
	}
	
	public void sumarIntervenciones(int c){
		
		this.intervenciones += c;
		this.intervencionesTotales += c;
		
	}
	
	public int getInterveciones() {
		
		return this.intervenciones;
		
	}
	
	public int getIntervencionesTotales(){
		
		return this.intervencionesTotales;
		
	}
	
	public void finPrograma(){
		
		this.intervenciones = 0;
		
	}
	
	public String getNombre(){
		
		return this.nombre;
	}
	
	public void setIntervencionesTotales(int inter){
		
		this.intervencionesTotales = inter;
		
	}
	

}
