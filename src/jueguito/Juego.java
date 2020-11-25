package jueguito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class Juego extends JPanel implements KeyListener, Runnable {

    private static final long serialVersionUID = 1L;
    private int anchoJuego;
    private int altoJuego;
    private int vidas;
    private Jugador jugador;
    private Elementos yerba;
    private Chuker chuker;
    private Azucar azucar; 

    public Juego(int anchoVentana, int altoVentana, int vidas) {
        this.anchoJuego = anchoVentana;
        this.altoJuego = altoVentana;
        this.setVidas(vidas);
        this.jugador = new Jugador(0, 200, 0, 0, 80, 80, Color.cyan);
        this.yerba = new Yerba(500, 500, 0, 0, 100, 100,null);
        this.chuker = new Chuker(200, 200, 0, 0, 200, 200, null);
        this.azucar = new Azucar(400, 400, 0, 0, 100, 100, null);
    }

    public Dimension getPreferredSize() {
        return new Dimension(anchoJuego, altoJuego);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == 39) {
            jugador.setVelocidadX(10);
        }
        else if (e.getKeyCode() == 37) {
            jugador.setVelocidadX(-10);
        }
        
        else if (e.getKeyCode() == 40) {
            jugador.setVelocidadY(10);
        }
        jugador.moverse();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 39) {
            jugador.setVelocidadX(10);
        }
        else if (e.getKeyCode() == 37) {
            jugador.setVelocidadX(-10);
        }
        
        else if (e.getKeyCode() == 40) {
            jugador.setVelocidadY(10);
        }
        
        jugador.moverse();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 39) {
            jugador.setVelocidadX(0);
        }
        else if (e.getKeyCode() == 37) {
            jugador.setVelocidadX(0);
        }
        else if (e.getKeyCode() == 40) {
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
        yerba.dibujar(g);
        chuker.dibujar(g);
        azucar.dibujar(g);
    }
    private void actualizarJuego() {
        jugador.moverse();
        yerba.moverse();
        chuker.update();
        azucar.update();
    }
   /* private void actualizarJuego() {
		verificarEstadoAmbiente();
		premio.moverse();
		jugador.moverse();
		moverEnemigos();
	}*/

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
}
