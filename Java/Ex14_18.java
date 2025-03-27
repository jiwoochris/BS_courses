package myPackage;

import java.util.HashMap;
import java.util.Scanner;

public class Ex14_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		int number=0;
		
		Scanner keyboard = new Scanner(System.in);
		
		while(true) {
			number = keyboard.nextInt();
			if(number == -1)
				break;
			if(hash.containsKey(number))
			{
				int value = hash.get(number);
				value++;
				hash.put(number, value);
			}
			else
				hash.put(number, 1);
		}
		keyboard.close();
		
		for(int i : hash.keySet()) {
			System.out.println("The number " + i +" occurs " + hash.get(i) + "times.");
		}
	}

}
