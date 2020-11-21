package Jueguito;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        int anchoVentana = 900;
        int altoVentana = 500;
        int vidas = 3;

        System.setProperty("sun.java2d.opengl", "true");
        JFrame ventana = new JFrame("Juego del mate");
        ventana.setIconImage(new ImageIcon("src/Resources/Imagenes/IconoJuegoMate.jpg").getImage());
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.setResizable(false); // no se puede modificar el tamaño de la ventana
        Juego juego = new Juego(anchoVentana, altoVentana, vidas);
        ventana.add(juego);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        Thread thread = new Thread(juego);
        thread.start();

        }
    }

