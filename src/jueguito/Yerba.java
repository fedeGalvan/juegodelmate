package jueguito;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class Yerba extends Elementos {
	private BufferedImage img;

	public Yerba(int posicionX, int posicionY, int velocidadX, int velocidadY, int ancho, int largo, Color color) {
		super(posicionX, posicionY, velocidadX, velocidadY, ancho, largo, color);

		try {
			String path = Paths.get(Jugador.class.getClassLoader().getResource("Resources/Imagenes/yerba2.png").toURI())
					.toString();
			this.img = ImageIO.read(new File(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void dibujar(Graphics graphics) {
		try {
			graphics.drawImage(img, (int)getPosicionX(), (int)getPosicionY(), this.getAncho(), this.getLargo(), null);
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
