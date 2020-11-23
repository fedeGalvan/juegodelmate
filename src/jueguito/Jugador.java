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
        return new File("src/Resources/Imagenes/mate.png");
    }


    @Override
    public void dibujar(Graphics graphics) {
        try {
            graphics.drawImage(img, getPosicionX(), getPosicionY(), this.getAncho(), this.getLargo(), null);
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
    }

    @Override
    public boolean hayColision(CaracteristicasPersonajes caracteristicasPersonajes) {
        return false;
    }

    @Override
    public void destruirse(Graphics graphics) {

    }
}
