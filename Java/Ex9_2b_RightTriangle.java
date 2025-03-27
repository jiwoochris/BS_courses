package myPackage;

public class Ex9_2b_RightTriangle extends Ex9_2b_Shape
{
	private double height, width;
	
	public Ex9_2b_RightTriangle(double initialHeight, double initialWidth)
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
		if(otherObject == null || !(otherObject instanceof Ex9_2b_RightTriangle))
			return false;
		Ex9_2b_RightTriangle otherRightTriangle = (Ex9_2b_RightTriangle)otherObject;
		return otherRightTriangle.height == this.height && otherRightTriangle.width == this.width;
	}
}
