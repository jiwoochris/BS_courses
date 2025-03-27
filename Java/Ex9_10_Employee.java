package myPackage;

public class Ex9_10_Employee extends Ex9_10_Staff{
	private int employeeId;
	private String department;
	
	public Ex9_10_Employee()
	{
		super();
		employeeId = 0;
		department = "No Department Yet.";
	}
	
	public Ex9_10_Employee(String initialName, int initialPayGrade, int initialEmployeeId, String initialDepartment)
	{
		super(initialName, initialPayGrade);
		employeeId = initialEmployeeId;
		department = initialDepartment;
	}
	
	public int getEmployeeId()
	{
		return employeeId;
	}
	
	public String getDepartment()
	{
		return department;
	}
	
	public void setEmployeeId(int newEmployeeId)
	{
		employeeId = newEmployeeId;
	}
	
	public void setDepartment(String newDepartment)
	{
		department = newDepartment;
	}
	
	public void writeOutput()
	{
		super.writeOutput();
		System.out.println("Emplyee Id: " + getEmployeeId());
		System.out.println("Department: " + getDepartment());
	}
	
	public boolean equals(Ex9_10_Employee otherEmployee)
	 {
		return this.equals((Ex9_10_Staff)otherEmployee) && this.employeeId == otherEmployee.employeeId && this.department == otherEmployee.department;
	 }
}
