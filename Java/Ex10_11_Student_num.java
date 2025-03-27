package myPackage;

public class Ex10_11_Student_num extends Ex9_10_Person implements java.lang.Comparable{
	private int studentNumber;
	public Ex10_11_Student_num()
	 {
	super();
	 studentNumber = 0;//Indicating no number yet
	 }
	public Ex10_11_Student_num(String initialName, int initialStudentNumber)
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
	public boolean equals(Ex10_11_Student_num otherStudent)
	 {
	return this.hasSameName(otherStudent) &&
	 (this.studentNumber == otherStudent.studentNumber);
	 }

	public int compareTo(Object o) {
		if(o != null && o instanceof Ex10_11_Student_num)
		{
			Ex10_11_Student_num otherStudent = (Ex10_11_Student_num)o;
			
			if(studentNumber>otherStudent.studentNumber)
				return 1;
			else if(studentNumber<otherStudent.studentNumber)
				return -1;
			else
				return 0;
		}
		return -1;
	}

}
