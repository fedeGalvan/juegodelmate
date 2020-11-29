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
	private PanelImagen panelImagen;
	protected boolean pararJuego;
	private boolean juegoCorriendo;

	public Juego(int anchoVentana, int altoVentana, int vidas) {
		this.anchoJuego = anchoVentana;
		this.altoJuego = altoVentana;
		this.vidas = new Vidas((anchoVentana / 2) - 50, 25, new Font("Rubik", 15, 20), Color.green, 3);
		this.puntaje = new Puntaje(50, 25, new Font("Rubik", 15, 20), Color.red, 0);
		this.jugador = new Jugador(anchoVentana - 70, altoVentana - 70, 0, 0, 70, 70, null);
		this.yerba = new Yerba(500, 500, 0, 0, 70, 70, null);

		this.chuker1 = new Chuker(-600, -600, 0, 0, 150, 150, null);
		this.chuker2 = new Chuker(-600, -600, 0, 0, 150, 150, null);
		this.chuker3 = new Chuker(-600, -600, 0, 0, 150, 150, null);
		this.azucar1 = new Azucar(-600, -600, 0, 0, 80, 80, null);
		this.azucar2 = new Azucar(-600, -600, 0, 0, 80, 80, null);
		this.azucar3 = new Azucar(-600, -600, 0, 0, 80, 80, null);
		this.panelImagen = new PanelImagen(0, 0, 0, 0, 1058, 650, null);
		this.pararJuego = false;
		this.juegoCorriendo = true;

		cargarSonidos();
	}

	private void cargarSonidos() {
		try {
			sonido = new Sonido();
			sonido.agregarSonido("ruidomate", "Resources/Sonidos/ruidomate.wav");
			sonido.agregarSonido("saturno", "Resources/Sonidos/saturno.wav");
			sonido.agregarSonido("azucar", "Resources/Sonidos/asco.wav");
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
		while (juegoCorriendo) {
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

	private void mostrarMensajePerder(Graphics g) {
		this.limpiarPantalla(g);
		g.setColor(new Color(23, 232, 218));
		g.setFont(new Font("Impact", 8, 30));

		drawString(g, "GAME OVER", 450, 250);
		g.setColor(Color.white);

		calcularPuntaje(g);
		
		g.setColor(new Color(23, 232, 218));
		drawString(g, "\n\nNo agarraste la canarias!", 380, 250);
		
	}

	private void calcularPuntaje(Graphics g) {
		if (puntaje.getPuntaje() >= 999) {
			drawString(g, ("\nObtuviste " + (Double.valueOf(puntaje.getPuntaje()) / 1000) + "kg de yerba"), 380, 250);
		} else {
			drawString(g, ("\nObtuviste " + puntaje.getPuntaje() + "g de yerba"), 380, 250);
		}
	}

	// Funcion que hace salto de linea
	private String drawString(Graphics g, String text, int x, int y) {
		for (String line : text.split("\n"))
			g.drawString(line, x, y += g.getFontMetrics().getHeight());

		return text;
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (!pararJuego) {
			super.paintComponent(g);
			panelImagen.dibujar(g);
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

		} else {
			mostrarMensajePerder(g);
			juegoCorriendo = false;
		}
	}

	private void limpiarPantalla(Graphics graphics) {
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, anchoJuego, altoJuego);
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
		verificarFinDeJuego();
	}

	private void verificarColisiones() {
		colisionYerba();
		colisionEdulcorante();
		colisionAzucar();
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

			if (vidas.getVidas() == 2) {
				vidas.setColor(Color.yellow);
			} else if (vidas.getVidas() == 1) {
				vidas.setColor(Color.red);
			}
		}
	}

	private void colisionYerba() {

		if (jugador.hayColision(yerba)) {
			yerba = new Yerba((int) (Math.random() * (anchoJuego) - 20), (int) (Math.random() * (altoJuego) - 20), 0, 0,
					70, 70, null);
			puntaje.ganarPuntaje();
			sonido.tocarSonido("ruidomate");
		}

	}

	private void colisionAzucar() {
		if (jugador.hayColision(azucar1) || jugador.hayColision(azucar2) || jugador.hayColision(azucar3)) {
			azucar1 = null;
			azucar2 = null;
			azucar3 = null;
			azucar1 = new Azucar(-600, -600, 0, 0, 100 + (int) (Math.random() * 150), 100 + (int) (Math.random() * 150),
					null);
			azucar2 = new Azucar(-600, -600, 0, 0, 100 + (int) (Math.random() * 150), 100 + (int) (Math.random() * 150),
					null);
			azucar3 = new Azucar(-600, -600, 0, 0, 100 + (int) (Math.random() * 150), 100 + (int) (Math.random() * 150),
					null);
			puntaje.perderPuntaje();
			sonido.tocarSonido("azucar");

		}
	}

	private void verificarFinDeJuego() {

		if (vidas.getVidas() == 0) {
			pararJuego = true;

		}

	}
}
