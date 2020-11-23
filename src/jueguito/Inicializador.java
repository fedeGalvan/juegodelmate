package jueguito;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
//import javax.swing.BoxLayout;

public class Inicializador extends JComponent implements KeyListener, Runnable {

	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		
		int anchoVentana = 1080;
		int largoVentana = 600;
		int tiempoDeEsperaEntreActualizaciones = 5;
		
	//	int enemigosPorLinea = 5;
		//int filasDeEnemigos = 2;

		// Activar aceleracion de graficos en 2 dimensiones
		System.setProperty("sun.java2d.opengl", "true");

		// Crear un objeto de tipo JFrame que es la ventana donde va estar el juego
		JFrame ventana = new JFrame("E L  M A T E  F E L I Z");
		//ventana.setLayout(new BoxLayout(ventana,BoxLayout.Y_AXIS));


		// Cerrar la aplicacion cuando el usuario hace click en la 'X'
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Abrir la ventana en el centro de la pantalla
		ventana.setLocationRelativeTo(null);

		// Mostrar la ventana
		ventana.setVisible(true);
        ventana.setIconImage(new ImageIcon("src/Resources/Imagenes/IconoJuegoMate.jpg").getImage());


		// Crear un "JComponent" llamado Juego y agregarlo a la ventana
		Inicio  inicio = new Inicio(anchoVentana, largoVentana); 
		
		//Boton de START:
		JButton button = new JButton("Button1");
		button.setText("START");	         
		button.setForeground(Color.white);
		button.setToolTipText("PRESS BUTTON TO START");
		button.setBackground(Color.green);
		inicio.add(button);
		ventana.add(inicio);
		ventana.pack();
		
		//Boton Instrucciones:
		JButton button2 = new JButton("Button2");
		button2.setText("INSTRUCCIONES");	         
		button2.setForeground(Color.white);
		button2.setBackground(Color.green);
		inicio.add(button2);
		ventana.add(inicio);
		ventana.pack();
		
		JButton button3 = new JButton("Button3");
		button3.setText("SALIR");	         
		button3.setForeground(Color.white);
		button3.setBackground(Color.green);
		inicio.add(button3);
		ventana.add(inicio);
		ventana.pack();
		
		
		//Accion al apretar start
		button.addActionListener(e -> {
			Juego juego = new Juego(anchoVentana, largoVentana, tiempoDeEsperaEntreActualizaciones);
			ventana.add(juego);
			inicio.setVisible(false);
			juego.setVisible(true);
			ventana.addKeyListener(juego);
			// Agregar enemigos al juego
		//	agregarEnemigos(juego, enemigosPorLinea, filasDeEnemigos);

			// Achicar la ventana lo maximo posible para que entren los componentes
			ventana.pack();

			// Crear un thread y pasarle como parametro al juego que implementa la interfaz
			// "Runnable"
			Thread thread = new Thread(juego);
			// Arrancar el juego
			thread.start();
		}); 
		button.setFocusable(false);
		
		//Accion al apretar instrucciones
		button2.addActionListener(e -> {
			Juego juego = new Juego(anchoVentana, largoVentana, tiempoDeEsperaEntreActualizaciones);
			ventana.add(juego);
			inicio.setVisible(false);
			juego.setVisible(true);
			ventana.addKeyListener(juego);
			// Achicar la ventana lo maximo posible para que entren los componentes
			ventana.pack();

			// Crear un thread y pasarle como parametro al juego que implementa la interfaz
			// "Runnable"
			Thread thread = new Thread(juego);
			// Arrancar el juego
			thread.start();
		
		});
		
		button3.addActionListener(e -> {
			Juego juego = new Juego(anchoVentana, largoVentana, tiempoDeEsperaEntreActualizaciones);
			ventana.add(juego);
			inicio.setVisible(false);
			juego.setVisible(true);
			ventana.addKeyListener(juego);
			// Achicar la ventana lo maximo posible para que entren los componentes
			ventana.pack();

			// Crear un thread y pasarle como parametro al juego que implementa la interfaz
			// "Runnable"
			Thread thread = new Thread(juego);
			// Arrancar el juego
			thread.start();
		
		});
	}
	/*
	private static void agregarEnemigos(Juego juego, int enemigosPorLinea, int filasDeEnemigos) {
		for (int x = 1; x < enemigosPorLinea; x++) {
			for (int y = 1; y < filasDeEnemigos; y++) {
				Color color = new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));
				juego.agregarEnemigoAuto(new EnemigoAuto(0 + x * 200, 120 + y * 30, 0.5, 0, 60, 30, color));
				juego.agregarEnemigoSerpiente(new EnemigoSerpiente(0 + x * 200, 300 + y * 30, 0.5, 0, 60, 30, color));
				juego.agregarEnemigoAuto(new EnemigoAuto(0 + x * 200, 480 + y * 30, 0.5, 0, 60, 30, color));
			}
		}
		for (int x = 1; x <  enemigosPorLinea; x++) {
			for (int y = 1; y < filasDeEnemigos; y++) {
				Color color = new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));
				juego.agregarEnemigoCamion(new EnemigoCamion(0 + x * 200, 220 + y * 30, -0.5, 0, 60, 30, color));            
				juego.agregarEnemigoCamion(new EnemigoCamion(0 + x * 200, 380 + y * 30, -0.5, 0, 60, 30, color));
			}
		}
		for (int x = 1; x < enemigosPorLinea; x++) {
			for (int y = 1; y < filasDeEnemigos; y++) {
				juego.agregarRanitas(new Ranitas(-45+ x * 130, 30 + y * 30, -1, 0, 40, 40, Color.green));            
			}
		}
	} */
	@Override
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getKeyCode() == 38) {
		}
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == 38) {
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyCode() == 37) {
		}
	}
	@Override
	public void run() {
	}
}
