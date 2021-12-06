package intento200000000000;


import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class Inicializador {

	public static void main (String[] args) {
		// tamaño pantalla 
		int anchoVentana = 950;
		int largoVentana = 750;
		
		//Acelera el juego 
		System.setProperty("sun.java2d.opengl", "true");
		
		// Crea la ventana del juego
		JFrame ventana = new JFrame("Tricky Bridge");
		
		// Cerrar el juego dandole a la "x"
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
		// Abrir la ventana en el centro de la pantalla
		ventana.setLocation(300,100);
		
		// Mostrar la ventana
		ventana.setVisible(true);
	
		//Instancia un nuevo panel y le manda el ancho y largo de la ventana
		Panel panel = new Panel (anchoVentana, largoVentana);
		/*Personaje personaje = new Personaje(anchoVentana, largoVentana);*/
		
		//Agrega a la ventana el panel (panel hereda de JPanel)
		ventana.add(panel);
		
		//Achica la ventana lo maximo posible para que entren los componentes, acomoda el panel a la ventana ante cambios de tama;o
		ventana.pack();
		
		// Crea un thread (hilo( enviandole panel (ya que panel implementa runnable( para poder utilizar runnable
		Thread hilo = new Thread (panel);
		
		// Inicio .start y no .run para que no inicialice run. Arranca el juego
		hilo.start();
		
		
		// Llama a run para que realice una animacion
		//panel.run();
		
		// Le digo a la ventana que tome las acciones del mouse y le adjunto una clase que tenga aplicado los usos del mouse
		/*ventana.addMouseMotionListener(panel);*/
		
		ventana.addKeyListener(panel);
		
		
	}
	
	
	
}