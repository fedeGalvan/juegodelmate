package jueguito;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import jueguito.Inicializador;
import javax.imageio.ImageIO;

public class Chuker extends Elementos {
    private BufferedImage img;
    int velocidad = 5;

	public Chuker(int posicionX, int posicionY, int velocidadX, int velocidadY, int ancho, int largo, Color color) {
		super(posicionX, posicionY, velocidadX, velocidadY, ancho, largo, color);
		// TODO Auto-generated constructor stub
		
		String path = Paths.get(Chuker.getResource().getPath())
                .toString();
        try {
            this.img = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
		// TODO Auto-generated method stub

	}

	@Override
	public void dibujar(Graphics graphics) {
        try {
            graphics.drawImage(img, getPosicionX(), getPosicionY(), this.getAncho(), this.getLargo(), null);
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
    }


	public void update() {
		posicionY+= velocidad;
		if(posicionY > Inicializador.largoVentana-10) {
			velocidad = -5;
		}
		if (posicionY < 0) {
			velocidad = 5;
		}
	}

}
