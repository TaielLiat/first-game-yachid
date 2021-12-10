package intento200000000000;

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
    protected int puntajeTotal;

    public PantallaImagen(int ancho, int largo, String resource) {
        try {
            this.ancho = ancho;
            this.largo = largo;
            String path = Paths.get(PantallaImagen.class.getClassLoader().getResource(resource).toURI()).toString();
            this.img = ImageIO.read(new File(path));
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
    }

    private void mostrarMensaje(Graphics g, String mensaje) {
        g.setColor(Color.black);
        g.setFont(new Font("Sans Serif", Font.BOLD, 30));
        g.drawString(mensaje, 10, 40);
    }

    public void dibujarse(Graphics graphics) {
        try {
        		mostrarMensaje(graphics, "TOTAL SCORE: " + Puntaje.getPuntajeTotal() );
    			graphics.drawImage(img, 0, 0, ancho, largo, null);
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
    }

}
