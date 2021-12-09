package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HojaSprites {
	private final int ancho; // FINAL recalca que la variable no va a cambiar
	private final int alto;
	public final int [] pixeles;

public HojaSprites(final String ruta, final int ancho, final int alto) {
	this.ancho = ancho;
	this.alto = alto;

	pixeles = new int [ancho*alto]; // 
	
	BufferedImage imagen;
	try {
		imagen = ImageIO.read(HojaSprites.class.getResource(ruta));// Se crea imagen y se le da el valor de una ruta
		imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
	} catch (IOException e) {
		e.printStackTrace();
	} 
}
	

	public int obtenerAncho(){
		return ancho;
	}

	
}

