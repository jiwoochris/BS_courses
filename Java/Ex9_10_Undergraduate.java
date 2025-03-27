package myPackage;

public class Ex9_10_Undergraduate extends Ex9_10_Student{
	private int level; //1 for freshman, 2 for sophomore
	//3 for junior, or 4 for senior.
	public Ex9_10_Undergraduate()
	 {
	super();
	 level = 1;
	 }
	public Ex9_10_Undergraduate(String initialName,
	int initialStudentNumber, int initialLevel)
	 {
	super(initialName, initialStudentNumber);
	 setLevel(initialLevel); //checks 1 <= initialLevel <= 4
	 }
	public void reset(String newName, int newStudentNumber,
	int newLevel)
	 {
	reset(newName, newStudentNumber); //Student's reset
	 setLevel(newLevel); //Checks 1 <= newLevel <= 4
	 }
	public int getLevel()
	 {
	return level;
	 }
	public void setLevel(int newLevel)
	 {
	if ((1 <= newLevel) && (newLevel <= 4))
	 level = newLevel;
	else
	 {
	 System.out.println("Illegal level!");
	 System.exit(0);
	 }
	 }
	public void writeOutput()
	 {
	super.writeOutput();
	 System.out.println("StudentLevel: " + level);
	 }
	public boolean equals(Ex9_10_Undergraduate otherUndergraduate)
	 {
	return this.equals((Ex9_10_Student) otherUndergraduate) &&
	 (this.level == otherUndergraduate.level);
	 }
}
