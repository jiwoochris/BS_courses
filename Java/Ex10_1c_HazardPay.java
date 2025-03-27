package myPackage;

public class Ex10_1c_HazardPay extends Ex10_1c_PayCalculator
{
	public Ex10_1c_HazardPay(double initialPayRate)
	{
		payRate = initialPayRate;
	}
	
	public double computePay(double hours)
	{
		return 1.5 *super.computePay(hours);
	}
	
	
}