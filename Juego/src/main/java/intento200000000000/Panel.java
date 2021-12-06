package intento200000000000;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable, KeyListener {
	private static final long serialVersionUID = 1L;
	private int anchoJuego;
	private int largoJuego;
	public int nivelActual = 4;
	int[][] nivel1;
	int[][] nivel2;
	int[][] nivel3;
	int[][] nivel4;
	int[][] nivel5;
	Personaje personaje = new Personaje(nivelActual);
	Mapa niveles = new Mapa (nivelActual, nivel1, nivel2, nivel3, nivel4, nivel5);	
	
	public Panel (int anchoJuego, int largoJuego) {
		inicializarVentana(anchoJuego, largoJuego);
	}
	
	private void inicializarVentana(int anchoJuego, int largoJuego) {
		this.anchoJuego = anchoJuego;
		this.largoJuego = largoJuego;
	}
	
	public Dimension getPreferredSize() {
		return new Dimension (anchoJuego, largoJuego);
	}
	
	
	public int getNivelActual() {
		return nivelActual;
	}
	
	public int cambiaNivelActual() {
		return nivelActual++;
	}
	
	@Override //Implemento metodo Override para superponer la creada por la clase Runnable
	public void run() {
		while (true) { 
			actualizarAmbiente();
			repintar();
			esperar(3);
		}
	}
	
	private void esperar(int milisegundos) {
		try {
			Thread.sleep (milisegundos);
		} catch (Exception el) {
			throw new RuntimeException(el);
		}
		if(nivelActual > 5){
			JOptionPane.showMessageDialog(null, "Felicidades! Ganaste.");
			System.exit(0);
		}
	}
	
	private void repintar() {
		this.repaint();
	}
	
	private void actualizarAmbiente() {
		//verificarColisiones();
			personaje.moverPersonaje();
		}
	
		
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		niveles.paint(g);
		personaje.dibujar(g);
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		personaje.keyTyped(e);	
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		personaje.keyPressed(e);	
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		personaje.keyReleased(e);
	}
}
