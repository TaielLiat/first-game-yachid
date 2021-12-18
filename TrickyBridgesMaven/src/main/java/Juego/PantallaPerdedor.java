package Juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PantallaPerdedor extends PantallaImagen {

    public PantallaPerdedor(int ancho, int largo, String resource, int puntos) {
        super(ancho, largo, resource, puntos);
    }

    public void dibujarse(Graphics graphics) {
        super.dibujarse(graphics);
        mostrarMensaje(graphics, "TOTAL SCORE: " + Puntaje.getPuntajeTotal());
    }

    private void mostrarMensaje(Graphics g, String mensaje) {
    	g.setFont(new Font("Sans Serif", Font.BOLD, 30));
    	Color fondoBoton = new Color (173, 117, 24);
		Color arcoBoton = new Color (247, 179, 96);
		g.setColor(fondoBoton);
		g.fillRect(200, 400, 310, 40);
		g.setColor(arcoBoton);
		g.drawRect(200, 400, 310, 40);
        g.setColor(Color.black);
        g.drawString(mensaje, 210, 430);
    }

}
