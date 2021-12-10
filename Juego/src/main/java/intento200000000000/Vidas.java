package intento200000000000;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Vidas {

    private int posicionX;
    private int posicionY;
    private static int vidas;

    public Vidas(int vidas) { 
        this.posicionX = 750;
        this.posicionY = 35;
        Vidas.vidas = vidas;
    }

    public void dibujarse(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("Sans Serif", Font.BOLD, 30));
        g.drawString("LIVES " + String.valueOf(vidas), posicionX, posicionY);
    }

    public static void perderVida() {
        vidas--;
    }

    public static int getVidas() {
        return vidas;
    }
    

}
