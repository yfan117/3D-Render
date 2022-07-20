package Driver;

import Beans.Triangle;
import Beans.Vertex;
import Render.Display;
import Utilities.MidService;

public class Driver {

	public static void main(String[] args) {
		
		Display display = new Display();
		
		MidService.mesh.add(new Triangle(new Vertex(-100, 100, 100),
										new Vertex(-100, -100, 100),
										new Vertex(100, -100, 100)));
		MidService.mesh.add(new Triangle(new Vertex(-100, 100, 100),
										new Vertex(100, -100, 100),
										new Vertex(100, 100, 100)));
		
//		MidService.mesh.add(new Triangle(new Vertex(-100, 100, -100),
//										new Vertex(-100, -100, -100),
//										new Vertex(100, -100, -100)));
//		MidService.mesh.add(new Triangle(new Vertex(-100, 100, -100),
//										new Vertex(100, -100, -100),
//										new Vertex(100, 100, -100)));
		while(true)
		{
			display.update();
			
			try {
				Thread.sleep(1000/30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
