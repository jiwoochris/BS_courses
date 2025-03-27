package myPackage;

import java.util.HashSet;

public class Ex14_2b {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> arrayToHashSet = new HashSet<String>();
		String[] array = new String[5];
		array[0] = "Web Programming";
		array[1] = "Object-Oriented Programming";
		array[2] = "Operating System";
		array[3] = "Probability & Statistics";
		array[4] = "Web Programming";
		
		for(String s :array) {
			arrayToHashSet.add(s);
		}
		
		arrayToHashSet.remove("Object-Oriented Programming");
		removeFromHashSet(arrayToHashSet, "Object-Oriented Programming");
		
		for(String s :arrayToHashSet) {
			System.out.println(s);
		}
		
	}
	
	public static void removeFromHashSet(HashSet<String> list, String s) {
		list.remove(s);
	}

}
