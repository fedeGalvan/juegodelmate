package jueguito;

import java.awt.Graphics;
import java.util.LinkedList;

public class Controller {
	
	LinkedList<Chuker> c = new LinkedList<Chuker>();
	
	Chuker TempChuker; 
	
	public void AgregandoChuker(){
		addChuker(new Chuker(70, 70, 10, 10, 200, 200, null));
	}
	
	public void addChuker(Chuker chuker) {
		c.add(chuker);
		c.add(chuker);
		c.add(chuker);
	}
	
	public  void dibujar(Graphics g) {
		for(int i = 0; i < c.size(); i++) {
			TempChuker = c.get(i);
			
			TempChuker.dibujar(g);
		}
	}
	
	public void update() {
		for(int i = 0; i < c.size(); i++) {
			TempChuker = c.get(i);
			
			TempChuker.update();

		}
	}

}
