package jueguito;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;




import javax.swing.JPanel;


public class Inicio extends JPanel implements KeyListener, Runnable {

	private static final long serialVersionUID = 1L;
	private int anchoJuego;
	private int largoJuego;
	private Sonido sonido;
	
	public Inicio(int anchoJuego, int largoJuego) {
		this.anchoJuego = anchoJuego;
		this.largoJuego = largoJuego;
		cancionDeFondo();
		sonido.tocarSonido("sound");
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
	
	// Reproduce cancion de fondo
	private void cancionDeFondo() {
		try {
			sonido = new Sonido();
			sonido.setSound("sound", "Resources/Sonidos/sound.wav");
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}


}