package intento200000000000;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable, KeyListener {
	private static final long serialVersionUID = 1L;
	private final static int PANTALLA_INICIO = 1;
    private final static int PANTALLA_JUEGO = 2;
    private final static int PANTALLA_PERDEDOR = 3;
	private final static int PANTALLA_GANADOR = 4;
	private static int nivelActual = 1;
	private int anchoJuego;
	private int largoJuego;
	private int pantallaActual;
    private int esperaActualizaciones; // para las pantallas intermedias uwu
    private PantallaImagen inicio;
    private PantallaImagen victoria;
    private PantallaImagen espera;
    private PantallaPerdedor derrota;
	private Vidas vidas;
    private static Puntaje puntaje;
    private Sonidos sonidos;
    private Panel panel;
    
    Mapa niveles = new Mapa ();	
    Personaje personaje = new Personaje ();
    
    
    public Panel (int anchoJuego, int largoJuego, int vidas) {
		this.anchoJuego = anchoJuego;
		this.largoJuego = largoJuego;
		this.pantallaActual = PANTALLA_INICIO;
		this.esperaActualizaciones = esperaActualizaciones;
		this.inicio =  new PantallaImagen(anchoJuego, largoJuego, "imagenes/inicio.jpg");
	    this.victoria = new PantallaImagen(anchoJuego, largoJuego, "imagenes/victoria.jpg");
	    this.espera = new PantallaImagen(anchoJuego, largoJuego, "imagenes/muerte.jpg");
	    this.derrota = new PantallaPerdedor(anchoJuego, largoJuego, "imagenes/derrota.jpg");
		this.vidas = new Vidas(vidas);

		cargarSonidos();
		this.sonidos.repetirSonido("menu.mp3");
		inicializarJuego();
	}
		
	 private void inicializarJuego() {
	        this.derrota = null;
	        this.victoria = null;
	        this.vidas = new Vidas(3);
	        inicializarPuntaje();
	    }
	
	 public void resetearNivel() {
		 panel.niveles = new Mapa();
		 personaje.inicializarPersonaje();
		 inicializarPuntaje();
	 }
	 
	 /*	
	public static void resetearNivel() {
		personaje.inicializarPersonaje();
		setNivelActual();
	}
	*/
	 
	 public static void inicializarPuntaje() {
		 System.out.println(nivelActual);
		if (nivelActual == 1) {
			Panel.puntaje = new Puntaje(14);
		}
		if (nivelActual == 2) {
			Panel.puntaje = new Puntaje(19);
		}
		if (nivelActual == 3) {
			Panel.puntaje= new Puntaje(25);
		}
		if (nivelActual == 4) {
			Panel.puntaje= new Puntaje(43);
		}
		if (nivelActual == 5) {
			Panel.puntaje = new Puntaje(41);
		} 
		if (nivelActual == 6){ 		//NIVEL 6
			Panel.puntaje = new Puntaje(41);
		}
	}
	 

	/* 
	 private void verificarFinDeJuego() {
        if (vidas.getVidas() == 0) {
            pantallaActual = PANTALLA_PERDEDOR;
        }
        if(nivelActual > 6){
			pantallaActual = PANTALLA_GANADOR;
		}
    }
	  */
	public Dimension getPreferredSize() {
		return new Dimension (anchoJuego, largoJuego);
	}

	
	public static int getNivelActual() {
		return nivelActual;
	}
	
	public static int cambiarNivelActual() {
		return nivelActual++;
		
	}
	
	@Override //Implemento metodo Override para superponer la creada por la clase Runnable
	public void run() {
		while (true) { 
			repintar();
			esperar(3);
		}
	}
	
	private void esperar(int milisegundos) {
		try {
			Thread.sleep (milisegundos);
		} catch (Exception el) {
			Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, "xd");
		}
		if(nivelActual > 5){
			JOptionPane.showMessageDialog(null, "Felicidades! Ganaste (provisional).");
			System.exit(0);
		}
		if (Vidas.getVidas() == 0) {
			JOptionPane.showMessageDialog(null, "Perdiste (provisional).");
			System.exit(3);
		}
	}

	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		niveles.paint(g);
		personaje.dibujar(g);
		pintarHud(g);
		vidas.dibujarse(g);
		puntaje.dibujarse(g);
	}
	
	public void pintarHud (Graphics g) {
		Color naranjon = new Color (255, 195, 0);
		Color amarillito = new Color (255, 237, 176);
		g.setColor(amarillito);
		g.fillRect(0, 0, 1000, 50);
		g.setColor(naranjon); 
		g.drawRect(0, 0, 1000, 50);
		g.setColor(amarillito);
		g.fillRect(0, 850,1000, 50);
		g.setColor(naranjon);
		g.drawRect(0, 850, 1000, 50);
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		personaje.keyTyped(e);	
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (pantallaActual == PANTALLA_INICIO) {
            inicializarJuego();
            pantallaActual = PANTALLA_JUEGO;
        }

        if (pantallaActual == PANTALLA_PERDEDOR || pantallaActual == PANTALLA_GANADOR) {
            pantallaActual = PANTALLA_INICIO;
        }

        if (pantallaActual == PANTALLA_JUEGO) {
		personaje.keyPressed(e);	
        }
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		personaje.keyReleased(e);
	}

	private void cargarSonidos() {
        try {
            sonidos = new Sonidos();
            sonidos.agregarSonido("toc", "sonidos/piso.mp3");
            sonidos.agregarSonido("muerte", "sonidos/muerte.mp3");
            sonidos.agregarSonido("background", "sonidos/menu.mp3");
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
    }
	
	private void repintar() {
		this.repaint();
	}


}
