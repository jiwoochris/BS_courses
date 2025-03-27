package myPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ex13_2b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "input_13_2b.txt";
		String outFileName = "output_13_2b.dat";
		
		try {
			Scanner inputStream = new Scanner(new File(fileName));
			
			int[] integers = new int[10];
			int i =0;
			
			while(inputStream.hasNextInt())
			{
				integers[i] = inputStream.nextInt();
				i++;
			}
			
			inputStream.close();
			
			int[] d = new int[10];
			d[0] = 0;
			for(i=1; i<10; i++)
			{
				d[i] = integers[i] - integers[i-1];
			}
			
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(outFileName));

			outputStream.writeInt(integers[0]);
			for(i=0; i<10; i++)
			{
				outputStream.writeInt(d[i]);
			}
			outputStream.close();
			
			ObjectInputStream inputStream2 = new ObjectInputStream(new FileInputStream(outFileName));
			
			int[] outD = new int[10];
			int firstInt = inputStream2.readInt();
			for(i=0; i<10; i++)
			{
				outD[i] = inputStream2.readInt();
			}
			
			for(i=0; i<10; i++) {
				firstInt += outD[i];
				System.out.println(firstInt);
			}
			
			inputStream2.close();
			
			
		} catch(FileNotFoundException e) {
			System.out.println("Error to open file " + fileName);
			System.exit(0);
		} catch(IOException e) {
			System.out.println("Error to open file " + outFileName);
			System.exit(0);
		}
		

	}

}
