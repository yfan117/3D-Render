package Beans;

import java.util.ArrayList;

public class Poly {

	public ArrayList<Vertex> list = new ArrayList<>();
	
	public Poly(Vertex ...v)
	{
		for(Vertex element: v)
		{
			list.add(element);
		}
	}
}
