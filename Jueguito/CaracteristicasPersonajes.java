package Jueguito;

import java.awt.Color;
import java.awt.Graphics;

public interface CaracteristicasPersonajes extends Dibujar {

        int getPosicionX();

        int getPosicionY();

        int getAncho();

        int getLargo();

        int getVelocidadX();

        int getVelocidadY();

        Color getColor();

        @Override
        void dibujar(Graphics graphics);

        void moverse();

        boolean hayColision(CaracteristicasPersonajes caracteristicasPersonajes);

        void rebotarEnEjeX();

        void rebotarEnEjeY();
}
