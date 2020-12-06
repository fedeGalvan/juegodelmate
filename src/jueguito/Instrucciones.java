package jueguito;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Instrucciones extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	private int anchoVentana, largoVentana, diapositiva=-1;
	private List<Image> listaDeImagenes = new ArrayList<>();
	private JFrame ventana;

	public Instrucciones(int anchoVentana, int largoVentana, JFrame ventana) {
	this.anchoVentana = anchoVentana;
	this.largoVentana = largoVentana;
	this.ventana = ventana;
	cargarImagenes();
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, anchoVentana, largoVentana);
		dibujarDiapositivas(g);
		dibujarInstrucciones(g);
	}
	private void cargarImagenes() {
		try {
			listaDeImagenes.add(ImageIO.read(new File("Resources/Imagenes/Instruc1.png")));
			listaDeImagenes.add(ImageIO.read(new File("Resources/Imagenes/Instruc2.png")));
			listaDeImagenes.add(ImageIO.read(new File("Resources/Imagenes/Instruc3.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void dibujarDiapositivas(Graphics g) {
		if(diapositiva<listaDeImagenes.size()) {
			g.drawImage(listaDeImagenes.get(diapositiva), anchoVentana/2-450, largoVentana/2-260, 900, 520, null);
		}
	}
	private void dibujarInstrucciones(Graphics g) {
		if(diapositiva == 0) {
			fuenteYTamaño(g);
			String insc = "Sos el mate y tenés que juntar yerba, cada una te dará 25 puntos, juntá 500 para ganar";
			g.drawString(insc, anchoVentana/2-(insc.length()*4), largoVentana/2-280);
		}
		if(diapositiva == 1) {
			fuenteYTamaño(g);
			String insc = "Cada azúcar te sacará 50 puntos, evitalos para no arruinar el mate";
			g.drawString(insc, anchoVentana/2-(insc.length()*4), largoVentana/2-280);
		}
		if(diapositiva == 2) {
			fuenteYTamaño(g);
			String insc = "El edulcorante es el peor enemigo del mate, si lo agarrás vas a perder una vida";
			g.drawString(insc, anchoVentana/2-(insc.length()*4), largoVentana/2-280);
		}
		/*if(diapositiva == 3) {
			Inicio inic = new Inicio(anchoVentana, anchoVentana, ventana);
			ventana.add(inic);
			inic.setVisible(true);
			this.setVisible(false);
			
		}*/
	}
	
	private void fuenteYTamaño(Graphics g) {
		g.setColor(Color.green);
		g.setFont(new Font("Impact", 6, 20));
	}
	
	private void reDibujar(){
		this.repaint();
	}

	@Override
	public void run() {
		while (diapositiva<listaDeImagenes.size()) {
			reDibujar();
			diapositiva++;
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}

}
