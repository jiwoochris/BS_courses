package myPackage;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Ex13_1a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = keyboard.nextLine();
		keyboard.close();
		
		PrintWriter outputStream = null;
		
		try {
			outputStream = new PrintWriter(fileName);
		}catch(FileNotFoundException e) {
			System.out.println("Error opening the file"+fileName);
			System.exit(0);
		}
		
		Random random = new Random();
		int[] r = new int[10];
		
		for(int i =0; i<10; i++)
		{
			r[i] = random.nextInt(10000);
			outputStream.println(r[i]);
		}
		
		outputStream.close();
		
		Scanner inputStream = null;
		
		try {
			inputStream = new Scanner(new File(fileName));
		}catch(FileNotFoundException e) {
			System.out.println("Error opening the file"+fileName);
			System.exit(0);
		}
		
		int[] out = new int[10];
		int i=0;
		
		while(inputStream.hasNextInt()) {
			out[i]=inputStream.nextInt();
			i++;
		}
		
		int min = out[0], max = out[0];
		int sum=0;
		double average;
		
		for(i=0; i<10; i++)
		{
			if(out[i]<min)
				min = out[i];
			if(out[i]>max)
				max=out[i];
			sum += out[i];
		}
		average = sum / (double)10;
		
		System.out.println("Min : "+min);
		System.out.println("Max : "+max);
		System.out.println("Sum : "+sum);
		System.out.println("Average : "+average);
		
		

	}

}
