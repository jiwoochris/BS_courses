package myPackage;

public class Ex10_1b_RightTriangle implements Ex10_1b
{
	private double height, width;
	
	public Ex10_1b_RightTriangle(double initialHeight, double initialWidth)
	{
		height = initialHeight;
		width = initialWidth;
	}
	
	public double getArea()
	{
		return height * width * 0.5;
	}
	
	public boolean equals(Object otherObject)
	{
		if(otherObject == null || !(otherObject instanceof Ex10_1b_RightTriangle))
			return false;
		Ex10_1b_RightTriangle otherRightTriangle = (Ex10_1b_RightTriangle)otherObject;
		return otherRightTriangle.height == this.height && otherRightTriangle.width == this.width;
	}
	
	public String toString()
	{
		return "Area: "+this.getArea();
	}
}
