package Render;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JPanel;

import Beans.Poly;
import Beans.Vertex;
import Utility.MidService;

public class Render extends JPanel{

	public Render() {}
	
	double angle = 0;
	public void update()
	{
		angle += 0.1;
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g2d);
		
		for(Poly element: MidService.mesh)
		{
			Polygon polygon = new Polygon();
			
			for(Vertex v: element.list)
			{
				Vertex nv = rotateX(v);
				nv = rotateY(nv);
//				nv = rotateZ(nv);
				nv = projection(nv);
				polygon.addPoint((int)(nv.x*100) + 250, (int)(nv.y*100) + 250);
			}
			
			g2d.drawPolygon(polygon);
		}
	}
	
	public Vertex projection(Vertex v)
	{
		double x = v.x / (Math.tan(MidService.fov/2));
		double y = v.y / (Math.tan(MidService.fov/2));
		double z = v.z * (-MidService.far/(MidService.far - MidService.near)) + (-MidService.far * MidService.near/(MidService.far - MidService.near));
		double w = -v.z;
		
//	    if (w != 1) { 
//	        x /= w; 
//	        y /= w; 
//	        z /= w; 
//	    } 
		double temp = (4 - v.z);
	    if (temp != 0) { 
	        x /= temp; 
	        y /= temp; 
	        z /= temp; 
	    } 

	    return new Vertex(x, y, z);
		
		
	}
	
	public Vertex rotateX(Vertex v)
	{
		double x = v.x;
		double y = v.y * Math.cos(angle) + v.z * (-Math.sin(angle));
		double z = v.y * Math.sin(angle) + v.z * Math.cos(angle);
		return new Vertex(x, y, z);
	}
	public Vertex rotateY(Vertex v)
	{
		double x = v.x * Math.cos(angle) + v.z * (Math.sin(angle));
		double y = v.y;
		double z = v.x * -Math.sin(angle) + v.z * Math.cos(angle);
		return new Vertex(x, y, z);
	}
	public Vertex rotateZ(Vertex v)
	{
		double x = v.x * Math.cos(angle) + v.y * (-Math.sin(angle));
		double y = v.x * Math.sin(angle) + v.y * (Math.cos(angle));
		double z = v.z;
		return new Vertex(x, y, z);
	}
}
