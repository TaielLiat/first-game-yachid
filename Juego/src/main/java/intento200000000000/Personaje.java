package intento200000000000;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Personaje implements KeyListener {
	private int personajeAncho = 30;
	private int personajeAlto = 40;
	private static int posicionX;
	private static int posicionY;
    private Sonidos sonidos;
    //MAPA
	private static int numeroFilas = 17; 
	private static int numeroColumnas = 19;
	//
	public Personaje (){
		inicializarPersonaje();
		
	}

	public void dibujarse(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(posicionX, posicionY, personajeAncho, personajeAlto);
		g.setColor(Color.black);
		g.drawRect(posicionX, posicionY, personajeAncho, personajeAlto);
	}
	
	
	public static void inicializarPersonaje() {
		if (Panel.getNivelActual() == 1) {
			Personaje.posicionX = 110;
			Personaje.posicionY = 605;
		} 
		if(Panel.getNivelActual() == 2) {
			Personaje.posicionX = 110;
			Personaje.posicionY = 605;
		}
		if(Panel.getNivelActual()== 3) {
			Personaje.posicionX = 160;
			Personaje.posicionY = 455;
		} 
		if(Panel.getNivelActual() == 4) {
			Personaje.posicionX = 160;
			Personaje.posicionY = 405;
		}
		if(Panel.getNivelActual() == 5) {
			Personaje.posicionX = 710;
			Personaje.posicionY = 455;
		}
		if(Panel.getNivelActual() == 6) {
			Personaje.posicionX = 110;
			Personaje.posicionY = 605;
		}
	}
	
	
	public int getLlegadaX() {
		if (Panel.getNivelActual() == 1) {
			return 810; //BIEN
		}
		if (Panel.getNivelActual()== 2) {
			return 710; //BIEN
		}
		if (Panel.getNivelActual() == 3) {
			return 710; //BIEN
		}
		if (Panel.getNivelActual() == 4) {
			return 710; //BIEN
		} 
		if (Panel.getNivelActual() == 5) {
			return 110; //BIEN
		} else {
			return 710; //BIEN
		}

	}
	
	public int getLlegadaY() {
		 if (Panel.getNivelActual() == 1) {
			 return 605; //BIEN
		 }
		 if (Panel.getNivelActual() == 2) {
			 return 455; //BIEN
		 }
		 if (Panel.getNivelActual() == 3) {
			 return 455; //BIEN
		 }
		 if (Panel.getNivelActual() == 4) {
			 return 405; //BIEN
		 } 
		 if (Panel.getNivelActual() == 5) {
			 return 605;
		}else {
			 return 455; 
		 }
	
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent arg8) {		
		if (arg8.getKeyCode () == 39 || arg8.getKeyCode () == 68) {//FLECHA DERECHA
			if(Mapa.obtenerNivel()[posicionY/50] [(posicionX/50) + 1] !=2) {
				posicionX = posicionX + 50;
				Puntaje.sumarPunto();
				if (Mapa.obtenerNivel()[(posicionY/50)] [(posicionX/50)] == 1 || Mapa.obtenerNivel()[(posicionY/50)] [(posicionX/50)] == 4) {
					Mapa.nivel[(posicionY/50)][(posicionX/50) -1] = 3;
				}
			}
		}
		if (arg8.getKeyCode () == 37 || arg8.getKeyCode () == 65) { //FLECHA IZQUIERDA
			if(Mapa.obtenerNivel()[(posicionY/50)] [(posicionX/50) - 1] !=2) {
				posicionX = posicionX - 50;
				Puntaje.sumarPunto();
				if (Mapa.obtenerNivel()[(posicionY/50)] [(posicionX/50)] == 1 || Mapa.obtenerNivel()[(posicionY/50)] [(posicionX/50)] == 4) {
					Mapa.nivel[(posicionY/50)][(posicionX/50) +1] = 3;
					
				}
			}
		}
		if (arg8.getKeyCode () == 38 || arg8.getKeyCode () == 87 ) {// FLECHA ARRIBA
			if(Mapa.obtenerNivel()[(posicionY/50) - 1] [posicionX/50] !=2 ) {
				posicionY = posicionY - 50;
				Puntaje.sumarPunto();
				if (Mapa.obtenerNivel()[(posicionY/50)] [(posicionX/50)] == 1 || Mapa.obtenerNivel()[(posicionY/50)] [(posicionX/50)] == 4) {
					Mapa.nivel[(posicionY/50)+1][(posicionX/50) ] = 3;
				
				}
			}
		}
		if (arg8.getKeyCode () == 40 || arg8.getKeyCode () == 83 ) {//FLECHA ABAJO
			if(Mapa.obtenerNivel()[(posicionY/50) + 1] [posicionX/50] !=2) {
				posicionY = posicionY + 50;
				Puntaje.sumarPunto();
				if (Mapa.obtenerNivel()[(posicionY/50)] [(posicionX/50)] == 1 || Mapa.obtenerNivel()[(posicionY/50)] [(posicionX/50)] == 4) {
					Mapa.nivel[(posicionY/50)-1][(posicionX/50) ] = 3;
				}
			}
		}
		
		
		// SI EL PERSONAJE ESTA EN EL MAPA ENCIMA DE LAVA
		if  (Mapa.obtenerNivel()[(posicionY/50)][(posicionX/50)] == 3) {
			Vidas.perderVida();					// PERDER UNA VIDA
			reiniciarMapa();					// PINTA DE NUEVO EL MAPA
			Puntaje.setPuntajeTotal();			// LE RESTA AL PUNTAJE TOTAL LOS PUNTOS QUE GANASTE AL PERDER
			Puntaje.setPuntaje0(0);				// VUELVE EL PUNTAJE POR NIVEL A 0
            Personaje.inicializarPersonaje();	// INICIA DE NUEVO AL PERSONAJE EN LA UBICACION POR NIVEL 
			sonidos.tocarSonido("muerte");		// LLAMA A HACER SONIDO DE MUERTE (AUN NO ESTABLECIDO)
		}
		
		if (posicionX== getLlegadaX() && posicionY==getLlegadaY() ) {
			System.out.println("Llegaste a la meta");
			Panel.cambiarNivelActual();
			Panel.inicializarPuntaje();
			inicializarPersonaje();
			Puntaje.setPuntaje0(0);
			
		}
	}
	
	
	public static void reiniciarMapa() {
		for (int i = 0; i<numeroFilas; i++) {
			for (int x = 0; x<numeroColumnas; x++) {
				if (Mapa.obtenerNivel()[i][x] == 3){
					Mapa.nivel[i][x] = 1;
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	public int getPosicionX() {
		return posicionX;
	}
	
	public int getPosicionY() {
		return posicionY;
	}



	
}
