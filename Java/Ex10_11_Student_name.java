package myPackage;

public class Ex10_11_Student_name extends Ex9_10_Person implements java.lang.Comparable{
	private int studentNumber;
	public Ex10_11_Student_name()
	 {
	super();
	 studentNumber = 0;//Indicating no number yet
	 }
	public Ex10_11_Student_name(String initialName, int initialStudentNumber)
	 {
	super(initialName);
	 studentNumber = initialStudentNumber;
	 }
	public void reset(String newName, int newStudentNumber)
	 {
	setName(newName);
	 studentNumber = newStudentNumber;
	 }
	public int getStudentNumber()
	 {
	return studentNumber;
	 }
	public void setStudentNumber(int newStudentNumber)
	 {
	 studentNumber = newStudentNumber;
	 }
	public void writeOutput()
	 {
	 System.out.println("Name: " + getName());
	 System.out.println("Student Number: " + studentNumber);
	 }
	public boolean equals(Ex10_11_Student_name otherStudent)
	 {
	return this.hasSameName(otherStudent) &&
	 (this.studentNumber == otherStudent.studentNumber);
	 }

	public int compareTo(Object o) {
		if(o == null && !(o instanceof Ex10_11_Student_name))
			return 0;
		Ex10_11_Student_name otherStudent = (Ex10_11_Student_name)o;
		return this.getName().compareTo(otherStudent.getName());
	}
}
