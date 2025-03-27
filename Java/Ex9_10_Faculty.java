package myPackage;

public class Ex9_10_Faculty extends Ex9_10_Staff{
	private String title;
	
	public Ex9_10_Faculty()
	{
		super();
		title = "No title yet.";
	}
	
	public Ex9_10_Faculty(String initialName, int initialPayGrade, String initialTitle)
	{
		super(initialName, initialPayGrade);
		title = initialTitle;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String newTitle)
	{
		title = newTitle;
	}
	
	public void writeOutput()
	{
		super.writeOutput();
		System.out.println("Title: " + getTitle());
	}
	
	public boolean equals(Ex9_10_Faculty otherFaculty)
	 {
		return this.equals((Ex9_10_Staff)otherFaculty) && this.title == otherFaculty.title;
	 }
}
