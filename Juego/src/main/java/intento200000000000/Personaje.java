package intento200000000000;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Personaje implements KeyListener {
	private int personajeAncho = 30;
	private int personajeAlto = 40;
	private int posicionX;
	private int posicionY;
	private int velocidadX;
	private int velocidadY;
	private int nivelActual;
	Panel panel; 
	Mapa nivel;
	
	public Personaje (int nivelActual){
		this.nivelActual = nivelActual;
		inicializarPersonaje();
	}

	public void dibujar(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(posicionX, posicionY, personajeAncho, personajeAlto);
		g.setColor(Color.black);
		g.drawRect(posicionX, posicionY, personajeAncho, personajeAlto);
		
		
	}
	public void moverPersonaje() {
		posicionX = posicionX + velocidadX;
		posicionY = posicionY + velocidadY;
	}


	public void setNivelActual(int nivelActual) {
		this.nivelActual = nivelActual;
	}
	public void inicializarPersonaje() {
		System.out.println (nivelActual);
		if (nivelActual == 1) {
			this.posicionX = 105;
			this.posicionY = 555;
		} 
		if(nivelActual == 2) {
			this.posicionX = 110;
			this.posicionY = 555;
		}
		if(nivelActual == 3) {
			this.posicionX = 160;
			this.posicionY = 405;
		} 
		if(nivelActual == 4) {
			this.posicionX = 160;
			this.posicionY = 355;
		}
		if(nivelActual == 5) {
			this.posicionX = 705;
			this.posicionY = 400;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg8) {
		int [][]nivel = Niveles.obtenerNivel(nivelActual);
		if (arg8.getKeyCode () == 39 || arg8.getKeyCode () == 68) {//FLECHA DERECHA
			if(nivel[posicionY/50] [(posicionX/50) + 1] !=2) {
				posicionX = posicionX + 50;
			}
		}
		if (arg8.getKeyCode () == 37 || arg8.getKeyCode () == 65) { //FLECHA IZQUIERDA
			if(nivel[posicionY/50] [(posicionX/50) - 1] !=2) {
				posicionX = posicionX - 50;
			}
		}
		if (arg8.getKeyCode () == 38 || arg8.getKeyCode () == 87 ) {// FLECHA ARRIBA
			if(nivel[(posicionY/50) - 1] [posicionX/50] !=2) {
				posicionY = posicionY - 50;
			}
		}
		if (arg8.getKeyCode () == 40 || arg8.getKeyCode () == 83 ) {//FLECHA ABAJO
			if(nivel[(posicionY/50) + 1] [posicionX/50] !=2) {
				posicionY = posicionY + 50;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		velocidadX = 0;
		velocidadY = 0;
	}
	
	public int getPosicionX() {
		return posicionX;
	}
	
	public int getPosicionY() {
		return posicionY;
	}
	
}
