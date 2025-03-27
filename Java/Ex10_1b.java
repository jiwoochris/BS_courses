package myPackage;

public interface Ex10_1b
{
	public double getArea();
	
	public String toString();
	
	

	public static void main(String[] args)
	{
		Ex10_1b[] s1 = new Ex10_1b[]
				{new Ex10_1b_Rectangle(5, 3.2), new Ex10_1b_RightTriangle(10, 2.5), new Ex10_1b_Circle(4)};
		
		Ex10_1b[] s2 = new Ex10_1b[]
				{new Ex10_1b_Rectangle(5, 3.1), new Ex10_1b_RightTriangle(5, 7.8), new Ex10_1b_Circle(4)};
		
		for (int index=0; index<3; index++)
			System.out.println(s1[index]);
		
		for (int index=0; index<3; index++)
			System.out.println(s1[index].equals(s2[index]));

		
	}
}

