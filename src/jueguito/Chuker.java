package jueguito;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

public class Chuker extends Elementos {
	private BufferedImage img;

	public Chuker(double posicionX, double posicionY, double velocidadX, double velocidadY) {
		super(posicionX, posicionY, velocidadX, velocidadY, 120, 150, null);

		String path = Paths.get(Chuker.getResource().getPath()).toString();
		try {
			this.img = ImageIO.read(new File(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public Chuker(){
		super(Inicializador.anchoVentana-(Math.random()*100), Inicializador.largoVentana+(Math.random()*100), Math.random()*10, Math.random()*10, 80, 80, null);
	}

	private static File getResource() {
		return new File("Resources/Imagenes/chuker.png");
	}

	@Override
	public boolean hayColision(CaracteristicasPersonajes caracteristicasPersonajes) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void destruirse(Graphics graphics) {

	}

	@Override
	public void dibujar(Graphics graphics) {
		try {
			graphics.drawImage(img, (int) getPosicionX(), (int) getPosicionY(), this.getAncho(), this.getLargo(), null);
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}
	}
}
