package myPackage;

public class Ex9_2b_Circle extends Ex9_2b_Shape
{
	private double radius;
	
	public Ex9_2b_Circle(double initialRadius)
	{
		radius = initialRadius;
	}

	public double getArea()
	{
		return radius*radius* Math.PI;
	}
	
	public boolean equals(Object otherObject)
	{
		if(otherObject == null || !(otherObject instanceof Ex9_2b_Circle))
			return false;
		Ex9_2b_Circle otherCircle = (Ex9_2b_Circle)otherObject;
		return otherCircle.radius == this.radius;
	}
}
