package myPackage;

public class Ex9_2b_Shape
{
	public double getArea()
	{
		return 0.0;
	}
	
	public String toString()
	{
		return "Area: "+this.getArea();
	}

	public static void main(String[] args)
	{
		Ex9_2b_Shape[] s1 = new Ex9_2b_Shape[]
				{new Ex9_2b_Rectangle(5, 3.2), new Ex9_2b_RightTriangle(10, 2.5), new Ex9_2b_Circle(4)};
		
		Ex9_2b_Shape[] s2 = new Ex9_2b_Shape[]
				{new Ex9_2b_Rectangle(5, 3.1), new Ex9_2b_RightTriangle(5, 7.8), new Ex9_2b_Circle(4)};
		
		for (int index=0; index<3; index++)
			System.out.println(s1[index]);
		
		for (int index=0; index<3; index++)
			System.out.println(s1[index].equals(s2[index]));

		
	}
}


------------------------------------------------------------------------------------------------------
    
    
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



-----------------------------------------------------------------------------------------------------------------------


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



----------------------------------------------------------------------------------------------------------


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
