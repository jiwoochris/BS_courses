package myPackage;

public class Ex9_10_Staff extends Ex9_10_Person{
	private int payGrade;
	
	public Ex9_10_Staff()
	{
		super();
		payGrade = 0;
	}
	
	public Ex9_10_Staff(String initialName, int initialPayGrade)
	{
		super(initialName);
		payGrade = initialPayGrade;
	}
	
	public int getPayGrade()
	{
		return payGrade;
	}
	
	public void setPayGrade(int newPayGrade)
	{
		if(newPayGrade<1 || newPayGrade>20)
			{
				System.out.println("Wrong Pay Grade");
				System.exit(0);
			}
		else
			payGrade = newPayGrade;
	}
	
	public void writeOutput()
	{
		super.writeOutput();
		System.out.println("Pay Grade: " + getPayGrade());
	}
	
	public boolean equals(Ex9_10_Staff otherStaff)
	 {
		return this.hasSameName(otherStaff) && (this.payGrade == otherStaff.payGrade);
	 }
}
