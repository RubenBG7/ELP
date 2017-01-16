package main;

import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;


public class Main {
	

	public static void main (String [ ] args) throws IOException {
	
		VentanaTablero.getInstance().setVisible(true);
		//VentanaAlumnos.getInstance().setVisible(true);
		
		
		java.awt.Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = ((pantallaTamano.width / 2) - (VentanaAlumnos.getInstance().getWidth()) / 2);
		int alto = (pantallaTamano.height / 2) - (VentanaAlumnos.getInstance().getHeight() );
		

		VentanaAlumnos.getInstance().setLocation(pantallaTamano.width-1,alto); // 1300 300
		VentanaAlumnos.getInstance().setVisible(true);

		moverAutomaticamenteVentana(VentanaAlumnos.getInstance(),pantallaTamano.width-1,ancho*2,alto,alto, 1);

	}
	
	// Metodo realizar movimiento.
	private static void moverAutomaticamenteVentana(JFrame ventana, int desdeX, int hastaX,
			int desdeY, int hastaY, int demora) {
		
		while ((desdeX != hastaX) || (desdeY != hastaY)) {
			// Movimiento vertical
			if (desdeY != hastaY) {
				try {
					Thread.sleep(demora / 2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (desdeY < hastaY) {
					desdeY++;
				} else if (desdeY != hastaY) {
					desdeY--;
				}
				ventana.setLocation(desdeX, desdeY);
			}
			// Movimiento horizontal
			if (desdeX != hastaX) {
				try {
					Thread.sleep(demora / 2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (desdeX < hastaX) {
					desdeX++;
				} else if (desdeX != hastaX) {
					desdeX--;
				}
				ventana.setLocation(desdeX, desdeY);
			}
		}
	}
	
}
