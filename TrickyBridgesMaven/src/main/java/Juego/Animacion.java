package Juego;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animacion {
	private int velocidad;
	private int index = 0;
	private int contador = 0;
	private int frames;

	private BufferedImage[] imagenes;
	private BufferedImage imagenActual;
	
	public Animacion (int velocidad, BufferedImage...args) {
		this.velocidad = velocidad;
		imagenes = new BufferedImage[args.length];
		for(int i = 0; i < args.length; i++) {
			imagenes [i] = args[i];
		}
		frames = args.length;
	}

	public void inicializarAnimacion () {
		index++;
		if (index > velocidad) {
			index = 0;
			siguienteImagen();
		}
	}

	private void siguienteImagen() {
		for (int i = 0; i < frames; i++) {
			if (contador == i) 
				imagenActual = imagenes[i];
			}
			
			contador++;
		
		if (contador > frames)
			contador = 0;
	}

	public void dibujarAnimacion(Graphics g, int posicionX, int posicionY) {
		g.drawImage(imagenActual, posicionX, posicionY, 50, 50, null);
	}











}
