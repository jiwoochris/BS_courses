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
