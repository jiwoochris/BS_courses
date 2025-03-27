package myPackage;

import java.util.Scanner;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class Ex13_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "Ex13_2_input.txt";
		String outFileName = "Ex13_2_output.dat";
		
		Scanner inputStream = null;
		
		try{
			inputStream = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Error to open file "+fileName);
			System.exit(0);
		}
		
		int numbers;
		int counter;
		
		ObjectOutputStream outputStream = null;
		
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(new File(outFileName)));
		} catch(IOException e) {
			System.out.println("Error to open file "+fileName);
			System.exit(0);
		}
		
		try {
			numbers = inputStream.nextInt();
			outputStream.writeInt(numbers);
			counter = numbers;
			
			while(inputStream.hasNextInt())
			{
				numbers = inputStream.nextInt();
				if(numbers != counter)
					outputStream.writeInt(numbers);
				counter = numbers;
			}
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Error to open file "+fileName);
			System.exit(0);
		}
		inputStream.close();
		
		ObjectInputStream input = null;
		try {
			input = new ObjectInputStream(new FileInputStream(outFileName));
		} catch (FileNotFoundException e) {
			System.out.println("Error to open file "+fileName);
			System.exit(0);
		} catch(IOException e) {
			System.out.println("Problem reding the file "+outFileName);
			System.exit(0);
		}

		try {
			try {
				while(true)
				{
					int outputNumber = input.readInt();
					System.out.println(outputNumber);
				}
			} catch(EOFException e) {
				System.out.println("End of reading from file.");
			}
			input.close();
		} catch (IOException e) {
			System.out.println("Problem reding the file "+outFileName);
			System.exit(0);
		}

	}

}
