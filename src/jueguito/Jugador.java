package jueguito;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Jugador extends Elementos {

    private BufferedImage img;

    public Jugador(int posicionX, int posicionY, int velocidadX, int velocidadY, int ancho, int largo, Color color) {
        super(posicionX, posicionY, velocidadX, velocidadY, ancho, largo, color);
        String path = Paths.get(Jugador.getResource().getPath())
                .toString();
        try {
            this.img = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static File getResource() {
        return new File("Resources/Imagenes/mate.png");
    }


    @Override
    public void dibujar(Graphics graphics) {
        try {
            graphics.drawImage(img, getPosicionX(), getPosicionY(), this.getAncho(), this.getLargo(), null);
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
    }

    // Metodo que detecta colisiones
    @Override
	public boolean hayColision(CaracteristicasPersonajes elemento) {
		if (this.getPosicionX() + 40 < elemento.getPosicionX() + elemento.getAncho() &&
				this.getPosicionX() + this.getAncho() > elemento.getPosicionX() + 40 &&
				this.getPosicionY() + 40 < elemento.getPosicionY() + elemento.getLargo() &&
				this.getLargo() + this.getPosicionY() > elemento.getPosicionY() + 40) {
			return true;
		}
		return false;
	}

    @Override
    public void destruirse(Graphics graphics) {

    }

}
