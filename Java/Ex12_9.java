package myPackage;

public class Ex12_9 {
	static int total =0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		getTotalGrains(3, 1);
	}
	
	public static int grains(int k, int grains)
	{
		if (k==1)
			return grains;
		else if (k>1)
			return 2 * grains(k-1, grains);
		else
			return -999;
	}
	
	public static void getTotalGrains(int k, int grains)
	{
		for (int i=1; i<=k; i++)
			total += grains(i, grains);
		
		System.out.println("Total number of grains : " + total);
	}

}
