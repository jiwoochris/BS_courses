package myPackage;

import java.util.Scanner;

public class Ex12_7 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("How many Fibonacci numbers it should calculate? : ");
		int number = keyboard.nextInt();
		
		display(number);
		
		

		keyboard.close();
	}
	
	public static int Fibonacci(int number)
	{
		if(number>2)
			return Fibonacci(number-2) + Fibonacci(number-1);
		else if(number == 1)
			return 0;
		else if(number == 2)
			return 1;
		else
			return -999;
	}
	
	public static void display(int number)
	{
		Fibonacci(number);
		
		System.out.println("Fibonacci #1 = 0");
		System.out.println("Fibonacci #2 = 1");
		
		for (int i=3; i<=number; i++) {
			System.out.println("Fibonacci #"+ i +" = " + Fibonacci(i) + "; "
					+ Fibonacci(i) + "/" + Fibonacci(i-1) + " = " + Fibonacci(i)/(double)Fibonacci(i-1));
		}
	}

}
