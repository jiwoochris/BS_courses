package myPackage;

public class Ex9_10_Student extends Ex9_10_Person{
	private int studentNumber;
	public Ex9_10_Student()
	 {
	super();
	 studentNumber = 0;//Indicating no number yet
	 }
	public Ex9_10_Student(String initialName, int initialStudentNumber)
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
	public boolean equals(Ex9_10_Student otherStudent)
	 {
	return this.hasSameName(otherStudent) &&
	 (this.studentNumber == otherStudent.studentNumber);
	 }
	}
