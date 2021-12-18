package Juego;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Toolkit;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Personaje extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	private int personajeAncho = 30;
	private int personajeAlto = 40;
	private static int posicionX;
	private static int posicionY;
    //MAPA
	private static int numeroFilas = 17; 
	private static int numeroColumnas = 19;
	//REM (PELO AZUL)
	private BufferedImage RemAdelante1;
	private BufferedImage RemAdelante2;
	private BufferedImage RemAdelante3;
	private BufferedImage RemDerecha1;
	private BufferedImage RemDerecha2;
	private BufferedImage RemDerecha3;
	private BufferedImage RemIzquierda1;
	private BufferedImage RemIzquierda2;
	private BufferedImage RemIzquierda3;
	private BufferedImage RemAtras1;
	private BufferedImage RemAtras2;
	private BufferedImage RemAtras3;
	private BufferedImage RemMuerte1;
	private BufferedImage RemMuerte2;
	private BufferedImage RemMuerte3;
	private BufferedImage RemMuerte4;
	private BufferedImage RemMuerte5;
	private BufferedImage RemMuerte6;
	private final int personajeDelay = 25;
	private final int personajeCantidadSprites= 4;
	private int personajeAnimContador = personajeDelay;
	private int personajeImDir = 1;
	private int personajeInicial = 1;
	public int vista = 0;
	
	public Personaje (){
		inicializarPersonaje();
		paint (getGraphics());
		cargarImagenes();
	}
	 
	public void paint(Graphics g) {
		hacerAnimacion();
		dibujarRem(g);
	}
	
	public void pintarMuerte(Graphics g) {
		hacerAnimacion();
		//dibujarMuerte(g);
		
	}
	
	public void cargarImagenes () {
		try {
			this.RemDerecha1 = ImageIO.read(getClass().getResource("/rem/caminarDerecha1.png"));
			this.RemDerecha2 = ImageIO.read(getClass().getResource("/rem/caminarDerecha2.png"));
			this.RemDerecha3 = ImageIO.read(getClass().getResource("/rem/caminarDerecha3.png"));
			this.RemIzquierda1 = ImageIO.read(getClass().getResource("/rem/caminarIzquierda1.png"));
			this.RemIzquierda2 = ImageIO.read(getClass().getResource("/rem/caminarIzquierda2.png"));
			this.RemIzquierda3 = ImageIO.read(getClass().getResource("/rem/caminarIzquierda3.png"));
			this.RemAdelante1 = ImageIO.read(getClass().getResource("/rem/caminarFrente1.png"));
			this.RemAdelante2 = ImageIO.read(getClass().getResource("/rem/caminarFrente2.png"));
			this.RemAdelante3 = ImageIO.read(getClass().getResource("/rem/caminarFrente3.png"));
			this.RemAtras1 = ImageIO.read(getClass().getResource("/rem/caminarAtras1.png"));
			this.RemAtras2 = ImageIO.read(getClass().getResource("/rem/caminarAtras2.png"));
			this.RemAtras3 = ImageIO.read(getClass().getResource("/rem/caminarAtras3.png"));
			this.RemMuerte1 = ImageIO.read(getClass().getResource("/imagenes/muerteRem1.png"));
			this.RemMuerte2 = ImageIO.read(getClass().getResource("/imagenes/muerteRem2.png"));
			this.RemMuerte3 = ImageIO.read(getClass().getResource("/imagenes/muerteRem3.png"));
			this.RemMuerte4 = ImageIO.read(getClass().getResource("/imagenes/muerteRem4.png"));
			this.RemMuerte5 = ImageIO.read(getClass().getResource("/imagenes/muerteRem5.png"));
			this.RemMuerte6 = ImageIO.read(getClass().getResource("/imagenes/muerteRem6.png"));
			
		} catch (IOException e) {
			System.out.println ("No se encontro la imagen");
			throw new RuntimeException(e);
		}
	}	
	
	public void hacerAnimacion() {
		personajeAnimContador--;
		if (personajeAnimContador <= 0) {
			personajeAnimContador = personajeDelay;
			personajeInicial = personajeInicial + personajeImDir;

			if (personajeInicial == (personajeCantidadSprites - 1) || personajeInicial == 0) {
				personajeImDir = -personajeImDir;
			}
		}
	}
	
	public void dibujarRem (Graphics g) {
		if (vista == 1) {
			dibujarRemDerecha(g);
		} else if (vista == 2) {
			dibujarRemIzquierda(g);
		} else if(vista == 3) {
			dibujarRemAdelante(g);
		} else if (vista == 4) {
			dibujarRemAtras(g);
		}
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent arg8) {		
		System.out.println(posicionX);
		System.out.println(posicionY);
		if (arg8.getKeyCode () == 39 || arg8.getKeyCode () == 68) {//FLECHA DERECHA
			if(Mapa.obtenerNivel()[posicionY/50] [(posicionX/50) + 1] !=2) {
				this.vista = 1;
				posicionX = posicionX + 50;
				Puntaje.sumarPunto();
				if (Mapa.obtenerNivel()[(posicionY/50)] [(posicionX/50)] == 1 || Mapa.obtenerNivel()[(posicionY/50)] [(posicionX/50)] == 4) {
					Mapa.nivel[(posicionY/50)][(posicionX/50) -1] = 3;
				}
			}
		}
		
		if (arg8.getKeyCode () == 37 || arg8.getKeyCode () == 65) { //FLECHA IZQUIERDA
			if(Mapa.obtenerNivel()[(posicionY/50)] [(posicionX/50) - 1] !=2) {
				this.vista = 2;
				posicionX = posicionX - 50;
				Puntaje.sumarPunto();
				if (Mapa.obtenerNivel()[(posicionY/50)] [(posicionX/50)] == 1 || Mapa.obtenerNivel()[(posicionY/50)] [(posicionX/50)] == 4) {
					Mapa.nivel[(posicionY/50)][(posicionX/50) +1] = 3;
				}
			}
		}
		
		if (arg8.getKeyCode () == 38 || arg8.getKeyCode () == 87 ) {// FLECHA ARRIBA
			if(Mapa.obtenerNivel()[(posicionY/50) - 1] [posicionX/50] !=2 ) {
				this.vista = 4;
				posicionY = posicionY - 50;
				Puntaje.sumarPunto();
				if (Mapa.obtenerNivel()[(posicionY/50)] [(posicionX/50)] == 1 || Mapa.obtenerNivel()[(posicionY/50)] [(posicionX/50)] == 4) {
					Mapa.nivel[(posicionY/50)+1][(posicionX/50) ] = 3;
				}
			}
		}
		
		if (arg8.getKeyCode () == 40 || arg8.getKeyCode () == 83 ) {//FLECHA ABAJO
			if(Mapa.obtenerNivel()[(posicionY/50) + 1] [posicionX/50] !=2) {
				this.vista = 3;
				posicionY = posicionY + 50;
				Puntaje.sumarPunto();
				if (Mapa.obtenerNivel()[(posicionY/50)] [(posicionX/50)] == 1 || Mapa.obtenerNivel()[(posicionY/50)] [(posicionX/50)] == 4) {
					Mapa.nivel[(posicionY/50)-1][(posicionX/50) ] = 3;
				}
			}
		}
		
		if (posicionX== getLlegadaX() && posicionY==getLlegadaY() ) {
			System.out.println("Llegaste a la meta");
			Panel.cambiarNivelActual();
			Panel.inicializarPuntaje();
			inicializarPersonaje();
			if (Panel.nivelActual < 8) {
				Puntaje.setPuntaje0(0);
			}
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
		if(Panel.getNivelActual() == 7) {
			Personaje.posicionX = 710;
			Personaje.posicionY = 405;
		}
		if(Panel.getNivelActual() == 8) {
			Personaje.posicionX = 460;
			Personaje.posicionY = 305;
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
		}
		if (Panel.getNivelActual() == 6) {
			return 710; //BIEN
		} 
		if (Panel.getNivelActual() == 7) {
			return 460; 
		} else {
			return 760; 
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
		 }
		 if (Panel.getNivelActual() == 6) {
			 return 455; 
		} 
		 if (Panel.getNivelActual() == 7) {
			 return 305; 
		 } else {
			 return 655;
		 }
	}
	
	public void ripearPersonaje () {
		Personaje.posicionX = 1000;
		Personaje.posicionY = 1000;
	}
	
	public void dibujarMuerte(Graphics g) {
		switch (personajeInicial) {
		case 1:
			g.drawImage(RemMuerte1, posicionX-5, posicionY, 40, personajeAlto, null);
			break;
		case 2:
			g.drawImage(RemMuerte2, posicionX-5, posicionY, 40, personajeAlto, null);
			break;
		case 3:
			g.drawImage(RemMuerte3, posicionX-5, posicionY, 40, personajeAlto, null);
			break;
		case 4:
			g.drawImage(RemMuerte4, posicionX-5, posicionY, 40, personajeAlto, null);
			break;
		case 5:
			g.drawImage(RemMuerte5, posicionX-5, posicionY, 40, personajeAlto, null);
			break;
		case 6:
			g.drawImage(RemMuerte6, posicionX-5, posicionY, 40, personajeAlto, null);
			break;
		default:
			g.drawImage(RemMuerte1, posicionX-5, posicionY, 40, personajeAlto, null);
			break;
		}
	}
	
	private void dibujarRemDerecha(Graphics g) {
		switch (personajeInicial) {
		case 1:
			g.drawImage(RemDerecha1, posicionX, posicionY, personajeAncho, personajeAlto, null);
			break;
		case 2:
			g.drawImage(RemDerecha2, posicionX, posicionY, personajeAncho, personajeAlto, null);
			break;
		case 3:
			g.drawImage(RemDerecha3, posicionX, posicionY, personajeAncho, personajeAlto, null);
			break;
		default:
			g.drawImage(RemDerecha1, posicionX, posicionY, personajeAncho, personajeAlto, null);
			break;
		}
	}
	
	private void dibujarRemIzquierda(Graphics g) {
		switch (personajeInicial) {
		case 1:
			g.drawImage(RemIzquierda1, posicionX, posicionY, personajeAncho, personajeAlto, null);
			break;
		case 2:
			g.drawImage(RemIzquierda2, posicionX, posicionY, personajeAncho, personajeAlto, null);
			break;
		case 3:
			g.drawImage(RemIzquierda3, posicionX, posicionY, personajeAncho, personajeAlto, null);
			break;
		default:
			g.drawImage(RemIzquierda1, posicionX, posicionY, personajeAncho, personajeAlto, null);
			break;
		}
	}
	
	private void dibujarRemAdelante(Graphics g) {
		switch (personajeInicial) {
		case 1:
			g.drawImage(RemAdelante1, posicionX, posicionY, personajeAncho, personajeAlto, null);
			break;
		case 2:
			g.drawImage(RemAdelante2, posicionX, posicionY, personajeAncho, personajeAlto, null);
			break;
		case 3:
			g.drawImage(RemAdelante3, posicionX, posicionY, personajeAncho, personajeAlto, null);
			break;
		default:
			g.drawImage(RemAdelante1, posicionX, posicionY, personajeAncho, personajeAlto, null);
			break;
		}
	}
	
	private void dibujarRemAtras(Graphics g) {
		switch (personajeInicial) {
		case 1:
			g.drawImage(RemAtras1, posicionX, posicionY, personajeAncho, personajeAlto, null);
			break;
		case 2:
			g.drawImage(RemAtras2, posicionX, posicionY, personajeAncho, personajeAlto, null);
			break;
		case 3:
			g.drawImage(RemAtras3, posicionX, posicionY, personajeAncho, personajeAlto, null);
			break;
		default:
			g.drawImage(RemAtras1, posicionX, posicionY, personajeAncho, personajeAlto, null);
			break;
		}
	}
	
	
	public static int getPosicionX() {
		return posicionX;
	}
	
	public static int getPosicionY() {
		return posicionY;
	}



	
}
