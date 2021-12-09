package intento200000000000;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PantallaPerdedor extends PantallaImagen {
    private Puntaje puntaje;

    public PantallaPerdedor(int ancho, int largo, String resource) {
        super(ancho, largo, resource);
    }

    public void dibujarse(Graphics graphics) {
        super.dibujarse(graphics);
        mostrarMensaje(graphics, "Obtuviste: " + puntaje.getPuntajeTotal() + " puntos.");
    }

    private void mostrarMensaje(Graphics g, String mensaje) {
        g.setColor(Color.black);
        g.setFont(new Font("Sans Serif", Font.BOLD, 30));
        g.drawString(mensaje, 10, 40);
    }

}
