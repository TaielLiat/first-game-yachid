package Juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class PantallaImagen {

    protected BufferedImage img;
    protected int ancho;
    protected int largo;
    protected int puntos;

    public PantallaImagen(int ancho, int largo, String resource, int puntos) {
       super ();
        try {
            this.ancho = ancho;
            this.largo = largo;
            String path = Paths.get(PantallaImagen.class.getClassLoader().getResource(resource).toURI()).toString();
            this.img = ImageIO.read(new File(path));
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
    }

    public void dibujarse(Graphics g) {
        try {
    		g.drawImage(img, 0, 0, ancho, largo, null);
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
    }
    
    public void dibujarVidas(Graphics g) {
    	g.setFont(new Font("Sans Serif", Font.BOLD, 30));
    	g.setColor(Color.white);
    	g.drawString("LIVES LEFT:" + Vidas.getVidas(), 400, 600);
    }
    
    public void dibujarPuntos(Graphics g) {
    	Color fondoBoton = new Color (173, 117, 24);
		Color arcoBoton = new Color (247, 179, 96);
    	g.setColor(fondoBoton);
    	// x y largo alto
    	g.fillRect(100, 265, 330, 50);
    	g.setColor(arcoBoton);
    	// x y largo alto
    	g.drawRect(100, 265, 330, 50);
    	g.setColor(arcoBoton);
    	// x y largo alto
    	g.drawRect(105, 270, 320, 40);
    	
    	
    	g.setColor(Color.black);
        g.setFont(new Font("Sans Serif", Font.BOLD, 30));
        g.drawString("TOTAL SCORE: " + Puntaje.getPuntajeTotal(), 120, 300);
    }

}
