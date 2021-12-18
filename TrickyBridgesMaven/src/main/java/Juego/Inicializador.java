package Juego;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class Inicializador {

	public static void main (String[] args) {
		// tama�o pantalla  
		int anchoVentana = 950;
		int largoVentana = 900;
		int vidas = 3;
		int esperaActualizaciones = 5;

		//Acelera el juego 
		System.setProperty("sun.java2d.opengl", "true");
		
		// Crea la ventana del juego
		JFrame ventana = new JFrame("Tricky Bridge");
		
		// Cerrar el juego dandole a la "x"
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
		// Abrir la ventana en el centro de la pantalla  (COORDENADAS X, Y)
		ventana.setLocation(450,40); 
		
		// Mostrar la ventana
		ventana.setVisible(true);
		
		ventana.setResizable(false);
		
		//Instancia un nuevo panel y le manda el ancho y largo de la ventana
		Panel panel = new Panel (anchoVentana, largoVentana, vidas, esperaActualizaciones);
		
		//Agrega a la ventana el panel (TODA LA PARTE VISUAL, AHI SE HACE EL CODIGO PRINCIPAL)
		ventana.add(panel);
		
		//Achica la ventana lo maximo posible para que entren los componentes, acomoda el panel a la ventana ante cambios de tama;o
		ventana.pack();
		
		 ImageIcon icono = new ImageIcon (Panel.class.getResource("/imagenes/icono.png"));
		    
		ventana.setIconImage(icono.getImage());
		
		// Crea un thread (NO IMPORTA EL NOMBRE YA QUE ES UN @OVERRIDE DE UNA INTERFAZ) enviandole panel (ya que panel implementa runnable( para poder utilizar runnable
		Thread hilo = new Thread (panel);
		
		// Inicio .start y no .run para que no inicialice run. Arranca el juego
		hilo.start();
		
		
		// Llama a run para que realice una animacion
		//panel.run();
		
		// Le digo a la ventana que tome las acciones del mouse y le adjunto una clase que tenga aplicado los usos del mouse
		/*ventana.addMouseMotionListener(panel);*/
		
		ventana.addKeyListener(panel); // LE A;ADO EL KEYLISTENER AL PANEL PARA QUE DETECTE MOVIMIENTOS DEL TECLADO. SI NO LO LLAMAS DESDE ACA NO FUNCIONA.
		
		
	}
	
	
	
}