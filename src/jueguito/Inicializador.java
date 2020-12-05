package jueguito;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Inicializador extends JComponent {

	private static final long serialVersionUID = 1L;
	public static int anchoVentana = 1058;
	public static int largoVentana = 650;

	public static void main(String[] args) {

		int tiempoDeEsperaEntreActualizaciones = 5;

		System.setProperty("sun.java2d.opengl", "true");
		JFrame ventana = new JFrame("El Juego del Mate");
		Inicio inicio = new Inicio(anchoVentana, largoVentana, ventana);
		ventana.setVisible(true);

		// Boton de START: asdasdasd
		JButton button = new JButton("Button1");
		button.setText("START");
		button.setForeground(Color.white);
		button.setToolTipText("PRESS BUTTON TO START");
		button.setBackground(Color.green);
		inicio.add(button);
		ventana.add(inicio);
		ventana.pack();

		// Boton Instrucciones:
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

		// Accion al apretar start
		button.addActionListener(e -> {
			Juego juego = new Juego(anchoVentana, largoVentana, tiempoDeEsperaEntreActualizaciones);
			ventana.add(juego);
			inicio.setVisible(false);
			juego.setVisible(true);
			ventana.addKeyListener(juego);

			// Crear un thread y pasarle como parametro al juego que implementa la interfaz
			// "Runnable"
			Thread thread = new Thread(juego);
			// Arrancar el juego
			thread.start();
		});
		button.setFocusable(false);

		// Accion al apretar instrucciones
		button2.addActionListener(e -> {
			Instrucciones instrucciones = new Instrucciones(anchoVentana, largoVentana, ventana);
			ventana.add(instrucciones);
			inicio.setVisible(false);

			Thread thread2 = new Thread(instrucciones);
			thread2.start();
		});

		button3.addActionListener(e -> {
			ventana.dispose();
		});

		ventana.setLocationRelativeTo(null);
	}
}
