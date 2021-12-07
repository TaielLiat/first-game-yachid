package intento200000000000;

import java.awt.Color;
import java.awt.Graphics;

public class Mapa {
	int[][] nivel = new int [15][19];
	public int fila = 0; //inicia en 0 para iterar en las filas de la matriz del mapa
	public int columna = 0; // >>>
	public int numeroFilas = 15; 
	public int numeroColumnas = 19;
	public int anchoBloque = 50;
	public int largoBloque = 50;
	public int nivelActual;
	Panel niveles;
	
		public Mapa(int[][] nivel1, int[][] nivel2, int[][] nivel3, int[][] nivel4, int[][] nivel5) {
		}
		
	public void paint (Graphics g) {
		for (fila = 0; fila<numeroFilas; fila++) {
			for (columna = 0; columna<numeroColumnas; columna++) {
				// FONDO
				if (Niveles.obtenerNivel()[fila][columna]== 0) {
					g.setColor(Color.WHITE);
					g.fillRect(columna*50, fila*50, anchoBloque, largoBloque);
					g.setColor(Color.BLACK);
					g.drawRect(columna*50, fila*50, anchoBloque, largoBloque);
				}
				// MADERA
				if (Niveles.obtenerNivel()[fila][columna]== 1) {
					g.setColor(Color.green);
					g.fillRect(columna*50, fila*50, anchoBloque, largoBloque);
					g.setColor(Color.BLACK);
					g.drawRect(columna*50, fila*50, anchoBloque, largoBloque);
				}
				//PARED
				if (Niveles.obtenerNivel()[fila][columna]== 2) {
					g.setColor(Color.gray);
					g.fillRect(columna*50, fila*50, anchoBloque, largoBloque);
					g.setColor(Color.BLACK);
					g.drawRect(columna*50, fila*50, anchoBloque, largoBloque);
				}
				// LLEGADA
				if (Niveles.obtenerNivel()[fila][columna]== 4) {
					g.setColor(Color.red);
					g.fillRect(columna*50, fila*50, anchoBloque, largoBloque);
					g.setColor(Color.BLACK);
					g.drawRect(columna*50, fila*50, anchoBloque, largoBloque);
				} // if
			} // for
		} // for 
	} // paint
	
}
	
	
	
	
	
	
	
	
	
	
	
	

