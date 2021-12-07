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
	Panel panel; 
	Mapa niveles;
	
	public Personaje (){
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
		System.out.println("PosicionX=" + posicionX);
		System.out.println("PosicionY=" + posicionY);
	}

	
	public void inicializarPersonaje() {
		if (Panel.getNivelActual() == 1) {
			this.posicionX = 110;
			this.posicionY = 555;
		} 
		if( Panel.getNivelActual() == 2) {
			this.posicionX = 110;
			this.posicionY = 555;
		}
		if( Panel.getNivelActual()== 3) {
			this.posicionX = 160;
			this.posicionY = 405;
		} 
		if( Panel.getNivelActual() == 4) {
			this.posicionX = 160;
			this.posicionY = 355;
		}
		if( Panel.getNivelActual() == 5) {
			this.posicionX = 710;
			this.posicionY = 405;
		}
	}
	
	
	public int getLlegadaX() {
		if ( Panel.getNivelActual() == 1) {
			return 810; //BIEN
		}
		if ( Panel.getNivelActual()== 2) {
			return 710; //BIEN
		}
		if ( Panel.getNivelActual() == 3) {
			return 710; //BIEN
		}
		if ( Panel.getNivelActual() == 4) {
			return 710; //BIEN
		} else {
			return 110; //BIEN
		}

	}
	
	public int getLlegadaY() {
		 if ( Panel.getNivelActual() ==1) {
			 return 555; //BIEN
		 }
		 if ( Panel.getNivelActual() == 2) {
			 return 405; //BIEN
		 }
		 if ( Panel.getNivelActual() == 3) {
			 return 405; //BIEN
		 }
		 if ( Panel.getNivelActual() == 4) {
			 return 355; //BIEN
		 } else {
			 return 555; //BIEN
		 }
	
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg8) {
		int [][]nivel = Niveles.obtenerNivel();
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
		if (posicionX== getLlegadaX() && posicionY==getLlegadaY() ) {
			System.out.println("Llegaste a la meta");
			Panel.cambiarNivelActual();
			inicializarPersonaje();
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
