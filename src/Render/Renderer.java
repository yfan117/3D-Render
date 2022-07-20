package Render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Beans.Triangle;
import Beans.Vertex;
import Utilities.MidService;

public class Renderer extends JPanel{
	
	public Renderer() {
		
	}
	
	double angle = 0;
	double a;
	double f;
	double l;
	double offSet;
	
	public void update() {
		
		angle += 0.03;
		
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		super.paintComponent(g2d);

		for(Triangle element: MidService.mesh) 
		{

			Vertex v1 = rotateY(element.v1);
			Vertex v2 = rotateY(element.v2);
			Vertex v3 = rotateY(element.v3);

			v1 = projection(v1);
			v2 = projection(v2);
			v3 = projection(v3);
			
			int offSet = (int) (MidService.displayX/2);

			g2d.drawLine(offSet + v1.x, offSet + v1.y, offSet + v2.x, offSet + v2.y);
			g2d.drawLine(offSet + v2.x, offSet + v2.y, offSet + v3.x, offSet + v3.y);
			g2d.drawLine(offSet + v3.x, offSet + v3.y, offSet + v1.x, offSet + v1.y);
			

		}
	}
	
	public Vertex projection(Vertex v)
	{
		a = MidService.displayY / MidService.displayX;
		f = 1 / (Math.tan(MidService.fieldOfView/2));
		l = MidService.Zfar / (MidService.Zfar - MidService.Znear);
		offSet = MidService.Zfar / (MidService.Zfar - MidService.Znear) * MidService.Znear;
		
		double x = (v.x * a * f);
		double y = (v.y * f);
		double z = (v.z * l - offSet);
		double w = v.z;
		
		if(w != 0.0) {
			x /= w;
			y /= w;
			z /= w;
		}
		return new Vertex((int)x, (int)y, (int)z);
	}
	
	
	public Vertex rotateY(Vertex v)
	{
		double x = v.x * Math.cos(angle) + v.z * Math.sin(angle);
		double y = v.y;
		double z = v.x * (-Math.sin(angle)) + v.z * Math.cos(angle);
		
		return new Vertex((int)x, (int)y, (int)z);
	}
	
	public Vertex rotateZ(Vertex v)
	{
		double x = v.x * Math.cos(angle) + v.y * (-Math.sin(angle));
		double y = v.x * Math.sin(angle) + v.y * Math.cos(angle);
		double z = v.z;
		
		return new Vertex((int)x, (int)y, (int)z);
	}

}
