package myPackage;

import java.util.ArrayList;

public class Ex14_1a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arrayToArrayList = new ArrayList<String>();
		String[] array = new String[5];
		array[0] = "Web Programming";
		array[1] = "Object-Oriented Programming";
		array[2] = "Operating System";
		array[3] = "Probability & Statistics";
		array[4] = "Software Mathmatics";
		
		for(String s :array) {
			arrayToArrayList.add(s);
		}
		
		arrayToArrayList.remove("Object-Oriented Programming");
		
		for(String s :arrayToArrayList) {
			System.out.println(s);
		}
		
	}
	
	void removeFromArrayList(ArrayList<String> list, String s) {
		list.remove(s);
	}

}
