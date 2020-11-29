package jueguito;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class Inicio extends JPanel {

	private static final long serialVersionUID = 1L;
	private int anchoJuego;
	private int largoJuego;
	private Sonido sonido;
	
	public Inicio(int anchoJuego, int largoJuego, JFrame ventana) {
		this.anchoJuego = anchoJuego;
		this.largoJuego = largoJuego;
		cargarSonidos();
		sonido.tocarSonido("sound");
		
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);
		ventana.pack();
		ventana.setIconImage(new ImageIcon("Resources/Imagenes/IconoJuegoMate.jpg").getImage());
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private void cargarSonidos() {
		try {
			sonido = new Sonido();
			sonido.agregarSonido("sound", "Resources/Sonidos/sound.wav");
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}
		
	}

	public Dimension getPreferredSize() {
		return new Dimension(anchoJuego, largoJuego);
	}
	
	// Agrega imagen fondo
	Image img = Toolkit.getDefaultToolkit().getImage("Resources/Imagenes/background.jpg");
	public void paintComponent(Graphics g) {
		   super.paintComponent(g);
		   g.drawImage(img, 0, 0, null);
	}
			

}