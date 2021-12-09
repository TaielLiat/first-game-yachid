package graficos;

public final class Sprite {
	private final int tamanio;
	
	private int x;
	private int y;
	
	public int[] pixeles;
	private final HojaSprites hoja;
	
	public Sprite(final int tamanio, final int columna, final int fila, final HojaSprites hoja) {
		this.tamanio = tamanio;
		this.hoja = hoja;
		
		pixeles = new int[tamanio * tamanio];
		
		this.x = columna * tamanio;
		this.y = fila * tamanio;
		
		for(int y = 0; y < tamanio; y++) { // Se recorre de izquierda a derecha 
			for(int x = 0; x < tamanio; x++){
				pixeles[x + y * tamanio] = hoja.pixeles[(x + this.x) 
				        + (y+this.y) * hoja.obtenerAncho()];//los operadores se ejecutan por orden en java
			}
			
		}
	}
}
