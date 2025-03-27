package myPackage;

public class Ex10_1b_Circle implements Ex10_1b
{
	private double radius;
	
	public Ex10_1b_Circle(double initialRadius)
	{
		radius = initialRadius;
	}

	public double getArea()
	{
		return radius*radius* Math.PI;
	}
	
	public boolean equals(Object otherObject)
	{
		if(otherObject == null || !(otherObject instanceof Ex10_1b_Circle))
			return false;
		Ex10_1b_Circle otherCircle = (Ex10_1b_Circle)otherObject;
		return otherCircle.radius == this.radius;
	}
	
	public String toString()
	{
		return "Area: "+this.getArea();
	}
}
