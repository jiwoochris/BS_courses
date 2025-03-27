package myPackage;

public class Ex9_1b_Person
{
	private String name;
	
	public Ex9_1b_Person()
	{
		name = "No Name Yet";
	}
	
	public Ex9_1b_Person(String initialName)
	{
		name = initialName;
	}
	
	public void setName(String newName)
	{
		name = newName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean hasSameName(Ex9_1b_Person otherPerson)
	{
		return this.name.equalsIgnoreCase(otherPerson.name);
	}
}



//////////////////////////////////////////////////////////////////////////////


package myPackage;

public class Ex9_1b_Doctor extends Ex9_1b_Person
{
	public enum Specialty
	{Medicine, Surgery, Dentist, Oriental};
	public Specialty specialty;
	private double visit_fee;
	
	public Ex9_1b_Doctor()
	{
		super();
		specialty = null;
		visit_fee = 0;
	}
	
	public Ex9_1b_Doctor(String initialName, String initialSpecialty, double initialVisit_fee)
	{
		super(initialName);
		setSpecialty(initialSpecialty);
		setVisit_fee(initialVisit_fee);
	}
	
	public void setSpecialty(String newSpecialty)
	{
		if (newSpecialty.equalsIgnoreCase("Medicine")||newSpecialty.equalsIgnoreCase("Surgery")||newSpecialty.equalsIgnoreCase("Dentist")||newSpecialty.equalsIgnoreCase("Oriental"))
			specialty = Specialty.valueOf(newSpecialty);
		else
			System.out.println("Worng Specialty.");
	}
	
	public void setVisit_fee(double newVisit_fee)
	{
		if(newVisit_fee>=0)
			visit_fee = newVisit_fee;
		else
			System.out.println("Worng visit_fee.");
	}
	
	public void reset(String newName, String newSpecialty, double newVisit_fee)
	{
		setName(newName);
		setSpecialty(newSpecialty);
		setVisit_fee(newVisit_fee);
	}
	
	public Specialty getSpecialty()
	{
		return specialty;
	}
	
	public double getVisit_fee()
	{
		return visit_fee;
	}
	
	public String toString()
	{
		return "Name: "+getName() + "\nSpecialty: "+getSpecialty() + "\nVisit_fee: "+getVisit_fee();
	}
	
	public boolean equals(Object otherObject)
	{
		if (otherObject == null || !(otherObject instanceof Ex9_1b_Doctor))
			return false;
		Ex9_1b_Doctor otherDoctor = (Ex9_1b_Doctor)otherObject;
		return this.hasSameName(otherDoctor) && this.specialty == otherDoctor.specialty && this.visit_fee == otherDoctor.visit_fee;
	}
}



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


package myPackage;

public class Ex9_1b_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex9_1b_Doctor d1 = new Ex9_1b_Doctor("Jiwoo", "Medicine", 30.5);
		Ex9_1b_Doctor d2 = new Ex9_1b_Doctor();
		d2.reset("Jiwoo", "Medicine", 30.5);
		
		System.out.println(d1);
		System.out.println(d2);
		
		System.out.println(d1.equals(d2));
		
		Ex9_1b_Doctor d3 = new Ex9_1b_Doctor("Jiwoo", "teacher", -1);
		System.out.println(d3);

	}

}
