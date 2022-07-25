package Driver;

import javax.swing.JFrame;

import Beans.Poly;
import Beans.Vertex;
import Render.Render;
import Utility.MidService;

public class Driver {

	public static void main(String[] args) throws InterruptedException
	{
		JFrame frame = new JFrame("3D Render");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(MidService.display[0], MidService.display[1]);
		frame.setLocationRelativeTo(null);
		
		Render render = new Render();
		frame.add(render);
		frame.setVisible(true);
		frame.validate();
		
		Poly poly = new Poly(new Vertex(-1, 1, -1),
							new Vertex(-1, -1, -1),
							new Vertex(1, -1, -1),
							new Vertex(1, 1, -1));
		Poly poly2 = new Poly(new Vertex(-1, 1, 1),
							new Vertex(-1, -1, 1),
							new Vertex(1, -1, 1),
							new Vertex(1, 1, 1));
		
		Poly poly3 = new Poly(new Vertex(-1, 1, -1),
							new Vertex(-1, -1, -1),
							new Vertex(-1, -1, 1),
							new Vertex(-1, 1, 1));
		Poly poly4 = new Poly(new Vertex(1, 1, 1),
							new Vertex(1, -1, 1),
							new Vertex(1, -1, -1),
							new Vertex(1, 1, -1));
		
		Poly poly5 = new Poly(new Vertex(-1, 1, -1),
							new Vertex(-1, -1, -1),
							new Vertex(1, 1, -1),
							new Vertex(1, -1, -1));
		Poly poly6 = new Poly(new Vertex(-1, 1, 1),
							new Vertex(-1, -1, 1),
							new Vertex(1, 1, 1),
							new Vertex(1, -1, 1));
		
		MidService.mesh.add(poly);
		MidService.mesh.add(poly2);
		MidService.mesh.add(poly3);
		MidService.mesh.add(poly4);
		while(true)
		{
			render.update();
			
			Thread.sleep(1000/30);
		}
	}
}
