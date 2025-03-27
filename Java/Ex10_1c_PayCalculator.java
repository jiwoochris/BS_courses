package myPackage;

public abstract class Ex10_1c_PayCalculator
{
	public double payRate;
	
	public double computePay(double hours)
	{
		return hours * payRate;
	}
}
