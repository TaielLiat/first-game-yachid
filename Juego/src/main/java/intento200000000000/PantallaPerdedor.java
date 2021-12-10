package intento200000000000;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PantallaPerdedor extends PantallaImagen {

    public PantallaPerdedor(int ancho, int largo, String resource, int puntos) {
        super(ancho, largo, resource);
        this.puntos=puntos;
    }

    public void dibujarse(Graphics graphics) {
        super.dibujarse(graphics);
        mostrarMensaje(graphics, "TOTAL SCORE: " + Puntaje.getPuntajeTotal());
    }

    private void mostrarMensaje(Graphics g, String mensaje) {
        g.setColor(Color.black);
        g.setFont(new Font("Sans Serif", Font.BOLD, 30));
        g.drawString(mensaje, 200, 400);
    }

}
