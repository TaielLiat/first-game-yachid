package intento200000000000;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Vidas {

    private int posicionX;
    private int posicionY;
    private static int vidas;

    public Vidas(int vidas) { //10, 45, new Font("Sans Serif", Font.BOLD, 30), Color.black,760, 35, new Font("Sans Serif", Font.BOLD, 30), Color.blue, vidas.getVidas()); //int posicionX, int posicionY, Font font, Color color,
        this.posicionX = 750;
        this.posicionY = 35;
        Vidas.vidas = vidas;
    }

    public void dibujarse(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("Sans Serif", Font.BOLD, 30));
        g.drawString("VIDAS " + String.valueOf(vidas), posicionX, posicionY);
    }

    public static void perderVida() {
        vidas--;
    }

    public static int getVidas() {
        return vidas;
    }

}
