package jueguito;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Elementos extends PersonajeBase {

    public Elementos(int posicionX, int posicionY, int velocidadX, int velocidadY, int ancho, int largo,
                   Color color) {
        super(posicionX, posicionY, velocidadX, velocidadY, ancho, largo, color);
    }

    public abstract void destruirse(Graphics graphics);

}
