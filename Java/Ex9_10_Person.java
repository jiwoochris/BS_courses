package myPackage;

public class Ex9_10_Person {
	private String name;
	public Ex9_10_Person()
	 {
	 name = "No name yet";
	 }
	public Ex9_10_Person(String initialName)
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
	public void writeOutput()
	 {
	 System.out.println("Name: " + name);
	 }
	public boolean hasSameName(Ex9_10_Person otherPerson)
	 {
	return this.name.equalsIgnoreCase(otherPerson.name);
	 }
}
