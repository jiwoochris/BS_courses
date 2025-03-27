package myPackage;

import java.util.Iterator;
import java.util.LinkedList;

public class Ex14_2c {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> arrayToLinkedList = new LinkedList<String>();
		String[] array = new String[5];
		array[0] = "Web Programming";
		array[1] = "Object-Oriented Programming";
		array[2] = "Operating System";
		array[3] = "Probability & Statistics";
		array[4] = "Web Programming";
		
		for(String s :array) {
			arrayToLinkedList.add(s);
		}
		
		removeFromArrayList(arrayToLinkedList, "Object-Oriented Programming");
		
		for(String s :arrayToLinkedList) {
			System.out.println(s);
		}
		
		Iterator<String> listIterator = arrayToLinkedList.listIterator();
		System.out.println(listIterator.next());
		System.out.println(listIterator.next());
		System.out.println(arrayToLinkedList.get(1));
		
	}
	
	public static void removeFromArrayList(LinkedList<String> list, String s) {
		list.remove(s);
	}

}