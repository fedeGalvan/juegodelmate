package jueguito;

import java.awt.*;

public abstract class PersonajeBase implements CaracteristicasPersonajes {

    protected double posicionX;
    protected double posicionY;
    protected double velocidadX;
    protected double velocidadY;
    protected int ancho;
    protected int largo;
    private Color color;

    public PersonajeBase(double posicionX, double posicionY, double velocidadX, double velocidadY, int ancho, int largo, Color color) {
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
    public double getPosicionX() {
        return posicionX;
    }

    @Override
    public double getPosicionY() {
        return posicionY;
    }

    public void setPosicionX(double posicionX) {
        this.posicionX = posicionX;
    }

    public void setPosicionY(double posicionY) {
        this.posicionY = posicionY;
    }
    public double getVelocidadX() {
        return velocidadX;
    }

    public void setVelocidadX(double velocidadX) {
        this.velocidadX = velocidadX;
    }

    public double getVelocidadY() {
        return velocidadY;
    }

    public void setVelocidadY(double velocidadY) {
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
