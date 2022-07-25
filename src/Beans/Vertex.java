package Beans;

public class Vertex {

	public double x;
	public double y;
	public double z;
	
	public Vertex(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return "Vertices [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
}
