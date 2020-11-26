package jueguito;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Juego extends JComponent implements KeyListener, Runnable {

	private static final long serialVersionUID = 1L;
	private int anchoJuego;
	private int altoJuego;
	private Vidas vidas;
	private Puntaje puntaje;
	private Jugador jugador;
	private Elementos yerba;
	private Chuker chuker1;
	private Chuker chuker2;
	private Chuker chuker3;
	private Azucar azucar1;
	private Azucar azucar2;
	private Azucar azucar3;
	private Sonido sonido;

	public Juego(int anchoVentana, int altoVentana, int vidas) {
		this.anchoJuego = anchoVentana;
		this.altoJuego = altoVentana;
		this.vidas = new Vidas((anchoVentana / 2) - 50, 25, new Font("Rubik", 15, 20), Color.black, 3);
		this.puntaje = new Puntaje(50, 25, new Font("Rubik", 15, 20), Color.red, 0);
		this.jugador = new Jugador(anchoVentana - 70, altoVentana - 70, 0, 0, 70, 70, null);
		this.yerba = new Yerba(500, 500, 0, 0, 70, 70, null);

		this.chuker1 = new Chuker(-200, -200, 0, 0, 150, 150, null);
		this.chuker2 = new Chuker(-200, -200, 0, 0, 150, 150, null);
		this.chuker3 = new Chuker(-200, -200, 0, 0, 150, 150, null);
		this.azucar1 = new Azucar((int) (Math.random() * (anchoVentana)), (int) (Math.random() * (altoVentana)), 0, 0,
				80, 80, null);
		this.azucar2 = new Azucar((int) (Math.random() * (anchoVentana)), (int) (Math.random() * (altoVentana)), 0, 0,
				80, 80, null);
		this.azucar3 = new Azucar((int) (Math.random() * (anchoVentana)), (int) (Math.random() * (altoVentana)), 0, 0,
				80, 80, null);
		
		cargarSonidos();
	}

	private void cargarSonidos() {
		try {
			sonido = new Sonido();
			sonido.agregarSonido("ruidomate", "Resources/Sonidos/ruidomate.wav");
			sonido.agregarSonido("saturno", "Resources/Sonidos/saturno.wav");
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}
		
	}

	public Dimension getPreferredSize() {
		return new Dimension(anchoJuego, altoJuego);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == 39 && jugador.posicionX < anchoJuego) {
			jugador.setVelocidadX(5);
		} else if (e.getKeyCode() == 37 && jugador.posicionX > -40) {
			jugador.setVelocidadX(-5);
		} else if (e.getKeyCode() == 37) {
			jugador.setPosicionX(anchoJuego);
		} else if (e.getKeyCode() == 39) {
			jugador.setPosicionX(-20);
		}

		if (e.getKeyCode() == 40 && jugador.posicionY < altoJuego) {
			jugador.setVelocidadY(5);
		} else if (e.getKeyCode() == 38 && jugador.posicionY > -40) {
			jugador.setVelocidadY(-5);
		} else if (e.getKeyCode() == 38) {
			jugador.setPosicionY(altoJuego);
		} else if (e.getKeyCode() == 40) {
			jugador.setPosicionY(-20);
		}

		jugador.moverse();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 39 && jugador.posicionX < anchoJuego) {
			jugador.setVelocidadX(5);
		} else if (e.getKeyCode() == 37 && jugador.posicionX > -40) {
			jugador.setVelocidadX(-5);
		} else if (e.getKeyCode() == 37) {
			jugador.setPosicionX(anchoJuego);
		} else if (e.getKeyCode() == 39) {
			jugador.setPosicionX(-20);
		}

		if (e.getKeyCode() == 40 && jugador.posicionY < altoJuego) {
			jugador.setVelocidadY(5);
		} else if (e.getKeyCode() == 38 && jugador.posicionY > -40) {
			jugador.setVelocidadY(-5);
		} else if (e.getKeyCode() == 38) {
			jugador.setPosicionY(altoJuego);
		} else if (e.getKeyCode() == 40) {
			jugador.setPosicionY(-20);
		}

		jugador.moverse();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 39) {
			jugador.setVelocidadX(0);
		} else if (e.getKeyCode() == 37) {
			jugador.setVelocidadX(0);
		} else if (e.getKeyCode() == 40) {
			jugador.setVelocidadY(0);
		} else if (e.getKeyCode() == 38) {
			jugador.setVelocidadY(0);
		}

		jugador.moverse();
	}

	@Override
	public void run() {
		while (true) {
			actualizarJuego();
			dibujar();
			try {
				Thread.sleep(10);
			} catch (Exception e1) {
				throw new RuntimeException(e1);
			}
		}
	}

	private void dibujar() {
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		jugador.dibujar(g);
		vidas.dibujar(g);
		puntaje.dibujar(g);
		yerba.dibujar(g);
		chuker1.dibujar(g);
		chuker2.dibujar(g);
		chuker3.dibujar(g);
		azucar1.dibujar(g);
		azucar2.dibujar(g);
		azucar3.dibujar(g);

	}

	private void actualizarJuego() {
		jugador.moverse();
		yerba.moverse();
		chuker1.update();
		chuker2.update();
		chuker3.update();
		azucar1.update();
		azucar2.update();
		azucar3.update();
		verificarColisiones();
	}

	private void verificarColisiones() {
		colisionYerba();
		colisionEdulcorante();

	}

	private void colisionEdulcorante() {
		if (jugador.hayColision(chuker1) || jugador.hayColision(chuker2) || jugador.hayColision(chuker3)) {
			chuker1 = null;
			chuker2 = null;
			chuker3 = null;
			chuker1 = new Chuker(-600, -600, 0, 0, 150, 150, null);
			chuker2 = new Chuker(-600, -600, 0, 0, 150, 150, null);
			chuker3 = new Chuker(-600, -600, 0, 0, 150, 150, null);
			vidas.perderVida();
			sonido.tocarSonido("saturno");
		}
	}

	private void colisionYerba() {
			
		if (jugador.hayColision(yerba)) {
			yerba = new Yerba((int) (Math.random() * (anchoJuego) - 20), (int) (Math.random() * (altoJuego) - 20), 0, 0,
					70, 70, null);
			
			if(puntaje.getPuntaje() >= 1000) {
				puntaje = new Puntaje(50, 25, new Font("Rubik", 15, 20), Color.blue, 0);
			}
			
			puntaje.ganarPuntaje();
			sonido.tocarSonido("ruidomate");
		}

	}

}
