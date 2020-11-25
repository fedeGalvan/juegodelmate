package jueguito;

import java.awt.*;

public abstract class PersonajeBase implements CaracteristicasPersonajes {

    protected int posicionX;
    protected int posicionY;
    private int velocidadX;
    private int velocidadY;
    private int ancho;
    private int largo;
    private Color color;

    public PersonajeBase(int posicionX, int posicionY, int velocidadX, int velocidadY, int ancho, int largo, Color color) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.velocidadX = velocidadX;
        this.velocidadY = velocidadY;
        this.ancho = ancho;
        this.largo = largo;
        this.color = color;
    }

    @Override
    public abstract void dibujar(Graphics graphics);


    @Override
    public void moverse() {
        posicionX = posicionX + velocidadX;
        posicionY = posicionY + velocidadY;
    }

    @Override
    public int getPosicionX() {
        return posicionX;
    }

    @Override
    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
    public int getVelocidadX() {
        return velocidadX;
    }

    public void setVelocidadX(int velocidadX) {
        this.velocidadX = velocidadX;
    }

    public int getVelocidadY() {
        return velocidadY;
    }

    public void setVelocidadY(int velocidadY) {
        this.velocidadY = velocidadY;
    }

    @Override
    public int getAncho() {
        return ancho;
    }

    @Override
    public int getLargo() {
        return largo;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void rebotarEnEjeX() {

    }

    public void rebotarEnEjeY() {

    }
}
