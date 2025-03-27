package myPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Scanner;

public class Ex13_2a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = keyboard.nextLine();
		keyboard.close();
		
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
		}catch(FileNotFoundException e) {
			System.out.println("Error opening the file"+fileName);
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Problem with output to file"+fileName);
			System.exit(0);
		}
		
		Random random = new Random();
		double[] r = new double[10];
		
		try {
			for(int i =0; i<10; i++)
			{
				r[i] = random.nextDouble();
				outputStream.writeDouble(r[i]);
			}
			outputStream.close();
		} catch(IOException e) {
			System.out.println("Problem with output to file" + fileName);
		}
		
		
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
			
			double[] out = new double[10];
			
			int i =0;
			while(i<10) {
				out[i]=inputStream.readDouble();
				i++;
			}
			
			inputStream.close();
			
			double min = out[0], max = out[0];
			double sum=0;
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
			
		}catch(FileNotFoundException e) {
			System.out.println("Error opening the file"+fileName);
			System.exit(0);
		}catch(IOException e) {
			System.out.println("Problem with output to file"+fileName);
			System.exit(0);
		}
		
	}
}
