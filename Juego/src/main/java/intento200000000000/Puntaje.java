package intento200000000000;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Puntaje {
    private int posicionX;
    private int posicionY;
    private static int puntaje = 0;
    private static int puntajeTotal;
    private static int puntajeNivel;

    public Puntaje(int puntajeNivel) { //14, 445, 35, new Font("Sans Serif", Font.BOLD, 30), Color.black
        this.posicionX = 445;
        this.posicionY = 35;
        Puntaje.puntajeNivel = puntajeNivel;
    }

    public void dibujarse(Graphics g) {
    	g.setFont(new Font("Sans Serif", Font.BOLD, 30));
    	g.setColor(Color.black);
        g.drawString(puntaje + " / " + puntajeNivel, posicionX, posicionY);
    
        g.setColor(Color.black);
        g.drawString("PUNTOS TOTALES " + puntajeTotal, 600, 880);
    
    }
    public static void setPuntaje0 (int puntaje) {
    	Puntaje.puntaje = puntaje;
    }

    public static void sumarPunto() {
    	puntaje++;
        puntajeTotal++;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getPuntajeTotal() {
    	return puntajeTotal;
    }
}
