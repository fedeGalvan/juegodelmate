package Jueguito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Juego extends JPanel implements KeyListener, Runnable {

    private static final long serialVersionUID = 1L;
    private int anchoJuego;
    private int altoJuego;
    private int vidas;
    private Jugador jugador;


    public Juego(int anchoVentana, int altoVentana, int vidas) {
        this.anchoJuego = anchoVentana;
        this.altoJuego = altoVentana;
        this.vidas = vidas;
        this.jugador = new Jugador(30, 30, 0, 0, 80, 80, Color.cyan);
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
        jugador.moverse();;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 39) {
            jugador.setVelocidadX(0);
        }
        else if (e.getKeyCode() == 37) {
            jugador.setVelocidadX(0);
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
    }
    private void actualizarJuego() {
        jugador.moverse();
    }
}
