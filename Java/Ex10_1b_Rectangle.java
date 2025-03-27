package myPackage;

public class Ex10_1b_Rectangle implements Ex10_1b
{
	private double height, width;
	
	public Ex10_1b_Rectangle(double initialHeight, double initialWidth)
	{
		height = initialHeight;
		width = initialWidth;
	}
	
	public double getArea()
	{
		return height * width;
	}
	
	public boolean equals(Ex10_1b otherShape)
	{
		if (otherShape == null || !(otherShape instanceof Ex10_1b_Rectangle))
				return false;
		Ex10_1b_Rectangle otherRectangle = (Ex10_1b_Rectangle)otherShape;
		return otherRectangle.height == this.height && otherRectangle.width == this.width;
	}
	
	public String toString()
	{
		return "Area: "+this.getArea();
	}
}
