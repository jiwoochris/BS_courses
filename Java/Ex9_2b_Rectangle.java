package myPackage;

public class Ex9_2b_Rectangle extends Ex9_2b_Shape
{
	private double height, width;
	
	public Ex9_2b_Rectangle(double initialHeight, double initialWidth)
	{
		height = initialHeight;
		width = initialWidth;
	}
	
	public double getArea()
	{
		return height * width;
	}
	
	public boolean equals(Ex9_2b_Shape otherShape)
	{
		if (otherShape == null || !(otherShape instanceof Ex9_2b_Rectangle))
				return false;
		Ex9_2b_Rectangle otherRectangle = (Ex9_2b_Rectangle)otherShape;
		return otherRectangle.height == this.height && otherRectangle.width == this.width;
	}
}
