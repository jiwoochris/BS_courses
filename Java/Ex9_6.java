package myPackage;

public class Ex9_6_Vehicle
{
	private String name;
	private int engine;
	private Ex9_1b_Person owner;
	
	public Ex9_6_Vehicle()
	{
		name = "No Name Yet";
		engine = 0;
		owner = new Ex9_1b_Person();
	}
	
	public Ex9_6_Vehicle(String initialName, int initialEngine, String initialowner)
	{
		name = initialName;
		engine = initialEngine;
		owner = new Ex9_1b_Person(initialowner);
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getEngine()
	{
		return engine;
	}
	
	public String getOwner()
	{
		return owner.getName();
	}
	
	public boolean sameVehicle(Ex9_6_Vehicle otherVehicle)
	{
		return this.name.equalsIgnoreCase(otherVehicle.name) && this.engine==otherVehicle.engine && this.owner.getName().equalsIgnoreCase(otherVehicle.owner.getName());
	}

}



----------------------------------------------------------------------------------------------------------------


package myPackage;

public class Ex9_6_Truck extends Ex9_6_Vehicle
{
	private double loadCapacity;
	private double towingCapacity;
	
	public Ex9_6_Truck()
	{
		super();
		loadCapacity = 0.0;
		towingCapacity = 0.0;
	}
	
	public Ex9_6_Truck(String initialName, int initialEngine, String initialowner, double initialLoadCapacity, double initailTowingCapacity)
	{
		super(initialName, initialEngine, initialowner);
		loadCapacity = initialLoadCapacity;
		towingCapacity = initailTowingCapacity;
	}
	
	public double getLoadCapacity()
	{
		return loadCapacity;
	}
	
	public double getTowingCapacity()
	{
		return towingCapacity;
	}
	
	public boolean equals(Object obj)
	{
		if (obj == null || !(obj instanceof Ex9_6_Truck))
				return false;
		Ex9_6_Truck otherTruck = (Ex9_6_Truck)obj;
		return this.sameVehicle(otherTruck) && this.loadCapacity==otherTruck.loadCapacity && this.towingCapacity==otherTruck.towingCapacity;
	}
}



-------------------------------------------------------------------------------------------------------------


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



--------------------------------------------------------------------------------------


package myPackage;

public class Ex9_6_DriverTest {

	public static void main(String[] args)
	{
		Ex9_6_Truck t1 = new Ex9_6_Truck("BMW", 100, "Jiwoo", 20.5, 30.2);
		Ex9_6_Truck t2 = new Ex9_6_Truck("BMW", 100, "Jiwoo", 20.5, 30.1);
		
		System.out.println("Manufacturer's name: "+t1.getName()+"\nNumber of cylinders in the engine: "+t1.getEngine()+
				"\nOwner: "+t1.getOwner() + "\nLoad Capacity: "+t1.getLoadCapacity()+"\nTowing Capacity: "+ t1.getTowingCapacity());
		System.out.println(t1.equals(t2));

	}

}
