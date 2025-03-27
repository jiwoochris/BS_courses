package myPackage;

public class Ex9_8_Pet {

	private String name;
	private int age; //in years
	private double weight;//in pounds
	public Ex9_8_Pet()
	 {
	 name = "No name yet.";
	 age = 0;
	 weight = 0;
	 }
	
	public Ex9_8_Pet(String initialName, int initialAge,
			double initialWeight)
			 {
			 name = initialName;
			if ((initialAge < 0) || (initialWeight < 0))
			 {
			 System.out.println("Error: Negative age or weight.");
			 System.exit(0);
			 }
			else
			 {
			 age = initialAge;
			 weight = initialWeight;
			 }
			 }
	public void setPet(String newName, int newAge,
			double newWeight)
			 {
			 name = newName;
			if ((newAge < 0) || (newWeight < 0))
			 {
			 System.out.println("Error: Negative age or weight.");
			 System.exit(0);
			 }
			else
			 {
			 age = newAge;
			 weight = newWeight;
			 }
			 }
	
	public String getName()
	 {
	 return name;
	 }
	 public int getAge()
	 {
	 return age;
	 }
	 public double getWeight()
	 {
	 return weight;
	 }
	 public void writeOutput()
	 {
	 System.out.println("Name: " + name);
	 System.out.println("Age: " + age + " years");
	 System.out.println("Weight: " + weight + " pounds");
	 }
	 
	 public boolean samePet(Ex9_8_Pet p)
	 {
		 return this.name.equalsIgnoreCase(p.name) && this.age==p.age && this.weight==p.weight;
	 }
	}


////////////////////////////////////////////////////////////////////////////////////////////////////


package myPackage;

public class Ex9_8_Dog extends Ex9_8_Pet
{
	private String breed;
	private boolean boosterShot;
	
	public Ex9_8_Dog()
	{
		super();
		breed = "No breed yet.";
		boosterShot = false;
	}
	
	public Ex9_8_Dog(String initialName, int initialAge, double initialWeight, String newBreed, boolean newBoosterShot)
	{
		super(initialName, initialAge, initialWeight);
		breed = newBreed;
		boosterShot = newBoosterShot;
	}
	
	public String getBreed()
	{
		return breed;
	}
	
	public boolean getBoosterShot()
	{
		return boosterShot;
	}
	
	public boolean equals(Object obj)
	{
		if(obj == null || !(obj instanceof Ex9_8_Dog))
			return false;
		Ex9_8_Dog d = (Ex9_8_Dog)obj;
		return this.samePet(d) && this.breed.equalsIgnoreCase(d.breed) && this.boosterShot==d.boosterShot;
	}
}



////////////////////////////////////////////////////////////////////////////////////////////////////////////////


package myPackage;

public class Ex9_8_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex9_8_Dog[] d = new Ex9_8_Dog[]
				{
						new Ex9_8_Dog("Choco", 2, 3.1, "poodle", true),
						new Ex9_8_Dog("Choco", 3, 3.1, "poodle", true),
						new Ex9_8_Dog("Bori", 5, 3.5, "poodle", false),
						new Ex9_8_Dog("Choco", 4, 5, "poodle", false),
						new Ex9_8_Dog("Choco", 2, 5.1, "poodle", false),
				};
		
		for(int index=0; index<5; index++)
		{
			if(d[index].getAge()>2 && d[index].getBoosterShot() == false)
				System.out.println("name: "+d[index].getName()+"\nbreed: "+d[index].getBreed()+"\n");
		}
		
		System.out.println(d[0].equals(d[1]));
	}

}

