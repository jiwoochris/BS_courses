package myPackage;

import java.util.Scanner;
import java.util.ArrayList;

public class Ex14_1b {

	public static void main(String[] args)
	{
		int sum=0, i=1, s;
		double average;
		
		Scanner keyboard = new Scanner(System.in);
		
		ArrayList<Integer>score = new ArrayList<Integer>();
		
		
		while(true)
		{
			System.out.println("Enter the score of "+i);
			s = keyboard.nextInt();
			if(s<0)
				break;
			score.add(s);
			i++;
		}
		
		for(Integer sc : score)
		{
			System.out.println(sc);
			sum += sc;
		}
		average = sum/(double)score.size();
		
		System.out.println("\naverage : "+average);
		
		keyboard.close();		
		
	}

}